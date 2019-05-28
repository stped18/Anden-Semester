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
	 * Constructor that creates an new object of 
	 * 
	 * @param employeeID int
	 * @param name String
	 * @param roleID int
	 * @param employeeCases Map<Integer, String>
	 * @param rights Map<Integer, String>
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
	 * @return Employee ID as an int
	 */
	public int getEmployeeID() {
        return this.employeeID;
    }

	/**
	 *
	 * @return Employees full name as a String
	 */
	public String getName() {
        return this.name;
    }

	/**
	 *
	 * @return Employee role ID as an int
	 */
	public int getRoleID() {
        return this.roleID;
    }

	/**
	 *
	 * @return Map<Integer, String> of Employees assigned cases
	 */
	public Map<Integer, String> getEmployeeCases() {
        return this.employeeCases;
    }

	/**
	 *
	 * @return Map<Integer, String> Employees rights
	 */
	public Map<Integer, String> getrights() {
        return this.rights;
    }
}
