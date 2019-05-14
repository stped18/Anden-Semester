package Data_layer;

public class Employee {
    
    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int roleID;
    private final int departmentID;

    public Employee(int employeeID, String firstName, String lastName, int roleID, int departmentID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
        this.departmentID = departmentID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRoleID() {
        return roleID;
    }

    public int getDepartmentID() {
        return departmentID;
    }
    
}
