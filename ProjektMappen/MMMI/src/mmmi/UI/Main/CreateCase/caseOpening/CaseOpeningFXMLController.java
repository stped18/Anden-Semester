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
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author PCATG
 */
public class CaseOpeningFXMLController implements Initializable {

    // FXML fx:ids
    // CB = CheckBox
    // RB = RadioButton
    // TA = TextArea
    // Vbox = Vbox
    // etc ...
    @FXML
    private AnchorPane caseOpenRootpane;
    @FXML
    private CheckBox fxCB_Activity104;
    @FXML
    private VBox fxVBox_carriage;
    @FXML
    private RadioButton fxRB_clearLookingForYes;
    @FXML
    private RadioButton fxRB_clearLookingForNo;
    @FXML
    private TextArea fxTA_RegardingInquiry;
    @FXML
    private RadioButton fxRB_carriage;
    @FXML
    private CheckBox fxCB_carriage1;
    @FXML
    private CheckBox fxCB_carriage2;
    @FXML
    private CheckBox fxCB_carriage3;
    @FXML
    private CheckBox fxCB_carriage4;
    @FXML
    private CheckBox fxCB_carriage5;
    @FXML
    private CheckBox fxCB_carriage6;
    @FXML
    private VBox fxVbox_treatment;
    @FXML
    private CheckBox fxCB_treatment1;
    @FXML
    private CheckBox fxCB_treatment2;
    @FXML
    private CheckBox fxCB_treatment3;
    @FXML
    private CheckBox fxCB_treatment4;
    @FXML
    private CheckBox fxCB_treatment5;
    @FXML
    private CheckBox fxCB_protectedEmploymentBenefit;
    @FXML
    private CheckBox fxCB_dayRelief;
    @FXML
    private CheckBox fxRB_cashBenefit1;
    @FXML
    private CheckBox fxRB_cashBenefit2;
    @FXML
    private VBox fxVbox_control;
    @FXML
    private CheckBox fxCB_control1;
    @FXML
    private CheckBox fxCB_control2;
    @FXML
    private CheckBox fxCB_control3;
    @FXML
    private CheckBox fxCB_control4;
    @FXML
    private VBox fxVbox_stay;
    @FXML
    private CheckBox fxCB_stay1;
    @FXML
    private CheckBox fxCB_stay2;
    @FXML
    private CheckBox fxCB_stay3;
    @FXML
    private CheckBox fxCB_stay4;
    @FXML
    private CheckBox fxCB_stay5;
    @FXML
    private CheckBox fxCB_personalHelp83;
    @FXML
    private CheckBox fxCB_personalHelp95;
    @FXML
    private CheckBox fxCB_practicalHelp83;
    @FXML
    private CheckBox fxCB_praticalHelp95;
    @FXML
    private VBox fxVbox_socialPedagogicalHelp;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp1;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp2;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp3;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp4;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp5;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp6;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp7;
    @FXML
    private CheckBox fxCB_socialPedagogicalHelp8;
    @FXML
    private VBox fxVbox_personHelpScheme;
    @FXML
    private CheckBox fxCB_personHelpScheme1;
    @FXML
    private CheckBox fxCB_personHelpScheme2;
    @FXML
    private CheckBox fxCB_personHelpScheme3;
    @FXML
    private CheckBox fxCB_personHelpScheme4;
    @FXML
    private CheckBox fxCB_personHelpScheme5;
    @FXML
    private CheckBox fxCB_personHelpScheme6;
    @FXML
    private CheckBox fxCB_personHelpScheme7;
    @FXML
    private CheckBox fxCB_ambulantTreatment;
    @FXML
    private CheckBox fxCB_housingGeneralCareHome;
    @FXML
    private CheckBox fxCB_housingElderlyOrHandicapFriendly;
    @FXML
    private CheckBox fxCB_housingShared;
    @FXML
    private CheckBox fx_housingDayTreatmentOffer;
    @FXML
    private CheckBox fxCB_housingCareHome;
    @FXML
    private CheckBox fxCB_housingCrisisCenter;
    @FXML
    private CheckBox fxCB_housingTemporary;
    @FXML
    private CheckBox fxCB_housingNursingHome;
    @FXML
    private CheckBox fxCB_housingRehabilitation;
    @FXML
    private CheckBox fxCB_outgoingOffer;
    @FXML
    private CheckBox fxCB_offerWithAuthority;
    @FXML
    private RadioButton fxRB_treatment;
    @FXML
    private RadioButton fxRB_cashBenefit;
    @FXML
    private RadioButton fxRB_control;
    @FXML
    private RadioButton fxRB_stay;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp;
    @FXML
    private RadioButton fxRB_personHelpScheme;
    @FXML
    private CheckBox fxCB_regardingCitizen;
    @FXML
    private CheckBox fxCB_regardingRelatives;
    @FXML
    private CheckBox fxCB_regardingDoctor;
    @FXML
    private CheckBox fxCB_regardingHospital;
    @FXML
    private CheckBox fxCB_regardingOtherAdministration;
    @FXML
    private CheckBox fxCB_regardingInProgressEffort;
    @FXML
    private CheckBox fxCB_regardingOtherCommune;
    @FXML
    private CheckBox fxCB_regardingOthers;
    @FXML
    private RadioButton fxRB_agreeToInquiryYes;
    @FXML
    private RadioButton fxRB_agreeToInquiryNo;
    @FXML
    private CheckBox fxCB_activityAndSocialInteractionOffer;
    @FXML
    private CheckBox fxCB_protectedEmploymentOffer;
    @FXML
    private CheckBox fxCB_dayCareOffer;
    @FXML
    private CheckBox fxCB_educationOffer;
    @FXML
    private CheckBox fxCB_guadianship;
    @FXML
    private CheckBox fxCB_guadianshipWithRevokedCapacity;
    @FXML
    private CheckBox fxCB_curatorship;
    @FXML
    private CheckBox fxCB_guardian;
    @FXML
    private CheckBox fx_layRepresentative;
    @FXML
    private CheckBox fxCB_partRepresentative;
    @FXML
    private CheckBox fxCB_powerOfAttorney;
    @FXML
    private TextArea fxTA_powerOfAttorney;
    @FXML
    private CheckBox fxCB_rightsAndDuties;
    @FXML
    private TextArea fxTA_rightsAndDuties;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationYes;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationNo;
    @FXML
    private TextArea fxTA_agreementsWithCitzen;
    @FXML
    private RadioButton fxRB_consentYes;
    @FXML
    private RadioButton fxRB_consentNo;
    @FXML
    private CheckBox fxCB_consentOral;
    @FXML
    private CheckBox fxCB_consentWritten;
    @FXML
    private CheckBox fxCB_getInfoDoctor;
    @FXML
    private CheckBox fxCB_getInfoSpecialDoctor;
    @FXML
    private CheckBox fxCB_getInfoHospital;
    @FXML
    private CheckBox fxCB_getInfoAKasse;
    @FXML
    private CheckBox fxCB_getInfoOffer;
    @FXML
    private CheckBox fxCB_getInfoEmployer;
    @FXML
    private CheckBox fxCB_getInfoPreviousCommune;
    @FXML
    private CheckBox fxCB_getInfoOtherAdministrations;
    @FXML
    private TextArea fxTA_getInfo;
    @FXML
    private TextArea fxTA_citizenSpecialCircumstances;
    @FXML
    private CheckBox fxCB_OtherActingCommune;
    @FXML
    private CheckBox fxCB_otherPayingCommune;
    @FXML
    private TextArea fxTA_CommunePayingOrActing;
    // Other attributes
    private ObservableList<CheckBox> carriageCheckboxes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tgLookingForGroup = new ToggleGroup();
        this.carriageCheckboxes = FXCollections.observableArrayList();
        fxRB_clearLookingForYes.setToggleGroup(tgLookingForGroup);
        fxRB_clearLookingForNo.setToggleGroup(tgLookingForGroup);

        carriageCheckboxes.add(fxCB_carriage1);
        carriageCheckboxes.add(fxCB_carriage2);
        carriageCheckboxes.add(fxCB_carriage3);
        carriageCheckboxes.add(fxCB_carriage4);
        carriageCheckboxes.add(fxCB_carriage5);
        carriageCheckboxes.add(fxCB_carriage6);

        for (CheckBox c : carriageCheckboxes) {
            c.setVisible(false);
        }

    }

    @FXML
    private void rbCarriageOnAction(ActionEvent event) {
        if (event.getSource() == fxRB_carriage) {
            carriageCheckboxes.forEach((CheckBox) -> {
                CheckBox.setVisible(true);
            });

            if (fxRB_carriage.isSelected() == false) {
                carriageCheckboxes.forEach((CheckBox) -> {
                    CheckBox.setVisible(false);
                });
            }

        }

    }

}
