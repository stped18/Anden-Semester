package mmmi.Domain;

import java.util.List;

public abstract class JobTitle {


    protected List<String> rights;

    //public abstract List<String> getRights();
    public abstract boolean checkRights(String right);
}
