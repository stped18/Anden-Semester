/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Domain;

import mmmi.Data_layer.SearchCase;
import java.util.HashMap;
import java.util.List;
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
     * Test of search method, of class Department.
     */
    @Test
    public void testSearch() {
        //value += "%" + String.valueOf(departmentID);
        IDataHandler searchHandler = new DataHandler();
        List<SearchCase> searchCases = searchHandler.search("Case", "%7");
        int employeeid = 1;
        mmmi.Data_layer.Employee newEmployee = dataHandler.readEmployee(employeeid);
        String[] split = newEmployee.toString().split(",");

        Map searchResultList = new HashMap();
        for (int i = 0; i < split.length; i++) {
            Map searchResultMap = new HashMap();
            searchResultMap.put("citizenName", searchCases.get(i).getCitizenName());
            searchResultMap.put("currentCaseDate", searchCases.get(i).getCurrentCaseDate());
            searchResultMap.put("createdCaseDate", searchCases.get(i).getCreatedCaseDate());
            searchResultMap.put("caseReason", searchCases.get(i).getReason());
            searchResultMap.put("caseEmployeeName", searchCases.get(i).getEmployeeName());
            searchResultMap.put("caseStatus", searchCases.get(i).getCaseStatus());
            searchResultList.put(searchCases.get(i).getCaseID(), searchResultMap);
        }
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
