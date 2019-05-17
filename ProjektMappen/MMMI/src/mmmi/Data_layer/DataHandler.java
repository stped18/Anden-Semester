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
        if(searchKey == "case") {
            try {
                selectQuery = "SELECT c.caseid, c.status, ci.citizenid, CONCAT(ci.firstname, ' ', ci.lastname) AS citizenName, cc.datestamp, cc.regardingInquiry, CONCAT(e.firstname, ' ', e.lastname) AS employeeName, e.employeeid";
                fromQuery = "FROM \"case\" as c, citizen AS ci, (SELECT casecaseid, datestamp, regardingInquiry FROM case_contents WHERE casecaseid = ? ORDER BY datestamp DESC LIMIT 1) AS cc, (SELECT casecaseid, employeeemployeeid FROM case_employee WHERE casecaseid = ?) AS ce, employee AS e";
                whereQuery = "WHERE ce.casecaseid = c.caseid AND e.employeeid = ce.employeeemployeeid AND cc.casecaseid = c.caseid AND ci.citizenid = c.citizenregardingcitizenid AND c.caseid = ? AND c.departmentdepartmentid = ?;";
                query = selectQuery + fromQuery + whereQuery;
                
                searchCaseStmt = dbConnection.prepareStatement(query);
                searchCaseStmt.setString(1, searchValue);
                searchCaseStmt.setString(2, searchValue);
                searchCaseStmt.setString(3, searchValue);
                searchCaseStmt.setString(4, ""); // departmentID from somewhere..
                dbResultSet = searchCaseStmt.executeQuery();
                while(dbResultSet.next()) {
                    sc.add(new SearchCase(dbResultSet.getInt(3), dbResultSet.getString(4), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(5), dbResultSet.getString(6), dbResultSet.getInt(8), dbResultSet.getString(7)));
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
        } else if(searchKey == "citizen") {
            try {
                selectQuery = "SELECT c.caseid, c.status, ci.citizenid, CONCAT(ci.firstname, ' ', ci.lastname) AS citizenName, cc.datestamp, cc.regardingInquiry, "
                            + "CONCAT(e.firstname, ' ', e.lastname) AS employeeName, e.employeeid";
                fromQuery = "FROM citizen AS ci, \"case\" AS c, zipcode AS z, employee AS e, "
                          + "(SELECT casecaseid, datestamp "
                            + "FROM case_contents, \"case\" AS c "
                            + "WHERE casecaseid = c.caseid AND c.citizenregardingcitizenid = 1 ORDER BY datestamp DESC LIMIT 1) AS cc, "
                          + "(SELECT casecaseid, employeeemployeeid "
                            + "FROM case_employee, \"case\" "
                            + "WHERE casecaseid = caseid AND citizenregardingcitizenid = 1) AS ce";
                whereQuery = "WHERE z.zipcode = ci.zipcodezipcode AND cc.casecaseid = c.caseid AND ce.casecaseid = c.caseid AND ce.employeeemployeeid = e.employeeid "
                           + "AND (CONCAT(ci.firstname, ' ', ci.lastname) LIKE ? OR (CONCAT(ci.streetname, ' ', ci.houseno) LIKE ? AND CONCAT(ci.zipcodezipcode, ' ', z.cityname) LIKE ?)) "
                           + "AND ci.citizenid = c.citizenregardingcitizenid AND c.departmentdepartmentid = ?";
                query = selectQuery + fromQuery + whereQuery;
                dbResultSet = searchCaseStmt.executeQuery(query);
                while(dbResultSet.next()) {
                    sc.add(new SearchCase(dbResultSet.getInt(3), dbResultSet.getString(4), dbResultSet.getString(1), dbResultSet.getString(2), dbResultSet.getString(5), dbResultSet.getString(6), dbResultSet.getInt(8), dbResultSet.getString(7)));
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
