package mmmi.Data_layer;

import java.util.List;

/**
 * @TODO: Error handling
 */
public class Citizen {

    private int citizenID;
    private String firstName;
    private String lastName;
    private String cprNo;
    private String streetName;
    private String houseNo;
    private String floor;
    private String floorDirection;
    private int zipcode;
    private String cityname;
    private boolean regardingCitizen;
    private boolean requestingCitizen;
    private List<Case> Cases;

    /**
     * Constructor, used when creating a regarding Citizen.
     *
     * @param citizenID
     * @param firstName
     * @param lastName
     * @param cprNo
     * @param regardingCitizen
     * @param requestingCitizen
     */
    public Citizen(int citizenID, String firstName, String lastName, String cprNo, boolean regardingCitizen, boolean requestingCitizen) {
        this.citizenID = citizenID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNo = cprNo;
        this.regardingCitizen = regardingCitizen;
        this.requestingCitizen = requestingCitizen;
    }

    /**
     * Constructor, used when creating a requesting citizen
     *
     * @param citizenID
     * @param firstName
     * @param lastName
     * @param cprNo
     * @param streetName
     * @param houseNo
     * @param floor
     * @param floorDirection
     * @param zipcode
     * @param cityname
     * @param regardingCitizen
     * @param requestingCitizen
     */
    public Citizen(int citizenID, String firstName, String lastName, String cprNo, String streetName, String houseNo, String floor, String floorDirection, int zipcode, String cityname, boolean regardingCitizen, boolean requestingCitizen) {
        this.citizenID = citizenID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNo = cprNo;
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.floor = floor;
        this.floorDirection = floorDirection;
        this.zipcode = zipcode;
        this.cityname = cityname;
        this.regardingCitizen = regardingCitizen;
        this.requestingCitizen = requestingCitizen;
    }

    /**
     * Getter method for variable cases.
     *
     * @return A list of cases reguarding the specefice Citizen.
     */
    public List<Case> getCases() {
        return Cases;
    }

    /**
     * Getter method for variable citizenID
     *
     * @return A Citizen ID as an int.
     */
    public int getCitizenID() {
        return citizenID;
    }

    /**
     * Getter method for variable firstName.
     *
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for variable lastName.
     *
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method for variable cprNo.
     *
     * @return String cprNo
     */
    public String getCprNo() {
        return cprNo;
    }

    /**
     * Getter method for variable streetName.
     *
     * @return String streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Getter method for variable houseNo.
     *
     * @return String houseNo
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Getter method for variable floor.
     *
     * @return String floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * Getter method for variable floorDirection.
     *
     * @return String floorDirection
     */
    public String getFloorDirection() {
        return floorDirection;
    }

    /**
     * Getter method for variable zipcode.
     *
     * @return int zipcode
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * Getter method for variable cityname.
     *
     * @return Stgring cityname
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * Getter method for variable regardingCitizen.
     *
     * @return boolean regardingCitizen
     */
    public boolean isRegardingCitizen() {
        return regardingCitizen;
    }

    /**
     * Getter method for variable requestingCitizen.
     *
     * @return boolean requestingCitizen
     */
    public boolean isRequestingCitizen() {
        return requestingCitizen;
    }

    /**
     * Setter method for variable citizenID.
     *
     * @param citizenID, int
     */
    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }

    /**
     * Setter method for variable Cases.
     *
     * @param Cases, List<Case>
     */
    public void setCases(List<Case> Cases) {
        this.Cases = Cases;
    }

    /**
     * Setter method for variable firstName.
     *
     * @param firstName, String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter method for variable lastName.
     *
     * @param lastName, String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter method for variable cprNo.
     *
     * @param cprNo, int
     */
    public void setCprNo(String cprNo) {
        this.cprNo = cprNo;
    }

    /**
     * Setter method for variable streetName.
     *
     * @param streetName, String
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Setter method for variable houseNo.
     *
     * @param houseNo, String
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * Setter method for variable floor.
     *
     * @param floor, String
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * Setter method for variable floorDirection.
     *
     * @param floorDirection, String
     */
    public void setFloorDirection(String floorDirection) {
        this.floorDirection = floorDirection;
    }

    /**
     * Setter method for variable zipcode.
     *
     * @param zipcode, int
     */
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Setter method for variable cityname.
     *
     * @param cityname, String
     */
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    /**
     * Setter method for variable regardingCitizen.
     *
     * @param regardingCitizen, boolean
     */
    public void setRegardingCitizen(boolean regardingCitizen) {
        this.regardingCitizen = regardingCitizen;
    }

    /**
     * Setter method for variable requestingCitizen.
     *
     * @param requestingCitizen, boolean
     */
    public void setRequestingCitizen(boolean requestingCitizen) {
        this.requestingCitizen = requestingCitizen;
    }

    /**
     * For Testing.
     *
     * @return
     */
    @Override
    public String toString() {
        String casestring = "";
        return "Citizen{" + "citizenID=" + citizenID + ", firstName=" + firstName + ", lastName=" + lastName + ", cprNo=" + cprNo + ", streetName=" + streetName + ", houseNo=" + houseNo + ", floor=" + floor + ", floorDirection=" + floorDirection + ", zipcode=" + zipcode + ", cityname=" + cityname + ", regardingCitizen=" + regardingCitizen + ", requestingCitizen=" + requestingCitizen + ", Cases=" + casestring + '}';
    }
}
