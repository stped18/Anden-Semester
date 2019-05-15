/*
 * Denne classe skaber kontakten mellem programet og databasen
 *
 */
package Data_layer.Connection;

import java.sql.*;


/**
 * @author steff dette er kun en ide til hvordan man henter og sender data
 */
public class DatabaseConnection {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "MMMI_pi_server";

    protected Connection dbConnection = null;
    protected Statement dbStatement = null;
    protected ResultSet dbResultSet = null;


    public void connectToDB() {
        try {

            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Connectet to MMMI Database");
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public void disConnectet() {
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
        } catch (SQLException ex) {
        }
    }


}

