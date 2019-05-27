package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import LoginSystem.DataLayer.DbEmployee;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

/**
 * @TODO: Need to implement ILogin Interface.
 */
public class LoginSystem implements IEmployee {

    private String username;
    private String password;
    private DatabaseHandler db = new DatabaseHandler();
    private DbEmployee employee;

    private IDomain mmmi;

	/**
	 *
	 */
	public LoginSystem() {
        mmmi = Department.getInstance();
    }

	/**
	 *
	 * @return
	 */
	public String getUsername() {
        return username;
    }

	/**
	 *
	 * @param username
	 */
	public void setUsername(String username) {
        this.username = username;
    }

	/**
	 *
	 * @return
	 */
	public String getPassword() {
        return password;
    }

	/**
	 *
	 * @param password
	 */
	public void setPassword(String password) {
        this.password = password;
    }

	/**
	 *
	 * @return
	 */
	public boolean getEmployee() {
        employee = db.getEmployeedb(this.username, this.password);
        if (employee == null) {
            return false;
        }
        mmmi.setDepartmentID(employee.getDepartmentID());
        mmmi.setLoginEmployee(this);
        return true;
    }

	/**
	 * 
	 * @return 
	 */
    @Override
    public int getEmployeeID() {
        return employee.getEmployeeID();
    }
}
