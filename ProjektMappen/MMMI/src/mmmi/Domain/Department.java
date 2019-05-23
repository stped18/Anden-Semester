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
    public Map<String, Map<String, String>> openCase(int caseID) {
        //TODO: Opens a case with all the info into a map that are sendt to the GUI

        Map<String, Map<String, String>> fullMap = new HashMap<>();

        int regardingID = 0;
        int requestingID = 0;

        Map<String, String> caseContents = new HashMap<>();
        Map<String, String> cRegardingInfo = new HashMap<>();

        caseContents = dataHandler.readCase(caseID).getCaseContent();
        Citizen regardingCitizen = dataHandler.readCase(caseID).getRegardingCitizen();

        cRegardingInfo.put("firstname", regardingCitizen.getFirstName());
        cRegardingInfo.put("lastname", regardingCitizen.getLastName());
        cRegardingInfo.put("cpr", regardingCitizen.getCprNo());
        cRegardingInfo.put("houseno", regardingCitizen.getHouseNo());
        cRegardingInfo.put("cityname", regardingCitizen.getCityname());
        cRegardingInfo.put("streetname", regardingCitizen.getStreetName());
        cRegardingInfo.put("floor", regardingCitizen.getFloor());
        cRegardingInfo.put("floordirection", regardingCitizen.getFloorDirection());
		
        Map<String, Map<String, String>> reqMap = new HashMap();
        for (Citizen citzen : dataHandler.readCase(caseID).getRequestingCitizen()) {
            if (citzen != null) {
                Map<String, String> cRequestingInfo = new HashMap<>();
                cRequestingInfo.put("firstname", citzen.getFirstName());
                cRequestingInfo.put("lastname", citzen.getLastName());
                cRequestingInfo.put("cpr", citzen.getCprNo());
                cRequestingInfo.put("houseno", citzen.getHouseNo());
                cRequestingInfo.put("cityname", citzen.getCityname());
                cRequestingInfo.put("streetname", citzen.getStreetName());
                cRequestingInfo.put("floor", citzen.getFloor());
                cRequestingInfo.put("floordirection", citzen.getFloorDirection());
                fullMap.put("cRequesting", cRequestingInfo);
            }
        }
        fullMap.put("caseContents", caseContents);
        fullMap.put("cRegarding", cRegardingInfo);

        return fullMap;
    }

    @Override
    public boolean saveCase(Map<String, Map<String, String>> caseInfo) {
        // RequestingCitizen skal kunne gemme alle id'er på de forskellige aktør der henvender sig om borgen, dvs, hvis sagen
        // åbnes igen og der tilføjes en ny requestingCitizen, skal der tilføjes til requestingCitizen listen.
//        Case caze = new Case(caseInfo.get("caseID"), caseInfo.get("caseStatus"), c.getCitizenID(), caseInfo.get("requestingCitizens"), caseInfo.get("caseContent"));
        Map<String, String> contentsMap = new HashMap<>();
        List<Map<String, String>> citizenInfoList = new ArrayList<>();

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

        int regardingID, requestingID = 0;
        Citizen regardingCitizen = null;
        List<Citizen> requestingCitizenList = new ArrayList<>();
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
                requestingID = dataHandler.writeCitizen(citizen);
                citizen.setCitizenID(requestingID);
                requestingCitizenList.add(citizen);
            } else if (citizen.isRegardingCitizen()) {
                regardingID = dataHandler.writeCitizen(citizen);
                citizen.setCitizenID(regardingID);
                regardingCitizen = citizen;
            }
        }

        Case caze;
        System.out.println(contentsMap.get("caseID"));
        if (contentsMap.get("caseID").equalsIgnoreCase("-1")) {
            contentsMap.remove("caseID");
            caze = dataHandler.createCase();
            caze.setCaseContent(contentsMap);
            caze.setCaseStatus("Igang");
            caze.setRegardingCitizen(regardingCitizen);
            caze.setRequestingCitizens(requestingCitizenList);
            caze.setDepartmentID(departmentID);
        } else {
            // TODO: If there is a case already you just need to set content (In regards to write it to the database)
            caze = null;
            System.out.println("TEST");
            return false;
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
    
    public String getnote(int caseID) {
        return dataHandler.readAlternativeNotets(caseID);
    }
    
    public boolean writenote(int caseID, String note) {
        System.out.println("in domain");
        return dataHandler.writeAlternativeNote(caseID, note);
    }

    @Override
    public Employee getEmployee() {
        return receiveEmployee();
    }

    private Employee receiveEmployee() {

        int employeeid = loginEmployee.getEmployeeID();
        String employeeName = dataHandler.readEmployee(employeeid).getName();
        int roleID = dataHandler.readEmployee(employeeid).getRoleID();
        Map<Integer, String> casemap = dataHandler.readEmployee(employeeid).getEmployeeCases();
        Map<Integer, String> rightsMap = dataHandler.readEmployee(employeeid).getrights();

        return mmmiEmployee = new Employee(employeeid, employeeName, this.departmentID, roleID, casemap, rightsMap);
    }
}
