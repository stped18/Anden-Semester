package mmmi.Data_layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Case {

    private final int caseID;
    private String caseStatus;
    private Citizen regardingCitizen;
    private int departmentID;
    private List<Citizen> requestingCitizens;
    private Map<String, String> caseContent;

    public Case(int caseID, int departmentID, String caseStatus, Citizen regardingCitizen, List<Citizen> requestingCitizens, Map<String, String> caseContent) {
        this.caseID = caseID;
        this.departmentID = departmentID;
        this.caseStatus = caseStatus;
        this.regardingCitizen = regardingCitizen;
        this.requestingCitizens = requestingCitizens;
        this.caseContent = caseContent;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
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

    public Citizen getRegardingCitizen() {
        return regardingCitizen;
    }

    public List<Citizen> getRequestingCitizen() {
        return requestingCitizens;
    }

    public void addRequestingCitizen(Citizen requestingCitizenID) {
        // TODO: Add a new requesting citizen to the list. Instead of overridding.
        requestingCitizens.add(requestingCitizenID);
    }

    public Map<String, String> getCaseContent() {
        return caseContent;
    }

    public void setRegardingCitizen(Citizen regardingCitizen) {
        this.regardingCitizen = regardingCitizen;
    }

    public void setRequestingCitizens(List<Citizen> requestingCitizens) {
        this.requestingCitizens = requestingCitizens;
    }

    public void setCaseContent(Map<String, String> caseContent) {
        this.caseContent = caseContent;
    }

    @Override
    public String toString() {
        return "Case{" + "caseID=" + caseID + ", caseStatus=" + caseStatus + ", regardingCitizenID=" + regardingCitizen + ", departmentID=" + departmentID + ", requestingCitizens=" + requestingCitizens + ", caseContent=" + caseContent + '}';
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
