package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    @Override
    public Case readCase(String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citizen readCitizen(int citizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param employeeID
     * @return
     */
    @Override
    public Employee readEmployee(int employeeID) {
        
        // TODO: Need to return rights.
        
        int id = 0;
        String firstName = "";
        String lastName = "";
        int roleID = 0;
        int departmentID = 0;
        List<Integer> employeeCases = new ArrayList<>();

        try {
            connectToDB();

            String getEmployee = "SELECT * FROM employee WHERE employeeid = " + employeeID;
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(getEmployee);

            while (dbResultSet.next()) {
                id = dbResultSet.getInt("employeeID");
                firstName = dbResultSet.getString("firstname");
                lastName = dbResultSet.getString("lastname");
                roleID = dbResultSet.getInt("roleroleid");
                departmentID = dbResultSet.getInt("departmentdepartmentid");
            }

            String getCaseID = "SELECT casecaseid FROM case_employee WHERE employeeemployeeid = " + employeeID;
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(getCaseID);

            while (dbResultSet.next()) {
                employeeCases.add(dbResultSet.getInt("casecaseid"));
            }

            disConnectet();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Employee(id, firstName, lastName, roleID, departmentID, employeeCases);
    }

    @Override
    public boolean writeCase(Case theCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Case createCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citizen createCitizen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SearchCase> search(String searchKey, String searchValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
