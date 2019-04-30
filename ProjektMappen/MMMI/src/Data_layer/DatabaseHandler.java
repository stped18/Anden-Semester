/*
 * Denne classe skaber kontakten mellem programet og databasen
 * 
 */
package Data_layer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steff dette er kun en ide til hvordan man henter og sender data
 *
 */
public class DatabaseHandler {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "MMMI_pi_server";
 
    private Connection dbConnection = null;
    private Statement dbStatement = null;
    private ResultSet dbResultSet = null;
    
    

    private void connectToDB() {
        try {

            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to MMMI Database");
        } catch (ClassNotFoundException | SQLException ex) {
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
            System.out.println("Disconnected From MMMI Database");
        } catch (SQLException ex) {
        }
        
    }

    public void addData(String statement) {
        connectToDB();
        try {
            dbStatement = dbConnection.createStatement();
            dbStatement.execute(statement);
            System.out.println(statement + " \nwas executed");
        } catch (SQLException ex) {
        }

       
        disConnectet();
    }

    public List getdataList(String resultString) {
        List<String> list = new ArrayList<>();
        connectToDB(); 
        try {
            String name = null;
            int age= 0;
            Statement st = dbConnection.createStatement();
            dbResultSet = st.executeQuery(resultString);

            while (dbResultSet.next()) {    
                name = dbResultSet.getString("name");
                age = dbResultSet.getInt("age");
                list.add("name : "+ name+" | age : "+ age );
            }
             
        } catch (SQLException ex) {
        }

        System.out.println("List of data was created");
        disConnectet();
        return list;
    }
    
    public void testConnection(){
        System.out.println("Testing connection to database");
        connectToDB();
        disConnectet();
    }

}
