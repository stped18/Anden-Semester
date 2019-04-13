package mmmi.Domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Case {

    private final int caseNumber;
    private String caseStatus;
    private final String date; // Has been changed from object Date to a String.
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
    public Case(Citizen regardingCitizen, String reason, int departmentID) {
        this.regardingCitizen = regardingCitizen;
        this.caseNumber = 1; // Has to be crated in another way.
        this.information.put("reason", reason);
        this.caseStatus = "Created";
        this.departmentID = departmentID;
        this.date = dateStamp();
    }

    /**
     *
     * @return The status of the case.
     */
    public String getCaseStatus() {
        return this.caseStatus;
    }

    /**
     * Have been added so it's possibal to change the status of the case.
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
     * @return The citizen the cases is about.
     */
    public Citizen getRegardingCitizen() {
        return this.regardingCitizen;
    }

    /**
     *
     * @return A list af citizens that has requested the case.
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
     * @return
     */
    public Map<String, String> getAllInformation() {
        // TODO - implement Case.getAllInformation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param key
     * @return
     */
    public String getSpecificInformation(String key) {
        // TODO - implement Case.getSpecificInformation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param key
     * @param information
     * @return
     */
    public boolean addInformation(String key, String information) {
        // TODO - implement Case.addInformation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param key
     * @param information
     * @return
     */
    public boolean updateInformation(String key, String information) {
        // TODO - implement Case.updateInformation
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param information
     * @return
     */
    public boolean closeCase(String information) {
        // TODO - implement Case.closeCase
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @return The Date to tell when a case have been crated.
     */
    private String dateStamp() {
        Calendar now = GregorianCalendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int mounth = now.get(Calendar.MONTH);
        int year = now.get(Calendar.YEAR);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        return "The case have been crated on: Day " + day + "/" + mounth + "-"
                + year + " Time: " + hour + ":" + minute;
    }
}
