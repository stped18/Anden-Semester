package mmmi.Domain;

import LoginSystem.Domain.IEmployee;

public class Employee {

    private int id;
    private String firstName;
    private String lastname;
    private int departmentID;
    //TODO: needs rights and a way to check them. 

    IEmployee getEmployee;
    
    /**
     * @param name
     * @param id
     * @param departmentID
     */
    public Employee(int id, String firstName, String lastname, int departmentID) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.departmentID = departmentID;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getDepartmentID() {
        return departmentID;
    }


}

