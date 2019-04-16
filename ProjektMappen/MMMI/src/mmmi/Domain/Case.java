package mmmi.Domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Case {

	private int caseNumber;
	private String caseStatus;
	private Date date;
	private Citizen regardingCitizen;
	private List<Citizen> requestingCitizen;
	private Map<String, String> information;
	private int departmentID;

	/**
	 * 
	 * @param regardingCitizen
	 * @param reason
	 * @param departmentID
	 */
	public Case(Citizen regardingCitizen, String reason, int departmentID) {
		// TODO - implement Case.Case
		throw new UnsupportedOperationException();
	}

	public String getCaseStatus() {
		return this.caseStatus;
	}

	public Citizen getRegardingCitizen() {
		return this.regardingCitizen;
	}

	public List<Citizen> getRequestingCitizens() {
		// TODO - implement Case.getRequestingCitizens
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param requestingCitizen
	 */
	public boolean addRequestingCitizen(Citizen requestingCitizen) {
		// TODO - implement Case.addRequestingCitizen
		throw new UnsupportedOperationException();
	}

	public int getDepartmentID() {
		return this.departmentID;
	}

	public Map<String, String> getAllInformation() {
		// TODO - implement Case.getAllInformation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param key
	 */
	public String getSpecificInformation(String key) {
		// TODO - implement Case.getSpecificInformation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param key
	 * @param information
	 */
	public boolean addInformation(String key, String information) {
		// TODO - implement Case.addInformation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param key
	 * @param information
	 */
	public boolean updateInformation(String key, String information) {
		// TODO - implement Case.updateInformation
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param information
	 */
	public boolean closeCase(String information) {
		// TODO - implement Case.closeCase
		throw new UnsupportedOperationException();
	}

    Integer getCaseNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}