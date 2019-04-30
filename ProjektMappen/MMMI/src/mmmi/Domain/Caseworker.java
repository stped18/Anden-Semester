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
        rights.add("close case");
        rights.add("back");
    }

    // Rapport: How we collect rights.
    /**
     *
     * @param right
     * @return
     */
    @Override
    public boolean checkRights(String right) {

        if (rights.indexOf(right) > -1) {
            return true;
        }
        return false;
    }
}
