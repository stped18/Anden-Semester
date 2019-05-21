package mmmi.Domain.Interfaces;

import LoginSystem.Domain.IEmployee;
import java.util.Map;
import mmmi.Domain.Employee;


public interface IDomain {
    
    //Case
    public Map<String, Map<String, String>> search (String key, String value); // list
    public Map<String, Map<String, String>> openCase (int caseID); // open a single case 
    public boolean saveCase (Map<String, Map<String, String>> caseInfo);
    
    public Employee getEmployee();
    
    public void setDepartmentID(int departmentID);
    public void setLoginEmployee(IEmployee employee);
    
    public String getnote(int caseID);
    public boolean writenote(int caseID, String note);
    
    
    
    
}
