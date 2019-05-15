package mmmi.Domain.Interfaces;

import MMMI.Data_layer.Case;
import MMMI.Data_layer.Citizen;
import java.util.List;
import java.util.Map;
import mmmi.Domain.Employee;


public interface IDomain {
    
    //Case
    public List<Map<String, String>> Search (String key, String value); // list
    public Map<String, String> openCase (String caseID); // open a single case 
    public boolean saveCase (Map<String, String> caseInfo);
    
    public Employee getEmployee();
    
    
    
    
}
