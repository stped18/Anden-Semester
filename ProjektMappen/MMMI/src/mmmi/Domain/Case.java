package mmmi.Domain;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Case {

    private static int socialCount = 1;
    private static int handicapCount = 1;

    private final String caseNumber;
    private String caseStatus;

    private final String date;
    private final Citizen regardingCitizen;
    private final List<Citizen> requestingCitizen = new ArrayList<>();
    private final Map<String, String> information = new HashMap<>();
    private final int departmentID;

    /**
     *
     * @param regardingCitizen
     * @param reason
     * @param departmentID
     */
    public Case(String reason, int departmentID) {

        this.regardingCitizen = new Citizen("name"); // TODO: Need alot of changes.
        this.information.put("reason", reason);
        this.departmentID = departmentID;
        this.caseNumber = setCaseNumber();
        this.date = dateStamp(); // Opret Date.
        // TODO: Case changes date.
        this.caseStatus = "Created";
    }

    /**
     *
     * @return The status of the case.
     */
    public String getCaseStatus() {

        return this.caseStatus;
    }

    /**
     * Have been added so it's possible to change the status of the case.
     *
     * @param newCaseStatus
     * @return True if the status of the case has been changed.
     */
    public boolean setCaseStatus(String newCaseStatus) {

        if (!this.caseStatus.equals(newCaseStatus)) {
            this.caseStatus = newCaseStatus;
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return The case number.
     */
    public String getCaseNumber() {
        return this.caseNumber;
    }

    /**
     *
     * @return The citizen the cases is about.
     */
    public Citizen getRegardingCitizen() {

        return this.regardingCitizen;
    }

    /**
     *
     * @return A list of citizens that has requested the case.
     */
    public List<Citizen> getRequestingCitizens() {

        return this.requestingCitizen;
    }

    /**
     *
     * @param requestingCitizen
     * @return True if the requesting citizen has been added.
     */
    public boolean addRequestingCitizen(Citizen requestingCitizen) {

        if (!this.requestingCitizen.contains(requestingCitizen)) {
            this.requestingCitizen.add(regardingCitizen);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return The ID of the department that have the case.
     */
    public int getDepartmentID() {

        return this.departmentID;
    }

    /**
     *
     * @return The map with all the information for the case.
     */
    public Map<String, String> getAllInformation() {

        return this.information;
    }

    /**
     *
     * @param key
     * @return Gets the information of the key.
     */
    public String getSpecificInformation(String key) {

        return this.information.get(key);
    }

    /**
     *
     * @param key
     * @param information
     * @return True if information is added.
     */
    public boolean addInformation(String key, String information) {

        // TODO: Add date for last changes.
        System.out.println("add info");
        this.information.put(key, information);
        System.out.println("info added");
        return this.information.containsKey(key);
    }

    /**
     *
     * @param key
     * @param information
     * @return True if the information is updated.
     */
    public boolean updateInformation(String key, String information) {

        // TODO: Add date for last changes.
        this.information.replace(key, information);

        return this.information.containsValue(information);
    }

    /**
     *
     * @return The date of the case last work
     */
    public String getDate() {
        return this.date;
    }

    /**
     *
     * @param information
     * @return Closes the case and return true.
     */
    public boolean closeCase(String information) {
        // TODO: Add date when case is closed.
        this.caseStatus = "Closed";
        this.information.put("Decision", information);
        return true;

    }

    /**
     *
     * @return The Date to tell when a case have been created.
     */
    private String dateStamp() {

        return GregorianCalendar.DAY_OF_MONTH + "-"
                + GregorianCalendar.MONTH + "-"
                + GregorianCalendar.YEAR + " "
                + GregorianCalendar.HOUR_OF_DAY + ":"
                + GregorianCalendar.MINUTE;
    }

    /**
     *
     * @return A new case number when the constructor is called.
     */
    private String setCaseNumber() {

        // Rapport: Check if case number has been crated, will be modifyed in #2.
        switch (this.departmentID) {
            case 1:
                String socialNum = "Social " + socialCount;
                socialCount++;
                return socialNum;
            case 2:
                String handicapNum = "Handicap " + handicapCount;
                handicapCount++;
                return handicapNum;
            default:
                return "Not a validated department";
        }
    }

    // TODO: Deletes in #2.
    @Override
    public String toString() {
        
        return "Case{" + "caseNumber=" + caseNumber + ", caseStatus="
                + caseStatus + ", date=" + date + ", regardingCitizen="
                + regardingCitizen + ", requestingCitizen=" + requestingCitizen
                + ", information=" + information + ", departmentID=" + departmentID + '}';
    }
}
