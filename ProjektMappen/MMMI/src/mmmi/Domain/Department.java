package mmmi.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Department {

    private String name;
    private int id;
    private Map<Integer, Case> caseMap; //Integer is the case number.
    private Map<Integer, Integer> employMap; 
    private static int countSearch = 0;
    
    public Department() {
        
    }
    /**
     *
     * @param searchWord
     * @return
     */
    public List<SearchCase> search(String searchWord) {
        // TODO - implement Department.search
        // Søge case frem baseret på sagsnummer, cpr nummer, navn. 
        
        List<Case> listCases = new ArrayList<>();
        Case c;
        
        for (Case searchCase : caseMap.values()) {
            
            if (searchCase.getRegardingCitizen().getCprNumber().equalsIgnoreCase(searchWord) ||
                   searchCase.getCaseNumber() == Integer.valueOf(searchWord) ||
                    searchCase.getRegardingCitizen().getName().equalsIgnoreCase(searchWord)) {
                listCases.add(searchCase);
            } else {
                System.out.println("Nothing found");
                break;
            }
        }
        
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @param caseNumber
     * @return
     */
    public Case openCase(int caseNumber) {
        // TODO - implement Department.openCase
        Case getCase = null;
        for (Integer caseNo : caseMap.keySet()) {
            if (caseNumber == caseNo) {
                getCase = caseMap.get(caseNo);
            }
        }
        return getCase;

    }

    /**
     *
     * @param name
     * @return
     */
    public Citizen createCitizen(String name) {
       
        // TODO - implement Department.createCitizen
        return new Citizen(name);
        
        
    }

    /**
     * Assign case to employee
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(int caseNumber, int employeeID) {
        
        Employee employee = null;
        
        if (employee.getId() != employeeID) {
            System.out.println("Employee not found!");
        } else {
            employee.setCase(caseNumber);
            System.out.println("Case added to employee");
        }
        
        throw new UnsupportedOperationException();
    }

    /**
     *  Remove case from employee
     * 
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(int caseNumber, int employeeID) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param name
     * @param reason
     * @return
     */
    public boolean createCase(String name, String reason) {
        // Skal kalde createCitizen og skal bruge det objekt for at oprette en ny case. 
        // Skal ligges i caseMap når det er oprettet. 
        Citizen citizen = createCitizen(name);
        
        
        
        throw new UnsupportedOperationException();
    }

    /**
     *  
     * @return
     */
    public boolean addInformationToCase(String name, int CaseNumber) {
        // Tilføj oplysninger til specific sag. Dvs. kald på addinformation fra case
        // og brug map fra case til at opdatere oplysninger
        
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param decision
     * @return
     */
    public boolean closeCase(String decision) {
        throw new UnsupportedOperationException();
    }

}
