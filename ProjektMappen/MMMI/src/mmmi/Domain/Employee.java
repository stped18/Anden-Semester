package mmmi.Domain;

public class Employee {

	private int id;
	private String name;

	/**
	 * 
	 * @param name
	 */
	public Employee(String name) {
		// TODO - implement Employee.Employee
		throw new UnsupportedOperationException();
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

    void setCase(int caseNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}