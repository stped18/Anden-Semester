package mmmi.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Department {

    private String name;
    private int id;
    private Map<Integer, Case> caseMap; //Integer is the case number.
    private Map<Integer, Integer> employMap;
    private static int countSearch = 0;
    private Employee employee;
    private DepartmentManager departmentManager;

    public Department() {
        employee = new Employee(name);
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

            if (searchCase.getRegardingCitizen().getCprNumber().equalsIgnoreCase(searchWord)
                    || searchCase.getCaseNumber() == Integer.valueOf(searchWord)
                    || searchCase.getRegardingCitizen().getName().equalsIgnoreCase(searchWord)) {
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
     *
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(int caseNumber, int employeeID) {

        if (employee.getId() != employeeID) {
            System.out.println("Employee not found!");
            return false;
        } else {
            departmentManager.assignCase(caseNumber, employeeID);
            System.out.println("Case added to employee");
            return true;
        }

        //throw new UnsupportedOperationException();
    }

    /**
     * Remove case from employee
     *
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(int caseNumber, int employeeID) {
        if (employee.getId() != employeeID) {
            System.out.println("Employee not found");
            return false;
        } else {
            departmentManager.removecase(caseNumber, employeeID);
            System.out.println("Case removed!");
            return true;
        }
        //throw new UnsupportedOperationException();
    }

    /**
     *
     * @param name
     * @param reason
     * @param departmentID
     * @return
     */
    public boolean createCase(String name, String reason, int departmentID) {
        // Skal kalde createCitizen og skal bruge det objekt for at oprette en ny case. 
        // Skal ligges i caseMap når det er oprettet. 
        if (!(name.isEmpty() && reason.isEmpty() && departmentID == 0)) {
            Citizen citizen = createCitizen(name);
            Case newCase = new Case(citizen, reason, departmentID);

            Integer rdmCaseNumber = 0;
            Random rdm = new Random();
            rdmCaseNumber = rdm.nextInt(500);
            caseMap.put(rdmCaseNumber, newCase);
            System.out.println("Case created!");
            return true;
        } else {
            System.out.println("Missing information");
            return false;
        }

    }

    /**
     *
     * @param name
     * @param CaseNumber
     * @return
     */
    public boolean addInformationToCase(String name, int CaseNumber) {
        // Tilføj oplysninger til specific sag. Dvs. kald på addinformation fra case
        // og brug map fra case til at opdatere oplysninger
        Boolean caseAdded = true;
        for (Case c : caseMap.values()) {
            if (c.getCaseNumber() != CaseNumber) {
                c.addInformation(name, name);
                System.out.println("information added!");
                return true;

            }
            System.out.println("Case not found!");
            return false;

        }
        System.out.println("Nothing added");
        return false;
    }

    /**
     *
     * @param CaseNumber
     * @param decision
     * @return
     */
    public boolean closeCase(int CaseNumber, String decision) {
        for (Case c : caseMap.values()) {
            if (CaseNumber == c.getCaseNumber()) {
                c.addInformation(decision, decision);
                // c.setCaseStatus()
                caseMap.values().remove(c);
                System.out.println("Case closed");
                return true;
            }
            System.out.println("Case not removed");
            return false;
        }
        System.out.println("Nothing happened");
        return false;
    }

}
