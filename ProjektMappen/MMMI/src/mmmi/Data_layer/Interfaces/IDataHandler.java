package mmmi.Data_layer.Interfaces;

import MMMI.Data_layer.Case;
import MMMI.Data_layer.Citizen;
import MMMI.Data_layer.Employee;
import MMMI.Data_layer.SearchCase;
import java.util.List;
import java.util.Map;

public interface IDataHandler {

    public Case readCase(String caseID);
    public Citizen readCitizen(int citizenID);
    public Employee readEmployee(int employeeID);
    public String readAlternativeNotets(String caseID);

    public boolean writeCase(Case theCase);
    public int writeCitizen(Citizen citizen);
    public boolean writeEmployee(Employee employee);
    public boolean writeAlternativeNote(String caseID, String note);

    public boolean updateCitizen(Citizen citizen);

    public Case createCase();
    public Citizen createCitizen(); //always called before createCase()

    public List<SearchCase> search(String searchKey, String searchValue); // searchKey = Where to look, searchValue = What to look for.

}
