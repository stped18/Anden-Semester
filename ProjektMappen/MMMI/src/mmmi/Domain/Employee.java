package mmmi.Domain;

import java.util.Map;

public class Employee {

    private int id;
    private String firstName;
    private String lastname;
    private int departmentID;
    private int roleID;
    private Map<Integer, String> rightsMap;
    private Map<Integer, String> caseMap;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastname, int departmentID, int roleID, Map<Integer, String> rightsMap) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.departmentID = departmentID;
        this.roleID = roleID;
        this.rightsMap = rightsMap;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getDepartmentID() {
        return this.departmentID;
    }

    public int getRoleID() {
        return this.roleID;
    }

    public Map<Integer, String> getRightsMap() {
        return this.rightsMap;
    }
    
    public Map<Integer,String> getCaseMap() {
        return this.caseMap;
    }

    public boolean checkRight(int rightID) {
        return this.rightsMap.containsKey(rightID);
    }
}
