package mmmi.Domain;

public class Employee {

    private int id;
    private String name;
    private int departmentID;
    //TODO: needs rights and a way to check them. 

    /**
     * @param name
     * @param id
     * @param departmentID
     */
    public Employee(String name, int id, int departmentID) {
        this.name = name;
        this.id = id;
        this.departmentID = departmentID;
        
    }

    /**
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return
     */
    public int getDepartmentID() {
        return departmentID;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

}
