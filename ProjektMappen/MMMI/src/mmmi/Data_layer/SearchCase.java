package MMMI.Data_layer;

import java.util.Date;

public class SearchCase {

    private String citizenName;
    private int citizenID;
    private String caseID;
    private String caseStatus;
    private Date date;
    private String reason;
    private String EmployeeName;
    private int EmployeeID;

    /**
     *
     */
    public SearchCase() {
        // TODO - implement SearchCase.SearchCase
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     */
    public Citizen getCitizen() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     */
    public int getCaseNumber() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return
     */
    public String getCaseStatus() {
        return this.caseStatus;
    }

    /**
     * @return
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @return
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * @return
     */
    public String getEmployeeName() {
        return this.EmployeeName;
    }

    /**
     * @return
     */
    public int getEmployeeID() {
        return this.EmployeeID;
    }

}
