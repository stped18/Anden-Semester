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
	 * Constructor that creates an new object of an Employee
	 * 
	 * @param employeeID int
	 * @param firstName String
	 * @param lastName String
	 * @param roleID int
	 * @param departmentID int
	 */
	public DbEmployee(int employeeID, String firstName, String lastName, int roleID, int departmentID) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleID = roleID;
        this.departmentID = departmentID;
    }

	/**
	 * Retruns the ID of the Employee.
	 * 
	 * @return Employee ID as an int.
	 */
	public int getEmployeeID() {
        return employeeID;
    }

	/**
	 * Retruns the 
	 * 
	 * @return Employee first name as a String.
	 */
	public String getFirstName() {
        return firstName;
    }

	/**
	 *
	 * @return Employee last name as a String
	 */
	public String getLastName() {
        return lastName;
    }

	/**
	 *
	 * @return Employee role ID as a int.
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
	 * @return The Employee as a String.
	 */
    @Override
    public String toString() {
        return "DbEmployee{" + "employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", roleID=" + roleID + ", departmentID=" + departmentID + ", rigths=" + rigths + '}';
    }

	/**
	 *
	 * @return A {@link java.util.Map<java.lang.Integer, java.lang.String>}, where the Key is the rightID and
	 * Value as the name of the right
	 */
	public Map<Integer, String> getRights() {
        return rigths;
    }
}
