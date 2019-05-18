package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        int id = employeeID;
        String firstName = "";
        String lastName = "";
        int roleID = -1;
        int departmentID = -1;
        int caseID = -1;
        Map<Integer, String> employeeCases = new HashMap<>();
        Map<Integer, String> rights = new HashMap<>();

        int citizenID = -1;

        // TODO: Get rights from database and set in map.
        int rightsid = -1;

        try {
            connectToDB();
            dbStatement = dbConnection.createStatement();

            String getEmployee = "SELECT * FROM employee WHERE employeeid = " + employeeID;
            dbResultSet = dbStatement.executeQuery(getEmployee);

            while (dbResultSet.next()) {
                firstName = dbResultSet.getString("firstname");
                lastName = dbResultSet.getString("lastname");
                roleID = dbResultSet.getInt("roleroleid");
                departmentID = dbResultSet.getInt("departmentdepartmentid");
            }

            String getCaseID = "SELECT casecaseid FROM case_employee WHERE employeeemployeeid = " + employeeID;
            dbResultSet = dbStatement.executeQuery(getCaseID);

            while (dbResultSet.next()) {
                caseID = dbResultSet.getInt("casecaseid");
            }

            String getCitizenID = "SELECT citizencitizenid FROM case WHERE caseid = " + caseID;
            dbResultSet = dbStatement.executeQuery(getCitizenID);

            while (dbResultSet.next()) {
                citizenID = dbResultSet.getInt("citizencitizenid");
            }

            String getCitizenName = "SELECT firstname AND lastname FROM citizen WHERE citizenid = " + citizenID;
            dbResultSet = dbStatement.executeQuery(getCitizenName);

            while (dbResultSet.next()) {
                employeeCases.put(caseID, dbResultSet.getString("firstname") + dbResultSet.getString("lastName"));
            }

            String getRightsID = "SELECT rightsrightsid from role_rights WHERE roleroleid = " + roleID;
            dbResultSet = dbStatement.executeQuery(getRightsID);

            while (dbResultSet.next()) {
                rightsid = dbResultSet.getInt("rightsrighstid");
            }

            String getRights = "SELECT * FORM role_rights WHERE rightsid = " + rightsid;
            dbResultSet = dbStatement.executeQuery(getRights);
            
            while(dbResultSet.next()) {
                rights.put(rightsid, dbResultSet.getString("rightsname"));
            }

            disConnectet();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Employee(employeeID, firstName, lastName, roleID, departmentID, employeeCases, rights);
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
