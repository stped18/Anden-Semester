/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.Home;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author $Terpen
 */
public class UIEmployee {

    private SimpleStringProperty name;
    private SimpleStringProperty number;

    public UIEmployee() {
    }

    public UIEmployee(String number, String name) {
        this.number = new SimpleStringProperty(number);
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getNumber() {
        return number.get();
    }

    public void setNumber(String number) {
        this.number = new SimpleStringProperty(number);
    }

}
