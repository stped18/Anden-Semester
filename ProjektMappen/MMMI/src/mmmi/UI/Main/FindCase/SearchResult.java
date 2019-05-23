package mmmi.UI.Main.FindCase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchResult {

    private final StringProperty citizenName;
    private final StringProperty caseID;
    private final StringProperty caseStatus;
    private final StringProperty currentCaseDate;
    private final StringProperty createdCaseDate;
    private final StringProperty reason;
    private final StringProperty employeeName;

    /**
     *
     * @param citizenName
     * @param caseID
     * @param caseStatus
     * @param date
     * @param createdDate
     * @param reason
     * @param employeeName
     */
    public SearchResult(String citizenName, String caseID, String caseStatus, String date, String createdDate, String reason, String employeeName) {
        this.citizenName = new SimpleStringProperty(citizenName);
        this.caseID = new SimpleStringProperty(caseID);
        this.caseStatus = new SimpleStringProperty(caseStatus);
        this.currentCaseDate = new SimpleStringProperty(date);
        this.createdCaseDate = new SimpleStringProperty(createdDate);
        this.reason = new SimpleStringProperty(reason);
        this.employeeName = new SimpleStringProperty(employeeName);
    }

	/**
	 *
	 * @return
	 */
	public String getCitizenName() {
        return citizenName.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty citizenNameProperty() {
        return citizenName;
    }

	/**
	 *
	 * @return
	 */
	public String getCaseID() {
        return caseID.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty caseIDProperty() {
        return caseID;
    }

	/**
	 *
	 * @return
	 */
	public String getCaseStatus() {
        return caseStatus.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty caseStatusProperty() {
        return caseStatus;
    }

	/**
	 *
	 * @return
	 */
	public String getCurrentCaseDate() {
        return currentCaseDate.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty currentCaseDateProperty() {
        return currentCaseDate;
    }

	/**
	 *
	 * @return
	 */
	public String getCreatedCaseDate() {
        return createdCaseDate.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty createdCaseDateProperty() {
        return createdCaseDate;
    }

	/**
	 *
	 * @return
	 */
	public String getReason() {
        return reason.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty reasonProperty() {
        return reason;
    }
    
	/**
	 *
	 * @return
	 */
	public String getEmployeeName() {
        return employeeName.get();
    }
    
	/**
	 *
	 * @return
	 */
	public StringProperty employeeNameProperty() {
        return employeeName;
    }
}
