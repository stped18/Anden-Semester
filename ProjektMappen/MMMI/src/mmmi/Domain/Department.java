package mmmi.Domain;

import MMMI.Data_layer.DataHandler;
import MMMI.Data_layer.Interfaces.IDataHandler;
import MMMI.Data_layer.SearchCase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mmmi.Domain.Interfaces.IDomain;

public class Department implements IDomain {

    private final int id;

    /**
     * @param id
     */
    public Department(int id) {
        this.id = id;
    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(String caseNumber, int employeeID) {

        throw new UnsupportedOperationException();

    }

    /**
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(String caseNumber, int employeeID) {

        throw new UnsupportedOperationException();
    }

    /**
     * @param name
     * @param reason
     * @return
     */
    public boolean createCase(String name, String reason) {

        throw new UnsupportedOperationException();

    }

    //REMEMBER: to use the correct names from the IDataHandler interface.
    //REMEMBER: check rights ask the people and dont just do some random stuff.
    @Override
    public List<Map<String, String>> Search(String key, String value) {
        //TODO: needs to be able to send all info from a searchcase to the GUI in the form of list with a map
        value += "%" + String.valueOf(id);
        IDataHandler searchHandler = new DataHandler();
        List<SearchCase> searchCases = searchHandler.search(key, value);
        int length = searchCases.size();
        String caseID, citizenName, caseStatus, caseReason, currentCaseDate, caseEmployeeName, listString;
        Map searchResultMap = new HashMap();
        List searchResultList = new ArrayList();
        for (int i = 0; i < length; i++) {
            caseID = searchCases.get(i).getCaseID();
            citizenName = searchCases.get(i).getCitizenName();
            caseStatus = searchCases.get(i).getCaseStatus();
            currentCaseDate = searchCases.get(i).getCurrentCaseDate();
            caseReason = searchCases.get(i).getCaseReason();
            caseEmployeeName = searchCases.get(i).getCaseEmployeeName();
            listString = citizenName + " " + currentCaseDate + " " + caseReason + " " + caseEmployeeName + " " + caseStatus;
            searchResultMap.put(caseID, listString);
            searchResultList.add(searchResultMap);
        }
        return searchResultList;
    }

    @Override
    public Map<String, String> openCase(String caseID) {
        //TODO: Opens a case with all the info into a map that are sendt to the GUI
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCase(Map<String, String> caseInfo) {
        //TODO: Gets a map with both case info and citizen and needs to make it into the right data
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getEmployee() {
        //TODO: Sends the data of employee with rights 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
