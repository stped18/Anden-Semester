/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.Data_layer;

import java.util.Map;

/**
 *
 * @author PCATG
 */
public class Case_contents {

    private Map<String, String> caseContents;
    private String carriageInfo, treamentcarriageInfo, treamentInfo, cashbenefitInfo, controlInfo, stayInfo, practicalhelpInfo, personalhelpInfo,
            protectedemploymentbenefitInfo,
            dayreliefInfo, socialpedogogicalhelpInfo, personalhelpschemeInfo, ambulanttreatmentInfo, outpatientoffersInfo, housingofferforadultsInfo,
            extendedhousingofferforadultsInfo, inquiryfromInfo, inquiryfromtextInfo, guardianshipInfo, guardianshiptextInfo, representationInfo,
            representationtextInfo, rightsanddutiesInfo, rightsanddutiestextInfo, agreementswithcitizentextInfo, consentInfo, getinfoInfo, getinfotextInfo,
            citizenspecialcircumstancestextInfo, otheractingcommuneInfo, otheractingcommunetextInfo;

    public Case_contents(Map<String, String> caseContents) {
        this.caseContents = caseContents;
    }

}
