package MMMI.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
                    + "AND ce.employeeemployeeid = em.employeeid AND c.caseid = ce.casecaseid "
                    + "AND ci.citizenid = c.citizenregardingcitizenid;";
            query = selectQuery + fromQuery + whereQuery;

            keyPreparedStatement = dbConnection.prepareStatement(query);
            keyPreparedStatement.setInt(1, employeeID);
            dbResultSet = keyPreparedStatement.executeQuery();

            while (dbResultSet.next()) {
                departmentID = dbResultSet.getInt("departmentid");
                roleID = dbResultSet.getInt("roleid");
                empolyeeName = dbResultSet.getString("employeename");
                employeeCases.put(dbResultSet.getString("caseid"), dbResultSet.getString("citizenname"));
            }

            selectQuery = "SELECT r.rightsid AS rightsid, r,rightsname AS rightsname ";
            fromQuery = "FROM role_rights AS rr, rights AS r ";
            whereQuery = "WHERE rr.roleroleid = " + roleID + " AND r.rightsid = rr.rightsrightsid;";

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
        // TODO: Handle empty case.
        connectToDB();
        try {

//            String count = "'?'";
            String[] list = {theCase.columnStringBuilder(theCase.getCaseContent())};
            String[] listString = Arrays.toString(list).split(",");

            String[] e = new String[listString.length];
            int count = 0;
            for (int i = 0; i < listString.length; i++) {

                e[i] = "?";
                count++;

            }

//            System.out.println(Arrays.toString(e).replace("]", "").replace("[", ""));
            String query = "INSERT INTO case_contents "
                    + "(casecaseid, " + theCase.columnStringBuilder(theCase.getCaseContent()) + ")"
                    + "VALUES"
                    + "(" + theCase.getCaseID() + "," + Arrays.toString(e).replace("]", "").replace("[", "") + ")";
            //System.out.println("Print substring: " + Arrays.toString(e).substring(1, e.length + 1) + "");
            System.out.println(query);
            dbPreparedStatement = dbConnection.prepareStatement(query);
            int i = 1;
            for (Map.Entry<String, String> entry : theCase.getCaseContent().entrySet()) {
                String value = entry.getValue();
                dbPreparedStatement.setString(i, value);
                i++;
            }

            dbPreparedStatement.executeUpdate();

            disconnectDB();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            disconnectDB();
            return false;
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int writeCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Case createCase() {
        List<Integer> requestingCitizen = new ArrayList<>();
        Map<String, String> caseContent = new HashMap<>();

        return new Case("", "", -1, requestingCitizen, caseContent);
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
