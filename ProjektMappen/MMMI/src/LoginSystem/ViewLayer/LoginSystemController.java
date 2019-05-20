package LoginSystem.ViewLayer;

import LoginSystem.Domain.ILogind;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mmmi.UI.Main.*;
import mmmi.Domain.Employee;

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
    @FXML
    private ProgressBar fxprocessbar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxErroBoks.setVisible(false);
           try {   
                process();
                 double d = fxprocessbar.getProgress();
                 fxprocessbar.setProgress(d);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

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

//    private void proces() {
//        new Thread(() -> {
//            for (double i = 0.01; i < 1.00; i++) {
//                fxprocessbar.setProgress(i);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(LoginSystemController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (i == 1.00) {
//                    i = 0.00;
//                }
////        try {
////            Thread.sleep(300);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        final double progress = i * 0.1;
////        
////        Platform.runLater(() -> ui.updateProgress(progress));
//
//            }
//        }).start();
//    }
    private void process() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final double progress = i * 0.1;
                
                Platform.runLater(() -> updateProgress(progress));

            }
        }).start();

    }

    public void updateProgress(double progress) {

        fxprocessbar.setProgress(progress);
        double d = fxprocessbar.getProgress();
        System.out.println("progress APPARENTLY set to: " + d);

    }
}







