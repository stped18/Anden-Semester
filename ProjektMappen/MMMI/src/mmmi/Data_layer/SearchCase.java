package mmmi.Data_layer;

/**
 * @TODO: Error handling
 */
public class SearchCase {

    private final int citizenID;
    private final String citizenName;
    private final String caseID;
    private final String caseStatus;
    private final String currentCaseDate;
    private final String createdCaseDate;
    private final String reason;
    private final int employeeID;
    private final String employeeName;

    /**
     * Constructor, used when a user Searches the database for a citizen or for
     * a specific case.
     *
     * @param citizenID
     * @param citizenName
     * @param caseID
     * @param caseStatus
     * @param date
     * @param createdDate
     * @param reason
     * @param employeeID
     * @param employeeName
     */
    public SearchCase(int citizenID, String citizenName, String caseID, String caseStatus, String date, String createdDate, String reason, int employeeID, String employeeName) {
        this.citizenID = citizenID;
        this.citizenName = citizenName;
        this.caseID = caseID;
        this.caseStatus = caseStatus;
        this.currentCaseDate = date;
        this.createdCaseDate = createdDate;
        this.reason = reason;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    /**
     * Getter method for variable citizenID.
     *
     * @return int citizenID
     */
    public int getCitizenID() {
        return citizenID;
    }

    /**
     * Getter method for variable citizenName.
     *
     * @return String citizenName
     */
    public String getCitizenName() {
        return citizenName;
    }

    /**
     * Getter method for variable caseID.
     *
     * @return String caseID
     */
    public String getCaseID() {
        return caseID;
    }

    /**
     * Getter method for variable caseStatus.
     *
     * @return String caseStatus
     */
    public String getCaseStatus() {
        return caseStatus;
    }

    /**
     * Getter method for variable currentCaseDate.
     *
     * @return String currentCaseDate
     */
    public String getCurrentCaseDate() {
        return currentCaseDate;
    }

    /**
     * Getter method for variable createdCaseDate.
     *
     * @return String createdCaseDate
     */
    public String getCreatedCaseDate() {
        return createdCaseDate;
    }

    /**
     * Getter method for variable reason.
     *
     * @return String resaon
     */
    public String getReason() {
        return reason;
    }

    /**
     * Getter method for variable employeeID.
     *
     * @return int employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Getter method for variable employeeName.
     *
     * @return String employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * For Testing.
     *
     * @return
     */
    @Override
    public String toString() {
        return "SearchCase{" + "citizenID=" + citizenID + ", citizenName=" + citizenName + ","
                + "caseID=" + caseID + ", caseStatus=" + caseStatus + ", currentCaseDate=" + currentCaseDate
                + ", reason=" + reason + ", employeeID=" + employeeID + ", employeeName=" + employeeName + '}';
    }
}
