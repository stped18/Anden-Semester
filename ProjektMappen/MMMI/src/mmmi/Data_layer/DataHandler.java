package MMMI.Data_layer;

import mmmi.Data_layer.Connection.DatabaseConnection;
import MMMI.Data_layer.Interfaces.IDataHandler;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataHandler extends DatabaseConnection implements IDataHandler {

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

        connectToDB();
        try {
            PreparedStatement statement;
            String getCaseContent = theCase.columnStrings(theCase.getCaseContent());

            statement = dbConnection.prepareStatement("INSERT INTO case_contents"
                    + "VALUES"
                    + "(?,?,?,?,?)");
            statement.setString(1, getCaseContent);

        } catch (SQLException e) {

            System.out.println("Exception at writeCase:mmmi.Data_layer.DataHandler"
                    + " a database access error occured "
                    + " or this method is called on a closed connection "
                    + "(setString) parameterIndex does not correspond to a parameter marker in the SQL statement"
                    + e.getLocalizedMessage());
        }
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
