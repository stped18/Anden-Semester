package mmmi.Domain;

import java.util.ArrayList;
import java.util.List;

public class Secretary extends JobTitle {

    /**
     *
     * Rights should be read from DB and saved in the list.
     */
    public Secretary() {
        rights = new ArrayList<>();
        rights.add("create case");
    }

    /**
     *
     * @param name
     * @param reason
     */
    public boolean createCase(String name, String reason) {
        // TODO - implement Secretary.createCase
        throw new UnsupportedOperationException();
    }

}