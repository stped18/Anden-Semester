package mmmi.Data_layer;

import java.util.List;

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
	 *
	 * @return
	 */
	public List<Case> getCases() {
        return Cases;
    }

	/**
	 *
	 * @return
	 */
	public int getCitizenID() {
        return citizenID;
    }

	/**
	 *
	 * @return
	 */
	public String getFirstName() {
        return firstName;
    }

	/**
	 *
	 * @return
	 */
	public String getLastName() {
        return lastName;
    }

	/**
	 *
	 * @return
	 */
	public String getCprNo() {
        return cprNo;
    }

	/**
	 *
	 * @return
	 */
	public String getStreetName() {
        return streetName;
    }

	/**
	 *
	 * @return
	 */
	public String getHouseNo() {
        return houseNo;
    }

	/**
	 *
	 * @return
	 */
	public String getFloor() {
        return floor;
    }

	/**
	 *
	 * @return
	 */
	public String getFloorDirection() {
        return floorDirection;
    }

	/**
	 *
	 * @return
	 */
	public int getZipcode() {
        return zipcode;
    }

	/**
	 *
	 * @return
	 */
	public String getCityname() {
        return cityname;
    }

	/**
	 *
	 * @return
	 */
	public boolean isRegardingCitizen() {
        return regardingCitizen;
    }

	/**
	 *
	 * @return
	 */
	public boolean isRequestingCitizen() {
        return requestingCitizen;
    }

	/**
	 *
	 * @param citizenID
	 */
	public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }

	/**
	 *
	 * @param Cases
	 */
	public void setCases(List<Case> Cases) {
        this.Cases = Cases;
    }

	/**
	 *
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

	/**
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	/**
	 *
	 * @param cprNo
	 */
	public void setCprNo(String cprNo) {
        this.cprNo = cprNo;
    }

	/**
	 *
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

	/**
	 *
	 * @param houseNo
	 */
	public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

	/**
	 *
	 * @param floor
	 */
	public void setFloor(String floor) {
        this.floor = floor;
    }

	/**
	 *
	 * @param floorDirection
	 */
	public void setFloorDirection(String floorDirection) {
        this.floorDirection = floorDirection;
    }

	/**
	 *
	 * @param zipcode
	 */
	public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

	/**
	 *
	 * @param cityname
	 */
	public void setCityname(String cityname) {
        this.cityname = cityname;
    }

	/**
	 *
	 * @param regardingCitizen
	 */
	public void setRegardingCitizen(boolean regardingCitizen) {
        this.regardingCitizen = regardingCitizen;
    }

	/**
	 *
	 * @param requestingCitizen
	 */
	public void setRequestingCitizen(boolean requestingCitizen) {
        this.requestingCitizen = requestingCitizen;
    }

	/**
	 * For Testing.
	 * @return
	 */
	@Override
    public String toString() {
        String casestring = "";
        return "Citizen{" + "citizenID=" + citizenID + ", firstName=" + firstName + ", lastName=" + lastName + ", cprNo=" + cprNo + ", streetName=" + streetName + ", houseNo=" + houseNo + ", floor=" + floor + ", floorDirection=" + floorDirection + ", zipcode=" + zipcode + ", cityname=" + cityname + ", regardingCitizen=" + regardingCitizen + ", requestingCitizen=" + requestingCitizen + ", Cases=" + casestring + '}';
    }
}
