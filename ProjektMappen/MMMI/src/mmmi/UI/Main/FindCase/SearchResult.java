package mmmi.UI.Main.FindCase;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchResult {

    private final StringProperty citizenName;
    private final StringProperty caseID;
    private final StringProperty caseStatus;
    private final StringProperty currentCaseDate;
    private final StringProperty reason;
    private final StringProperty employeeName;

    /**
     *
     * @param citizenName
     * @param caseID
     * @param caseStatus
     * @param date
     * @param reason
     * @param employeeName
     */
    public SearchResult(String citizenName, String caseID, String caseStatus, String date, String reason, String employeeName) {
        this.citizenName = new SimpleStringProperty(citizenName);
        this.caseID = new SimpleStringProperty(caseID);
        this.caseStatus = new SimpleStringProperty(caseStatus);
        this.currentCaseDate = new SimpleStringProperty(date);
        this.reason = new SimpleStringProperty(reason);
        this.employeeName = new SimpleStringProperty(employeeName);
    }

    public String getCitizenName() {
        return citizenName.get();
    }
    
    public StringProperty citizenNameProperty() {
        return citizenName;
    }

    public String getCaseID() {
        return caseID.get();
    }
    
    public StringProperty caseIDProperty() {
        return caseID;
    }

    public String getCaseStatus() {
        return caseStatus.get();
    }
    
    public StringProperty caseStatusProperty() {
        return caseStatus;
    }

    public String getCurrentCaseDate() {
        return currentCaseDate.get();
    }
    
    public StringProperty currentCaseDateProperty() {
        return currentCaseDate;
    }

    public String getReason() {
        return reason.get();
    }
    
    public StringProperty reasonProperty() {
        return reason;
    }
    
    public String getEmployeeName() {
        return employeeName.get();
    }
    
    public StringProperty employeeNameProperty() {
        return employeeName;
    }
}
