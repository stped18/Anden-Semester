package MMMI.Data_layer;

import java.util.List;
import java.util.Map;

public class Case {
    
    private final String caseID;
    private final int reguardingCitizenID;
    private List<Integer> requestingCitizen;
    private final Map<String, String> caseContent;

    public Case(String caseID, int reguardingCitizenID, List<Integer> requestingCitizen, Map<String, String> caseContent) {
        this.caseID = caseID;
        this.reguardingCitizenID = reguardingCitizenID;
        this.requestingCitizen = requestingCitizen;
        this.caseContent = caseContent;
    }

    public String getCaseID() {
        return caseID;
    }

    public int getReguardingCitizenID() {
        return reguardingCitizenID;
    }

    public List<Integer> getRequestingCitizen() {
        return requestingCitizen;
    }

    public void addRequestingCitizen(Integer requestingCitizenID) {
        
        // TODO: Add a new requesting citizen to the list. Insteed of overridding.
        this.requestingCitizen = requestingCitizen;
    }
    
    public Map<String, String> getCaseContent() {
        return caseContent;
    }

}
