package mmmi.UI.Main.CreateCase;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import mmmi.UI.Main.createCase.NodeFinder;

public class CaseInvestigationController implements Initializable {

	@FXML
	private TextArea fxTa_physicsInformationCitizen, fxTa_physicsInformatinOthers, fxTa_physicsRemarks,
			fxTa_mentallyInformationCitizen, fxTa_mentallyInformatinOthers, fxTa_mentallyRemarks,
			fxTa_socialInformationCitizen, fxTa_sociallyInformatinOthers, fxTa_sociallyRemarks;
	@FXML
	private TextArea fxTa_practiceTasksInformationCitizen, fxTa_practiceTasksInformatinOthers,
			fxTa_practiceTasksRemarks, fxTa_selfcareInformationCitizen, fxTa_selfcareInformatinOthers,
			fxTa_selfcareRemarks, fxTa_mobilityInformationCitizen, fxTa_mobilityInformatinOthers, fxTa_mobilityRemarks;
	@FXML
	private TextArea fxTa_communicationInformationCitizen, fxTa_communicationInformatinOthers, fxTa_communicationRemarks,
			fxTa_communityLifeInformationCitizen, fxTa_communityLifeInformatinOthers, fxTa_communityLifeRemarks,
			fxTa_socialLifeInformationCitizen, fxTa_socialLifeInformatinOthers, fxTa_socialLifeRemarks;
	@FXML
	private TextArea fxTa_healthInformationCitizen, fxTa_healthInformatinOthers, fxTa_healthRemarks,
			fxTa_environmentInformationCitizen, fxTa_environmentInformatinOthers, fxTa_environmentRemarks;
	@FXML
	private TextField fxTf_physicalThemes, fxTf_mentallyThemes, fxTf_sociallyThemes,
			fxTf_practiceTasksThemes, fxTf_selfcareThemes, fxTf_mobilityThemes, fxTf_communicationThemes,
			fxTf_communityLifeThemes, fxTf_socialLifeThemes, fxTf_healthThemes, fxTf_environmentThemes;
	@FXML
	private RadioButton fxRb_physicalLevelFunction0, fxRb_physicalLevelFunction1, fxRb_physicalLevelFunction2,
			fxRb_physicalLevelFunction3, fxRb_physicalLevelFunction4fxRb_mentallyLevelFunction0,
			fxRb_mentallyLevelFunction1, fxRb_mentallyLevelFunction2, fxRb_mentallyLevelFunction3, fxRb_mentallyLevelFunction4;
	@FXML
	private RadioButton fxRb_sociallyLevelFunction0, fxRb_sociallyLevelFunction1, fxRb_sociallyLevelFunction2,
			fxRb_sociallyLevelFunction3, fxRb_sociallyLevelFunction4, fxRb_practiceTasksLevelFunction0, fxRb_practiceTasksLevelFunction1,
			fxRb_practiceTasksLevelFunction2, fxRb_practiceTasksLevelFunction3, fxRb_practiceTasksLevelFunction4;
	@FXML
	private RadioButton fxRb_selfcareLevelFunction0, fxRb_selfcareLevelFunction1, fxRb_selfcareLevelFunction2,
			fxRb_selfcareLevelFunction3, fxRb_selfcareLevelFunction4, fxRb_mobilityLevelFunction0, xRb_mobilityLevelFunction1,
			fxRb_mobilityLevelFunction2, fxRb_mobilityLevelFunction3, fxRb_mobilityLevelFunction4;
	@FXML
	private RadioButton fxRb_communicationLevelFunction0, fxRb_communicationLevelFunction1,
			fxRb_communicationLevelFunction2, fxRb_communicationLevelFunction3, fxRb_communicationLevelFunction4,
			fxRb_communityLifeLevelFunction0, fxRb_communityLifeLevelFunction1, fxRb_communityLifeLevelFunction2,
			fxRb_communityLifeLevelFunction3, fxRb_communityLifeLevelFunction4;
	@FXML
	private RadioButton fxRb_healthLevelFunction0, fxRb_healthLevelFunction1, fxRb_healthLevelFunction2,
			fxRb_healthLevelFunction3, fxRb_healthLevelFunction4, fxRb_socialLifeLevelFunction0,
			fxRb_socialLifeLevelFunction1, fxRb_socialLifeLevelFunction2, fxRb_socialLifeLevelFunction3,
			fxRb_socialLifeLevelFunction4;
	@FXML
	private RadioButton fxRb_environmentLevelFunction0, fxRb_environmentLevelFunction1,
			fxRb_environmentLevelFunction2, fxRb_environmentLevelFunction3, fxRb_environmentLevelFunction4,
			fxRb_evaluated0, fxRb_evaluated1, fxRb_evaluated2, fxRb_evaluated3, fxRb_evaluated4;
	@FXML
	private Button fxBtn_save;
	@FXML
	private AnchorPane fxAc_CaseInvestigationroot;

	NodeFinder nf;

	/**
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		nf = NodeFinder.getInstance();
		nf.runRadioFinder(fxAc_CaseInvestigationroot);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void BtnHandler(ActionEvent event) {

		nf.getContents().put("caseID", "-1");
		nf.addContents(nf.findNodehandler(fxAc_CaseInvestigationroot));

		for (Map.Entry<String, String> entry : nf.getContents().entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();
			System.out.println(key + "    " + val);
		}
	}
}
