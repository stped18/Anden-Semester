package mmmi.Data_layer;

import MMMI.Data_layer.Case;
import MMMI.Data_layer.Citizen;
import MMMI.Data_layer.Employee;
import MMMI.Data_layer.SearchCase;
import mmmi.Data_layer.Connection.DatabaseConnection;
import mmmi.Data_layer.Interfaces.IDataHandler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    private int employeeID;
    private Employee employee = null;
    private Case noteCase;

    @Override
    public Case readCase(String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                if (result) { // REMEMBER: If result is what????
                    dbResultSet = fetchCitizen.getResultSet();
                    dbResultSet.next();

                    citizen = new Citizen(citizenID, dbResultSet.getString(3), dbResultSet.getString(4), dbResultSet.getString(5), dbResultSet.getString(6), dbResultSet.getString(7), dbResultSet.getString(8), dbResultSet.getString(9), dbResultSet.getInt(2), dbResultSet.getString(12), dbResultSet.getBoolean(10), dbResultSet.getBoolean(11));

                    String caseID;
                    List<Case> cases = new ArrayList();
                    Map<String, String> caseContent = new HashMap();
                    List<Integer> requestingCitizens = new ArrayList();

                    query = "SELECT count(*) over(), column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'case_contents'";
                    dbStatement = dbConnection.createStatement();
                    dbResultSet = dbStatement.executeQuery(query);
                    dbResultSet.next();
                    int rowCount = dbResultSet.getInt(1);

                    String caseContentQuery = "SELECT cc.*, c.* FROM case_contents AS cc, \"case\" AS c WHERE cc.casecaseid = caseid AND citizenregardingcitizenid = ? ORDER BY cc.datestamp DESC LIMIT 1";
                    fetchCaseContent = dbConnection.prepareStatement(caseContentQuery);
                    fetchCaseContent.setInt(1, citizenID);
                    caseContentSet = fetchCaseContent.executeQuery();

                    caseContentSet.next();
                    caseID = caseContentSet.getString(2);
                    for (int i = 3; i <= rowCount; i++) {
                        caseContent.put(dbResultSet.getString(2), caseContentSet.getString(i));
                        if (i < rowCount) {
                            dbResultSet.next();
                        }
                    }

                    String requestingCitizenQuery = "SELECT citizenrequestingcitizenid FROM case_requestingcitizen AS cr, \"case\" AS c WHERE casecaseid = caseid AND citizenregardingcitizenid = ?";
                    fetchRequestingCitizen = dbConnection.prepareStatement(requestingCitizenQuery);
                    fetchRequestingCitizen.setInt(1, citizenID);
                    requestingCitizenSet = fetchRequestingCitizen.executeQuery();
                    while (requestingCitizenSet.next()) {
                        requestingCitizens.add(requestingCitizenSet.getInt(1));
                    }

                    cases.add(new Case(caseID, "Status", citizenID, requestingCitizens, caseContent));

                    citizen.setCases(cases);
                }
            } else {
                // NO DB CONNECTION
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
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

        List<Integer> requestingCitizen = new ArrayList<>();
        Map<String, String> caseContent = new HashMap<>();

        return new Case("", "", -1, requestingCitizen, caseContent);
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
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean writeEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
