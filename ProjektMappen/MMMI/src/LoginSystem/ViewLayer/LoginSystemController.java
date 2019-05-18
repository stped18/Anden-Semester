/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.ViewLayer;

import LoginSystem.Domain.LoginSystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mmmi.UI.Main.*;
import mmmi.Domain.Employee;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class LoginSystemController implements Initializable {

    @FXML
    private TextField fxUsername;

    @FXML
    private Button fxLoginBtn;

    @FXML
    private PasswordField fxPassword;

    LoginSystem loginSystem;
    @FXML
    private AnchorPane fxloginroot;

    @FXML
    private Button fxtryagainBtn;
    @FXML
    private AnchorPane fxErroBoks;
    private MMMI main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxErroBoks.setVisible(false);
    }

    @FXML
    private void loginBtnHandler(ActionEvent event) {
        if (event.getSource() == fxLoginBtn) {
            loginSystem = new LoginSystem();
            loginSystem.setUsername(fxUsername.getText());
            loginSystem.setPassword(fxPassword.getText());
            if (loginSystem.getEmployee()) {
                loginSystem.sendEmployee();
                MMMI main = new MMMI();
                try {
                    main.changeScene();
                    Stage stage = (Stage) fxloginroot.getScene().getWindow();
                    stage.close();
                } catch (IOException ex) {
                    Logger.getLogger(LoginSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                fxErroBoks.setVisible(true);

            }
        } else if (event.getSource() == fxtryagainBtn) {
            fxErroBoks.setVisible(false);
        }

    }

}


