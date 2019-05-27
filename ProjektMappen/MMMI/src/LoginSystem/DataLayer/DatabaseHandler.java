package LoginSystem.DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "MMMI_pi_server";

    protected Connection dbConnection = null;
    protected Statement dbStatement = null;
    protected ResultSet dbResultSet = null;
    protected PreparedStatement preparedStatement = null;

	/**
	 * Creates a connection to the database.
	 */
    public void connectDB() {

        try {
            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Connectet to MMMI Database");
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

	/**
	 * This method returns a new Employee object that has been validated
	 * by the database on Username and Password.
	 * 
	 * @param username, String 
	 * @param password, String
	 * @return An object of Employee
	 */
	public DbEmployee getEmployeedb(String username, String password) {

        String qurryString = "SELECT *  From employee WHERE username='" + username + "'  AND password='" + password + "';";
        connectDB();
        DbEmployee employee = null;
        
        try {
            preparedStatement = dbConnection.prepareStatement(qurryString);
            dbResultSet = preparedStatement.executeQuery();
            while (dbResultSet.next()) {
                int employeid = dbResultSet.getInt("employeeid");
                String first_name = dbResultSet.getString("firstname");
                String last_name = dbResultSet.getString("lastname");
                int departnemtId = dbResultSet.getInt("departmentdepartmentid");
                int roleID = dbResultSet.getInt("roleroleid");

                employee = new DbEmployee(employeid, first_name, last_name, roleID, departnemtId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconect();
        return employee;
    }

	/**
	 * Closes the database connection if there are no statments to executed.
	 */
	public void disconect() {
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
