/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.createCase.caseOpening;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author PCATG
 */
public class CaseOpeningFXMLController implements Initializable {

    @FXML
    private AnchorPane caseOpenRootpane;
    @FXML
    private AnchorPane clearWhatCitizenSearchesYesCheckBox;
    @FXML
    private TextArea fxRegardingTextArea;
    @FXML
    private CheckBox fxCBCarriage1;
    @FXML
    private CheckBox fxCBCarriage2;
    @FXML
    private CheckBox fxCBCarriage3;
    @FXML
    private CheckBox fxCBCarriage4;
    @FXML
    private CheckBox fxCBCarriage5;
    @FXML
    private CheckBox fxCBCarriage6;
    @FXML
    private RadioButton fxRBLookingForYes;
    @FXML
    private RadioButton fxRBCarriage;
    @FXML
    private RadioButton fxRBLookingForNo;
    private ObservableList<CheckBox> carriageCheckboxes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tgLookingForGroup = new ToggleGroup();
        this.carriageCheckboxes = FXCollections.observableArrayList();
        fxRBLookingForYes.setToggleGroup(tgLookingForGroup);
        fxRBLookingForNo.setToggleGroup(tgLookingForGroup);

        carriageCheckboxes.add(fxCBCarriage1);
        carriageCheckboxes.add(fxCBCarriage2);
        carriageCheckboxes.add(fxCBCarriage3);
        carriageCheckboxes.add(fxCBCarriage4);
        carriageCheckboxes.add(fxCBCarriage5);
        carriageCheckboxes.add(fxCBCarriage6);

        for (CheckBox c : carriageCheckboxes) {
            c.setVisible(false);
        }

    }

    @FXML
    private void rbCarriageOnAction(ActionEvent event) {
        if (event.getSource() == fxRBCarriage) {
            for (CheckBox c : carriageCheckboxes) {
                c.setVisible(true);
            }
            if (fxRBCarriage.isSelected() == false) {
                carriageCheckboxes.forEach((CheckBox) -> {
                    CheckBox.setVisible(false);
                });
            }

        }

    }

}
