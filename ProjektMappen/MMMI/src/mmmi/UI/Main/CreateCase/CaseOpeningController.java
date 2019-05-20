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
    private TextField fxTF_firstname;
    @FXML
    private TextField fxTF_lastname;
    @FXML
    private TextField fxTF_zipcode;
    @FXML
    private TextField fxTF_cityname;
    @FXML
    private TextField fxTF_streetName;
    @FXML
    private TextField fxTF_houseNo;
    @FXML
    private TextField fxTF_floorAndFloorDirection;
    @FXML
    private TextArea fxTA_RegardingInquiry;
    @FXML
    private VBox fxVBox_carriage;
    @FXML
    private RadioButton fxRB_carriage1;
    @FXML
    private RadioButton fxRB_carriage2;
    @FXML
    private RadioButton fxRB_carriage3;
    @FXML
    private RadioButton fxRB_carriage4;
    @FXML
    private RadioButton fxRB_carriage5;
    @FXML
    private RadioButton fxRB_carriage6;
    @FXML
    private VBox fxVbox_treatment;
    @FXML
    private RadioButton fxRB_treatment1;
    @FXML
    private RadioButton fxRB_treatment2;
    @FXML
    private RadioButton fxRB_treatment3;
    @FXML
    private RadioButton fxRB_treatment4;
    @FXML
    private RadioButton fxRB_treatment5;
    @FXML
    private RadioButton fxRB_protectedEmploymentBenefit;
    @FXML
    private RadioButton fxRB_dayRelief;
    @FXML
    private RadioButton fxRB_cashBenefit1;
    @FXML
    private RadioButton fxRB_cashBenefit2;
    @FXML
    private VBox fxVbox_control;
    @FXML
    private RadioButton fxRB_control1;
    @FXML
    private RadioButton fxRB_control2;
    @FXML
    private RadioButton fxRB_control3;
    @FXML
    private RadioButton fxRB_control4;
    @FXML
    private VBox fxVbox_stay;
    @FXML
    private RadioButton fxRB_stay1;
    @FXML
    private RadioButton fxRB_stay2;
    @FXML
    private RadioButton fxRB_stay3;
    @FXML
    private RadioButton fxRB_stay4;
    @FXML
    private RadioButton fxRB_stay5;
    @FXML
    private RadioButton fxRB_personalHelp83;
    @FXML
    private RadioButton fxRB_personalHelp95;
    @FXML
    private RadioButton fxRB_practicalHelp83;
    @FXML
    private RadioButton fxRB_praticalHelp95;
    @FXML
    private VBox fxVbox_socialPedagogicalHelp;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp1;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp2;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp3;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp4;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp5;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp6;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp7;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp8;
    @FXML
    private VBox fxVbox_personHelpScheme;
    @FXML
    private RadioButton fxRB_personHelpScheme1;
    @FXML
    private RadioButton fxRB_personHelpScheme2;
    @FXML
    private RadioButton fxRB_personHelpScheme3;
    @FXML
    private RadioButton fxRB_personHelpScheme4;
    @FXML
    private RadioButton fxRB_personHelpScheme5;
    @FXML
    private RadioButton fxRB_personHelpScheme6;
    @FXML
    private RadioButton fxRB_personHelpScheme7;
    @FXML
    private RadioButton fxRB_housingGeneralCareHome;
    @FXML
    private RadioButton fxRB_housingElderlyOrHandicapFriendly;
    @FXML
    private RadioButton fxRB_housingShared;
    @FXML
    private RadioButton fxRB_housingDayTreatmentOffer;
    @FXML
    private RadioButton fxRB_housingCareHome;
    @FXML
    private RadioButton fxRB_housingCrisisCenter;
    @FXML
    private RadioButton fxRB_housingTemporary;
    @FXML
    private RadioButton fxRB_housingNursingHome;
    @FXML
    private RadioButton fxRB_housingRehabilitation;
    @FXML
    private RadioButton fxRB_securedHousing;
    @FXML
    private RadioButton fxRB_otherLengthyHousing;
    @FXML
    private RadioButton fxRB_clearLookingForYes;
    @FXML
    private RadioButton fxRB_clearLookingForNo;
    @FXML
    private RadioButton fxRB_carriage;
    @FXML
    private RadioButton fxRB_treatment;
    @FXML
    private RadioButton fxRB_control;
    @FXML
    private RadioButton fxRB_stay;
    @FXML
    private RadioButton fxRB_socialPedagogicalHelp;
    @FXML
    private RadioButton fxRB_personHelpScheme;
    @FXML
    private RadioButton fxRB_regardingCitizen;
    @FXML
    private RadioButton fxRB_regardingRelatives;
    @FXML
    private RadioButton fxRB_regardingDoctor;
    @FXML
    private RadioButton fxRB_regardingHospital;
    @FXML
    private RadioButton fxRB_regardingOtherAdministration;
    @FXML
    private RadioButton fxRB_regardingInProgressEffort;
    @FXML
    private RadioButton fxRB_regardingOtherCommune;
    @FXML
    private RadioButton fxRB_regardingOthers;
    @FXML
    private RadioButton fxRB_agreeToInquiryYes;
    @FXML
    private RadioButton fxRB_agreeToInquiryNo;
    @FXML
    private RadioButton fxRB_activityAndSocialInteractionOffer;
    @FXML
    private RadioButton fxRB_protectedEmploymentOffer;
    @FXML
    private RadioButton fxRB_dayCareOffer;
    @FXML
    private RadioButton fxRB_educationOffer;
    @FXML
    private RadioButton fxRB_guadianship;
    @FXML
    private RadioButton fxRB_guadianshipWithRevokedCapacity;
    @FXML
    private RadioButton fxRB_curatorship;
    @FXML
    private RadioButton fxRB_guardian;
    @FXML
    private TextArea fxTA_guardianContact;
    @FXML
    private RadioButton fxRB_layRepresentative;
    @FXML
    private RadioButton fxRB_partRepresentative;
    @FXML
    private RadioButton fxRB_powerOfAttorney;
    @FXML
    private TextArea fxTA_powerOfAttorney;
    @FXML
    private RadioButton fxRB_rightsAndDuties;
    @FXML
    private TextArea fxTA_rightsAndDuties;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationYes;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationNo;
    @FXML
    private TextArea fxTA_agreementsWithCitzen;
    @FXML
    private RadioButton fxRB_getInfoDoctor;
    @FXML
    private RadioButton fxRB_getInfoSpecialDoctor;
    @FXML
    private RadioButton fxRB_getInfoHospital;
    @FXML
    private RadioButton fxRB_getInfoAKasse;
    @FXML
    private RadioButton fxRB_getInfoOffer;
    @FXML
    private RadioButton fxRB_getInfoEmployer;
    @FXML
    private RadioButton fxRB_getInfoPreviousCommune;
    @FXML
    private RadioButton fxRB_getInfoOtherAdministrations;
    @FXML
    private TextArea fxTA_obtainOfInformation;
    @FXML
    private TextArea fxTA_citizenSpecialCircumstances;
    @FXML
    private RadioButton fxRB_OtherActingCommune;
    @FXML
    private RadioButton fxRB_otherPayingCommune;
    @FXML
    private TextArea fxTA_CommunePayingOrActing;
    @FXML
    private RadioButton fxRB_Activity104;
    @FXML
    private RadioButton fxRB_ambulantTreatment;
    @FXML
    private AnchorPane fxAP_subpane;
    @FXML
    private TitledPane fxTP_inquiries;
    @FXML
    private TitledPane fxTP_guardianRepresentation;
    @FXML
    private TitledPane fxTP_rightsDuties;
    @FXML
    private TitledPane fxTP_agreementsWithCitzen;
    @FXML
    private TitledPane fxTP_obtainOfInformation;
    @FXML
    private TitledPane fxTP_citizenSpecialCircumstances;
    @FXML
    private TitledPane communePayingOrActing;
    @FXML
    private TitledPane fxTP_benefitsParagraphs;

    // Other attributes
    private ObservableList<RadioButton> carriageList,
            treatmentList,
            otherElementsList,
            controlList,
            controlBenefitList,
            stayList,
            socialPedagogicalHelpList,
            personHelpSchemeList;

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

}
