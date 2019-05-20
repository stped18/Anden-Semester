package MMMI.Data_layer;

import java.util.Map;

public class Employee {

    private final int employeeID;
    private final String name;
    private final int roleID;
    private final Map<String, String> employeeCases;
    private final Map<Integer, String> rights;

    public Employee(int employeeID, String name, int roleID, Map<String, String> employeeCases, Map<Integer, String> rights) {
        this.employeeID = employeeID;
        this.name = name;
        this.roleID = roleID;
        this.employeeCases = employeeCases;
        this.rights = rights;
    }

   

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getName() {
        return this.name;
    }

    public int getRoleID() {
        return this.roleID;
    }

    public Map<String, String> getEmployeeCases() {
        return this.employeeCases;
    }

    public Map<Integer, String> getrights() {
        return this.rights;
    }
}

