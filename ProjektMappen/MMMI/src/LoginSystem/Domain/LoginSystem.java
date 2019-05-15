/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import mmmi.Domain.Employee;





/**
 *
 * @author steff
 */
public class LoginSystem {
   
   
    
    private String username;
    private String password;
    DatabaseHandler databaseHandler;

    public LoginSystem(String username, String password) {
       databaseHandler.getEmployee(username, password);
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 


    
    
  
    
}






