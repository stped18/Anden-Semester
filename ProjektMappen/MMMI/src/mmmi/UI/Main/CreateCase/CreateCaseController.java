package mmmi.UI.Main.CreateCase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import mmmi.UI.Main.RunFxmlLoader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.createCase.NodeFinder;

public class CreateCaseController extends RunFxmlLoader implements Initializable {

    @FXML
    private Button fxnextBtn;
    @FXML
    private Button fxBackBtn;
    @FXML
    private Button fxSaveBtn;
    @FXML
    private AnchorPane fxSubSubpane;

    List<String> list;
    IDomain department = Department.getInstance();
    private int count = 0;
    private NodeFinder nf;

	/**
	 * 
	 * @param url
	 * @param rb 
	 */
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        nf = NodeFinder.getInstant();
        this.list = new ArrayList<>();
        list.add(0, "../createcase/fxml/caseOpening.fxml");
        list.add(1, "../createcase/fxml/caseInvestigation.fxml");
        changeFxml(fxSubSubpane, list.get(0));
        chanceScene();
    }

	/**
	 * 
	 * @param event 
	 */
    @FXML
    private void buttonHandler(ActionEvent event) {

        if (event.getSource() == fxnextBtn) {
            this.count++;
            chanceScene();
        }
        if (event.getSource() == fxBackBtn) {
            this.count--;
            chanceScene();
        }
        if (event.getSource() == fxSaveBtn) {
            if(!nf.isFullMapEmty()){
                department.saveCase(nf.getFullContensMap());
            }
        }
    }

	/**
	 * 
	 */
    private void chanceScene() {
        switch (this.count) {
            case 0:
                changeFxml(fxSubSubpane, list.get(count));
                fxnextBtn.setVisible(true);
                fxBackBtn.setVisible(false);
                break;
            case 1:
                changeFxml(fxSubSubpane, list.get(count));
                fxnextBtn.setVisible(false);
                fxBackBtn.setVisible(true);
                break;
        }
    }
}

