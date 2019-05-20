package mmmi.Data_layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Case {

    private final int caseID;
    private String caseStatus;
    private int regardingCitizenID;

    private List<Integer> requestingCitizens;
    private Map<String, String> caseContent;

    public Case(int caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent) {
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

    public int getCaseID() {
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

    public void setRegardingCitizenID(int regardingCitizenID) {
        this.regardingCitizenID = regardingCitizenID;
    }

    public void setRequestingCitizens(List<Integer> requestingCitizens) {
        this.requestingCitizens = requestingCitizens;
    }

    public void setCaseContent(Map<String, String> caseContent) {
        this.caseContent = caseContent;
    }

    /**
     *
     * @param theCase
     * @return
     */
    public String columnStringBuilder(Case theCase) {

        List<String> stringColoumnBuilder = new ArrayList<>();
        // put mapKeys to list
        for (String mapKey : theCase.getCaseContent().keySet()) {
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
}
