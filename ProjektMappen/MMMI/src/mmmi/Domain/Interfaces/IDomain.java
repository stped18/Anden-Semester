package mmmi.Domain.Interfaces;

import java.util.List;
import java.util.Map;
import mmmi.Domain.Employee;


public interface IDomain {
    
    //Case
    public Map<String, Map<String, String>> search (String key, String value); // list
    public Map<String, String> openCase (String caseID); // open a single case 
    public boolean saveCase (List< Map<String, String>> caseInfo);
    
    public Employee getEmployee();
    
    
    
    
}
