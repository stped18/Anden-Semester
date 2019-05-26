package mmmi.Domain.Interfaces;

import LoginSystem.Domain.IEmployee;
import java.util.Map;
import mmmi.Domain.Employee;


public interface IDomain {
    
	/**
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public Map<String, Map<String, String>> search (String key, String value); // list
	
	/**
	 *
	 * @param caseID
	 * @return
	 */
	public Map<String, Map<String, String>> openCase (int caseID); // open a single case 
	
	/**
	 *
	 * @param caseInfo
	 * @return
	 */
	public boolean saveCase (Map<String, Map<String, String>> caseInfo);
    
	/**
	 *
	 * @return
	 */
	public Employee getEmployee();
    
	/**
	 *
	 * @param departmentID
	 */
	public void setDepartmentID(int departmentID);
	
	/**
	 *
	 * @param employee
	 */
	public void setLoginEmployee(IEmployee employee);
    
	/**
	 *
	 * @param caseID
	 * @return
	 */
	public String getnote(int caseID);

	/**
	 *
	 * @param caseID
	 * @param note
	 * @return
	 */
	public boolean writenote(int caseID, String note);
}
