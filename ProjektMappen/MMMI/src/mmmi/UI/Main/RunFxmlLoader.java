/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author steff
 */
public class RunFxmlLoader {
    
    
      public void changeFxml(AnchorPane subPane, String fxml){
              AnchorPane pane;
            try {
                pane = FXMLLoader.load(getClass().getResource(fxml)); 
                subPane.getChildren().setAll(pane);
            } catch (IOException ex) {
                Logger.getLogger(MainControler.class.getName()).log(Level.SEVERE, null, ex);
            }     
        }
    
    
    
    
}




