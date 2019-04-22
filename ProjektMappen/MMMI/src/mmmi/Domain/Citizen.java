package mmmi.Domain;

public class Citizen {

    private String name;
    private String cprNumber;
    private String address;
    private int phoneNumber;

    public Citizen(String name) {
        this.name = name;
        cprNumber = "Unregistered";
        address = "Unregistered";
        phoneNumber = 00000000;
    }

    public Citizen(String name, String cprNumber) {
        this.name = name;
        this.cprNumber = cprNumber;
        address = "Unregistered";
        phoneNumber = 00000000;
    }
    
    public Citizen(String name, String cprNumber, String address) {
        this.name = name;
        this.cprNumber = cprNumber;
        this.address = address;
        phoneNumber = 00000000;
    }
    
    public Citizen(String name, String cprNumber, int phoneNumber) {
        this.name = name;
        this.cprNumber = cprNumber;
        this.phoneNumber = phoneNumber;
        address = "Unregistered";
    }
    
    public Citizen(String name, String cprNumber, String address, int phoneNumber) {
        this.name = name;
        this.cprNumber = cprNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCprNumber() {
        return this.cprNumber;
    }

    public void setCprNumber(String cprNumber) {
        this.cprNumber = cprNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
