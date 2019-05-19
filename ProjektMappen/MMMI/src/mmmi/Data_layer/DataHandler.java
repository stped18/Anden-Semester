package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler{

    @Override
    public Case readCase(String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Citizen createCitizen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<SearchCase> search(String searchKey, String searchValue) {
        List<SearchCase> sc = new ArrayList();
        PreparedStatement searchCaseStmt = null;
        String selectQuery, fromQuery, whereQuery, query;
        if(searchKey.equals("Case")) {
            try {
                connectToDB();
                if(dbConnection != null) {
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
                    while(dbResultSet.next()) {
                        sc.add(new SearchCase(dbResultSet.getInt(4), dbResultSet.getString(5), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(6), dbResultSet.getString(3), dbResultSet.getString(7), dbResultSet.getInt(9), dbResultSet.getString(8)));
                    }
                } else {
                    // NO DB CONNECTION
                }
            } catch (SQLException ex) {
                System.out.println("readCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                disConnectet();
            } finally {
                if(searchCaseStmt != null) {
                    searchCaseStmt = null;
                }
                disConnectet();
            }
        } else if(searchKey.equals("Citizen")) {
            try {
                connectToDB();
                if(dbConnection != null) {
                    String[] search = searchValue.split("%");
                    List<String> searchVal = new ArrayList();
                    String searchQuery = "";
                    int columns = 0;
                    if(!search[0].equals("")) {
                        searchQuery += "\"CPR-nr\" LIKE ?";
                        columns++;
                        searchVal.add(search[0]);
                    } 
                    if(!search[1].equals("")) {
                        if(!searchQuery.equals("")) {
                            searchQuery += " AND ";
                        }
                         searchQuery += "CONCAT(ci.firstname, ' ', ci.lastname) LIKE ?";
                         columns++;
                         searchVal.add(search[1]);
                    } 
                    if(!search[2].equals("") || !search[3].equals("")) {
                        if(!searchQuery.equals("")) {
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
                    for(int i = 1; i <= 3; i++) {
                        for (int j = 0; j < columns; j++) {
                            searchCaseStmt.setString(index, "%" + searchVal.get(j) + "%");
                            index++;
                        }
                    }
                    searchCaseStmt.setInt(index, Integer.valueOf(search[4]));
                    dbResultSet = searchCaseStmt.executeQuery();
                    while(dbResultSet.next()) {
                        sc.add(new SearchCase(dbResultSet.getInt(4), dbResultSet.getString(5), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(6), dbResultSet.getString(3), dbResultSet.getString(7), dbResultSet.getInt(9), dbResultSet.getString(8)));
                    }
                } else {
                    // NO DB CONNECTION
                }
            } catch (SQLException ex) {
                System.out.println("search:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
                disConnectet();
            } finally {
                if(searchCaseStmt != null) {
                    searchCaseStmt = null;
                }
                disConnectet();
            }
        }
        return sc;
    }

}
