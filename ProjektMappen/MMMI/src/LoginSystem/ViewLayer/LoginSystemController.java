/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem.ViewLayer;

import LoginSystem.Domain.LoginSystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }    
    
    @FXML
    private void loginBtnHandler(ActionEvent event) {
        loginSystem = new LoginSystem();
        loginSystem.setUsername(fxUsername.getText());
        loginSystem.setPassword(fxPassword.getText());
        loginSystem.getEmployee();
        System.out.println(loginSystem.getPassword()+ "  and "+ loginSystem.getUsername());
        
    }
    
}







