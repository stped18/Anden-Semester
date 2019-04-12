package mmmi.Domain;

import java.util.List;
import java.util.Map;

public class Department {

	private String name;
	private int id;
	private Map<Integer, Case> caseMap; //Integer is the case number.

	/**
	 * 
	 * @param searchWord
         * @return 
	 */
	public List<SearchCase> search(String searchWord) {
		// TODO - implement Department.search
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param caseNumber
         * @return 
	 */
	public Case openCase(int caseNumber) {
		// TODO - implement Department.openCase
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
         * @return 
	 */
	public Citizen createCitizen(String name) {
		// TODO - implement Department.createCitizen
		throw new UnsupportedOperationException();
	}

}