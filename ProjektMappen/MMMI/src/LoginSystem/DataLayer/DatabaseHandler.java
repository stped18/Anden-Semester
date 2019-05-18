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
    private DbEmployee employee;

   

    public DbEmployee getEmployee( String username, String password) {
        try {

            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url, username, password);
            System.out.println("Connectet to MMMI Database");
        } catch (ClassNotFoundException | SQLException ex) {
            
        }
    
    
        
        
        try {
             dbResultSet = dbStatement.executeQuery("SELECT  * From employee WHERE username="+username+" AND password="+password+"");
            while(dbResultSet.next()){
              employee = new DbEmployee(dbResultSet.getInt("employeeid"), dbResultSet.getString("firstname"), dbResultSet.getString("lastname"), dbResultSet.getInt("departmentdepartmentid"));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
   

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
        return this.employee;
    }



    
}







