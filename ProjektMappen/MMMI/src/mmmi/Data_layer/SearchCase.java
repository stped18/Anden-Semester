package MMMI.Data_layer;

import java.util.Date;

public class SearchCase {

    private final int citizenID;
    private final String citizenName;
    private final String caseID;
    private final String caseStatus;
    private final String date;
    private final String reason;
    private final int EmployeeID;
    private final String EmployeeName;

    /**
     *
     * @param citizenID
     * @param citizenName
     * @param caseID
     * @param caseStatus
     * @param date
     * @param reason
     * @param EmployeeID
     * @param EmployeeName
     */
    public SearchCase(int citizenID, String citizenName, String caseID, String caseStatus, String date, String reason, int EmployeeID, String EmployeeName) {
        this.citizenID = citizenID;
        this.citizenName = citizenName;
        this.caseID = caseID;
        this.caseStatus = caseStatus;
        this.date = date;
        this.reason = reason;
        this.EmployeeID = EmployeeID;
        this.EmployeeName = EmployeeName;
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

    public String getDate() {
        return date;
    }

    public String getReason() {
        return reason;
    }
    
    public int getEmployeeID() {
        return EmployeeID;
    }
    
    public String getEmployeeName() {
        return EmployeeName;
    }

}
