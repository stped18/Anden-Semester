package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
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

    @Override
    public void setUsername(String username) {
        this.username = username;
        System.out.println("im set");
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        System.out.println("im set2");
    }

    public boolean getEmployee() {
        employee = db.getEmployeedb(this.username, this.password);
        if (employee == null) {
            return false;
        }
        return true;
    }

    @Override
    public DbEmployee sendEmployee() {
        employee = new DbEmployee(employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(), employee.getRoleID(), employee.getDepartmentID());
        return employee;
    }

}


