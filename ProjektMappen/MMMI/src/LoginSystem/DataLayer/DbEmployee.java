/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.DataLayer;

import java.util.Map;

/**
 *
 * @author steff
 */
public class DbEmployee {


    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int roleID;
    private final int departmentID;
    private Map<Integer, String> rigths; // Key == IDkey Integer of rigth value = Name

    public DbEmployee(int employeeID, String firstName, String lastName, int roleID, int departmentID) {
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

    // Test
    @Override
    public String toString() {
        return "DbEmployee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", roleID=" + roleID + ", departmentID=" + departmentID + ", rigths=" + rigths + '}';
    }
    
    

}
    






