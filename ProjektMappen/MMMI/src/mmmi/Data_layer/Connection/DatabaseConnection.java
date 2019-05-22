package mmmi.Data_layer.Connection;

import java.sql.*;

public class DatabaseConnection {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "MMMI_pi_server";

    protected Connection dbConnection = null;
    protected Statement dbStatement = null;
    protected PreparedStatement dbPreparedStatement = null;
    protected ResultSet dbResultSet = null;

    public void connectToDB() {
        try {
            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public void disconnectDB() {
        try {
            if (dbStatement != null) {
                dbStatement.close();
            }
            if (dbPreparedStatement != null) {
                dbPreparedStatement.close();
            }
            if (dbResultSet != null) {
                dbResultSet.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException ex) {
        }
    }
}
