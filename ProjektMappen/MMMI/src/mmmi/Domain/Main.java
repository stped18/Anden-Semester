/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Domain;

import java.util.Scanner;

/**
 *
 * @author steff
 */
public class Main {
    private static boolean quit = false;
    
    
    
    
    public static void main(String[] args) {
        Department detDepartment = new Department();
        detDepartment.createEmployee("trine", 252525, 5000, "Secretary");
        
        
        
         while(!quit){
             
        try (Scanner sc = new Scanner(System.in))  {
            String text = sc.nextLine();
            
            

            switch(text){
                case "Secretary":
                    
                    break; 
                    
                    
                case "quit":
                    quit = true;
                        
            }
        } catch (Exception e) {
           
        }
       
        }
        
        
        
        
    }
    
    
    
}
