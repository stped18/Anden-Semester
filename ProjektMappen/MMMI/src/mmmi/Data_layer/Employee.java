package MMMI.Data_layer;

import java.util.List;

public class Employee {
    
    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int roleID;
    private final int departmentID;
    private List<Integer> employeeCases;

    public Employee(int employeeID, String firstName, String lastName, int roleID, int departmentID, List<Integer> employeeCases) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
        this.departmentID = departmentID;
        this.employeeCases = employeeCases;
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
    
    public List<Integer> getEmployeeCases() {
        return this.employeeCases;
    }
    
}
