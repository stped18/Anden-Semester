package mmmi.UI.Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

	/**
	 * 
	 * @param stage Stage
	 * @throws Exception IOEccpetion if something goes wrong.
	 */
	@Override
	public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        this.scene = new Scene(root);
        stage.setScene(this.scene);
        stage.setTitle("MMMI");
        stage.show();
	}

	/**
	 * 
	 * @throws IOException New Exceotion
	 */
	public void changeScene() throws IOException {
		this.stage = new Stage();
		this.root = FXMLLoader.load(getClass().getResource("../mmmi/UI/Main/Main.fxml"));
		this.stage.setResizable(false);
		this.scene = new Scene(root);
		this.stage.setScene(scene);
		this.stage.show();
	}
}
