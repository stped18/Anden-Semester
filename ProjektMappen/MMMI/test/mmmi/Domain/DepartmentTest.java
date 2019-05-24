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
import java.util.List;
import mmmi.Data_layer.DataHandler;
import mmmi.Data_layer.Interfaces.IDataHandler;
import mmmi.Data_layer.SearchCase;
import mmmi.Domain.Interfaces.IDomain;
import org.hamcrest.core.Is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
    public void searchTestCase() {
        IDataHandler searchHandler = new DataHandler();
        String caseNumber = "123"; // Case number to search for

        List<SearchCase> searchCases = searchHandler.search("Case", caseNumber + "%1"); // search after case number
        Map<String, String> expectedMap = new HashMap<>();

        // Expected output
        expectedMap.put("currentCaseDate", "24/05-2019");
        expectedMap.put("createdCaseDate", "17/05-2019");
        expectedMap.put("caseStatus", "igang");
        expectedMap.put("caseReason", "Henvendelse drejer sig om en Test");
        expectedMap.put("caseEmployeeName", "Aleksander Henriksen");
        expectedMap.put("citizenName", "Poul Johanson");

        // searchResult
        Map<String, String> mapContains = new HashMap<>();
        Map searchResultList = new HashMap();
        for (int i = 0; i < searchCases.size(); i++) {
            Map searchResultMap = new HashMap();
            searchResultMap.put("citizenName", searchCases.get(i).getCitizenName());
            searchResultMap.put("currentCaseDate", searchCases.get(i).getCurrentCaseDate());
            searchResultMap.put("createdCaseDate", searchCases.get(i).getCreatedCaseDate());
            searchResultMap.put("caseReason", searchCases.get(i).getReason());
            searchResultMap.put("caseEmployeeName", searchCases.get(i).getEmployeeName());
            searchResultMap.put("caseStatus", searchCases.get(i).getCaseStatus());
            searchResultList.put(searchCases.get(i).getCaseID(), searchResultMap);

            // Test
            assertThat(searchResultMap, Is.is(expectedMap));

            // Print out both maps
            System.out.println("searchResult: " + searchResultMap);
            System.out.println("Expected: " + expectedMap);

        }
    }

    @Test
    public void searchTestCitizen() {
        IDataHandler searchHandler = new DataHandler();
        String citizen = "123123-1231%Poul Johanson%kimvej%"; // citizen to search for

        List<SearchCase> searchCases = searchHandler.search("Citizen", citizen + "%1"); // search after citizen
        Map<String, String> expectedMap = new HashMap<>();

        // Expected output
        expectedMap.put("currentCaseDate", "24/05-2019");
        expectedMap.put("createdCaseDate", "17/05-2019");
        expectedMap.put("caseStatus", "igang");
        expectedMap.put("caseReason", "Henvendelse drejer sig om en Test");
        expectedMap.put("caseEmployeeName", "Aleksander Henriksen");
        expectedMap.put("citizenName", "Poul Johanson");

        // searchResult
        Map<String, String> mapContains = new HashMap<>();
        Map searchResultList = new HashMap();
        for (int i = 0; i < searchCases.size(); i++) {
            Map searchResultMap = new HashMap();
            searchResultMap.put("citizenName", searchCases.get(i).getCitizenName());
            searchResultMap.put("currentCaseDate", searchCases.get(i).getCurrentCaseDate());
            searchResultMap.put("createdCaseDate", searchCases.get(i).getCreatedCaseDate());
            searchResultMap.put("caseReason", searchCases.get(i).getReason());
            searchResultMap.put("caseEmployeeName", searchCases.get(i).getEmployeeName());
            searchResultMap.put("caseStatus", searchCases.get(i).getCaseStatus());
            searchResultList.put(searchCases.get(i).getCaseID(), searchResultMap);

            // Test
            assertThat(searchResultMap, Is.is(expectedMap));

            // Print out both maps
            System.out.println("searchResult: " + searchResultMap);
            System.out.println("Expected: " + expectedMap);

        }

    }

    @Test
    public void saveCaseTest() {

        Map<String, Map<String, String>> caseInfo = new HashMap<>();
        department.setDepartmentID(1);
        Map<String, String> conentsMap = new HashMap<>();
        conentsMap.put("regardinginquiry", "Henvendelse drejer sig om en Test");
        conentsMap.put("treatment", "paragrafTest2");
        conentsMap.put("carriage", "paragrafTest1");
        conentsMap.put("caseID", "-1");

        Map<String, String> citizenInfoRegarding1 = new HashMap<>();
        citizenInfoRegarding1.put("firstName", "Hans");
        citizenInfoRegarding1.put("lastName", "Frederiksen");
        citizenInfoRegarding1.put("streetName", "Snervej");
        citizenInfoRegarding1.put("cityName", "Taarup");
        citizenInfoRegarding1.put("zipCode", "5560");
        citizenInfoRegarding1.put("houseNo", "75");
        citizenInfoRegarding1.put("regardingCitizen", "true");
        citizenInfoRegarding1.put("requestingCitizen", "false");
        citizenInfoRegarding1.put("cpr", "887799-5544");
        citizenInfoRegarding1.put("floor", "");
        citizenInfoRegarding1.put("floorDirection", "");

        Map<String, String> citizenInfoRequesting1 = new HashMap<>();
        citizenInfoRequesting1.put("firstName", "Mads");
        citizenInfoRequesting1.put("lastName", "Simpson");
        citizenInfoRequesting1.put("streetName", "tillevej");
        citizenInfoRequesting1.put("cityName", "Odense");
        citizenInfoRequesting1.put("zipCode", "5000");
        citizenInfoRequesting1.put("houseNo", "22");
        citizenInfoRequesting1.put("regardingCitizen", "false");
        citizenInfoRequesting1.put("requestingCitizen", "true");
        citizenInfoRequesting1.put("cpr", "120596-7745");
        citizenInfoRequesting1.put("floor", "etage 2");
        citizenInfoRequesting1.put("floorDirection", "venstre");

        caseInfo.put("caseContents", conentsMap);
        caseInfo.put("cRegarding", citizenInfoRegarding1);
        caseInfo.put("cRequesting", citizenInfoRequesting1);

        assertEquals(true, department.saveCase(caseInfo));

    }

}
