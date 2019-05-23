package LoginSystem.DataLayer;

import java.util.Map;

public class DbEmployee {

    private final int employeeID;
    private final String firstName;
    private final String lastName;
    private final int roleID;
    private final int departmentID;
    private Map<Integer, String> rigths; // Key == IDkey Integer of rigth value = Name

	/**
	 *
	 * @param employeeID
	 * @param firstName
	 * @param lastName
	 * @param roleID
	 * @param departmentID
	 */
	public DbEmployee(int employeeID, String firstName, String lastName, int roleID, int departmentID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
        this.departmentID = departmentID;
    }

	/**
	 *
	 * @return
	 */
	public int getEmployeeID() {
        return employeeID;
    }

	/**
	 *
	 * @return
	 */
	public String getFirstName() {
        return firstName;
    }

	/**
	 *
	 * @return
	 */
	public String getLastName() {
        return lastName;
    }

	/**
	 *
	 * @return
	 */
	public int getRoleID() {
        return roleID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

	/**
	 * Created for testing.
	 * 
	 * @return
	 */
    @Override
    public String toString() {
        return "DbEmployee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", roleID=" + roleID + ", departmentID=" + departmentID + ", rigths=" + rigths + '}';
    }

	/**
	 *
	 * @return
	 */
	public Map<Integer, String> getRights() {
        return rigths;
    }
}
