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
        Department detDepartment = new Department("first", 1);
        Employee trine = detDepartment.createEmployee("trine", 252525, "Secretary");
        String command;
        String text;
        
        System.out.println("Velkommen");
        while(!quit){
            //System.out.println("Vælg rolle: du har muligheden 'Secretary'");
            try (Scanner sc = new Scanner(System.in))  {
                System.out.println("Vælg rolle: du har muligheden 'Secretary'");
                text = sc.nextLine();

                switch(text){
                    case "Secretary":
                        command = loop();
                        if (trine.getJob().checkRights(command)){
                            System.out.println("Skriv navn");
                            String name = sc.nextLine();
                            System.out.println("Skriv begrundelse");
                            String reason = sc.nextLine();
                            if (detDepartment.createCase(name, reason)){
                                System.out.println("Sag oprettet");
                            } else {
                                System.out.println("Sagen blev ikke oprettet");
                            }
                            System.out.println("ting ting");
                        } 
                        break; 


                    case "quit":
                        System.out.println("Du quiter");
                        quit = true;
                        break;

                }
                System.out.println("Nyt loop");
            } catch (Exception e) {

            }
        
        }
        
        
        
        
    }
    
    public static String loop(){
        while (true){
            Scanner s = new Scanner(System.in);
            String t = s.nextLine();
                
            switch(t){
                case "create case":
                    return t;
                    
                case "close case":

                    return t;
                case "add information":

                    return t; 
                case "assign case":

                    return t; 
                case "reassign case": 

                    return t;
                case "quit":
                    quit = true;
                    return "quit";
                    
                default:
                    System.out.println("not a command");
                    break;
            }
            
        }
        
    }
    
}
