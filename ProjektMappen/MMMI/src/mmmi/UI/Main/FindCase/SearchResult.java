package mmmi.UI.Main.FindCase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @TODO: Error handling
 */
public class SearchResult {

    private final StringProperty citizenName;
    private final StringProperty caseID;
    private final StringProperty caseStatus;
    private final StringProperty currentCaseDate;
    private final StringProperty createdCaseDate;
    private final StringProperty reason;
    private final StringProperty employeeName;

    /**
     * Constructor, used when creating a SearchResult.
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
     * Getter for citizenName.
     *
     * @return String citizenName
     */
    public String getCitizenName() {
        return citizenName.get();
    }

    /**
     * Getter for citizenNameProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty citizenName
     */
    public StringProperty citizenNameProperty() {
        return citizenName;
    }

    /**
     * Getter for caseID.
     *
     * @return
     */
    public String getCaseID() {
        return caseID.get();
    }

    /**
     * Getter for caseIDProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty caseID
     */
    public StringProperty caseIDProperty() {
        return caseID;
    }

    /**
     * Getter for caseStatus.
     *
     * @return
     */
    public String getCaseStatus() {
        return caseStatus.get();
    }

    /**
     * Getter for caseStatuProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty caseStatus
     */
    public StringProperty caseStatusProperty() {
        return caseStatus;
    }

    /**
     * Getter for CurrentCaseDate.
     *
     * @return
     */
    public String getCurrentCaseDate() {
        return currentCaseDate.get();
    }

    /**
     * Getter for currentCaseDateProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty currentCaseDate
     */
    public StringProperty currentCaseDateProperty() {
        return currentCaseDate;
    }

    /**
     * Getter for createdCaseDate.
     *
     * @return
     */
    public String getCreatedCaseDate() {
        return createdCaseDate.get();
    }

    /**
     * Getter for createdCaseDateProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty createdCaseDate
     */
    public StringProperty createdCaseDateProperty() {
        return createdCaseDate;
    }

    /**
     * Getter for reason.
     *
     * @return
     */
    public String getReason() {
        return reason.get();
    }

    /**
     * Getter for reasonProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty reason
     */
    public StringProperty reasonProperty() {
        return reason;
    }

    /**
     * Getter for employee.
     *
     * @return
     */
    public String getEmployeeName() {
        return employeeName.get();
    }

    /**
     * Getter for employeeNameProperty.
     *
     * Used by the observableList in
     * {@link mmmi.UI.Main.FindCase.FindCaseController}
     *
     * @return StringProperty employeeName
     */
    public StringProperty employeeNameProperty() {
        return employeeName;
    }
}
