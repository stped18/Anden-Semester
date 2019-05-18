/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.DataHandler;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Aleksander Henriksen
 */
public class DataHandlerTest extends DatabaseConnection{
    
    public DataHandlerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readEmployee method, of class DataHandler.
     */
    @Test
    public void testReadEmployee() {
        
        int id = 7;
        String empolyeeName = "";
        int roleID = -1;
        int departmentID = -1;
        Map<String, String> employeeCases = new HashMap<>();
        Map<Integer, String> rights = new HashMap<>();

        String selectQuery, fromQuery, whereQuery, query;
        PreparedStatement keyPreparedStatement = null;

        try {
            connectToDB();

            selectQuery = "SELECT em.departmentdepartmentid AS departmentid,"
                    + "em.roleroleid AS roleid,"
                    + "CONCAT(em.firstname, ' ', em.lastname) AS employeename,"
                    + "ce.casecaseid AS caseid,"
                    + "CONCAT(ci.firstname, ' ', ci.lastname) AS citizenname";
            fromQuery = "FROM employee AS em, case_employee AS ce, \"case\" AS c, citizen AS ci";
            whereQuery = "WHERE em.employeeid = ? "
                    + "AND ce.employeeemployeeid = ? " 
                    + "AND c.caseid = ce.casecaseid"
                    + "AND ci.citizenid = c.citizenregardingcitizenid;";
            query = selectQuery + fromQuery + whereQuery;

            keyPreparedStatement = dbConnection.prepareStatement(query);
            keyPreparedStatement.setInt(1, id);
            keyPreparedStatement.setInt(2, id);
            dbResultSet = keyPreparedStatement.executeQuery();

            while (dbResultSet.next()) {
                departmentID = dbResultSet.getInt("departmentid");
                roleID = dbResultSet.getInt("roleid");
                empolyeeName = dbResultSet.getString("employeename");
                employeeCases.put(dbResultSet.getString("caseid"), dbResultSet.getString("citizenname"));
            }

            selectQuery = "SELECT r.rightsid AS rightsid, r,rightsname AS rightsname";
            fromQuery = "FROM role_rights AS rr, rights AS r";
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
    }
}
