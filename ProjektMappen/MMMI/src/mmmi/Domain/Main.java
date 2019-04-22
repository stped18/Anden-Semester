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
    private static Department detDepartment = new Department("Social afl", 1);
   

    public static void main(String[] args) {

        Employee trine = detDepartment.createEmployee("trine", 252525, "Secretary");
        Employee mads = detDepartment.createEmployee("mads", 353535, "CaseWorker");
        
        String command;
        String text;

        System.out.println("Velkommen til MMMI");

        //System.out.println("Vælg rolle: du har muligheden 'Secretary'");
        try (Scanner sc = new Scanner(System.in)) {
            while (!quit) {
                rollInfor();
                text = sc.nextLine().toLowerCase();

                switch (text) {
                    case "secretary":
                        secrataryCaseInfo();
                        commands(trine);
                        break;
                    case "caseworker":
                        System.out.println("Du er Sagsbehandler");
                        caseInfo();
                        commands(mads);
                        break;

                    case "quit":
                        System.out.println("Du quiter");
                        quit = true;
                        break;

                    default:
                        System.out.println(text + "Er ikke en kommando \n"
                                + "Prøv igen\n");
                        break;
                }

            }
            System.out.println("Nyt loop");
        } catch (Exception e) {

        }

    }

    public static String loop() {
        boolean start = true;
        while (true) {
            Scanner s = new Scanner(System.in);
            String t = s.nextLine().toLowerCase();

            switch (t) {
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
                case "back":
                    return t;
                default:
                    System.out.println(t + "Er ikke en kommando \n"
                            + "Prøv igen\n");
            }

        }
    }

    public static void rollInfor() {
        System.out.println("Rolle informationer\n");
        System.out.println("Vælg rolle : Skriv rolle navn \n"
                + "Secretary : \n"
                + "Quit : for at afslutte programet \n");
    }

    public static void caseInfo(Employee employee) {
        if(employee.getJob())
        System.out.println("Case Informationer\n");
        System.out.println("Skriv : \n"
                + "Create case : lav en ny sag \n"
                + "Close case : for at lukke en sag \n"
                + "Add information : for at skrive Informationer \n"
                + "Assign case : for at udgive en sag \n"
                + "Reassign case : for at vidergive en sag \n"
                + "Quit : for at afslutte loop \n");
    }

    public static void secrataryCaseInfo() {
        System.out.println("Du er sceretary");
        System.out.println("Case Informationer\n");
        System.out.println("Skriv : \n"
                + "Create case : lav en ny sag \n"
                + "back : for at komme tilbage");
    }

    public static void commands(Employee employee) {
        boolean start = true;
        Scanner sc = new Scanner(System.in);
        String command = loop();
         while (start= true){
        if (employee.getJob().checkRights(command)) {
            switch (command) {
                case "create case":
                    System.out.println("oprat sag");
                    System.out.println("Skriv navn");
                    String name = sc.nextLine().toLowerCase();
                    System.out.println("Skriv begrundelse");
                    String reason = sc.nextLine().toLowerCase();
                    if (detDepartment.createCase(name, reason)) {
                        System.out.println("Sag oprettet");
                    } else {
                        System.out.println("Sagen blev ikke oprettet");
                    }
                    break;
                case "close case":
                    System.out.println("Luk sag");
                    System.out.println("find sag ");
                    String caseWord = sc.nextLine().toLowerCase();
                    if(detDepartment.search(caseWord)!=null){
                        System.out.println("forkert søgeord");
                    }else{
                        System.out.println(detDepartment.search(caseWord).toString());
                        System.out.println("Skriv sags Nummber");
                        String caseNumber = sc.nextLine().toLowerCase();
                        System.out.println("Skriv begrundelse");
                        String decision = sc.nextLine().toLowerCase();
                        detDepartment.closeCase(caseNumber,decision);
                    }
                    break;
                case "add information":

                    break;
                case "assign case":

                   break;
                case "reassign case":

                   break;
                case "back":
                    start = false;
                    break;
                default:
                    System.out.println(command + "Er ikke en kommando \n"
                            + "Prøv igen\n");
            }
            }

        }
    }

}
