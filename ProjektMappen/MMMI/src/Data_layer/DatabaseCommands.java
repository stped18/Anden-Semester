/*
 * Denne classe skaber kontakten mellem programet og databasen
 * 
 */
package Data_layer;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.*;
import java.util.List;

/**
 *
 * @author steff dette er kun en ide til hvordan man henter og sender data
 *
 */
public class DatabaseCommands {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "morten1234";
 
    private Connection dbConnection = null;
    private Statement dbStatement = null;
    private ResultSet dbResultSet = null;
    
    

    private void connectToDB() {
        try {

            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);

            System.out.println("Connectet to MMMI Database");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }

    private void disConnectet() {
        try {
            if (dbStatement != null) {
                dbStatement.close();
            }
            if (dbResultSet != null) {
                dbResultSet.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
            System.out.println("Disconnectet From MMMI Database");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public void addData(String statement) {
        connectToDB();
        try {
            dbStatement = dbConnection.createStatement();
            dbStatement.execute(statement);
            System.out.println(statement + " was executet");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       
        disConnectet();
    }

    public List<ResultSet> getdataList(String resultString) {
        List<ResultSet> list = new VirtualFlow.ArrayLinkedList<>();
        connectToDB();
        try {
            dbResultSet = dbStatement.executeQuery(resultString);
            while (dbResultSet.next()) {
                list.add(dbResultSet);

            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("List of data was Createt");
        disConnectet();
        return list;
    }
    
    public void testConnection(){
        System.out.println("Testing connection to database");
        connectToDB();
        disConnectet();
    }

}
