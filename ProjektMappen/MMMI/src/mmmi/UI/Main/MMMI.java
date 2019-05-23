/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author steff
 */
public class MMMI extends Application {

    Scene scene;
    Stage stage;
	Parent root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

        this.scene = new Scene(root);

        stage.setScene(this.scene);
        stage.setTitle("MMMI");
        stage.show();
    }

    public void changeScene() throws IOException {

        this.stage = new Stage();
        this.root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        this.stage.setResizable(false);
//        this.scene = new Scene(root);
//        this.stage.setScene(scene);
//        this.stage.show();
    }

}


