/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Domain;


import Data_layer.Commands;
import java.util.List;

/**
 *
 * @author steff
 */
public class Main {

    public static void main(String[] args) {
            Commands db = new Commands();

            List<String> list = db.getdataList("SELECT  name, age FROM cats");
            list.forEach(System.out::println);
            
            

    }

 
}
