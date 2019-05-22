package LoginSystem.ViewLayer;

import LoginSystem.Domain.LoginSystem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mmmi.UI.Main.*;

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
    private Label fxLb_ErroMesage;
    int count = 0;
    @FXML
    private AnchorPane fxAp_Laader;
    @FXML
    private ProgressIndicator FXLoader;

    boolean isind = true;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxAp_Laader.setVisible(false);
    }

    @FXML
    private void loginBtnHandler(ActionEvent event) {
        if (count < 3) {
            fxAp_Laader.setVisible(true);
            // TODO : need a procesIndikator for time to login;

            loginSystem = new LoginSystem();
            loginSystem.setUsername(fxUsername.getText());
            loginSystem.setPassword(fxPassword.getText());
            if (event.getSource() == fxLoginBtn) {
                if (loginSystem.getEmployee()) {
                    MMMI main = new MMMI();
                    try {
                        main.changeScene();

                        Stage stage = (Stage) fxloginroot.getScene().getWindow();
                        isind = false;
                        stage.close();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginSystemController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    fxAp_Laader.setVisible(false);
                    fxLb_ErroMesage.setText("Forkert brugernavn eller kode prøv igen \nForsøg tilbage :  " + (3 - count));
                    count++;
                }
            }
        } else {
            fxLb_ErroMesage.setText("Kontakt admin:");
        }
    }
}
