package mmmi.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Department {

    private String name;
    private int id;
    private Map<String, Case> caseMap; //Integer is the case number.
    //private Map<Integer, Integer> employMap;
    private static int countSearch = 0;
    private Employee employee;
    private DepartmentManager departmentManager;
    private Case originalCase;

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // DER SKAL TJEKKES PÃ… I FORHOLD TIL CASENUMBER OM DET SKAL VÃ†RE STRING ELLER INT, FORDI DET KOMMER 
    // BLANDET NED AD KLASSEN.
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Department() {

    }

    public Department(String eName, int eID, int eDepartmentID, String eTitle) {
        employee = new Employee(eName, eID, eDepartmentID, eTitle);

    }

    /**
     *
     * @param searchWord
     * @return
     */
    public List<Case> search(String searchWord) {
        // TODO - implement Department.search
        // SÃ¸ge case frem baseret pÃ¥ sagsnummer, cpr nummer, navn. 

        List<Case> listCases = new ArrayList<>();

        for (Case searchCase : caseMap.values()) {

            if (searchCase.getRegardingCitizen().getCprNumber().equalsIgnoreCase(searchWord)
                    || searchCase.getCaseNumber() == String.valueOf(searchWord)
                    || searchCase.getRegardingCitizen().getName().equalsIgnoreCase(searchWord)) {
                listCases.add(searchCase);

                System.out.println(Arrays.asList(listCases));   // Test to find the stuff found in the array
            }
        }

        return listCases;
    }

    /**
     *
     * @param caseNumber
     * @return
     */
    public Case openCase(String caseNumber) {
        // TODO - implement Department.openCase

        for (String caseNo : caseMap.keySet()) {
            if (caseNumber == caseNo) {
                this.originalCase = caseMap.get(caseNo);
            }
        }
        return originalCase;

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
        // Skal ligges i caseMap nÃ¥r det er oprettet. 
        if (!(name.isEmpty() && reason.isEmpty() && departmentID == 0)) {
            Citizen citizen = createCitizen(name);
            Case newCase = new Case(citizen, reason, departmentID);

            caseMap.put(newCase.generateCaseNumber(), newCase);
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
    public boolean addInformationToCase(String name, String caseType, String CaseNumber) {
        // TilfÃ¸j oplysninger til specific sag. Dvs. kald pÃ¥ addinformation fra case
        // og brug map fra case til at opdatere oplysninger
        Boolean caseAdded = true;
        for (Case c : caseMap.values()) {
            if (c.getCaseNumber().equalsIgnoreCase(CaseNumber)) {

                c.addInformation(caseType, name);   // Either caseType or other parameter. Depends on the method under Case class.
                System.out.println("information added!");
                return true;

            }

        }
        System.out.println("Case not found!");
        return false;
    }

    /**
     *
     * @param CaseNumber
     * @param decision
     * @return
     */
    public boolean closeCase(String CaseNumber, String decision) {
        for (Case c : caseMap.values()) {
            if (CaseNumber.equals(c.getCaseNumber())) {
                c.addInformation(decision, decision);
                // c.setCaseStatus()
                caseMap.values().remove(c);
                System.out.println("Case closed");
                return true;
            }

        }
        System.out.println("Case not removed");
        return false;
    }

}
