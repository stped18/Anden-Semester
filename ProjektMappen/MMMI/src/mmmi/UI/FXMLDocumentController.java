/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Data_layer.DatabaseConnection;

/**
 *
 * @author steff
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private PasswordField passWord;
    @FXML
    private TextField userName;
    @FXML
    private Button LoginBTN;
    
    DatabaseConnection db = new DatabaseConnection();
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginBTNHandler(ActionEvent event) {
        String user = userName.getText();
        String pass = passWord.getText();

        
        
        
        
        
    }
    
}
