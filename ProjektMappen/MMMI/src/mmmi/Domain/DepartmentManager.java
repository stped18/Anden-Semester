package mmmi.Domain;

import java.util.ArrayList;

public class DepartmentManager extends JobTitle {

    /**
     * Rights should be read from DB and saved in the list.
     */
    public DepartmentManager() {
        rights = new ArrayList<>();
        rights.add("create case");
        rights.add("add information");
        rights.add("close case");
        rights.add("assign case");
        rights.add("reassign case");
        rights.add("back");
    }

    /**
     * @param right
     * @return
     */
    @Override
    public boolean checkRights(String right) {
        return rights.indexOf(right) > -1;
    }
}
