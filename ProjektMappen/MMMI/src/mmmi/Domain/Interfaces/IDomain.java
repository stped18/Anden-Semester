package mmmi.Domain.Interfaces;

import LoginSystem.Domain.IEmployee;
import java.util.Map;
import mmmi.Domain.Employee;

public interface IDomain {

	/**
	 * Forwards input to data layer and creates map for the UI.
	 *
	 * This method forwards the @params to the method
	 * {@link mmmi.Data_layer.DataHandler#search(java.lang.String, java.lang.String)}.
	 * The resulting List of {@link mmmi.Data_layer.SearchCase} objects is then
	 * looped through to create a Map to send back to the presentation layer.
	 *
	 * @param key, String
	 * @param value, String
	 * @return Map<String, <Map<String, String>>
	 */
	public Map<String, Map<String, String>> search(String key, String value); // list

	/**
	 *
	 * This method forwards the @params to the method
	 * {@link mmmi.Data_layer.DataHandler#readCase(java.lang.Integer)}. The
	 * result of #readCase sends a {@link mmmi.Data_layer.Case} object back
	 * found with specific caseID and its contents.
	 *
	 * @param caseID, int
	 * @return Map<String, Map<String, String>> with the case contents found in
	 * the returned Case object.
	 */
	public Map<String, Map<String, String>> openCase(int caseID); // open a single case 

	/**
	 *
	 * This method forwards the @params to the method
	 * {@link mmmi.Data_layer.DataHandler#search(java.util.Map<String, java.util.Map<String, String>>)}
	 *
	 * if (contentsMap.get("caseID").equalsIgnoreCase("-1")), then the method
	 * creates a new {@link mmmi.Data_layer.Case} object and sets the variable
	 * to the result, and fills the empty object with Case specific informtaion
	 * and case contents and afterwards {@link mmmi.Data_layer.DataHandler#writeCase(theCase)), where theCase
	 * is the Case sent from saveCase()
	 *
	 * @param caseInfo, java.util.Map<String, Map<String, String>> ret urn
	 * boolean, if the case got saved successfully, or false if error occured.
	 */
	public boolean saveCase(Map<String, Map<String, String>> caseInfo);

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
