package LoginSystem.ViewLayer;

import LoginSystem.Domain.ILogind;
import LoginSystem.Domain.LoginSystem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginSystemController implements Initializable {

    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxPassWord;
    @FXML
    private Button fxLoginBTM;
    
    ILogind loginSystem;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void logindHandler(ActionEvent event) {
        loginSystem = new LoginSystem(fxUsername.getText(), fxPassWord.getText());
    }

}
