/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import LoginSystem.DataLayer.DbEmployee;
import MMMI.Data_layer.Employee;
import LoginSystem.DataLayer.DbEmployee;

/**
 *
 * @author steff
 */
public class LoginSystem implements IEmployee {

    private String username;
    private String password;
    DatabaseHandler db = new DatabaseHandler();
    DbEmployee employee;

    public LoginSystem() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEmployee() {
        employee = db.getEmployeedb(this.username, this.password);
        if (employee == null) {
            return false;
        }
        return true;
    }

//    @Override
//    public Employee sendEmployee() {
//   employee = new Employee(employee.getEmployeeID(), employee.getFirstName(),employee.getLastName(), employee.getRoleID(),  employee.getDepartmentID());
//    return e;
//       
//    }
    @Override
    public DbEmployee sendEmployee() {
        employee = new DbEmployee(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), employee.getRoleID(), employee.getDepartmentID());
        return employee;
    }

}


