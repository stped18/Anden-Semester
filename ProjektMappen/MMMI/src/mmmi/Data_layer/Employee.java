package mmmi.Data_layer;

import java.util.Map;

public class Employee {

    private final int employeeID;
    private final String name;
    private final int roleID;
    private final Map<Integer, String> employeeCases;
    private final Map<Integer, String> rights;

	/**
	 *
	 * @param employeeID
	 * @param name
	 * @param roleID
	 * @param employeeCases
	 * @param rights
	 */
	public Employee(int employeeID, String name, int roleID, Map<Integer, String> employeeCases, Map<Integer, String> rights) {
        this.employeeID = employeeID;
        this.name = name;
        this.roleID = roleID;
        this.employeeCases = employeeCases;
        this.rights = rights;
    }

	/**
	 *
	 * @return
	 */
	public int getEmployeeID() {
        return this.employeeID;
    }

	/**
	 *
	 * @return
	 */
	public String getName() {
        return this.name;
    }

	/**
	 *
	 * @return
	 */
	public int getRoleID() {
        return this.roleID;
    }

	/**
	 *
	 * @return
	 */
	public Map<Integer, String> getEmployeeCases() {
        return this.employeeCases;
    }

	/**
	 *
	 * @return
	 */
	public Map<Integer, String> getrights() {
        return this.rights;
    }
}
