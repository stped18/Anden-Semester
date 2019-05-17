package mmmi.Domain;

import LoginSystem.Domain.IEmployee;
import LoginSystem.Domain.LoginSystem;
import java.util.HashMap;
import java.util.Map;

public class Employee {

    private int id;
    private String firstName;
    private String lastname;
    private int departmentID;
    private int roleID;
    private Map<Integer, String> rightsMap = new HashMap<>();

    private final IEmployee employee = new LoginSystem();

    public Employee() {
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getDepartmentID() {
        return this.departmentID;
    }
    
    public int getRoleID() {
        return this.roleID;
    }
    
    public Map<Integer, String> getRightsMap() {
        return this.rightsMap;
    }
    
    public boolean checkRight(int rightID) {
        return this.rightsMap.containsKey(rightID);
    }

    private void receiveEmployee() {

        this.id = employee.sendEmployee().getEmployeeID();
        this.roleID = employee.sendEmployee().getRoleID();
        this.departmentID = employee.sendEmployee().getDepartmentID();
        this.firstName = employee.sendEmployee().getFirstName();
        this.lastname = employee.sendEmployee().getLastName();
        this.rightsMap = employee.sendEmployee().getRights();
    }

}
