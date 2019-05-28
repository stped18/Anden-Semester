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

	public LoginSystem() {
        mmmi = Department.getInstance();
    }

	/**
	 *
	 * @return The username of the logged in user as a String
	 */
	public String getUsername() {
        return username;
    }

	/**
	 * 
	 * Sets the username for the user that is trying to login or is logged in.
	 * 
	 * @param username String
	 */
	public void setUsername(String username) {
        this.username = username;
    }

	/**
	 *
	 * @return The passeword for the user as a String
	 */
	public String getPassword() {
        return password;
    }

	/**
	 *
	 * Sets the password for the user that's trying to login or is logged in.
	 * 
	 * @param password String
	 */
	public void setPassword(String password) {
        this.password = password;
    }

	/**
	 *
	 * @return true if it was possibale to set the login Employee equle to the
	 * mmmi Employee
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
	 * {@inheritDoc}
	 */
    @Override
    public int getEmployeeID() {
        return employee.getEmployeeID();
    }
}
