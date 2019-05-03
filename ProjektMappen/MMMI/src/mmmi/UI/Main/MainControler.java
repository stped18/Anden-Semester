/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class MainControler implements Initializable {

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
        // TODO
    }    

    @FXML
    private void BtnHandler(ActionEvent event) {
    }
    
}


