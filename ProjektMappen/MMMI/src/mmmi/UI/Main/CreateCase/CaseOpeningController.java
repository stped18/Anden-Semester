package mmmi.UI.Main.CreateCase;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.createCase.NodeFinder;

public class CaseOpeningController implements Initializable {

    @FXML
    private TextArea fxTA_RegardingInquiry;
    @FXML
    private TextField fxTF_firstnameRegarding, fxTF_lastnameRegarding, fxTF_cprNoRegarding, fxTF_zipcodeRegarding, fxTF_citynameRegarding,
            fxTF_streetNameRegarding, fxTF_houseNoRegarding, fxTF_floorAndFloorDirectionRegarding,
            fxTF_firstnameRequesting, fxTF_lastnameRequesting, fxTF_zipcodeRequesting, fxTF_citynameRequesting, fxTF_streetNameRequesting,
            fxTF_houseNoRequesting, fxTF_floorAndFloorDirectionRequesting, fxTF_cprNoRequesting;
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
    private RadioButton fxRB_protectedEmploymentOffer, fxRB_dayCareOffer, fxRB_educationOffer, fxRB_rightsAndDuties, fxRB_agreeToElectronicRegistrationYes1,
            fxRB_agreeToElectronicRegistrationNo1;
    @FXML
    private RadioButton fxRP_guardianship, fxRP_guardianshipWithRenounced, fxRP_socialGoal, fxRB_guardianCheckbox,
            fxRP_assessor, fxRP_partyRepresentative, fxRP_consentIfYesGiveInfo,
            fxRB_consentYes, fxRB_consentNo, fxRB_consentOral, fxRB_consentWritten;
    @FXML
    private TitledPane fxTP_consent;
    @FXML
    private TextArea fxTA_guadianshipText, fxTA_representationText;
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
            fxTP_stay, fxTP_carriage, fxTP_requestingInfo, fxTP_regardingInfo, fxTP_representationAndGuardian;
    @FXML
    private Button fxBT_save;
    @FXML
    private CheckBox fxCB_getInfoDoctor, fxCB_getInfoSpecialDoctor, fxCB_getInfoHospital, fxCB_getInfoAKasse, fxCB_getInfoOffer, fxCB_getInfoPreviousCommune,
            fxCB_getInfoOtherAdministrations, fxCB_getInfoEmployer;
    // other attributes
    private ToggleGroup sureLookingForTG, yesNoInquiryTG1, yesNoInquiryTG2, sectionOneVisibilityTG, carriageTG, treatmentTG,
            otherOffersAndParagraphsTG, controlTG, stayTG, socialPedagogicalHelpTG, housingOfferTG, extendedhousingofferTG,
            personalHelpSchemeTG, requestingList, regardingTG, communePayingOrActingTG, representationTG, guardianTG, consentOptTG, whichConsentTG,
            rightsAndDutiesTG, agreeToElectronicRegistrationTG, outpatientOffersTG;
    private String carriageText, socialPedagogicalHelpText, treatmentText, stayText, controlText, personalhelpschemeText, outputText,
            otheroffersandparagrafsText, outpatientoffersText, housingofferforadultsText, extendedhousingofferforadultsText, communeTextFromRB;
    private Map<String, String> contentsMap, cRegardingMap, cRequestingMap;

    private IDomain department;
    private NodeFinder nf;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nf = NodeFinder.getInstance();

        department = Department.getInstance();
        department.setDepartmentID(1);
        contentsMap = new HashMap<>();
        cRegardingMap = new HashMap<>();
        cRequestingMap = new HashMap<>();

        // inquiry section
        yesNoInquiryTG1 = createToggleGroup(fxRB_agreeToInquiryYesRegarding, fxRB_agreeToInquiryNo1Regarding);

        yesNoInquiryTG2 = createToggleGroup(fxRB_agreeToInquiryYesRequesting, fxRB_agreeToInquiryNoRequesting);
        sureLookingForTG = createToggleGroup(fxRB_clearLookingForYes, fxRB_clearLookingForNo);

        regardingTG = createToggleGroup(fxRB_regardingCitizen, fxRB_regardingRelatives, fxRB_regardingDoctor, fxRB_regardingHospital,
                fxRB_regardingOtherAdministration, fxRB_regardingInProgressEffort, fxRB_regardingOtherCommune,
                fxRB_regardingOthers);
        fxTP_benefitsParagraphs.setVisible(false);

        // Representation and guadian
        guardianTG = createToggleGroup(fxRP_guardianship, fxRP_guardianshipWithRenounced, fxRP_socialGoal, fxRB_guardianCheckbox);
        representationTG = createToggleGroup(fxRP_assessor, fxRP_partyRepresentative, fxRP_consentIfYesGiveInfo);
        fxTA_guadianshipText.setEditable(false);
        fxTA_representationText.setEditable(false);

        // consent section
        consentOptTG = createToggleGroup(fxRB_consentYes, fxRB_consentNo);
        whichConsentTG = createToggleGroup(fxRB_consentOral, fxRB_consentWritten);
        fxRB_consentOral.setVisible(false);
        fxRB_consentWritten.setVisible(false);

        // ToggleGroups for, Rights and duties
        fxTA_rightsAndDuties.setEditable(false);
        rightsAndDutiesTG = createToggleGroup(fxRB_rightsAndDuties);
        agreeToElectronicRegistrationTG = createToggleGroup(fxRB_agreeToElectronicRegistrationYes1, fxRB_agreeToElectronicRegistrationNo1);

        // obtain Of Information section
        // commune Paying Or Acting section
        communePayingOrActingTG = createToggleGroup(fxRB_OtherActingCommune, fxRB_otherPayingCommune);

        // paragrafs and offers section
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
        housingOfferTG = createToggleGroup(fxRB_housingGeneralCareHome, fxRB_housingElderlyOrHandicapFriendly, fxRB_housingShared,
                fxRB_housingDayTreatmentOffer, fxRB_housingCareHome, fxRB_housingCrisisCenter, fxRB_housingTemporary, fxRB_housingNursingHome,
                fxRB_housingRehabilitation);
        extendedhousingofferTG = createToggleGroup(fxRB_securedHousing, fxRB_otherLengthyHousing, fxRB_outgoingOffer, fxRB_offerWithAuthority);
        otherOffersAndParagraphsTG = createToggleGroup(fxRB_practicalHelp83, fxRB_praticalHelp95, fxRB_dayRelief, fxRB_personalHelp83, fxRB_personalHelp95,
                fxRB_protectedEmploymentBenefit);
        outpatientOffersTG = createToggleGroup(fxRB_activityAndSocialInteractionOffer, fxRB_protectedEmploymentOffer, fxRB_dayCareOffer, fxRB_educationOffer);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void inquiryRBonAction(ActionEvent event) {
        if (event.getSource() == sureLookingForTG.getSelectedToggle()) {
            if (fxRB_clearLookingForYes.isSelected()) {
                fxTP_benefitsParagraphs.setVisible(true);

            } else if (fxRB_clearLookingForNo.isSelected()) {
                fxTP_benefitsParagraphs.setVisible(false);
            }
        } else if (event.getSource() == yesNoInquiryTG1.getSelectedToggle()) {
            if (fxRB_agreeToInquiryYesRegarding.isSelected()) {
                fxTP_regardingInfo.setExpanded(true);

            } else if (fxRB_agreeToInquiryNo1Regarding.isSelected()) {
                // fxTP_regardingInfo.setVisible(false);
                fxTP_regardingInfo.setExpanded(false);
            }
        } else if (event.getSource() == yesNoInquiryTG2.getSelectedToggle()) {
            if (fxRB_agreeToInquiryYesRequesting.isSelected()) {
                // fxTP_requestingInfo.setVisible(true);
                fxTP_requestingInfo.setExpanded(true);

            } else if (fxRB_agreeToInquiryNoRequesting.isSelected()) {
                fxTP_requestingInfo.setExpanded(false);

            }
        }

    }// fxRB_agreeToInquiryNoRequesting

    /**
     *
     * @param event
     */
    @FXML
    private void rightsAndDutiesRBOnAction(ActionEvent event) {
        if (rightsAndDutiesTG.getSelectedToggle() == fxRB_rightsAndDuties) {
            fxTA_rightsAndDuties.setEditable(true);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void communePayingOrActingRBonAction(ActionEvent event) {
        if (event.getSource() == communePayingOrActingTG.getSelectedToggle()) {
            communeTextFromRB = "";
            if (fxRB_OtherActingCommune.isSelected()) {
                communeTextFromRB = fxRB_OtherActingCommune.getText();
            } else if (fxRB_otherPayingCommune.isSelected()) {
                communeTextFromRB = fxRB_otherPayingCommune.getText();
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void benefitsParagraphs(ActionEvent event) {

        carriageTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                carriageText = rb.getText();

            }
        });
        treatmentTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                treatmentText = rb.getText();

            }
        });
        controlTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                controlText = rb.getText();

            }
        });
        stayTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                stayText = rb.getText();

            }
        });
        socialPedagogicalHelpTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                socialPedagogicalHelpText = rb.getText();

            }
        });
        outpatientOffersTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                outpatientoffersText = rb.getText();

            }
        });
        personalHelpSchemeTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                personalhelpschemeText = rb.getText();

            }
        });
        housingOfferTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                housingofferforadultsText = rb.getText();

            }
        });
        extendedhousingofferTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                extendedhousingofferforadultsText = rb.getText();

            }
        });
        otherOffersAndParagraphsTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                otheroffersandparagrafsText = rb.getText();

            }
        });

    }
    private String guadianText, representationText;

    @FXML
    private void representationAndGuardianActionHandler(ActionEvent event) {
        guadianText = "";
        guardianTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                guadianText = rb.getText();
                if (guardianTG.getSelectedToggle() == fxRB_guardianCheckbox) {
                    fxTA_guadianshipText.setEditable(true);

                }

            }
        });
        representationText = "";
        representationTG.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
                representationText = rb.getText();
                if (representationTG.getSelectedToggle() == fxRP_consentIfYesGiveInfo) {
                    fxTA_representationText.setEditable(true);

                }
            }
        });

    }

    @FXML
    private void consentActionHandler(ActionEvent event) {
        if (event.getSource() == consentOptTG.getSelectedToggle()) {
            if (fxRB_consentYes.isSelected()) {
                fxRB_consentOral.setVisible(true);
                fxRB_consentWritten.setVisible(true);
            } else if (fxRB_consentNo.isSelected()) {
                fxRB_consentOral.setVisible(false);
                fxRB_consentWritten.setVisible(false);
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        if (event.getSource() == fxBT_save) {
            System.out.println(socialPedagogicalHelpText + carriageText + carriageText);

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

            String text = "";
            contentsMap.put("caseID", "-1");
            contentsMap.put("regardinginquiry", fxTA_RegardingInquiry.getText());
            contentsMap.put("rightsanddutiestext", !fxTA_rightsAndDuties.getText().isEmpty() ? fxTA_rightsAndDuties.getText() : "");
            contentsMap.put("rightsandduties", agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_agreeToElectronicRegistrationYes1
                    ? "yes"
                    : (agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_agreeToElectronicRegistrationNo1)
                    ? "no" : "");
            contentsMap.put("agreementswithcitizentext", !fxTA_agreementsWithCitzen.getText().isEmpty()
                    ? fxTA_agreementsWithCitzen.getText() : "");

            String getTextCB = "";
            getTextCB = fxCB_getInfoAKasse.isSelected() ? fxCB_getInfoAKasse.getText() : "";
            getTextCB += fxCB_getInfoDoctor.isSelected() ? fxCB_getInfoDoctor.getText() : "";
            getTextCB += fxCB_getInfoHospital.isSelected() ? fxCB_getInfoHospital.getText() : "";
            getTextCB += fxCB_getInfoEmployer.isSelected() ? fxCB_getInfoEmployer.getText() : "";
            getTextCB += fxCB_getInfoOffer.isSelected() ? fxCB_getInfoOffer.getText() : "";
            getTextCB += fxCB_getInfoOtherAdministrations.isSelected() ? fxCB_getInfoOtherAdministrations.getText() : "";
            getTextCB += fxCB_getInfoPreviousCommune.isSelected() ? fxCB_getInfoPreviousCommune.getText() : "";
            getTextCB += fxCB_getInfoSpecialDoctor.isSelected() ? fxCB_getInfoSpecialDoctor.getText() : "";

            contentsMap.put("getinfo", getTextCB);
            contentsMap.put("getinfotext", !fxTA_obtainOfInformation.getText().isEmpty() ? fxTA_obtainOfInformation.getText() : "");
            contentsMap.put("citizenspecialcircumstancestext", !fxTA_citizenSpecialCircumstances.getText().isEmpty() ? fxTA_citizenSpecialCircumstances.getText() : "");

            contentsMap.put("guardianship", guadianText != null ? guadianText : "");
            contentsMap.put("guardianshiptext", !fxTA_guadianshipText.getText().isEmpty() ? fxTA_guadianshipText.getText() : "");
            contentsMap.put("representation", representationText != null ? representationText : "");
            contentsMap.put("representationtext", !fxTA_representationText.getText().isEmpty() ? fxTA_representationText.getText() : "");

            contentsMap.put("consent", whichConsentTG.getSelectedToggle() == fxRB_consentOral
                    ? fxRB_consentOral.getText()
                    : (agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_consentWritten)
                    ? fxRB_consentWritten.getText() : "");

            contentsMap.put("agreementswithcitizentext", !fxTA_agreementsWithCitzen.getText().isEmpty()
                    ? fxTA_agreementsWithCitzen.getText() : "");
            contentsMap.put("otheractingcommune", communePayingOrActingTG.getSelectedToggle() == fxRB_OtherActingCommune
                    ? fxRB_OtherActingCommune.getText()
                    : (agreeToElectronicRegistrationTG.getSelectedToggle() == fxRB_otherPayingCommune)
                    ? fxRB_otherPayingCommune.getText() : "");
            contentsMap.put("otheractingcommunetext", fxTA_CommunePayingOrActing.getText().isEmpty() ? fxTA_CommunePayingOrActing.getText() : "");

            contentsMap.put("socialpedogogicalhelp", socialPedagogicalHelpText != null ? socialPedagogicalHelpText : "");
            contentsMap.put("carriage", carriageText != null ? carriageText : "");
            contentsMap.put("personalhelpscheme", personalhelpschemeText != null ? personalhelpschemeText : "");
            contentsMap.put("otheroffersandparagrafs", otheroffersandparagrafsText != null ? otheroffersandparagrafsText : "");
            contentsMap.put("stay", stayText != null ? stayText : "");
            contentsMap.put("treatment", treatmentText != null ? treatmentText : "");
            contentsMap.put("control", controlText != null ? controlText : "");

            contentsMap.put("ambulanttreatment", fxRB_ambulantTreatment.isSelected() ? fxRB_ambulantTreatment.getText() : "");
            contentsMap.put("outpatientoffers", outpatientoffersText != null ? outpatientoffersText : "");
            contentsMap.put("housingofferforadults", housingofferforadultsText != null ? housingofferforadultsText : "");
            contentsMap.put("extendedhousingofferforadults", extendedhousingofferforadultsText != null ? extendedhousingofferforadultsText : "");

            System.out.println("Social: " + contentsMap.get("socialpedogogicalhelp"));
            System.out.println("Carriage: " + contentsMap.get("carriage"));
            System.out.println(contentsMap);
            nf.addContents(contentsMap);
            nf.addmap(cRegardingMap, "cRegarding");
            nf.addmap(cRequestingMap, "cRequesting");

        }
    }

    /**
     * Method to create new toggleGroups.
     *
     * @param names
     * @return
     */
    private ToggleGroup createToggleGroup(RadioButton... names) {
        ToggleGroup tg = new ToggleGroup();
        for (RadioButton name : names) {
            name.setToggleGroup(tg);
        }
        return tg;
    }

    private String radionButtonChangeListener(ToggleGroup tg) {
        //outputText = "";
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {

                RadioButton rb = (RadioButton) newValue.getToggleGroup().getSelectedToggle(); // Cast object to radio button
                outputText = rb.getText();

            }
        });

        return outputText;
    }

}
