package mmmi.UI.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;

public class RunFxmlLoader {

	/**
	 *
	 * @param subPane AnchorPane
	 * @param fxml String
	 */
	public void changeFxml(AnchorPane subPane, String fxml) {

        AnchorPane pane;
        try {
            pane = FXMLLoader.load(getClass().getResource(fxml));
            subPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            System.out.println("Message: " + ex.getMessage() + ex.getLocalizedMessage());
            System.out.println(ex);
        }
    }
}
