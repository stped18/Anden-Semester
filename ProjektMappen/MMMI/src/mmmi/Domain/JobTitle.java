package mmmi.Domain;

import java.util.List;

public abstract class JobTitle {
    private static final String CREATECASE = "create case";
    private static final String ADDINFORMATION = "add information";
    private static final String CLOSECASE = "close case";

    protected List<String> rights;

    //public abstract List<String> getRights();
    public abstract boolean checkRights(String right);
}
