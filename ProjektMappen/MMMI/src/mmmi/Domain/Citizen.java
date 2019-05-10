package mmmi.Domain;

public class Citizen {

    private String name;
    private String cprNumber;
    private String address;
    private int phoneNumber;

    /**
     * @param name
     */
    public Citizen(String name) {
        this(name, "Unregistered", "Unregistered", 0);
    }

    /**
     * @param name
     * @param cprNumber
     */
    public Citizen(String name, String cprNumber) {
        this(name, cprNumber, "Unregistered", 0);
    }

    /**
     * @param name
     * @param cprNumber
     * @param address
     */
    public Citizen(String name, String cprNumber, String address) {
        this(name, cprNumber, address, 0);
    }

    /**
     * @param name        String.
     * @param cprNumber   String.
     * @param phoneNumber int.
     */
    public Citizen(String name, String cprNumber, int phoneNumber) {
        this(name, cprNumber, "Unregistered", phoneNumber);
    }

    /**
     * @param name
     * @param cprNumber
     * @param address
     * @param phoneNumber
     */
    public Citizen(String name, String cprNumber, String address, int phoneNumber) {
        this.name = name;
        this.cprNumber = cprNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getCprNumber() {
        return this.cprNumber;
    }

    /**
     * @param cprNumber
     */
    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    /**
     * @return
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return
     */
    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
