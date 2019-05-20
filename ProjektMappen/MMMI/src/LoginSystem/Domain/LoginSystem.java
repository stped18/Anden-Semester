package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import LoginSystem.DataLayer.DbEmployee;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

/**
 *
 * @author steff
 */
public class LoginSystem implements IEmployee {

    private String username;
    private String password;
    private DatabaseHandler db = new DatabaseHandler();
    private DbEmployee employee;

    private IDomain mmmi;

    public LoginSystem() {
        mmmi = Department.getInstance();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("im set");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("im set2");
    }

    public boolean getEmployee() {
        employee = db.getEmployeedb(this.username, this.password);
        mmmi.setDepartmentID(employee.getDepartmentID());
        mmmi.setLoginEmployee(this);
        if (employee == null) {
            return false;
        }
        return true;
    }

    @Override
    public int getEmployeeID() {
        return employee.getEmployeeID();
    }

}
