package mmmi.Data_layer.Interfaces;

import mmmi.Data_layer.Case;
import mmmi.Data_layer.Citizen;
import mmmi.Data_layer.Employee;
import mmmi.Data_layer.SearchCase;
import java.util.List;

public interface IDataHandler {

    /**
     * public Case readCase(int caseID);
     *
     * Reads from database based on caseID.
     *
     * Returns case object where caseContents has information from the specific
     * caseID and has regarding citizen object which refereces to case content
     * based on the regarding Citizen id. And if it has a requestingCitizen
     * bound to the specific case, then it will return it in a List of citizen
     * objects.
     *
     * @param caseID, accepts int value
     * @return returns Case object
     */
    public Case readCase(int caseID);

    /**
     *
     * @param citizenID
     * @return
     */
    public Citizen readCitizen(int citizenID);

    /**
     *
     * @param employeeID
     * @return
     */
    public Employee readEmployee(int employeeID);
    public String readAlternativeNotets(int caseID);

    /**
     * public boolean writeCase(Case theCase);
     * 
     * writeCase saves the content found in the specific Case object. 
     * 
     * @param theCase
     * @return
     */
    public boolean writeCase(Case theCase);

    /**
     * 
     * @param citizen
     * @return
     */
    public int writeCitizen(Citizen citizen);
    //public boolean writeEmployee(Employee employee);
    public boolean writeAlternativeNote(int caseID, String note);

    /**
     *
     * @param citizen
     * @return
     */
    public boolean updateCitizen(Citizen citizen);

    /**
     *
     * @return
     */
    public Case createCase();

    /**
     *
     * @return
     */
    public Citizen createCitizen(); //always called before createCase()

    /**
     *
     * @param searchKey
     * @param searchValue
     * @return
     */
    public List<SearchCase> search(String searchKey, String searchValue); // searchKey = Where to look, searchValue = What to look for.

}
