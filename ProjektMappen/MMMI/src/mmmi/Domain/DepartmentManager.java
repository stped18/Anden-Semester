package mmmi.Domain;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManager extends JobTitle {


    /**
     *
     * Rights should be read from DB and saved in the list.
     */
    public DepartmentManager() {
        rights = new ArrayList<>();
        rights.add("create case");
        rights.add("add information");
        rights.add("close case");
        rights.add("assign case");
        rights.add("reassign case");
    }

    @Override
    public boolean checkRights(String right) {
        if(rights.indexOf(right) > -1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param caseNumber
     * @param employeeID
     */
    public boolean assignCase(int caseNumber, int employeeID) {
        // TODO - implement DepartmentManager.assignCase
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param caseNumber
     * @param employeeID
     */
    public boolean removecase(int caseNumber, int employeeID) {
        // TODO - implement DepartmentManager.removecase
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param name
     * @param reason
     */
    public boolean createCase(String name, String reason) {
        // TODO - implement DepartmentManager.createCase
        throw new UnsupportedOperationException();
    }

    public boolean addInformationToCase() {
        // TODO - implement DepartmentManager.addInformationToCase
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param decision
     */
    public boolean closeCase(String decision) {
        // TODO - implement DepartmentManager.closeCase
        throw new UnsupportedOperationException();
    }

}
