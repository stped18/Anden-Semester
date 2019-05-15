package MMMI.Data_layer;

public class Citizen {
    
    private final int citizenID;
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

    public Citizen(int citizenID, String firstName, String lastName, String cprNo, boolean regardingCitizen, boolean requestingCitizen) {
        this.citizenID = citizenID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNo = cprNo;
        this.regardingCitizen = regardingCitizen;
        this.requestingCitizen = requestingCitizen;
    }
    
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

    public int getCitizenID() {
        return citizenID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCprNo() {
        return cprNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getFloor() {
        return floor;
    }

    public String getFloorDirection() {
        return floorDirection;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCityname() {
        return cityname;
    }

    public boolean isRegardingCitizen() {
        return regardingCitizen;
    }

    public boolean isRequestingCitizen() {
        return requestingCitizen;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCprNo(String cprNo) {
        this.cprNo = cprNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setFloorDirection(String floorDirection) {
        this.floorDirection = floorDirection;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public void setRegardingCitizen(boolean regardingCitizen) {
        this.regardingCitizen = regardingCitizen;
    }

    public void setRequestingCitizen(boolean requestingCitizen) {
        this.requestingCitizen = requestingCitizen;
    }
    
}
