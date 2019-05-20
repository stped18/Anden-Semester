package mmmi.Domain;

import MMMI.Data_layer.Case;
import MMMI.Data_layer.Citizen;
import MMMI.Data_layer.DataHandler;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mmmi.Domain.Interfaces.IDomain;

public class Department implements IDomain {

    private final int id;

    private IDataHandler dataHandler;

    /**
     * @param id
     */
    public Department(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
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
    public List<Map<String, String>> Search(String key, String value) {
        //TODO: needs to be able to send all info from a searchcase to the GUI in the form of list with a map
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> openCase(String caseID) {
        //TODO: Opens a case with all the info into a map that are sendt to the GUI
        return dataHandler.readCase(caseID).getCaseContent();
    }

    @Override
    public boolean saveCase(List< Map<String, String>> caseInfo) {
        //TODO: Gets a map with both case info and citizen and needs to make it into the right data
        //public Case(String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent) 
        //TODO: Create case object where contents from caseInfo get put into caseContent Map
        // Autogenerate caseID based on department, commune
        // We need to get all info from caseInfo in regards to writeCitizen 
        // Autogenerate

        // Key = CaseContents > Map
        // Key = citizenInformation > Map
        // Key = 
        // writeCitizen returner en int værdi ift. regardingCitizen id
        // RequestingCitizen skal kunne gemme alle id'er på de forskellige aktør der henvender sig om borgen, dvs, hvis sagen
        // åbnes igen og der tilføjes en ny requestingCitizen, skal der tilføjes til requestingCitizen listen.
//        Case caze = new Case(caseInfo.get("caseID"), caseInfo.get("caseStatus"), c.getCitizenID(), caseInfo.get("requestingCitizens"), caseInfo.get("caseContent"));
        dataHandler = new DataHandler();
        Map<String, String> contentsMap = new HashMap<>();
        List<Map<String, String>> citizenInfoList = new ArrayList<>();
        Map<String, String> otherInfoMap = new HashMap<>();

//        for (Map.Entry<String, Map<String, String>> entry : caseInfo.entrySet()) {
//            if (entry.getKey().equalsIgnoreCase("caseContents")) {
//                contentsMap = entry.getValue();

        System.out.println(caseInfo);
        for (int i = 0; i < caseInfo.size(); i++) {
            
            Map<String, String> map = caseInfo.get(i);
            if (map.containsKey("regardinginquiry")) {            
               System.out.println("condmap" + map);
                contentsMap = map;
            }else{
            citizenInfoList.add(map);
            }  
        }

//            System.out.println(Arrays.asList(citizenInfoList));
//                if (entry.getValue().containsKey("requestingCitizen") && entry.getValue().containsValue("true")) {
//                    System.out.println("Requesting" + entry.getValue());
//                    citizenInfoList.add(entry.getValue());
//                    
//                }
//
//                if (entry.getValue().containsKey("regardingCitizen") && entry.getValue().containsValue("true")) {
//
//                    System.out.println("Regarding" + entry.getValue().toString());
//                    citizenInfoList.add(entry.getValue());
//                    
//                for (Map.Entry<String, String> entry1 : entry.getValue().entrySet()) {
//                    String key = entry1.getKey();
//                    String value = entry1.getValue();
//                    System.out.println(key + ":   " + value);
//                    if (key.equalsIgnoreCase("regardingCitizen") && value.equalsIgnoreCase("true")) {                           
//                        System.out.println("REGARDR" + entry1.getValue());
//                        
//                        citizenInfoList.add(entry1);
//                        
//                    } else if (key.equalsIgnoreCase("requestingCitizen") && value.equalsIgnoreCase("true")) {
//                        System.out.println("EQUEST" + entry1.getValue());
//                        citizenInfoList.add(entry1);
//                    }


//        String firstName, lastName, streetName, cityName, cpr, zipcode, houseNo, floor, floorDir, citizenType;
//        firstName = lastName = streetName = cityName = zipcode = houseNo = floor = floorDir = citizenType = cpr = "";

        int getCitizenID = 0;
        List<Citizen> citezinList = new ArrayList<Citizen>();
        Citizen c = dataHandler.createCitizen();
        for (Map<String, String> map : citizenInfoList) {
            if (map.containsKey("regardingCitizen") || map.containsValue("requestingCitizen")) {
                c.setFirstName(map.get("firstName"));
                c.setLastName(map.get("lastName"));
                c.setStreetName(map.get("streetName"));
                c.setCprNo(map.get("cpr")); 
                c.setCityname(map.get("cityName"));
                c.setZipcode(Integer.valueOf(map.get("zipCode")));
                c.setHouseNo(map.get("houseNo"));
                c.setFloor(map.get("floor"));
                c.setFloorDirection(map.get("floorDirection"));
                c.setRegardingCitizen(Boolean.valueOf(map.get("reqardingCitizen")));
                c.setRequestingCitizen(Boolean.valueOf(map.get("regardingCitizen")));
            }
            c = new Citizen(-1, c.getFirstName(), c.getLastName(),
                            c.getCprNo(), c.getStreetName(), c.getHouseNo(), c.getFloor(), c.getFloorDirection(),
                            c.getZipcode(), c.getCityname(), c.isRegardingCitizen(), c.isRequestingCitizen());
        
            citezinList.add(c);
            
        }
        for (Citizen a : citezinList) {     
            System.out.println("Citesin add to db:  "+a.toString());
            getCitizenID = dataHandler.writeCitizen(a);
        }

        List<Integer> requestingCitizenList = new ArrayList<>();
        requestingCitizenList.add(getCitizenID);

        return dataHandler.writeCase(new Case(String.valueOf(new Random().nextInt(1000)), "igang", getCitizenID, requestingCitizenList, contentsMap));

    }
    
    private boolean isCitizen(String key, String value, Map<String , String> map) {
    if (map != null){
        if (map.containsKey(key)){
            if ((map.get(key)).equals(value)){
                return true;
            }
        }
    }
    return false;
}

    @Override
    public Employee getEmployee() {
        //TODO: Sends the data of employee with rights  getRegardingID
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Department department = new Department(1);
        List<Map<String, String>> caseInfo = new ArrayList<Map<String,String>>();

        Map<String, String> conentsMap = new HashMap<>();
        conentsMap.put("regardinginquiry", "test1");
        conentsMap.put("treatment", "test2");

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
        
        Map<String, String> cd= new HashMap<>();
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

        caseInfo.add(conentsMap);
        caseInfo.add(citizenInfoRegarding);
        caseInfo.add(citizenInfoRequesting);
        caseInfo.add(cd);
        caseInfo.add(cb);
        
//        caseInfo.put("citizenInfo", citizenInfoRequesting);

        department.saveCase(caseInfo);
        ;

    }
}























