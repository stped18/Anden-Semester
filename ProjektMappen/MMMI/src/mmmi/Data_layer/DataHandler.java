package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler{

    @Override
    public Case readCase(String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
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
            String query = "SELECT c.*, zipcode.cityname FROM citizen c JOIN zipcode ON zipcode = zipcodezipcode WHERE citizenID = ?";
            fetchCitizen = dbConnection.prepareStatement(query);
            fetchCitizen.setInt(1, citizenID);
            boolean result = fetchCitizen.execute();
            if(result) {
                dbResultSet = fetchCitizen.getResultSet();
                dbResultSet.next();
                
                citizen = new Citizen(citizenID, dbResultSet.getString(3), dbResultSet.getString(4), dbResultSet.getString(5),dbResultSet.getString(6), dbResultSet.getString(7), dbResultSet.getString(8), dbResultSet.getString(9), dbResultSet.getInt(2), dbResultSet.getString(12), dbResultSet.getBoolean(10), dbResultSet.getBoolean(11));
                
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
                fetchCaseContent.setInt(1,citizenID);
                caseContentSet = fetchCaseContent.executeQuery();
                
                caseContentSet.next();
                caseID = caseContentSet.getString(2);
                for (int i = 3; i <= rowCount; i++) {
                    caseContent.put(dbResultSet.getString(2), caseContentSet.getString(i));
                    if(i < rowCount) {
                        dbResultSet.next();
                    }
                }
                
                String requestingCitizenQuery = "SELECT citizenrequestingcitizenid FROM case_requestingcitizen AS cr, \"case\" AS c WHERE casecaseid = caseid AND citizenregardingcitizenid = ?";
                fetchRequestingCitizen = dbConnection.prepareStatement(requestingCitizenQuery);
                fetchRequestingCitizen.setInt(1,citizenID);
                requestingCitizenSet = fetchRequestingCitizen.executeQuery();
                while(requestingCitizenSet.next()) {
                    requestingCitizens.add(requestingCitizenSet.getInt(1));
                }
                
                cases.add(new Case(caseID, citizenID, requestingCitizens, caseContent));
                
                citizen.setCases(cases);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("readCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disConnectet();
        } finally {
            if(fetchCitizen != null) {
                fetchCitizen = null;
            }
            if(fetchCase != null) {
                fetchCase = null;
            }
            if(fetchCaseContentKeys != null) {
                fetchCaseContentKeys = null;
            }
            if(fetchCaseContent != null) {
                fetchCaseContent = null;
            }
            if(fetchRequestingCitizen != null) {
                fetchRequestingCitizen = null;
            }
            disConnectet();
        }
        return citizen;
    }

    @Override
    public Employee readEmployee(int employeeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean writeCase(Case theCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
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
            if(rs.next()) {
                citizenID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("writeCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disConnectet();
        } finally {
            if(insertCitizen != null) {
                insertCitizen = null;
            }
            disConnectet();
        }
        return citizenID;
    }

    @Override
    public boolean writeEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            if(result > 0) {
                citizen_updated = true;
            }
            
        } catch (SQLException ex) {
            System.out.println("updateCitizen:\nSQLState: " + ex.getSQLState() + "\nmessage: " + ex.getMessage());
            disConnectet();
        } finally {
            if(updateCitizen != null) {
                updateCitizen = null;
            }
            disConnectet();
        }
        return citizen_updated;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
