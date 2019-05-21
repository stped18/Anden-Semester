/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author steff
 */
public class RunFxmlLoader {


    public void changeFxml(AnchorPane subPane, String fxml) {
        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource(fxml));
            subPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println("Message: " + ex.getMessage() + ex.getLocalizedMessage());
        }
    }


}




