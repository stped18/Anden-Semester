package mmmi.Domain;

import java.util.ArrayList;

public class Secretary extends JobTitle {

    /**
     *
     * Rights should be read from DB and saved in the list.
     */
    public Secretary() {
        rights = new ArrayList<>();
        rights.add("create case");
        rights.add("back");
    }

    /**
     * 
     * @param right
     * @return 
     */
    @Override
    public boolean checkRights(String right) {
        if(rights.indexOf(right) > -1) {
            return true;
        }
        return false;
    }
}