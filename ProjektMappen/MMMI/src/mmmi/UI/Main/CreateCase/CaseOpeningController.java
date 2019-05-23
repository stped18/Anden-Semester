/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.CreateCase;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.MainController;
import mmmi.UI.Main.createCase.NodeFinder;

/**
 * FXML Controller class
 *
 * @author PCATG
 */
public class CaseOpeningController  implements Initializable {

    @FXML
    private TextArea fxTA_RegardingInquiry;
    @FXML
    private TextField fxTF_firstnameRegarding, fxTF_lastnameRegarding, fxTF_cprNoRegarding, fxTF_zipcodeRegarding, fxTF_citynameRegarding,
            fxTF_streetNameRegarding, fxTF_houseNoRegarding, fxTF_floorAndFloorDirectionRegarding,
            fxTF_firstnameRequesting, fxTF_lastnameRequesting, fxTF_zipcodeRequesting, fxTF_citynameRequesting, fxTF_streetNameRequesting,
            fxTF_houseNoRequesting, fxTF_floorAndFloorDirectionRequesting;
    @FXML
    private RadioButton fxRB_agreeToInquiryYesRegarding, fxRB_agreeToInquiryYesRequesting, fxRB_agreeToInquiryNoRequesting,
            fxRB_offerWithAuthority, fxRB_outgoingOffer, fxRB_agreeToInquiryNo1Regarding;

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
            fxRB_regardingOthers, fxRB_activityAndSocialInteractionOffer;
    @FXML
    private RadioButton fxRB_protectedEmploymentOffer, fxRB_dayCareOffer, fxRB_educationOffer, fxRB_rightsAndDuties;
    @FXML
    private RadioButton fxRB_agreeToElectronicRegistrationYes, fxRB_getInfoOtherAdministrations,
            fxRB_getInfoPreviousCommune, fxRB_getInfoEmployer, fxRB_getInfoOffer, fxRB_getInfoAKasse,
            fxRB_getInfoHospital, fxRB_getInfoSpecialDoctor, fxRB_getInfoDoctor, fxRB_agreeToElectronicRegistrationNo;
    @FXML
    private TextArea fxTA_obtainOfInformation, fxTA_CommunePayingOrActing, fxTA_citizenSpecialCircumstances,
            fxTA_agreementsWithCitzen, fxTA_rightsAndDuties;
    @FXML
    private RadioButton fxRB_OtherActingCommune, fxRB_ambulantTreatment, fxRB_Activity104, fxRB_otherPayingCommune;
    @FXML
    private AnchorPane fxAP_subpane;
    @FXML
    private TitledPane fxTP_inquiries, fxTP_benefitsParagraphs, communePayingOrActing,
            fxTP_citizenSpecialCircumstances, fxTP_obtainOfInformation, fxTP_agreementsWithCitzen, fxTP_rightsDuties,
            fxTP_socialPedagogicalHelp, fxTP_personHelpScheme, fxTP_otherOffersAndParagraphs, fxTP_homeOfferForAdults,
            fxTP_extendedHomeOffersForAdults, fxTP_ambulantTreatment, fxTP_dayOfferForAdults, fxTP_treatment, fxTP_control,
            fxTP_stay, fxTP_carriage, fxTP_requestingInfo, fxTP_regardingInfo;
    @FXML
    private Button fxBT_save;
    // other attributes
    private ToggleGroup sureLookingForTG, yesNoInquiryTG1, yesNoInquiryTG2, sectionOneVisibilityTG, carriageTG, treatmentTG,
            otherElementTG, controlTG, controlBenefitTG, stayTG, socialPedagogicalHelpTG,
            personalHelpSchemeTG, requestingList, regardingTG,
            rightsAndDutiesTG, agreeToElectronicRegistrationTG;
    private Map<String, Map<String, String>> theFullContentsMap;
    private Map<String, String> contentsMap, cRegardingMap, cRequestingMap;
    private IDomain department;
    @FXML
    private TextField fxTF_cprNoRequesting;
    //private Label fxLB_userInfo;
    NodeFinder nf;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nf = NodeFinder.getInstant();
                
      
                
      
        department = Department.getInstance();
        department.setDepartmentID(1);
        theFullContentsMap = new HashMap<>();
        contentsMap = new HashMap<>();
        cRegardingMap = new HashMap<>();
        cRequestingMap = new HashMap<>();

        // ToggleGroups for first section, inquiry
        yesNoInquiryTG1 = createToggleGroup(fxRB_agreeToInquiryYesRegarding, fxRB_agreeToInquiryNo1Regarding);

        yesNoInquiryTG2 = createToggleGroup(fxRB_agreeToInquiryYesRequesting, fxRB_agreeToInquiryNoRequesting);
        sureLookingForTG = createToggleGroup(fxRB_clearLookingForYes, fxRB_clearLookingForNo);
        carriageTG = createToggleGroup(fxRB_carriage1, fxRB_carriage2, fxRB_carriage3, fxRB_carriage4, fxRB_carriage5, fxRB_carriage6);
        treatmentTG = createToggleGroup(fxRB_treatment1, fxRB_treatment2, fxRB_treatment3, fxRB_treatment4, fxRB_treatment5);
        controlTG = createToggleGroup(fxRB_control1, fxRB_control2, fxRB_control3, fxRB_control4);
        stayTG = createToggleGroup(fxRB_stay1, fxRB_stay2, fxRB_stay3, fxRB_stay4, fxRB_stay5);

        socialPedagogicalHelpTG = createToggleGroup(fxRB_socialPedagogicalHelp1, fxRB_socialPedagogicalHelp2,
                fxRB_socialPedagogicalHelp3, fxRB_socialPedagogicalHelp4,
                fxRB_socialPedagogicalHelp5, fxRB_socialPedagogicalHelp6, fxRB_socialPedagogicalHelp7, fxRB_socialPedagogicalHelp8);

        personalHelpSchemeTG = createToggleGroup(fxRB_personHelpScheme1, fxRB_personHelpScheme2, fxRB_personHelpScheme3,
                fxRB_personHelpScheme4, fxRB_personHelpScheme5, fxRB_personHelpScheme6, fxRB_personHelpScheme7);

        sectionOneVisibilityTG = createToggleGroup(fxRB_carriage, fxRB_treatment, fxRB_control, fxRB_stay, fxRB_socialPedagogicalHelp,
                fxRB_personHelpScheme);

        regardingTG = createToggleGroup(fxRB_regardingCitizen, fxRB_regardingRelatives, fxRB_regardingDoctor, fxRB_regardingHospital,
                fxRB_regardingOtherAdministration, fxRB_regardingInProgressEffort, fxRB_regardingOtherCommune,
                fxRB_regardingOthers);
        fxTP_benefitsParagraphs.setVisible(false);
        fxTP_regardingInfo.setVisible(false);
        fxTP_requestingInfo.setVisible(false);

        // ToggleGroups for second section, Rights and duties
        fxTA_rightsAndDuties.setEditable(false);
        rightsAndDutiesTG = createToggleGroup(fxRB_rightsAndDuties);
        agreeToElectronicRegistrationTG = createToggleGroup(fxRB_agreeToElectronicRegistrationYes, fxRB_agreeToElectronicRegistrationNo);

    }
 
    @FXML
    private void inquiryRBonAction(ActionEvent event) {

        if (sureLookingForTG.getSelectedToggle() == fxRB_clearLookingForYes) {
            fxTP_benefitsParagraphs.setVisible(true);
        } else if (sureLookingForTG.getSelectedToggle() == fxRB_clearLookingForNo) {
            fxTP_benefitsParagraphs.setVisible(false);
        }
        if (yesNoInquiryTG1.getSelectedToggle() == fxRB_agreeToInquiryYesRegarding) {
            fxTP_regardingInfo.setVisible(true);
            fxTP_regardingInfo.setExpanded(true);
        } else if (yesNoInquiryTG1.getSelectedToggle() == fxRB_agreeToInquiryNo1Regarding) {
            fxTP_regardingInfo.setVisible(false);
            fxTP_requestingInfo.setExpanded(false);
        }
        if (yesNoInquiryTG2.getSelectedToggle() == fxRB_agreeToInquiryYesRequesting) {
            fxTP_requestingInfo.setVisible(true);
            fxTP_requestingInfo.setExpanded(true);
        } else if (yesNoInquiryTG1.getSelectedToggle() == fxRB_agreeToInquiryNoRequesting) {
            fxTP_requestingInfo.setVisible(false);
            fxTP_requestingInfo.setExpanded(false);
        }

    }

    @FXML
    private void rightsAndDutiesRBOnAction(ActionEvent event) {
        if (rightsAndDutiesTG.getSelectedToggle() == fxRB_rightsAndDuties) {
            fxTA_rightsAndDuties.setEditable(true);

        }

    }

    @FXML
    private void obtainOfInformationRBonAction(ActionEvent event) {
    }

    @FXML
    private void communePayingOrActingRBonAction(ActionEvent event) {
    }

    @FXML
    private void benefitsParagraphs(ActionEvent event) {
    }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
         if (event.getSource() == fxBT_save) {

            if (!fxTF_firstnameRegarding.getText().isEmpty()) {
                cRegardingMap.put("firstName", fxTF_firstnameRegarding.getText());
                cRegardingMap.put("lastName", fxTF_lastnameRegarding.getText());
                cRegardingMap.put("streetName", fxTF_streetNameRegarding.getText());
                cRegardingMap.put("cityName", fxTF_citynameRegarding.getText());
                cRegardingMap.put("zipCode", String.valueOf(fxTF_zipcodeRegarding.getText()));
                cRegardingMap.put("houseNo", String.valueOf(fxTF_zipcodeRegarding.getText()));
                cRegardingMap.put("regardingCitizen", "true");
                cRegardingMap.put("requestingCitizen", "false");
                cRegardingMap.put("cpr", String.valueOf(fxTF_cprNoRegarding.getText()));
                String[] regfd = fxTF_floorAndFloorDirectionRegarding.getText().split(", ", 2);
                if (regfd.length != 2) {
                    cRegardingMap.put("floor", "");
                    cRegardingMap.put("floorDirection", "");
                } else {
                    String regfloor = regfd[0];
                    String regfloorDir = regfd[1];
                    cRegardingMap.put("floor", regfloor);
                    cRegardingMap.put("floorDirection", regfloorDir);
                }
                System.out.println("her er jeg");
            }
            if (!fxTF_firstnameRequesting.getText().isEmpty()) {
                cRequestingMap.put("firstName", fxTF_firstnameRegarding.getText());
                cRequestingMap.put("lastName", fxTF_lastnameRequesting.getText());
                cRequestingMap.put("streetName", fxTF_streetNameRequesting.getText());
                cRequestingMap.put("cityName", fxTF_citynameRegarding.getText());
                cRequestingMap.put("zipCode", String.valueOf(fxTF_zipcodeRequesting.getText()));
                cRequestingMap.put("houseNo", String.valueOf(fxTF_zipcodeRequesting.getText()));
                cRequestingMap.put("regardingCitizen", "false");
                cRequestingMap.put("requestingCitizen", "true");
                cRequestingMap.put("cpr", String.valueOf(fxTF_cprNoRequesting.getText()));
                String[] reqfd = fxTF_floorAndFloorDirectionRequesting.getText().split(", ", 2);
                if (reqfd.length != 2) {
                    cRegardingMap.put("floor", "");
                    cRegardingMap.put("floorDirection", "");
                } else {
                    String reqfloor = reqfd[0];
                    String reqfloorDir = reqfd[1];
                    cRequestingMap.put("floor", reqfloor);
                    cRequestingMap.put("floorDirection", reqfloorDir);
                }

            }
//            String text = "";

//          contentsMap.put("caseID", "-1");
////            contentsMap.put("casestatus", "igang");
//            contentsMap.put("regardinginquiry", fxTA_RegardingInquiry.getText());
//           //fxLB_userInfo.setTextFill(Paint.valueOf("#0076a3"));
//            contentsMap.put("rightsanddutiestext", fxTA_rightsAndDuties.getText());
//            contentsMap.put("rightsandduties", agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_agreeToElectronicRegistrationYes ? "yes"
//                    : (agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_agreeToElectronicRegistrationNo) ? "no" : "");
//            contentsMap.put("agreementswithcitizentext", !fxTA_agreementsWithCitzen.getText().isEmpty() ? fxTA_agreementsWithCitzen.getText() : "");
        nf.getContens().put("caseID", "-1");
        nf.addToAllRadioNodes(fxAP_subpane);
        nf.addContens(nf.findeNodehandler(fxAP_subpane));
        nf.addmap(cRegardingMap, "cRegarding");
        nf.addmap(cRequestingMap, "cRequesting");
           

        }
       
        

    }

    private ToggleGroup createToggleGroup(RadioButton... names) {
        ToggleGroup tg = new ToggleGroup();
        for (RadioButton name : names) {

            name.setToggleGroup(tg);

        }
        return tg;
    }
}
























































