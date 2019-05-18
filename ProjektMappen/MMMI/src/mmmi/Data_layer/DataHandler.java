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
        String empolyeeName = "";
        int roleID = -1;
        int departmentID = -1;
        Map<String, String> employeeCases = new HashMap<>();
        Map<Integer, String> rights = new HashMap<>();

        // TODO: Get rights from database and set in map.

        try {
            connectToDB();
            dbStatement = dbConnection.createStatement();

            String selectQuery = "SELECT em.departmentdepartmentid AS departmentid,"
                    + "em.roleroleid AS roleid,"
                    + "CONCAT(em.firstname, ' ', em.lastname) AS employeename,"
                    + "ce.casecaseid AS caseid,"
                    + "CONCAT(ci.firstname, ' ', ci.lastname) AS citizenname";
            String fromQuery = "FROM employee AS em, case_employee AS ce, \"case\" AS c, citizen AS ci";
            String whereQuery = "WHERE em.employeeid = ?"
                    + "AND ce.employeeemployeeid = ? AND c.caseid = ce.casecaseid"
                    + "AND ci.citizenid = c.citizenregardingcitizenid;";
            String query = selectQuery + fromQuery + whereQuery; 

            dbResultSet = dbStatement.executeQuery(query);
            
            while(dbResultSet.next()) {
                departmentID = dbResultSet.getInt("departmentid");
                roleID = dbResultSet.getInt("roleid");
                empolyeeName = dbResultSet.getString("employeename");
                employeeCases.put(dbResultSet.getString("caseid"), dbResultSet.getString("citizenname"));
            }
            
            String selectQuery2, fromQuery2, whereQuery2;
            
            selectQuery2 = "SELECT r.rightsid AS rightsid, r,rightsname AS rightsname";
            fromQuery2 = "FROM role_rights AS rr, rights AS r";
            whereQuery2 = "WHERE rr.roleroleid = " + roleID + "AND r.rightsid = rr.rightsrightsid";
            
            String query2 = selectQuery2 + fromQuery2 + whereQuery2; 
            
            dbResultSet = dbStatement.executeQuery(query2);

            while(dbResultSet.next()) {
                rights.put(dbResultSet.getInt("rightsid"), dbResultSet.getString("rightsname"));
            }

            disConnectet();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new Employee(employeeID, empolyeeName, roleID, departmentID, employeeCases, rights);
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
