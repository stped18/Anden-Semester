/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.Home;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author $Terpen
 */
public class UIEmployee {

    private SimpleStringProperty name;
    private SimpleIntegerProperty number;

    public UIEmployee() {
    }

    public UIEmployee(int number, String name) {
        this.number = new SimpleIntegerProperty(number);
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getNumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number = new SimpleIntegerProperty(number);
    }

}
