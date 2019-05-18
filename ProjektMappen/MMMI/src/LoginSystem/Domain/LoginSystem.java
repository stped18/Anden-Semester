/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import LoginSystem.DataLayer.DbEmployee;






/**
 *
 * @author steff
 */
public class LoginSystem {
   
   
    
    private String username;
    private String password;
    DatabaseHandler db;
    DbEmployee employee;
    
    
    

    public LoginSystem() {
 
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
    public void  getEmployee (){
     employee = db.getEmployee(this.username, this.password);
    System.out.println(employee.toString());
    }

 


    
    
  
    
}











