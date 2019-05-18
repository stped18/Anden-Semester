/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.DataLayer;

import LoginSystem.Domain.LoginSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author steff
 */
public class DatabaseHandler {

    private final String url = "jdbc:postgresql://mmmihosting.ddns.net:3306/mmmidb";
    private final String username = "pi";
    private final String password = "MMMI_pi_server";

    protected Connection dbConnection = null;
    protected Statement dbStatement = null;
    protected ResultSet dbResultSet = null;


    public void connectDB() {
        try {

            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Connectet to MMMI Database");
        } catch (ClassNotFoundException | SQLException ex) {

        }
    }

    public DbEmployee getEmployeedb(String username, String password) {
        
        connectDB();
         DbEmployee employee = null;
        try {
            dbStatement = dbConnection.createStatement();
            dbResultSet = dbStatement.executeQuery("SELECT  *  From employee WHERE username='" + username + "'  AND password='" + password + "';");
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






