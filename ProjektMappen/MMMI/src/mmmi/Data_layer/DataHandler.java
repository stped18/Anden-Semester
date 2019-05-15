package MMMI.Data_layer;

import Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataHandler extends DatabaseConnection implements IDataHandler {

    @Override
    public Case readCase(String caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citizen readCitizen(int citizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param employeeID
     * @return
     */
    @Override
    public Employee readEmployee(int employeeID) {

        DatabaseConnection dbc = new DatabaseConnection();

        int id = 0;
        String firstName = "";
        String lastName = "";
        int roleID = 0;
        int departmentID = 0;

        try {
            dbc.connectToDB();

            String query = "SELECT * FORM employee WHERE employeeid = " + employeeID;
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery(query);

            while (dbResultSet.next()) {
                id = dbResultSet.getInt("employeeID");
                firstName = dbResultSet.getString("firstname");
                lastName = dbResultSet.getString("lastname");
                roleID = dbResultSet.getInt("roleroleid");
                departmentID = dbResultSet.getInt("departmentdepartmentid");
            }
            
            dbc.disConnectet();
        } catch (SQLException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Employee(id, firstName, lastName, roleID, departmentID);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
