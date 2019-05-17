package MMMI.Data_layer;

import java.util.Map;

public class Employee {

    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int roleID;
    private final int departmentID;
    private Map<Integer, String> employeeCases;
    private Map<Integer, String> rights;

    public Employee(int employeeID, String firstName, String lastName, int roleID, int departmentID, Map<Integer, String> employeeCases, Map<Integer, String> rights) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
        this.departmentID = departmentID;
        this.employeeCases = employeeCases;
        this.rights = rights;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getRoleID() {
        return this.roleID;
    }

    public int getDepartmentID() {
        return this.departmentID;
    }

    public Map<Integer, String> getEmployeeCases() {
        return this.employeeCases;
    }

    public Map<Integer, String> getrights() {
        return this.rights;
    }
}
