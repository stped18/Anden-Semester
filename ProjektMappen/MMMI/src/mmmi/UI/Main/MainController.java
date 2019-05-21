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
public class MainController extends RunFxmlLoader implements Initializable {

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
                changeFxml(fxSubPane, "home/home.fxml");

    }

    @FXML
    private void BtnHandler(ActionEvent event) {
        if (event.getSource() == fxHomeBtn) {
            changeFxml(fxSubPane, "home/home.fxml");
        }
        if (event.getSource() == fxCreateCaseBtn) {
            changeFxml(fxSubPane, "createcase/fxml/createCase.fxml");
        }
        if (event.getSource() == fxSearchcaseBtn) {
            changeFxml(fxSubPane, "findcase/findCase.fxml");

        }
    }

}









