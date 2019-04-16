package mmmi.Domain;

public class Employee {

    private int id;
    private String name;
    private int departmentID;

    /**
     *
     * @param name
     */
    public Employee(String name, int id, int departmentID) {
        this.name = name;
        this.id = id;
        this.departmentID = departmentID;
    }

    public int getId() {
        return this.id;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    /**
     *
     * @param departmentID
     */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
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

}