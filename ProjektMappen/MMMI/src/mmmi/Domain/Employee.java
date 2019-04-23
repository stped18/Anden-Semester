package mmmi.Domain;

public class Employee {

    private int id;
    private String name;
    private int departmentID;
    private JobTitle jobFunction; // Role, jobtitle, ...
    private String title;

    /**
     *
     * @param name
     */
    public Employee(String name, int id, int departmentID, String title) {
        this.name = name;
        this.id = id;
        this.departmentID = departmentID;
        this.title = title;
        if(title.equalsIgnoreCase("caseworker")) {
            jobFunction = new Caseworker();
        } else if(title.equalsIgnoreCase("secretary")) {
            jobFunction = new Secretary();
        } else if(title.equalsIgnoreCase("departmentmanager")) {
            jobFunction = new DepartmentManager();
        }
    }

    public String getTitle() {
        return title;
    }
    

    public JobTitle getJob() {
        return jobFunction;
    }

    public void setJob(JobTitle job) {
        this.jobFunction = job;
        
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
