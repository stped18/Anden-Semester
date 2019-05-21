/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.CreateCase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author PCATG
 */
public class CaseOpeningController implements Initializable {

    // FXML fx:ids
    // CB = CheckBox
    // RB = RadioButton
    // TA = TextArea
    // Vbox = Vbox
    // etc ...
    @FXML
    private TextField fxTF_firstname, fxTF_lastname, fxTF_zipcode, fxTF_cityname, fxTF_streetName, fxTF_houseNo, fxTF_floorAndFloorDirection;
    @FXML
    private TextArea fxTA_RegardingInquiry;
    @FXML
    private VBox fxVBox_carriage, fxVbox_treatment, fxVbox_control, fxVbox_stay,
            fxVbox_socialPedagogicalHelp, fxVbox_personHelpScheme;
    @FXML
    private RadioButton fxRB_carriage1, fxRB_carriage2, fxRB_carriage3, fxRB_carriage4, fxRB_carriage5, fxRB_carriage6;
    @FXML
    private RadioButton fxRB_treatment1, fxRB_treatment2, fxRB_treatment3, fxRB_treatment4, fxRB_treatment5;
    @FXML
    private RadioButton fxRB_protectedEmploymentBenefit, fxRB_dayRelief, fxRB_cashBenefit1, fxRB_cashBenefit2;
    @FXML
    private RadioButton fxRB_control1, fxRB_control2, fxRB_control3, fxRB_control4;
    @FXML
    private RadioButton fxRB_stay1, fxRB_stay2, fxRB_stay3, fxRB_stay4, fxRB_stay5;
    @FXML
    private RadioButton fxRB_personalHelp83, fxRB_personalHelp95, fxRB_practicalHelp83, fxRB_praticalHelp95;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp1, fxRB_socialPedagogicalHelp2,
            fxRB_socialPedagogicalHelp3, fxRB_socialPedagogicalHelp4,
            fxRB_socialPedagogicalHelp5, fxRB_socialPedagogicalHelp6, fxRB_socialPedagogicalHelp7, fxRB_socialPedagogicalHelp8;
    @FXML
    private RadioButton fxRB_personHelpScheme1, fxRB_personHelpScheme2, fxRB_personHelpScheme3,
            fxRB_personHelpScheme4, fxRB_personHelpScheme5, fxRB_personHelpScheme6, fxRB_personHelpScheme7;
    @FXML
    private RadioButton fxRB_housingGeneralCareHome, fxRB_housingElderlyOrHandicapFriendly,
            fxRB_housingShared, fxRB_housingDayTreatmentOffer, fxRB_housingCareHome, fxRB_housingCrisisCenter,
            fxRB_housingTemporary, fxRB_housingNursingHome, fxRB_housingRehabilitation;
    @FXML
    private RadioButton fxRB_securedHousing, fxRB_otherLengthyHousing, fxRB_clearLookingForYes,
            fxRB_clearLookingForNo, fxRB_carriage, fxRB_treatment, fxRB_control, fxRB_stay,
            fxRB_socialPedagogicalHelp, fxRB_personHelpScheme, fxRB_regardingCitizen;
    @FXML
    private RadioButton fxRB_regardingRelatives, fxRB_regardingDoctor, fxRB_regardingHospital,
            fxRB_regardingOtherAdministration, fxRB_regardingInProgressEffort, fxRB_regardingOtherCommune,
            fxRB_regardingOthers, fxRB_agreeToInquiryYes, fxRB_agreeToInquiryNo, fxRB_activityAndSocialInteractionOffer;
    @FXML
    private RadioButton fxRB_protectedEmploymentOffer, fxRB_dayCareOffer, fxRB_educationOffer,
            fxRB_guadianship, fxRB_guadianshipWithRevokedCapacity, fxRB_curatorship, fxRB_guardian,
            fxRB_layRepresentative, fxRB_rightsAndDuties, fxRB_powerOfAttorney, fxRB_partRepresentative;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationYes, fxRB_getInfoOtherAdministrations,
            fxRB_getInfoPreviousCommune, fxRB_getInfoEmployer, fxRB_getInfoOffer, fxRB_getInfoAKasse,
            fxRB_getInfoHospital, fxRB_getInfoSpecialDoctor, fxRB_getInfoDoctor, fxRB_agreeToElectronicRegistrationNo;
    @FXML
    private TextArea fxTA_obtainOfInformation, fxTA_CommunePayingOrActing, fxTA_citizenSpecialCircumstances,
            fxTA_agreementsWithCitzen, fxTA_rightsAndDuties, fxTA_powerOfAttorney, fxTA_guardianContact;
    @FXML
    private RadioButton fxRB_OtherActingCommune, fxRB_ambulantTreatment, fxRB_Activity104, fxRB_otherPayingCommune;
    @FXML
    private AnchorPane fxAP_subpane;
    @FXML
    private TitledPane fxTP_inquiries, fxTP_benefitsParagraphs, communePayingOrActing,
            fxTP_citizenSpecialCircumstances, fxTP_obtainOfInformation, fxTP_agreementsWithCitzen, fxTP_rightsDuties, fxTP_guardianRepresentation;

    // Other attributes
    private ObservableList<RadioButton> carriageList,
            treatmentList,
            otherElementsList,
            controlList,
            controlBenefitList,
            stayList,
            socialPedagogicalHelpList,
            personHelpSchemeList;
    @FXML
    private RadioButton fxRB_outgoingOffer;
    @FXML
    private RadioButton fxRB_offerWithAuthority;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tgLookingForGroup = new ToggleGroup();

        this.carriageList = FXCollections.observableArrayList();
        this.treatmentList = FXCollections.observableArrayList();
        this.otherElementsList = FXCollections.observableArrayList();
        this.controlList = FXCollections.observableArrayList();
        this.controlBenefitList = FXCollections.observableArrayList();
        this.stayList = FXCollections.observableArrayList();
        this.socialPedagogicalHelpList = FXCollections.observableArrayList();
        this.personHelpSchemeList = FXCollections.observableArrayList();

        fxRB_clearLookingForYes.setToggleGroup(tgLookingForGroup);
        fxRB_clearLookingForNo.setToggleGroup(tgLookingForGroup);

        carriageList.add(fxRB_carriage1);
        carriageList.add(fxRB_carriage2);
        carriageList.add(fxRB_carriage3);
        carriageList.add(fxRB_carriage4);
        carriageList.add(fxRB_carriage5);
        carriageList.add(fxRB_carriage6);

        treatmentList.add(fxRB_treatment1);
        treatmentList.add(fxRB_treatment2);
        treatmentList.add(fxRB_treatment3);
        treatmentList.add(fxRB_treatment4);
        treatmentList.add(fxRB_treatment5);

        controlBenefitList.add(fxRB_cashBenefit1);
        controlBenefitList.add(fxRB_cashBenefit2);

        controlList.add(fxRB_control1);
        controlList.add(fxRB_control2);
        controlList.add(fxRB_control3);
        controlList.add(fxRB_control4);

        stayList.add(fxRB_stay1);
        stayList.add(fxRB_stay2);
        stayList.add(fxRB_stay3);
        stayList.add(fxRB_stay4);
        stayList.add(fxRB_stay5);

        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp1);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp2);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp3);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp4);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp5);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp6);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp7);
        socialPedagogicalHelpList.add(fxRB_socialPedagogicalHelp8);

        personHelpSchemeList.add(fxRB_personHelpScheme1);
        personHelpSchemeList.add(fxRB_personHelpScheme2);
        personHelpSchemeList.add(fxRB_personHelpScheme3);
        personHelpSchemeList.add(fxRB_personHelpScheme4);
        personHelpSchemeList.add(fxRB_personHelpScheme5);
        personHelpSchemeList.add(fxRB_personHelpScheme6);
        personHelpSchemeList.add(fxRB_personHelpScheme7);

        // Eventual implementation:
        otherElementsList.add(fxRB_Activity104);
        otherElementsList.add(fxRB_protectedEmploymentBenefit);
        otherElementsList.add(fxRB_personalHelp83);
        otherElementsList.add(fxRB_personalHelp95);

        carriageList.forEach((RadioButton) -> {
            RadioButton.setVisible(false);
            RadioButton.setToggleGroup(tgLookingForGroup);
        });

    }

//    @FXML
//    private void rbCarriageOnAction(ActionEvent event) {
//        if (event.getSource() == fxRB_carriage) {
//            carriageList.forEach((RadioButton) -> {
//                RadioButton.setVisible(true);
//            });
//
//            if (fxRB_carriage.isSelected() == false) {
//                carriageList.forEach((RadioButton) -> {
//                    RadioButton.setVisible(false);
//                });
//            }
//
//        }
//    }

    @FXML
    private void getMarkedInformation(ActionEvent event) {
    }
}
