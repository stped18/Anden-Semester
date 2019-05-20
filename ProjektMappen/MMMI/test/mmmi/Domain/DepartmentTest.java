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
import mmmi.Data_layer.DataHandler;
import mmmi.Data_layer.Interfaces.IDataHandler;
import mmmi.Domain.Interfaces.IDomain;
public class DepartmentTest {
    
    private IDataHandler dataHandler = new DataHandler();
    private IEmployee loginEmployee = new LoginSystem();
    private IDomain department = Department.getInstance();
     
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

        mmmi.Data_layer.Employee newEmployee = dataHandler.readEmployee(employeeid);
        String[] split = newEmployee.toString().split(",");

            firstName = split[0];
            lastName = split[1];
            roleID = Integer.parseInt(split[2]);
            departmentID = Integer.parseInt(split[3]);
    }
    @Test
    public void saveCaseTest() {
        

        Map<String, Map<String, String>> caseInfo = new HashMap<>();

        Map<String, String> conentsMap = new HashMap<>();
        conentsMap.put("regardinginquiry", "test1");
        conentsMap.put("treatment", "test2");
        conentsMap.put("caseID", "-1");

        Map<String, String> citizenInfoRegarding = new HashMap<>();
        citizenInfoRegarding.put("firstName", "RegardingFind");
        citizenInfoRegarding.put("lastName", "RegardingHansen");
        citizenInfoRegarding.put("streetName", "RegardingStreet");
        citizenInfoRegarding.put("cityName", "Kerteminde");
        citizenInfoRegarding.put("zipCode", "5300");
        citizenInfoRegarding.put("houseNo", "75");
        citizenInfoRegarding.put("regardingCitizen", "true");
        citizenInfoRegarding.put("requestingCitizen", "false");
        citizenInfoRegarding.put("cpr", "");
        citizenInfoRegarding.put("floor", "");
        citizenInfoRegarding.put("floorDirection", "");

        Map<String, String> citizenInfoRequesting = new HashMap<>();
        citizenInfoRequesting.put("firstName", "Requestingmads");
        citizenInfoRequesting.put("lastName", "RequestingHansen");
        citizenInfoRequesting.put("streetName", "RequestingStreet");
        citizenInfoRequesting.put("cityName", "Kerteminde");
        citizenInfoRequesting.put("zipCode", "5300");
        citizenInfoRequesting.put("houseNo", "75");
        citizenInfoRequesting.put("regardingCitizen", "false");
        citizenInfoRequesting.put("requestingCitizen", "true");
        citizenInfoRequesting.put("cpr", "");
        citizenInfoRequesting.put("floor", "");
        citizenInfoRequesting.put("floorDirection", "");

        Map<String, String> cd = new HashMap<>();
        citizenInfoRequesting.put("firstName", "cd");
        citizenInfoRequesting.put("lastName", "RequestingHansen");
        citizenInfoRequesting.put("streetName", "RequestingStreet");
        citizenInfoRequesting.put("cityName", "Kerteminde");
        citizenInfoRequesting.put("zipCode", "5300");
        citizenInfoRequesting.put("houseNo", "75");
        citizenInfoRequesting.put("regardingCitizen", "false");
        citizenInfoRequesting.put("requestingCitizen", "true");
        citizenInfoRequesting.put("cpr", "");
        citizenInfoRequesting.put("floor", "");
        citizenInfoRequesting.put("floorDirection", "");

        Map<String, String> cb = new HashMap<>();
        citizenInfoRegarding.put("firstName", "cb");
        citizenInfoRegarding.put("lastName", "RegardingHansen");
        citizenInfoRegarding.put("streetName", "RegardingStreet");
        citizenInfoRegarding.put("cityName", "Kerteminde");
        citizenInfoRegarding.put("zipCode", "5300");
        citizenInfoRegarding.put("houseNo", "75");
        citizenInfoRegarding.put("regardingCitizen", "true");
        citizenInfoRegarding.put("requestingCitizen", "false");
        citizenInfoRegarding.put("cpr", "");
        citizenInfoRegarding.put("floor", "");
        citizenInfoRegarding.put("floorDirection", "");

        caseInfo.put("caseContents", conentsMap);
        caseInfo.put("cRegarding", citizenInfoRegarding);
        caseInfo.put("cRequesting", citizenInfoRequesting);

        department.saveCase(caseInfo);
    }
    
}
