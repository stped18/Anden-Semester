package MMMI.Data_layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Case {

    private final String caseID;
    private String caseStatus;
    private final int regardingCitizenID;
    private List<Integer> requestingCitizens;
    private final Map<String, String> caseContent;

    public Case(String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent) {
        this.caseID = caseID;
        this.caseStatus = caseStatus;
        this.regardingCitizenID = regardingCitizenID;
        this.requestingCitizens = requestingCitizens;
        this.caseContent = caseContent;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseID() {
        return caseID;
    }

    public int getRegardingCitizenID() {
        return regardingCitizenID;
    }

    public List<Integer> getRequestingCitizen() {
        return requestingCitizens;
    }

    public void addRequestingCitizen(Integer requestingCitizenID) {

        // TODO: Add a new requesting citizen to the list. Instead of overridding.
        requestingCitizens.add(requestingCitizenID);
    }

    public Map<String, String> getCaseContent() {
        return caseContent;
    }

    public void addContents(String key, String value) {
        caseContent.put(key, value);
    }
    /**
     * 
     * @param caseContenst
     * @return 
     */
    public String columnStringBuilder(Map<String, String> caseContenst) {
        List<String> stringColoumnBuilder = new ArrayList<>();
        // put mapKeys to list
        for (String mapKey : caseContenst.keySet()) {
            stringColoumnBuilder.add(mapKey);
        }
        // build string, seperated with ","
        StringBuilder sb = new StringBuilder();
        for (String s : stringColoumnBuilder) {

            sb.append(s).append(",");
        }
        
        sb.setLength(sb.length() - 1);  // To remove "," on the last part of the string when it gets appended.

        return sb.toString();

    }

    public static void main(String[] args) {
        Map<String, String> mapTestValues = new TreeMap<>();

        List<Integer> listTest = new ArrayList<>();
        listTest.add(1);
        listTest.add(2);

        Case caze = new Case("1", "Afventer", 1, listTest, mapTestValues);
        caze.addContents("Test1", "Test1");
        caze.addContents("Test2", "Test2");
        caze.addContents("Test3", "Test3");

        System.out.println(caze.columnStringBuilder(mapTestValues));
    }

}
