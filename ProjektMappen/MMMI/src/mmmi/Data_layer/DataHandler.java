package MMMI.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    @Override
    public Case readCase(String caseID) {

        String getCaseQuery = "SELECT * "
                + "FROM \"case\" AS c "
                + "RIGHT JOIN case_contents AS cc ON (c.caseid = cc.casecaseid) "
                + "RIGHT JOIN case_requestingcitizen AS cr ON (c.caseid = cr.casecaseid)";
//        String getCaseQuery = "SELECT *\n"
//                + "FROM mmmidb.\"public\".\"Case\" AS c"
//                + "RIGHT JOIN mmmidb.\"public\".\"Case_contents\" ON (c.caseID = mmmidb.\"public\".\"Case_contents\".casecaseid)"
//                + "RIGHT JOIN mmmidb.\"public\".\"Case_requestingcitizen\" ON (c.caseID = mmmidb.\"public\".\"Case_requestingcitizen\".casecaseid);";
        List<String> columnNames = new ArrayList<>();
        List<Integer> requstingCitizenIDs = new ArrayList<>();
        Map<String, String> columnToValuesMap = new HashMap<>();

        Integer regardingCitizenID = 0;

        connectToDB();

        try {

            dbStatement = dbConnection.createStatement();

            dbResultSet = dbStatement.executeQuery(getCaseQuery);

            ResultSetMetaData rsmd = dbResultSet.getMetaData();

            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnNames.add(columnName);

                //Load the Map initially with keys(columnnames) and empty value
                columnToValuesMap.put(columnName, "");
            }
            //System.out.println(Arrays.asList(columnNames));

            while (dbResultSet.next()) {

                for (String columnName : columnNames) {
                    if (columnName.equalsIgnoreCase("citizenrequestingcitizenid")) {
                        requstingCitizenIDs.add(dbResultSet.getInt(String.valueOf(columnName)));
                    } else if (columnName.equalsIgnoreCase("citizenregardingcitizenid")) {
                        regardingCitizenID = dbResultSet.getInt(String.valueOf(columnName));
                    }

                    //Get the list mapped to column name
//                    String columnDataList = columnToValuesMap.get(columnName);
                    String columnDataList = dbResultSet.getString(columnName);

                    //add the updated list of column data to the map now
                    columnToValuesMap.put(columnName, columnDataList);

                }

            }

            // String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //List<Integer> rc = caze.getRequestingCitizen();
        disconnectDB();
        return new Case(caseID, "Igang", regardingCitizenID, requstingCitizenIDs, columnToValuesMap);

    }

    @Override
    public Citizen readCitizen(int citizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee readEmployee(int employeeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeCase(Case theCase) {

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
    public boolean writeCitizen(Citizen citizen
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeEmployee(Employee employee
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCitizen(Citizen citizen
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Case createCase() {
        List<Integer> requestingCitizen = new ArrayList<>();
        Map<String, String> caseContent = new HashMap<>();

        return new Case("", "Igang", 0, requestingCitizen, caseContent);
    }

    @Override
    public Citizen createCitizen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SearchCase> search(String searchKey, String searchValue
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        List<Integer> listTest = new ArrayList<>();
        listTest.add(3);
        listTest.add(2);
        Map<String, String> mapTestValues = new LinkedHashMap<>();
        mapTestValues.put("carriage", "Test1");
        mapTestValues.put("treament", "Test2");
        mapTestValues.put("cashbenefit", "Test3");
        mapTestValues.put("control", "Test4");
        mapTestValues.put("stay", "Test5");
        mapTestValues.put("practicalhelp", "Test6");
//        mapTestValues.put("personalhelp", "Test7");
        mapTestValues.put("protectedemploymentbenefit", "Test8");
        mapTestValues.put("dayrelief", "Test9");
        mapTestValues.put("socialpedogogicalhelp", "Test10");
        mapTestValues.put("personalhelpscheme", "Test11");
        mapTestValues.put("ambulanttreatment", "Test12");
        mapTestValues.put("outpatientoffers", "Test13");
//        mapTestValues.put("housingofferforadults", "Test13");
//        mapTestValues.put("extendedhousingofferforadults", "Test13");
        mapTestValues.put("inquiryfrom", "Test13");
        mapTestValues.put("inquiryfromtext", "Test13");
        mapTestValues.put("guardianship", "Test13");
        mapTestValues.put("guardianshiptext", "Test13");
        mapTestValues.put("representation", "Test13");
        mapTestValues.put("representationtext", "Test13");
        mapTestValues.put("rightsandduties", "Test13");
//        mapTestValues.put("rightsanddutiestext", "Test13");
//        mapTestValues.put("agreementswithcitizentext", "Test13");
        mapTestValues.put("consent", "Test13");
        mapTestValues.put("getinfo", "Test13");
        mapTestValues.put("getinfotext", "Test13");
        mapTestValues.put("citizenspecialcircumstancestext", "Test13");
        mapTestValues.put("otheractingcommune", "Test13");
        mapTestValues.put("otheractingcommunetext", "Test13");

//INSERT into "Case_contents" (casecaseid, carriage, treament, cashbenefit, control, stay, practicalhelp, 
//personalhelp, protectedemploymentbenefit, dayrelief, socialpedogogicalhelp, personalhelpscheme, ambulanttreatment, 
//outpatientoffers, housingofferforadults, extendedhousingofferforadults, inquiryfrom, inquiryfromtext, guardianship, 
//guardianshiptext, representation, representationtext, rightsandduties, rightsanddutiestext, agreementswithcitizentext, 
//consent, getinfo, getinfotext, citizenspecialcircumstancestext, otheractingcommune, otheractingcommunetext) VALUES
//        for (int i = 1; i <= 31; i++) {
//            mapTestValues.put("Test" + String.valueOf(i), "Test" + String.valueOf(i));
//        }
        //System.out.println(mapTestValues);
        Case caze = new Case("1234", "Igang", 3, listTest, mapTestValues);

//        dataHandler.readCase(caze.getCaseID());
//        System.out.println("l178: " + dataHandler.readCase(caze.getCaseID()));
        System.out.println(dataHandler.writeCase(caze));

    }
}
