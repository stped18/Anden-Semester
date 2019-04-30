/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Domain;

import java.util.Scanner;
import Data_layer.DatabaseHandler;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author steff
 */
public class Main {

    private static boolean quit = false;
    private static Department detDepartment = new Department("Social afl", 1);
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
            
            DatabaseHandler db = new DatabaseHandler();

            
            list = db.getdataList("SELECT  name, age FROM cats");
            for(String s : list){
                System.out.println(s);
            }
            
            
        
        
        
//        detDepartment.createCase("jhon", "Full 8 dage om ugen");
//        detDepartment.createCase("sanne", "Misbrug af penge øremærket hindes børn");
//        detDepartment.createCase("Jhin", "ikke en person");
//        detDepartment.createCase("claus ", "Vold mod andre");
//        detDepartment.createCase("gud", "midbrug af mennesker");
//
//
//        String text;
//
//        System.out.println("Velkommen til MMMI");
//
//        //System.out.println("Vælg rolle: du har muligheden 'Secretary'");
//        try (Scanner sc = new Scanner(System.in)) {
//            while (!quit) {
//                rollInfor();
//                text = sc.nextLine().toLowerCase();
//
//                switch (text) {
//                    case "secretary":
//                        //Employee trine = detDepartment.createEmployee("trine", 252525, "secretary");
//                        //commands(trine);
//                        break;
//                    case "caseworker":
//                        //Employee mads = detDepartment.createEmployee("mads", 353535, "caseworker");
//                        //commands(mads);
//                        break;
//                    case "departmentmanager":
//                        //Employee martin = detDepartment.createEmployee("martin", 262626, "departmentmanager");
//                        //commands(martin);
//                        break;
//
//                    case "quit":
//                        System.out.println("Du quiter");
//                        quit = true;
//                        break;
//
//                    default:
//                        System.out.println(text + "Er ikke en kommando \n"
//                                + "Prøv igen\n");
//                        break;
//                }
//
//            }
//        } catch (Exception e) {
//
//        }

    }

    public static String loop() {
        while (true) {
            Scanner s = new Scanner(System.in);
            String t = s.nextLine().toLowerCase();

            switch (t) {
                case "back":
                    return t;
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

                default:
                    System.out.println(t + " Er ikke en kommando \n"
                            + "Prøv igen\n");
            }

        }
    }

    public static void rollInfor() {
        System.out.println("Rolle informationer\n");
        System.out.println("Vælg rolle : Skriv rolle navn \n"
                + "Secretary : \n"
                + "Caseworker\n"
                + "Departmentmanager\n"
                + "Quit : for at afslutte programet \n");
    }

    public static void caseInfo(Employee e) {
        System.out.println("Navn : " + e.getName() + "\nTitle : " + convertTitleToDanish(e) + "\n"
                + "Options");

        if (e.getTitle().equalsIgnoreCase("caseworker")) {
            System.out.println("Create case : lav en ny sag \n"
                    + "Close case : for at lukke en sag \n"
                    + "Add information : for at skrive Informationer \n"
                    + "back : for at komme tilbage\n");
        } else if (e.getTitle().equalsIgnoreCase("secretary")) {
            System.out.println("Create case : lav en ny sag \n"
                    + "back : for at komme tilbage\n");

        } else if (e.getTitle().equalsIgnoreCase("departmentmanager")) {
            System.out.println("Create case : lav en ny sag \n"
                    + "Close case : for at lukke en sag \n"
                    + "Add information : for at skrive Informationer \n"
                    + "Assign case : for at udgive en sag \n"
                    + "Reassign case : for at vidergive en sag \n"
                    + "back : for at komme tilbage \n");
        }

    }

    public static void commands(Employee employee) {
        boolean start = true;
        Scanner sc = new Scanner(System.in);
        String name;
        String reason;
        String decision;
        Case cs;
        while (start) {
            caseInfo(employee);
            String command = loop();
            if (employee.getJob().checkRights(command)) {
                switch (command) {
                    case "back":
                        start = false;
                        break;
                    case "create case":
                        System.out.println("oprat sag");
                        System.out.println("Skriv navn");
                        name = sc.nextLine().toLowerCase();
                        System.out.println("Skriv begrundelse");
                        reason = sc.nextLine().toLowerCase();
                        if (detDepartment.createCase(name, reason)) {
                            System.out.println("Sag oprettet");
                        } else {
                            System.out.println("Sagen blev ikke oprettet");
                        }
                        break;
                    case "close case":
                        System.out.println("Luk en sag");
                        System.out.println("find sag ");
                        String caseWord = sc.nextLine().toLowerCase();
                        if (!detDepartment.search(caseWord).isEmpty()) {
                            System.out.println("Alle sager");
                            System.out.println(detDepartment.search(caseWord).toString());
                            System.out.println("Skriv sags Nummber");
                            String caseNumber = sc.nextLine().toLowerCase();
                            System.out.println("Skriv begrundelse");
                            decision = sc.nextLine().toLowerCase();
                            detDepartment.closeCase(caseNumber, decision);
                           
                        } else {
                           System.out.println("Ingen sager");
                           
                        }
                        break;
                    case "add information":
                        System.out.println("find sag ");
                        String caseWords = sc.nextLine();

                        if (!detDepartment.search(caseWords).isEmpty()) { 
                            System.out.println("Alle sager");
                            System.out.println(detDepartment.search(caseWords).toString());
                            System.out.println("Skriv sags Nummber");
                            String caseNumberString = sc.nextLine().toLowerCase();
                            cs = detDepartment.openCase(caseNumberString);
                            System.out.println("Skriv keyword");
                            String key = sc.nextLine().toLowerCase();
                            System.out.println("Skriv information");
                            
                            String info = sc.nextLine();
                            
                            cs.addInformation(key, info);
                            System.out.println("Informationen er gemt");
                          
                        } else {
                           System.out.println("Ingen sager");
                           
                        }

                        break;
                    case "assign case":
                        
                        break;
                    case "reassign case":

                        break;

                    default:
                        System.out.println(command + "Er ikke en kommando \n"
                                + "Prøv igen\n");
                }
            }

        }
    }

    public static String convertTitleToDanish(Employee e) {
        String title = e.getTitle();
        String danishTitle = null;
        if (title.equalsIgnoreCase("secretary")) {
            danishTitle = "Sekrætær";
        }
        if (title.equalsIgnoreCase("caseworker")) {
            danishTitle = "Sagsbehandler";
        }
        if (title.equalsIgnoreCase("departmentmanager")) {
            danishTitle = "Afdelingsleder";

        }
        return danishTitle;
    }
 
}
