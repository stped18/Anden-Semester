package mmmi.Domain;

import LoginSystem.Domain.IEmployee;
import LoginSystem.Domain.LoginSystem;
import MMMI.Data_layer.DataHandler;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.util.List;
import java.util.Map;
import mmmi.Domain.Interfaces.IDomain;

public class Department implements IDomain {

    private final int id;

    private IDataHandler dataHandler = new DataHandler();
    private IEmployee loginEmployee = new LoginSystem();
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
        
        String firstName = dataHandler.readEmployee(employeeid).getFirstName();
        String lastName = dataHandler.readEmployee(employeeid).getLastName();
        int departmentID = dataHandler.readEmployee(employeeid).getDepartmentID();
        int roleID = dataHandler.readEmployee(employeeid).getRoleID();
        Map<Integer, String> casemap = dataHandler.readEmployee(employeeid).getEmployeeCases();
        Map<Integer, String> rightsMap = dataHandler.readEmployee(employeeid).getrights();

        return mmmiEmployee = new Employee(employeeid, firstName, lastName, departmentID, roleID, casemap, rightsMap);
    }
}
