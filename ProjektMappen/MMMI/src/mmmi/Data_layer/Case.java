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

	/**
	 *
	 * @param caseID, of type int
	 * @param departmentID, of type int
	 * @param caseStatus, of type String
	 * @param regardingCitizen, of type Citizen
	 * @param requestingCitizens, of type List<Citizen>
	 * @param caseContent, of type Map<String, String>
	 */
	public Case(int caseID, int departmentID, String caseStatus, Citizen regardingCitizen, List<Citizen> requestingCitizens, Map<String, String> caseContent) {
        this.caseID = caseID;
        this.departmentID = departmentID;
        this.caseStatus = caseStatus;
        this.regardingCitizen = regardingCitizen;
        this.requestingCitizens = requestingCitizens;
        this.caseContent = caseContent;
    }

	/**
	 *
	 * @return Department ID for at case as an int.
	 */
	public int getDepartmentID() {
        return departmentID;
    }

	/**
	 *
	 * @param departmentID int
	 */
	public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

	/**
	 *
	 * @return The case status as a String.
	 */
	public String getCaseStatus() {
        return caseStatus;
    }

	/**
	 *
	 * @param caseStatus String
	 */
	public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

	/**
	 *
	 * @return The cases ID as an int.
	 */
	public int getCaseID() {
        return caseID;
    }

	/**
	 *
	 * @return A object of the requarding Citizen for the case.
	 */
	public Citizen getRegardingCitizen() {
        return regardingCitizen;
    }

	/**
	 *
	 * @return A List of the requesting for the case.
	 */
	public List<Citizen> getRequestingCitizen() {
        return requestingCitizens;
    }

	/**
	 *
	 * @param requestingCitizenID Citizen
	 */
	public void addRequestingCitizen(Citizen requestingCitizenID) {
        // TODO: Add a new requesting citizen to the list. Instead of overridding.
        requestingCitizens.add(requestingCitizenID);
    }

	/**
	 *
	 * @return The contens of the case as a Map<String, String>.
	 * Where the Key is the attrubute name, and the value is the content.
	 */
	public Map<String, String> getCaseContent() {
        return caseContent;
    }

	/**
	 *
	 * @param regardingCitizen Citizen
	 */
	public void setRegardingCitizen(Citizen regardingCitizen) {
        this.regardingCitizen = regardingCitizen;
    }

	/**
	 *
	 * @param requestingCitizens List<mmmi.Data_layer.Citizen>
	 */
	public void setRequestingCitizens(List<Citizen> requestingCitizens) {
        this.requestingCitizens = requestingCitizens;
    }

	/**
	 *
	 * @param caseContent Map<String, String>
	 */
	public void setCaseContent(Map<String, String> caseContent) {
        this.caseContent = caseContent;
    }

	/**
	 * For testing.
	 * 
	 * @return
	 */
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
