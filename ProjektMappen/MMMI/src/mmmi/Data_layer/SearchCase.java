package MMMI.Data_layer;

import java.util.Date;

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

    public int getCitizenID() {
        return citizenID;
    }
    
    public String getCitizenName() {
        return citizenName;
    }

    public String getCaseID() {
        return caseID;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public String getCurrentCaseDate() {
        return currentCaseDate;
    }

    public String getCreatedCaseDate() {
        return createdCaseDate;
    }

    public String getReason() {
        return reason;
    }
    
    public int getEmployeeID() {
        return employeeID;
    }
    
    public String getEmployeeName() {
        return employeeName;
    }

    @Override
    public String toString() {
        return "SearchCase{" + "citizenID=" + citizenID + ", citizenName=" + citizenName + ", caseID=" + caseID + ", caseStatus=" + caseStatus + ", currentCaseDate=" + currentCaseDate + ", reason=" + reason + ", employeeID=" + employeeID + ", employeeName=" + employeeName + '}';
    }

}
