package mmmi.Data_layer.Interfaces;

import mmmi.Data_layer.Case;
import mmmi.Data_layer.Citizen;
import mmmi.Data_layer.Employee;
import mmmi.Data_layer.SearchCase;
import java.util.List;

public interface IDataHandler {

    public Case readCase(int caseID);
    public Citizen readCitizen(int citizenID);
    public Employee readEmployee(int employeeID);

    public boolean writeCase(Case theCase);
    public int writeCitizen(Citizen citizen);
    public boolean writeEmployee(Employee employee);

    public boolean updateCitizen(Citizen citizen);

    public Case createCase();
    public Citizen createCitizen(); //always called before createCase()

    public List<SearchCase> search(String searchKey, String searchValue); // searchKey = Where to look, searchValue = What to look for.

}
