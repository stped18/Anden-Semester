package mmmi.Domain;

import java.util.ArrayList;

public class Caseworker extends JobTitle {
    
    /**
     *
     * Rights should be read from DB and saved in the list.
     */
    public Caseworker() {
        rights = new ArrayList<>();
        rights.add("create case");
        rights.add("add information");
        rights.add("cloase case");
    }
	/**
	 * 
	 * @param name
	 * @param reason
	 */
	public boolean createCase(String name, String reason) {
		// TODO - implement Caseworker.createCase
		throw new UnsupportedOperationException();
	}

	public boolean addInformationToCase() {
		// TODO - implement Caseworker.addInformationToCase
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param decision
	 */
	public boolean closeCase(String decision) {
		// TODO - implement Caseworker.closeCase
		throw new UnsupportedOperationException();
	}

}