package mmmi.Domain;

import mmmi.Data_layer.Case;
import mmmi.Data_layer.Citizen;
import mmmi.Data_layer.SearchCase;
import java.util.ArrayList;
import java.util.HashMap;
import LoginSystem.Domain.IEmployee;
import mmmi.Data_layer.DataHandler;
import mmmi.Data_layer.Interfaces.IDataHandler;
import java.util.List;
import java.util.Map;
import mmmi.Domain.Interfaces.IDomain;

public class Department implements IDomain {

    private int departmentID;

    private final IDataHandler dataHandler = new DataHandler();
    private IEmployee loginEmployee;
    private Employee mmmiEmployee;

    private static Department departmentInstance = null;

    private Department() {

    }

    public static Department getInstance() {

        if (departmentInstance == null) {
            departmentInstance = new Department();
        }

        return departmentInstance;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getId() {
        return departmentID;
    }

    public void setLoginEmployee(IEmployee employee) {
        this.loginEmployee = employee;
    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(String caseNumber, int employeeID) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(String caseNumber, int employeeID) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param name
     * @param reason
     * @return
     */
    public boolean createCase(String name, String reason) {
        throw new UnsupportedOperationException();
    }

    //REMEMBER: to use the correct names from the IDataHandler interface.
    //REMEMBER: check rights ask the people and dont just do some random stuff.
    @Override
    public Map<String, Map<String, String>> search(String key, String value) {
        //TODO: needs to be able to send all info from a searchcase to the GUI in the form of list with a map
        value += "%" + String.valueOf(departmentID);
        IDataHandler searchHandler = new DataHandler();
        List<SearchCase> searchCases = searchHandler.search(key, value);

        int length = searchCases.size();

        Map searchResultList = new HashMap();
        for (int i = 0; i < length; i++) {
            Map searchResultMap = new HashMap();
            searchResultMap.put("citizenName", searchCases.get(i).getCitizenName());
            searchResultMap.put("currentCaseDate", searchCases.get(i).getCurrentCaseDate());
            searchResultMap.put("createdCaseDate", searchCases.get(i).getCreatedCaseDate());
            searchResultMap.put("caseReason", searchCases.get(i).getReason());
            searchResultMap.put("caseEmployeeName", searchCases.get(i).getEmployeeName());
            searchResultMap.put("caseStatus", searchCases.get(i).getCaseStatus());
            searchResultList.put(searchCases.get(i).getCaseID(), searchResultMap);
        }
        return searchResultList;
    }

    @Override
    public Map<String, String> openCase(int caseID) {
        //TODO: Opens a case with all the info into a map that are sendt to the GUI
        return dataHandler.readCase(caseID).getCaseContent();
    }

    @Override
    public boolean saveCase(Map<String, Map<String, String>> caseInfo) {
        // RequestingCitizen skal kunne gemme alle id'er på de forskellige aktør der henvender sig om borgen, dvs, hvis sagen
        // åbnes igen og der tilføjes en ny requestingCitizen, skal der tilføjes til requestingCitizen listen.
//        Case caze = new Case(caseInfo.get("caseID"), caseInfo.get("caseStatus"), c.getCitizenID(), caseInfo.get("requestingCitizens"), caseInfo.get("caseContent"));
        Map<String, String> contentsMap = new HashMap<>();
        List<Map<String, String>> citizenInfoList = new ArrayList<>();

        System.out.println(caseInfo);

        for (Map.Entry<String, Map<String, String>> entry : caseInfo.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("caseContents")) {
                contentsMap = entry.getValue();

            }
            if (entry.getKey().equalsIgnoreCase("cRegarding")
                    && isCitizen("regardingCitizen", "true", entry.getValue())) {

                citizenInfoList.add(entry.getValue());
            }
            if (entry.getKey().equalsIgnoreCase("cRequesting")
                    && isCitizen("requestingCitizen", "true", entry.getValue())) {
                citizenInfoList.add(entry.getValue());
            }
        }

        int regardingID = 0;

        List<Integer> requestingCitizenList = new ArrayList<>();
        for (Map<String, String> map : citizenInfoList) {

            Citizen citizen = dataHandler.createCitizen();
            citizen.setFirstName(map.get("firstName"));
            citizen.setLastName(map.get("lastName"));
            citizen.setStreetName(map.get("streetName"));
            citizen.setCprNo(map.get("cpr"));
            citizen.setCityname(map.get("cityName"));
            citizen.setZipcode(Integer.valueOf(map.get("zipCode")));
            citizen.setHouseNo(map.get("houseNo"));
            citizen.setFloor(map.get("floor"));
            citizen.setFloorDirection(map.get("floorDirection"));
            citizen.setRegardingCitizen(Boolean.valueOf(map.get("regardingCitizen")));
            citizen.setRequestingCitizen(Boolean.valueOf(map.get("requestingCitizen")));

            if (citizen.isRequestingCitizen()) {

                requestingCitizenList.add(dataHandler.writeCitizen(citizen));

            } else if (citizen.isRegardingCitizen()) {
                regardingID = dataHandler.writeCitizen(citizen);
            }
        }

        Case caze;
        if (contentsMap.get("caseID").equalsIgnoreCase("-1")) {
            contentsMap.remove("caseID");
            caze = dataHandler.createCase();
            caze.setCaseContent(contentsMap);
            caze.setCaseStatus("Igang");
            caze.setRegardingCitizenID(regardingID);
            caze.setRequestingCitizens(requestingCitizenList);
            caze.setDepartmentID(departmentID);
        } else {
            // TODO: If there is a case already you just need to set content (In regards to write it to the database)
            caze = null;
        }
        return dataHandler.writeCase(caze);

    }

    private boolean isCitizen(String key, String value, Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(key)) {
                if ((map.get(key)).equalsIgnoreCase(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee() {
        return receiveEmployee();
    }

    private Employee receiveEmployee() {

        int employeeid = loginEmployee.getEmployeeID();

        String employeeName = dataHandler.readEmployee(employeeid).getName();
        int roleID = dataHandler.readEmployee(employeeid).getRoleID();
        Map<String, String> casemap = dataHandler.readEmployee(employeeid).getEmployeeCases();
        Map<Integer, String> rightsMap = dataHandler.readEmployee(employeeid).getrights();

        return mmmiEmployee = new Employee(employeeid, employeeName, this.departmentID, roleID, casemap, rightsMap);
    }

    public static void main(String[] args) {
        Department department = new Department();

        Map<String, Map<String, String>> caseInfo = new HashMap<>();

        Map<String, String> conentsMap = new HashMap<>();
        conentsMap.put("regardinginquiry", "test1");
        conentsMap.put("treatment", "test2");
        conentsMap.put("caseID", "-1");

        Map<String, String> citizenInfoRegarding = new HashMap<>();
        citizenInfoRegarding.put("firstName", "RegardingFind");
        citizenInfoRegarding.put("lastName", "RegardingHansen");
        citizenInfoRegarding.put("streetName", "RegardingStreet");
        citizenInfoRegarding.put("cityName", "Kerteminde");
        citizenInfoRegarding.put("zipCode", "5300");
        citizenInfoRegarding.put("houseNo", "75");
        citizenInfoRegarding.put("regardingCitizen", "true");
        citizenInfoRegarding.put("requestingCitizen", "false");
        citizenInfoRegarding.put("cpr", "");
        citizenInfoRegarding.put("floor", "");
        citizenInfoRegarding.put("floorDirection", "");

        Map<String, String> citizenInfoRequesting = new HashMap<>();
        citizenInfoRequesting.put("firstName", "Requestingmads");
        citizenInfoRequesting.put("lastName", "RequestingHansen");
        citizenInfoRequesting.put("streetName", "RequestingStreet");
        citizenInfoRequesting.put("cityName", "Kerteminde");
        citizenInfoRequesting.put("zipCode", "5300");
        citizenInfoRequesting.put("houseNo", "75");
        citizenInfoRequesting.put("regardingCitizen", "false");
        citizenInfoRequesting.put("requestingCitizen", "true");
        citizenInfoRequesting.put("cpr", "");
        citizenInfoRequesting.put("floor", "");
        citizenInfoRequesting.put("floorDirection", "");

        Map<String, String> cd = new HashMap<>();
        citizenInfoRequesting.put("firstName", "cd");
        citizenInfoRequesting.put("lastName", "RequestingHansen");
        citizenInfoRequesting.put("streetName", "RequestingStreet");
        citizenInfoRequesting.put("cityName", "Kerteminde");
        citizenInfoRequesting.put("zipCode", "5300");
        citizenInfoRequesting.put("houseNo", "75");
        citizenInfoRequesting.put("regardingCitizen", "false");
        citizenInfoRequesting.put("requestingCitizen", "true");
        citizenInfoRequesting.put("cpr", "");
        citizenInfoRequesting.put("floor", "");
        citizenInfoRequesting.put("floorDirection", "");

        Map<String, String> cb = new HashMap<>();
        citizenInfoRegarding.put("firstName", "cb");
        citizenInfoRegarding.put("lastName", "RegardingHansen");
        citizenInfoRegarding.put("streetName", "RegardingStreet");
        citizenInfoRegarding.put("cityName", "Kerteminde");
        citizenInfoRegarding.put("zipCode", "5300");
        citizenInfoRegarding.put("houseNo", "75");
        citizenInfoRegarding.put("regardingCitizen", "true");
        citizenInfoRegarding.put("requestingCitizen", "false");
        citizenInfoRegarding.put("cpr", "");
        citizenInfoRegarding.put("floor", "");
        citizenInfoRegarding.put("floorDirection", "");

        caseInfo.put("caseContents", conentsMap);
        caseInfo.put("cRegarding", citizenInfoRegarding);
        caseInfo.put("cRequesting", citizenInfoRequesting);

        department.saveCase(caseInfo);

    }
}
