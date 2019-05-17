package mmmi.Domain;

import LoginSystem.Domain.IEmployee;
import LoginSystem.Domain.LoginSystem;
import java.util.List;
import java.util.Map;
import mmmi.Domain.Interfaces.IDomain;

public class Department implements IDomain {

    private final int id;

    private final IEmployee loginEmployee = new LoginSystem();
    private Employee mmmiEmployee;

    /**
     * @param id
     */
    public Department(int id) {
        this.id = id;
    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(String caseNumber, int employeeID) {

        throw new UnsupportedOperationException();

    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(String caseNumber, int employeeID) {

        throw new UnsupportedOperationException();
    }

    /**
     * @param name
     * @param reason
     * @return
     */
    public boolean createCase(String name, String reason) {

        throw new UnsupportedOperationException();

    }

    //REMEMBER: to use the correct names from the IDataHandler interface.
    //REMEMBER: check rights ask the people and dont just do some random stuff.
    @Override
    public List<Map<String, String>> Search(String key, String value) {
        //TODO: needs to be able to send all info from a searchcase to the GUI in the form of list with a map
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> openCase(String caseID) {
        //TODO: Opens a case with all the info into a map that are sendt to the GUI
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCase(Map<String, String> caseInfo) {
        //TODO: Gets a map with both case info and citizen and needs to make it into the right data
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployee() {
        return receiveEmployee();
    }

    private Employee receiveEmployee() {

        int employeeid = loginEmployee.sendEmployee().getEmployeeID();
        int roleID = loginEmployee.sendEmployee().getRoleID();
        int departmentID = loginEmployee.sendEmployee().getDepartmentID();
        String firstName = loginEmployee.sendEmployee().getFirstName();
        String lastname = loginEmployee.sendEmployee().getLastName();
        Map<Integer, String> rightsMap = loginEmployee.sendEmployee().getRights();
        
        return mmmiEmployee = new Employee(employeeid, firstName, lastname, departmentID, roleID, rightsMap);
    }
}
