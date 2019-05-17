package MMMI.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    @Override
    public Case readCase(String caseID) {

        String getCaseQuery = "SELECT *"
                + "FROM Case AS c"
                + "RIGHT JOIN Case_contents ON (c." + caseID + " = Case_contents.casecaseid)"
                + "RIGHT JOIN Case_requestingcitizen ON (c." + caseID + " = Case_requestingcitizen.casecaseid)";
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

            PreparedStatement statement;

            statement = getDbConnection().prepareStatement(getCaseQuery);

            ResultSet rs = statement.executeQuery(getCaseQuery);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnNames.add(columnName);

                //Load the Map initially with keys(columnnames) and empty value
                columnToValuesMap.put(columnName, "");
            }
            while (rs.next()) {

                for (String columnName : columnNames) {
                    if (columnName.equalsIgnoreCase("citizenrequestingcitizenid")) {
                        requstingCitizenIDs.add(rs.getInt(Integer.parseInt(columnName)));
                    } else if (columnName.equalsIgnoreCase("citizenregardingcitizenid")) {
                        regardingCitizenID = rs.getInt(Integer.parseInt(columnName));
                    }

                    //Get the list mapped to column name
                    //String columnDataList = columnToValuesMap.get(columnName);
                    String getColoumnData = rs.getString(columnName);

                    //add the updated list of column data to the map now
                    columnToValuesMap.put(columnName, getColoumnData);

                }
                for (String key : columnToValuesMap.keySet()) {
			System.out.println(key);
		}

            }

            // String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent
        } catch (SQLException e) {
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
            PreparedStatement statement;

            String count = "'?'";
            String[] e = null;
            String[] list = {"null", theCase.columnStringBuilder(theCase.getCaseContent())};
            for (int i = 1; i < list.length; i++) {
                e[i] = count;

            }

            statement = dbConnection.prepareStatement("INSERT INTO case_contents"
                    + "(" + theCase.getCaseID() + "," + theCase.columnStringBuilder(theCase.getCaseContent()) + ")"
                    + "VALUES"
                    + "(" + Arrays.toString(e).substring(1, e.length - 1) + ")");

            for (int i = 1; i < list.length; i++) {

                statement.setString(i, list[i]);

            }
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
    public boolean writeCitizen(Citizen citizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeEmployee(Employee employee) {
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

        return new Case("", "Igang", 0, requestingCitizen, caseContent);
    }

    @Override
    public Citizen createCitizen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SearchCase> search(String searchKey, String searchValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        List<Integer> listTest = new ArrayList<>();
        listTest.add(1);
        listTest.add(2);
        Map<String, String> mapTestValues = new HashMap<>();
        Case caze = new Case("123", "Igang", 1, listTest, mapTestValues);

        dataHandler.readCase(caze.getCaseID());
        System.out.println(dataHandler.readCase(caze.getCaseID()));

    }
}
