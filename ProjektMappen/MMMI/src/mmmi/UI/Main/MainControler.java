/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class MainControler extends FxmlSuper implements Initializable {

    @FXML
    private AnchorPane fxRootPane;
    @FXML
    private Button fxHomeBtn;
    @FXML
    private Button fxCreateCaseBtn;
    @FXML
    private Button fxSearchcaseBtn;
    @FXML
    private Button fxAssinecaseBtn;
    @FXML
    private Button fxListOfCasesBtn;
    @FXML
    private Button fxDaiaryBtn;
    @FXML
    private Button fxContackt;
    @FXML
    private AnchorPane fxSubPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Thread(){
            @Override
            public void run() {
               changeFxml(fxSubPane,"homeFXML.fxml");
            }

        }.start();
    }    
// alle fxml w 1050 h 900
    @FXML
    private void BtnHandler(ActionEvent event) {
        if(event.getSource()==fxHomeBtn){
           changeFxml(fxSubPane,"homeFXML.fxml");
        }
        if(event.getSource()==fxCreateCaseBtn){
            changeFxml(fxSubPane,"createCaseFXML.fxml");
        }
        
        
        
    }
  

  
    
    
    
   
}














































