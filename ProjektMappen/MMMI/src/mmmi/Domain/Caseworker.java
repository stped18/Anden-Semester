package mmmi.Domain;

import java.util.ArrayList;
import java.util.List;

public class Caseworker extends JobTitle {

    /**
     *
     * Rights should be read from DB and saved in the list.
     */
    public Caseworker() {
        rights = new ArrayList<>();
        rights.add("create case");
        rights.add("add information");
        rights.add("close case");
        rights.add("back");
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

    @Override
    public boolean checkRights(String right) {
        if(rights.indexOf(right) > -1) {
            return true;
        }
        return false;
    }
}
