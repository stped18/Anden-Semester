package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
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

        String selectQuery, fromQuery, whereQuery, query;
        PreparedStatement keyPreparedStatement = null;

        try {
            connectToDB();

            selectQuery = "SELECT em.departmentdepartmentid AS departmentid, "
                    + "em.roleroleid AS roleid, "
                    + "CONCAT(em.firstname, ' ', em.lastname) AS employeename, "
                    + "ce.casecaseid AS caseid, "
                    + "CONCAT(ci.firstname, ' ', ci.lastname) AS citizenname ";
            fromQuery = "FROM employee AS em, case_employee AS ce, \"case\" AS c, citizen AS ci ";
            whereQuery = "WHERE em.employeeid = ? "
                    + "AND ce.employeeemployeeid = ? AND c.caseid = ce.casecaseid "
                    + "AND ci.citizenid = c.citizenregardingcitizenid;";
            query = selectQuery + fromQuery + whereQuery;

            keyPreparedStatement = dbConnection.prepareStatement(query);
            keyPreparedStatement.setInt(1, employeeID);
            keyPreparedStatement.setInt(2, employeeID);
            dbResultSet = keyPreparedStatement.executeQuery();

            while (dbResultSet.next()) {
                departmentID = dbResultSet.getInt("departmentid");
                roleID = dbResultSet.getInt("roleid");
                empolyeeName = dbResultSet.getString("employeename");
                employeeCases.put(dbResultSet.getString("caseid"), dbResultSet.getString("citizenname"));
            }

            selectQuery = "SELECT r.rightsid AS rightsid, r,rightsname AS rightsname ";
            fromQuery = "FROM role_rights AS rr, rights AS r ";
            whereQuery = "WHERE rr.roleroleid = " + roleID + "AND r.rightsid = rr.rightsrightsid;";

            query = selectQuery + fromQuery + whereQuery;

            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(query);

            while (dbResultSet.next()) {
                rights.put(dbResultSet.getInt("rightsid"), dbResultSet.getString("rightsname"));
            }
        } catch (SQLException ex) {
            System.out.println("getEmployee:\nSQLState:" + ex.getSQLState() + "\nMessage:" + ex.getMessage());
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            disConnectet();
        } finally {
            disConnectet();
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
