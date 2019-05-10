/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_layer;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author steff
 */
public class Commands extends DatabaseConnection {


    public void addData(String statement) {
        connectToDB();
        try {
            dbStatement = dbConnection.createStatement();
            dbStatement.execute(statement);
            System.out.println(statement + " \nwas executet");
        } catch (SQLException ex) {
        }


        disConnectet();
    }

    public List getdataList(String resultString) {
        List<String> list = new ArrayList<>();
        connectToDB();
        String name;
        int age;


        try {

            Statement st = dbConnection.createStatement();
            dbResultSet = st.executeQuery(resultString);

            while (dbResultSet.next()) {
                name = dbResultSet.getString("name");
                age = dbResultSet.getInt("age");
                list.add("name : " + name + " | age : " + age);
            }

        } catch (SQLException ex) {
        }

        System.out.println("List of data was Createt");
        disConnectet();
        return list;
    }

    public void testConnection() {
        System.out.println("Testing connection to database");
        connectToDB();
        disConnectet();
    }


}
