/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class MainControler extends RunFxmlLoader implements Initializable {

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
                changeFxml(fxSubPane, "home/homeFXML.fxml");

    }

    @FXML
    private void BtnHandler(ActionEvent event) {
        if (event.getSource() == fxHomeBtn) {
            changeFxml(fxSubPane, "home/homeFXML.fxml");
        }
        if (event.getSource() == fxCreateCaseBtn) {
            changeFxml(fxSubPane, "createCase/createCaseFXML.fxml");
        }
        if (event.getSource() == fxSearchcaseBtn) {
            changeFxml(fxSubPane, "findeCase/findeCaseFXML.fxml");

        }
    }

}









