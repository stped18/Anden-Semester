/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.DataHandler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        int id = 0;
        String firstName = "";
        String lastName = "";
        int roleID = 0;
        int departmentID = 0;
        List<Integer> employeeCases = new ArrayList<>();

        try {
            connectToDB();

            String getEmployee = "SELECT * FROM employee WHERE employeeid = " + id;
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(getEmployee);

            while (dbResultSet.next()) {
                id = dbResultSet.getInt("employeeID");
                firstName = dbResultSet.getString("firstname");
                lastName = dbResultSet.getString("lastname");
                roleID = dbResultSet.getInt("roleroleid");
                departmentID = dbResultSet.getInt("departmentdepartmentid");
            }

            String getCaseID = "SELECT casecaseid FROM case_employee WHERE employeeemployeeid = " + id;
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(getCaseID);

            while (dbResultSet.next()) {
                employeeCases.add(dbResultSet.getInt("casecaseid"));
            }

            disConnectet();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
