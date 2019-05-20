/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Aleksander Henriksen
 */
import LoginSystem.Domain.IEmployee;
import LoginSystem.Domain.LoginSystem;
import MMMI.Data_layer.DataHandler;
import MMMI.Data_layer.Interfaces.IDataHandler;
public class DepartmentTest {
    
    private IDataHandler dataHandler = new DataHandler();
    private IEmployee loginEmployee = new LoginSystem();
     
    public DepartmentTest() {
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
     * Test of getEmployee method, of class Department.
     */
    @Test
    public void testGetEmployee() {
        int employeeid = 0;
        String firstName = "";
        String lastName = "";
        int departmentID = -1;
        int roleID = -1;
        Map<Integer, String> rightsMap = new HashMap<>();

        MMMI.Data_layer.Employee newEmployee = dataHandler.readEmployee(employeeid);
        String[] split = newEmployee.toString().split(",");

            firstName = split[0];
            lastName = split[1];
            roleID = Integer.parseInt(split[2]);
            departmentID = Integer.parseInt(split[3]);
    }
    
}
