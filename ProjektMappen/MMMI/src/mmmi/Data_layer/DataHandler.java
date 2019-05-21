package mmmi.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import java.sql.ResultSet;
import mmmi.Data_layer.Interfaces.IDataHandler;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gruppe 2
 */
public class DataHandler extends DatabaseConnection implements IDataHandler {

    private int employeeID;
    private Employee employee = null;

    /**
     * returns case object where caseContents has information from the specified
     * caseID and has regarding citizen object which refereces to case content
     * based on the regarding Citizen id.
     *
     * @param caseID, accepts int value
     * @return returns Case object
     */
    @Override
    public Case readCase(int caseID) {

        List<String> columnNames = new ArrayList<>();
        List<Citizen> requstingCitizens = new ArrayList<>();
        Map<String, String> columnToValuesMap = new HashMap<>();

        String caseStatus = "";
        int departmentID = 0;

        connectToDB();

        try {
            String getCitizenQuery = "SELECT cit.*, zc.cityname "
                    + "FROM citizen AS cit, zipcode AS zc, case_requestingcitizen cr "
                    + "WHERE cit.citizenid = cr.citizenrequestingcitizenid AND cr.casecaseid = ? AND "
                    + "zc.zipcode = cit.zipcodezipcode";

            dbPreparedStatement = dbConnection.prepareStatement(getCitizenQuery);
            dbPreparedStatement.setInt(1, caseID);

            dbResultSet = dbPreparedStatement.executeQuery();
            System.out.println("test");
            while (dbResultSet.next()) {
                // int citizenID, String firstName, String lastName, String cprNo, String streetName, 
// String houseNo, String floor, String floorDirection, int zipcode, String cityname, boolean regardingCitizen, boolean requestingCitizen

                requstingCitizens.add(new Citizen(dbResultSet.getInt("citizenid"),
                        dbResultSet.getString("firstname"),
                        dbResultSet.getString("lastname"),
                        dbResultSet.getString("CPR-nr"),
                        dbResultSet.getString("streetname"),
                        dbResultSet.getString("houseNo"),
                        dbResultSet.getString("floor"), dbResultSet.getString("floordirection"), dbResultSet.getInt("zipcodezipcode"), dbResultSet.getString("cityname"),
                        dbResultSet.getBoolean("regardingcitizen"), dbResultSet.getBoolean("requestingcitizen")));

            }

            String getCaseQuery = "SELECT c.departmentdepartmentid, c.casestatus, crg.*, zc.cityname, cc.* "
                    + "FROM \"case\" AS c, (SELECT  *FROM case_contents WHERE casecaseid = ? ORDER BY datestamp DESC LIMIT 1) AS cc, citizen AS crg, zipcode AS zc "
                    + "WHERE c.citizenregardingcitizenid = crg.citizenid AND crg.zipcodezipcode = zc.zipcode AND c.caseid = ?;";

            dbPreparedStatement = dbConnection.prepareStatement(getCaseQuery);
            dbPreparedStatement.setInt(1, caseID);
            dbPreparedStatement.setInt(2, caseID);

            dbResultSet = dbPreparedStatement.executeQuery();

            ResultSetMetaData rsmd = dbResultSet.getMetaData();

            int columnCount = rsmd.getColumnCount();
            List<String> citizenColumns = new ArrayList<>();
            Citizen regardingCitizen = null;

            for (int i = 19; i <= columnCount; i++) {
                String columnName = rsmd.getColumnName(i);
                columnNames.add(columnName);

                //Load the Map initially with keys(columnnames) and empty value
                columnToValuesMap.put(columnName, "");

            }
            //System.out.println(Arrays.asList(columnNames));
            int regardingCitizenID = 0, zipcode = 0;
            String cityname = "", firstname = "", lastname = "", cprno = "", streetname = "", houseno = "", floor = "", floordirection = "";
            boolean regardingcitizen = false, requestingcitizen = false;
            while (dbResultSet.next()) {

//                requstingCitizens.add(dbResultSet.getInt("citizenrequestingcitizenid"));
// Hent alt fra db omkring citizen og opret et nyt citizen objekt for hver der findes
                //requstingCitizens.add(requestingCitizen.setCitizenID(dbResultSet.getInt("citizenrequestingcitizenid")));
                regardingCitizenID = dbResultSet.getInt("citizenid");
                caseStatus = dbResultSet.getString("casestatus");

                departmentID = dbResultSet.getInt("departmentdepartmentid");
                zipcode = dbResultSet.getInt("zipcodezipcode");
                cityname = dbResultSet.getString("cityname");
                firstname = dbResultSet.getString("firstname");
                lastname = dbResultSet.getString("lastname");
                cprno = dbResultSet.getString("CPR-nr");
                streetname = dbResultSet.getString("streetname");
                houseno = dbResultSet.getString("houseno");
                floor = dbResultSet.getString("floor");
                floordirection = dbResultSet.getString("floordirection");
                regardingcitizen = dbResultSet.getBoolean("regardingcitizen");
                requestingcitizen = dbResultSet.getBoolean("requestingcitizen");

                for (String columnName : columnNames) {

                    //Get the list mapped to column name
//                    String columnDataList = columnToValuesMap.get(columnName);
                    String columnDataList = dbResultSet.getString(columnName);

                    //add the updated list of column data to the map now
                    columnToValuesMap.put(columnName, columnDataList);

                }

            }
            regardingCitizen = new Citizen(caseID, firstname, lastname, cprno, streetname, houseno, floor, floordirection, caseID, cityname, regardingcitizen, requestingcitizen);
            return new Case(caseID, departmentID, caseStatus, regardingCitizen, requstingCitizens, columnToValuesMap);

            // String caseID, String caseStatus, int regardingCitizenID, List<Integer> requestingCitizens, Map<String, String> caseContent
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            disconnectDB();
        }
        //List<Integer> rc = caze.getRequestingCitizen();

        return new Case(caseID, departmentID, caseStatus, null, null, columnToValuesMap);
    }

    /**
     * caseContentQuery should have a check for the departmentid.
     *
     * @param citizenID
     * @return
     */
    @Override
    public Citizen readCitizen(int citizenID) {
        Citizen citizen = null;
        PreparedStatement fetchCitizen = null, fetchCase = null, fetchCaseContentKeys = null, fetchCaseContent = null, fetchRequestingCitizen = null;
        ResultSet caseContentSet, requestingCitizenSet;
        try {
            connectToDB();
            if (dbConnection != null) {
                String query = "SELECT c.*, zipcode.cityname FROM citizen c JOIN zipcode ON zipcode = zipcodezipcode WHERE citizenID = ?";
                fetchCitizen = dbConnection.prepareStatement(query);
                fetchCitizen.setInt(1, citizenID);
                boolean result = fetchCitizen.execute();
                if (result) {
                    dbResultSet = fetchCitizen.getResultSet();
                    dbResultSet.next();

                    citizen = new Citizen(citizenID, dbResultSet.getString(3), dbResultSet.getString(4), dbResultSet.getString(5), dbResultSet.getString(6), dbResultSet.getString(7), dbResultSet.getString(8), dbResultSet.getString(9), dbResultSet.getInt(2), dbResultSet.getString(12), dbResultSet.getBoolean(10), dbResultSet.getBoolean(11));

                    int caseID;
                    List<Case> cases = new ArrayList();
                    Map<String, String> caseContent = new HashMap();
                    List<Integer> requestingCitizens = new ArrayList();

                    query = "SELECT count(*) over(), column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'case_contents'";
                    dbStatement = dbConnection.createStatement();
                    dbResultSet = dbStatement.executeQuery(query);
                    dbResultSet.next();
                    int rowCount = dbResultSet.getInt(1);

                    String caseContentQuery = "SELECT c.caseid, c.departmentdepartmentid, c.casestatus, cc.* FROM case_contents AS cc, \"case\" AS c WHERE cc.casecaseid = caseid AND citizenregardingcitizenid = ? ORDER BY cc.datestamp DESC LIMIT 1";
                    fetchCaseContent = dbConnection.prepareStatement(caseContentQuery);
                    fetchCaseContent.setInt(1, citizenID);
                    caseContentSet = fetchCaseContent.executeQuery();

                    caseContentSet.next();
                    caseID = caseContentSet.getInt(1);
                    int departmentID = caseContentSet.getInt(2);
                    String caseStatus = caseContentSet.getString(3);

                    for (int i = 3; i <= rowCount; i++) {
                        caseContent.put(caseContentSet.getString(7), caseContentSet.getString(i));
                        if (i < rowCount) {
                            caseContentSet.next();
                        }
                    }

                    String requestingCitizenQuery = "SELECT citizenrequestingcitizenid FROM case_requestingcitizen AS cr, \"case\" AS c WHERE casecaseid = caseid AND citizenregardingcitizenid = ?";
                    fetchRequestingCitizen = dbConnection.prepareStatement(requestingCitizenQuery);
                    fetchRequestingCitizen.setInt(1, citizenID);
                    requestingCitizenSet = fetchRequestingCitizen.executeQuery();
                    while (requestingCitizenSet.next()) {
                        requestingCitizens.add(requestingCitizenSet.getInt(1));
                    }
                    // TODO: Update with the changes for case constructor
                    cases.add(new Case(caseID, departmentID, caseStatus, null, null, caseContent));

                    citizen.setCases(cases);

                }
            } else {
                // NO DB CONNECTION
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("readCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disconnectDB();
        } finally {
            if (fetchCitizen != null) {
                fetchCitizen = null;
            }
            if (fetchCase != null) {
                fetchCase = null;
            }
            if (fetchCaseContentKeys != null) {
                fetchCaseContentKeys = null;
            }
            if (fetchCaseContent != null) {
                fetchCaseContent = null;
            }
            if (fetchRequestingCitizen != null) {
                fetchRequestingCitizen = null;
            }
            disconnectDB();
        }
        return citizen;
    }

    /**
     *
     * @param employeeID
     * @return
     */
    @Override
    public Employee readEmployee(int employeeID) {

        if (this.employeeID != employeeID) {

            this.employeeID = employeeID;
            String empolyeeName = "";
            int roleID = -1;
            Map<Integer, String> employeeCases = new HashMap<>();
            Map<Integer, String> rights = new HashMap<>();

            String selectQuery, fromQuery, whereQuery, query;
            PreparedStatement keyPreparedStatement = null;

            try {
                connectToDB();

                selectQuery = "SELECT em.roleroleid AS roleid, "
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
                    roleID = dbResultSet.getInt("roleid");
                    empolyeeName = dbResultSet.getString("employeename");
                    employeeCases.put(dbResultSet.getInt("caseid"), dbResultSet.getString("citizenname"));
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
                disconnectDB();
            } finally {
                disconnectDB();
            }
            employee = new Employee(employeeID, empolyeeName, roleID, employeeCases, rights);
        }

        return employee;
    }

    /**
     *
     * @param theCase TEST
     * @return TEST
     */
    @Override
    public boolean writeCase(Case theCase) {

        if (theCase.getCaseID() == -1) {

            String[] list = {theCase.columnStringBuilder(theCase)};
            String[] listString = Arrays.toString(list).split(",");
            String[] e = new String[listString.length];
            int count = 0;
            for (int i = 0; i < listString.length; i++) {

                e[i] = "?";
                count++;
            }
            connectToDB();
            System.out.println(theCase.getCaseContent());
            try {
                String insertIntoCase = "INSERT INTO \"case\" "
                        + "(citizenregardingcitizenid, casestatus, departmentdepartmentid) ";
                String values = "VALUES(?,?,?) ";
               
                dbPreparedStatement.setInt(1, theCase.getRegardingCitizen().getCitizenID());
                dbPreparedStatement.setString(2, theCase.getCaseStatus());
                dbPreparedStatement.setInt(3, theCase.getDepartmentID());
                dbPreparedStatement.executeUpdate();
                dbResultSet = dbPreparedStatement.getGeneratedKeys();
                dbResultSet.next();
                int caseID = dbResultSet.getInt(1);
                String query = "INSERT INTO case_contents "
                        + "(casecaseid, " + theCase.columnStringBuilder(theCase) + ")"
                        + "VALUES"
                        + "(" + caseID + "," + Arrays.toString(e).replace("]", "").replace("[", "") + ")";

                System.out.println(query);
                dbPreparedStatement = dbConnection.prepareStatement(query);
                int i = 1;
                String value;
                for (Map.Entry<String, String> entry : theCase.getCaseContent().entrySet()) {
                    value = entry.getValue();
                    if (!(value == null)) {
                        dbPreparedStatement.setString(i, value);

                    }
                    value = "";
                    i++;
                }
                dbPreparedStatement.executeUpdate();

                disconnectDB();
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(DataHandler.class
                        .getName()).log(Level.SEVERE, null, ex);

                return false;
            } finally {

                if (dbPreparedStatement != null) {
                    dbPreparedStatement = null;
                }
                disconnectDB();
            }
        } else {
            // TODO: In and create a new row in case_contents with caseContents information from theCase

            return false;
        }

    }

    /**
     * Method returns the ID of the citizen created in the database or -1 if
     * something happened an the citizen was not created.
     *
     * @param citizen
     * @return
     */
    @Override
    public int writeCitizen(Citizen citizen) {
        int citizenID = citizen.getCitizenID();
        PreparedStatement insertCitizen = null;
        try {
            connectToDB();
            if (dbConnection != null) {
                String query = "INSERT INTO citizen(zipcodezipcode, firstname, lastname, \"CPR-nr\", streetname, houseno, floor, floordirection, regardingCitizen, requestingcitizen) VALUES(?,?,?,?,?,?,?,?,?,?)";
                insertCitizen = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                insertCitizen.setInt(1, citizen.getZipcode());
                insertCitizen.setString(2, citizen.getFirstName());
                insertCitizen.setString(3, citizen.getLastName());
                insertCitizen.setString(4, citizen.getCprNo());
                insertCitizen.setString(5, citizen.getStreetName());
                insertCitizen.setString(6, citizen.getHouseNo());
                insertCitizen.setString(7, citizen.getFloor());
                insertCitizen.setString(8, citizen.getFloorDirection());
                insertCitizen.setBoolean(9, citizen.isRegardingCitizen());
                insertCitizen.setBoolean(10, citizen.isRequestingCitizen());
                insertCitizen.executeUpdate();

                ResultSet rs = insertCitizen.getGeneratedKeys();
                if (rs.next()) {
                    citizenID = rs.getInt(1);

                }
            } else {
                // NO DB CONNECTION
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println("writeCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disconnectDB();
        } finally {
            if (insertCitizen != null) {
                insertCitizen = null;
            }
            disconnectDB();
        }
        return citizenID;
    }

    @Override
    public boolean updateCitizen(Citizen citizen) {
        boolean citizen_updated = false;
        PreparedStatement updateCitizen = null;
        try {
            connectToDB();
            String updateQuery = "UPDATE citizen";
            String setQuery = "SET zipcodezipcode = ?, firstname = ?, lastname = ?, \"CPR-nr\" = ?, streetname = ?, houseno = ?, floor = ?, floordirection = ?, regardingCitizen = ?, requestingcitizen = ?";
            String whereQuery = "WHERE citizenid = ?;";
            String query = updateQuery + setQuery + whereQuery;

            updateCitizen = dbConnection.prepareStatement(query);
            updateCitizen.setInt(1, citizen.getZipcode());
            updateCitizen.setString(2, citizen.getFirstName());
            updateCitizen.setString(3, citizen.getLastName());
            updateCitizen.setString(4, citizen.getCprNo());
            updateCitizen.setString(5, citizen.getStreetName());
            updateCitizen.setString(6, citizen.getHouseNo());
            updateCitizen.setString(7, citizen.getFloor());
            updateCitizen.setString(8, citizen.getFloorDirection());
            updateCitizen.setBoolean(9, citizen.isRegardingCitizen());
            updateCitizen.setBoolean(10, citizen.isRequestingCitizen());
            updateCitizen.setInt(11, citizen.getCitizenID());
            int result = updateCitizen.executeUpdate();
            if (result > 0) {
                citizen_updated = true;
            }

        } catch (SQLException ex) {
            System.out.println("updateCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disconnectDB();
        } finally {
            if (updateCitizen != null) {
                updateCitizen = null;
            }
            disconnectDB();
        }
        return citizen_updated;
    }

    @Override
    public Case createCase() {

        List<Citizen> requestingCitizen = new ArrayList<>();
        Map<String, String> caseContent = new HashMap<>();

        return new Case(-1, -1, "", createCitizen(), requestingCitizen, caseContent);
    }

    @Override
    public Citizen createCitizen() {

        return new Citizen(-1, "", "", "", "", "", "", "", -1, "", false, false);
    }

    @Override
    public List<SearchCase> search(String searchKey, String searchValue) {

        List<SearchCase> sc = new ArrayList();
        PreparedStatement searchCaseStmt = null;
        String selectQuery, fromQuery, whereQuery, query;
        if (searchKey.equals("Case")) {
            try {
                connectToDB();
                if (dbConnection != null) {
                    String[] search = searchValue.split("%");
                    selectQuery = "SELECT c.caseid, c.casestatus, to_char(c.createddate, 'DD/MM-YYYY'), ci.citizenid, CONCAT(ci.firstname, ' ', ci.lastname) AS citizenName, to_char(cc.datestamp, 'DD/MM-YYYY') AS datestamp, cc.regardinginquiry, CONCAT(e.firstname, ' ', e.lastname) AS employeeName, e.employeeid ";
                    fromQuery = "FROM \"case\" as c, citizen AS ci, (SELECT casecaseid, datestamp, regardinginquiry FROM case_contents WHERE casecaseid = ? ORDER BY datestamp DESC LIMIT 1) AS cc, (SELECT casecaseid, employeeemployeeid FROM case_employee WHERE casecaseid = ?) AS ce, employee AS e ";
                    whereQuery = "WHERE ce.casecaseid = c.caseid AND e.employeeid = ce.employeeemployeeid AND cc.casecaseid = c.caseid AND ci.citizenid = c.citizenregardingcitizenid AND c.caseid = ? AND c.departmentdepartmentid = ? ORDER BY c.caseid DESC;";
                    query = selectQuery + fromQuery + whereQuery;

                    searchCaseStmt = dbConnection.prepareStatement(query);
                    searchCaseStmt.setString(1, search[0]);
                    searchCaseStmt.setString(2, search[0]);
                    searchCaseStmt.setString(3, search[0]);
                    searchCaseStmt.setInt(4, Integer.valueOf(search[1]));
                    dbResultSet = searchCaseStmt.executeQuery();
                    while (dbResultSet.next()) {
                        sc.add(new SearchCase(dbResultSet.getInt(4), dbResultSet.getString(5), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(6), dbResultSet.getString(3), dbResultSet.getString(7), dbResultSet.getInt(9), dbResultSet.getString(8)));
                    }
                } else {
                    // NO DB CONNECTION
                }
            } catch (SQLException ex) {
                System.out.println("readCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
                Logger
                        .getLogger(DataHandler.class
                                .getName()).log(Level.SEVERE, null, ex);
                disconnectDB();
            } finally {
                if (searchCaseStmt != null) {
                    searchCaseStmt = null;
                }
                disconnectDB();
            }
        } else if (searchKey.equals("Citizen")) {
            try {
                connectToDB();
                if (dbConnection != null) {
                    String[] search = searchValue.split("%");
                    List<String> searchVal = new ArrayList();
                    String searchQuery = "";
                    int columns = 0;
                    if (!search[0].equals("")) {
                        searchQuery += "\"CPR-nr\" LIKE ?";
                        columns++;
                        searchVal.add(search[0]);
                    }
                    if (!search[1].equals("")) {
                        if (!searchQuery.equals("")) {
                            searchQuery += " AND ";
                        }
                        searchQuery += "CONCAT(ci.firstname, ' ', ci.lastname) LIKE ?";
                        columns++;
                        searchVal.add(search[1]);
                    }
                    if (!search[2].equals("") || !search[3].equals("")) {
                        if (!searchQuery.equals("")) {
                            searchQuery += " AND ";
                        }
                        searchQuery += "(CONCAT(ci.streetname, ' ', ci.houseno) LIKE ? AND CONCAT(ci.zipcodezipcode, ' ', z.cityname) LIKE ?)";
                        columns++;
                        searchVal.add(search[2]);
                        columns++;
                        searchVal.add(search[3]);
                    }
                    searchVal.add(search[4]);
                    selectQuery = "SELECT c.caseid, c.casestatus, to_char(c.createddate, 'DD/MM-YYYY'), ci.citizenid, CONCAT(ci.firstname, ' ', ci.lastname) AS citizenName, to_char(cc.datestamp, 'DD/MM-YYYY'), cc.regardinginquiry, "
                            + "CONCAT(e.firstname, ' ', e.lastname) AS employeeName, e.employeeid ";
                    fromQuery = "FROM citizen AS ci, \"case\" AS c, zipcode AS z, employee AS e, "
                            + "(SELECT casecaseid, MAX(datestamp) AS datestamp, regardinginquiry "
                            + "FROM case_contents, \"case\" AS c "
                            + "WHERE casecaseid = c.caseid AND c.citizenregardingcitizenid in "
                            + "(SELECT citizenid "
                            + "FROM citizen AS ci, zipcode AS z "
                            + "WHERE (" + searchQuery + ")) "
                            + "GROUP BY(casecaseid, regardinginquiry)) AS cc, "
                            + "(SELECT casecaseid, employeeemployeeid "
                            + "FROM case_employee, \"case\" "
                            + "WHERE casecaseid = caseid AND citizenregardingcitizenid in "
                            + "(SELECT citizenid "
                            + "FROM citizen AS ci, zipcode AS z "
                            + "WHERE (" + searchQuery + ")) "
                            + ") AS ce ";
                    whereQuery = "WHERE z.zipcode = ci.zipcodezipcode AND cc.casecaseid = c.caseid AND ce.casecaseid = c.caseid AND ce.employeeemployeeid = e.employeeid "
                            + "AND (" + searchQuery + ") "
                            + "AND ci.citizenid = c.citizenregardingcitizenid AND ci.regardingcitizen AND c.departmentdepartmentid = ? ORDER BY c.caseid DESC";
                    query = selectQuery + fromQuery + whereQuery;

                    searchCaseStmt = dbConnection.prepareStatement(query);
                    int index = 1;
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 0; j < columns; j++) {
                            searchCaseStmt.setString(index, "%" + searchVal.get(j) + "%");
                            index++;
                        }
                    }
                    searchCaseStmt.setInt(index, Integer.valueOf(search[4]));
                    dbResultSet = searchCaseStmt.executeQuery();
                    while (dbResultSet.next()) {
                        sc.add(new SearchCase(dbResultSet.getInt(4), dbResultSet.getString(5), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(6), dbResultSet.getString(3), dbResultSet.getString(7), dbResultSet.getInt(9), dbResultSet.getString(8)));
                    }
                } else {
                    // NO DB CONNECTION
                }
            } catch (SQLException ex) {
                System.out.println("search:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
                Logger
                        .getLogger(DataHandler.class
                                .getName()).log(Level.SEVERE, null, ex);
                disconnectDB();
            } finally {
                if (searchCaseStmt != null) {
                    searchCaseStmt = null;
                }
                disconnectDB();
            }
        }
        return sc;
    }

    @Override
    public String readAlternativeNotets(int caseID) {

        String selectQuery, fromQuery, whereQuery, query;
        String note = null;

        try {
            connectToDB();

            selectQuery = "SELECT alternativenotes ";
            fromQuery = "FROM case_contents AS cc ";
            whereQuery = "WHERE cc.casecaseid = ? ORDER BY cc.datestamp DESC LIMIT 1;";
            query = selectQuery + fromQuery + whereQuery;

            dbPreparedStatement = dbConnection.prepareStatement(query);
            dbPreparedStatement.setInt(1, caseID);
            dbResultSet = dbPreparedStatement.executeQuery();

            while (dbResultSet.next()) {
                note = dbResultSet.getString("alternativenotes");
            }

        } catch (SQLException ex) {
            System.out.println("read note:\nSQLState: " + ex.getSQLState() + "\nMessage: " + ex.getMessage());
        } finally {
            disconnectDB();
        }

        if (note == null) {
            note = "";
        }

        return note;
    }

    @Override
    public boolean writeAlternativeNote(int caseID, String note) {

        String selectQuery, fromQuery, whereQuery, query;
        Map<String, String> valueMap = new HashMap<>();

        try {
            connectToDB();

            selectQuery = "SELECT * ";
            fromQuery = "FROM case_contents AS cc ";
            whereQuery = "WHERE cc.casecaseid = ? ORDER BY cc.datestamp DESC LIMIT 1;";
            query = selectQuery + fromQuery + whereQuery;

            dbPreparedStatement = dbConnection.prepareStatement(query);
            dbPreparedStatement.setInt(1, caseID);
            dbResultSet = dbPreparedStatement.executeQuery();
            ResultSetMetaData rsmd = dbResultSet.getMetaData();

            while (dbResultSet.next()) {
                for (int i = 4; i <= rsmd.getColumnCount(); i++) {
                    if ("alternativenotes".equals(rsmd.getColumnName(i)) || dbResultSet.getString(i) == null) {
                    } else {
                        valueMap.put(rsmd.getColumnName(i), dbResultSet.getString(i));
                    }
                }
            }

            StringBuilder keysb = new StringBuilder();
            StringBuilder questionmarksb = new StringBuilder();

            for (String key : valueMap.keySet()) {
                keysb.append(",").append(key);
                questionmarksb.append(", ?");
            }

            String insert = "INSERT INTO case_contents (casecaseid, alternativenotes " + keysb.toString() + ") ";
            String values = "VALUES (?, ?" + questionmarksb.toString() + ");";
            query = insert + values;

            dbPreparedStatement = dbConnection.prepareStatement(query);
            dbPreparedStatement.setInt(1, caseID);
            dbPreparedStatement.setString(2, note);
            for (int i = 3; i < valueMap.size() + 3; i++) {
                dbPreparedStatement.setString(i, valueMap.get(rsmd.getColumnName(i)));
            }
            dbResultSet = dbPreparedStatement.executeQuery();

            return true;

        } catch (SQLException ex) {
            System.out.println("write note:\nSQLState: " + ex.getSQLState() + "\nMessage: " + ex.getMessage());
            return false;
        } finally {
            disconnectDB();
        }

    }

    public static void main(String[] args) {

        DataHandler dataHandler = new DataHandler();

        System.out.println(dataHandler.readCase(123));

    }
}
