package mmmi.UI.Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

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
	 * @param url URL
	 * @param rb ResourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		changeFxml(fxSubPane, "Home/home.fxml");
	}

	/**
	 * 
	 * @param event 
	 */
	@FXML
	private void BtnHandler(ActionEvent event) {
		if (event.getSource() == fxHomeBtn) {
			changeFxml(fxSubPane, "Home/home.fxml");
		}
		if (event.getSource() == fxCreateCaseBtn) {
			changeFxml(fxSubPane, "createCase/fxml/createcase.fxml");
		}
		if (event.getSource() == fxSearchcaseBtn) {
			changeFxml(fxSubPane, "findcase/findCase.fxml");
		}
	}
}
