package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.SQLException;
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

            String selectQuery = "SELECT em.departmentdepartmentid AS departmentid,"
                    + "em.roleroleid AS roleid,"
                    + "CONCAT(em.firstname, ' ', em.lastname) AS employeename,"
                    + "ce.casecaseid AS caseid,"
                    + "CONCAT(ci.firstname, ' ', ci.lastname) AS citizenname";
            String fromQuery = "FROM employee AS em, case_employee AS ce, \"case\" AS c, citizen AS ci";
            String whereQuery = "WHERE em.employeeid = 7"
                    + "AND ce.employeeemployeeid = 7 AND c.caseid = ce.casecaseid"
                    + "AND ci.citizenid = c.citizenregardingcitizenid;";
            String query = selectQuery + fromQuery + whereQuery; 

            dbResultSet = dbStatement.executeQuery(query);
            
            while(dbResultSet.next()) {
                
            }
            
            String getRightsID = "SELECT rightsrightsid from role_rights WHERE roleroleid = " + roleID;
            dbResultSet = dbStatement.executeQuery(getRightsID);

            while (dbResultSet.next()) {
                rightsid = dbResultSet.getInt("rightsrighstid");
            }

            String getRights = "SELECT * FORM rights WHERE rightsid = " + rightsid;
            dbResultSet = dbStatement.executeQuery(getRights);

            while (dbResultSet.next()) {
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
