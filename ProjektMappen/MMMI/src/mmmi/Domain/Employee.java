package mmmi.Domain;

import java.util.Map;

public class Employee {

    private final int employeeID;
    private final String name;
    private final int roleID;
    private final int departmentID;
    private final Map<Integer, String> employeeCases;
    private final Map<Integer, String> rights;

	/**
	 *
	 * @param employeeID
	 * @param name
	 * @param roleID
	 * @param departmentID
	 * @param employeeCases
	 * @param rights
	 */
	public Employee(int employeeID, String name, int roleID, int departmentID, Map<Integer, String> employeeCases, Map<Integer, String> rights) {
        this.employeeID = employeeID;
        this.name = name;
        this.roleID = roleID;
        this.departmentID = departmentID;
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
	public int getDepartmentID() {
        return this.departmentID;
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

	/**
	 *
	 * @param rightID
	 * @return
	 */
	public boolean checkRight(int rightID) {
        return this.rights.containsKey(rightID);
    }
}
