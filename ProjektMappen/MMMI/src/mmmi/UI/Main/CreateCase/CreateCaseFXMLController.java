/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.createCase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mmmi.UI.Main.RunFxmlLoader;
import mmmi.UI.Main.MainControler;
public class CreateCaseFXMLController extends RunFxmlLoader implements Initializable {


    @FXML
    private Button fxnextBtn;
    @FXML
    private Button fxBackBtn;

    @FXML
    private Button fxSaveBtn;

    @FXML
    private AnchorPane fxSubSubpane;

    /**
     * Initializes the controller class.
     */
    @Override  
    public void initialize(URL url, ResourceBundle rb) {
  
   
}

    @FXML
    private void buttonHandler(ActionEvent event) { 
        if(event.getSource()==fxnextBtn) {
            changeFxml(fxSubSubpane, "caseInvestigation/caseInvestigationFXML.fxml");
        }
    }


         
  
    


    
    
    
}



































































