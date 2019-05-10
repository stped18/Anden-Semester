package mmmi.Domain;

import java.util.List;

public abstract class JobTitle {

    protected List<String> rights;

    /**
     * @param right
     * @return
     */
    public abstract boolean checkRights(String right);
}
