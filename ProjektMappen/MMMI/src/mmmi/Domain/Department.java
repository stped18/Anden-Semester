package mmmi.Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Department {

    private String name;
    private int id;
    private Map<String, Case> caseMap;
    private List<Employee> employeeList;
    private static int countSearch = 0;
    private DepartmentManager departmentManager;
    private Map<Integer, List<Case>> assignedCaseMap;

    /**
     *
     * @param name
     * @param id
     */
    public Department(String name, int id) {
        this.name = name;
        this.id = id;
        this.caseMap = new HashMap<>();
        this.employeeList = new ArrayList<>();
        this.assignedCaseMap = new HashMap<>();
    }

    /**
     *
     * @param name
     * @param employeeID
     * @param title
     * @return
     */
    public boolean addEmployee(String name, int employeeID, String title) {

        Employee e = new Employee(name, employeeID, this.id, title);
        this.employeeList.add(e);

        return true;
    }

    /**
     *
     * @param searchWord
     * @return
     */
    public List<Case> search(String searchWord) {

        List<Case> listCases = new ArrayList<>();

        for (Case searchCase : caseMap.values()) {
            if (searchCase.getRegardingCitizen().getCprNumber().equalsIgnoreCase(searchWord)
                    || searchCase.getCaseNumber().equalsIgnoreCase(String.valueOf(searchWord))
                    || searchCase.getRegardingCitizen().getName().equalsIgnoreCase(searchWord)) {
                listCases.add(searchCase);
            }
        }

        return listCases;
    }

    /**
     *
     * @return
     */
    public List<Employee> getEmployee() {

        return this.employeeList;
    }

    /**
     * If it's empty it returns null.
     *
     * @param caseNumber
     * @return
     */
    public Case openCase(String caseNumber) {

        Case originalCase = null;

        for (String caseNo : caseMap.keySet()) {
            if (caseNumber.equalsIgnoreCase(caseNo)) {
                originalCase = caseMap.get(caseNo);
            }
        }
        return originalCase;

    }

    /**
     *
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean assignCase(String caseNumber, int employeeID) {
        List<Case> employeeListCase = new ArrayList<>();
        for (Employee employee : employeeList) {

            if (employee.getId() == employeeID) {
                // TODO: assign case.
                // TODO: create a map with employee(Value) and case(Key).
                // CHANGE: Instead of employee(Value) and case(Key), its going to be
                // employeeID(Key) and the following emplopyee can have one to many cases,
                // which is why we create a list and then this list can be assigned to specific employeeID

                for (Case assignCase : caseMap.values()) {
                    if (assignCase.getCaseNumber().equalsIgnoreCase(caseNumber)) {
                        employeeListCase.add(assignCase);
                        assignedCaseMap.put(employeeID, employeeListCase);
                        return true;
                    }
                }

            }
        }
        return false;
    }

    /**
     *
     * @param caseNumber
     * @param employeeID
     * @return
     */
    public boolean removeCase(String caseNumber, int employeeID) {

        for (Employee employee : employeeList) {
            if (employee.getId() == employeeID) {
                // TODO: remove case.
                // TODO: create a map with employee(Value) and case(Key).
                Set<Integer> setOfID = assignedCaseMap.keySet();
                for (Integer id : setOfID) {
                    for (Case removeCase : assignedCaseMap.get(id)) {
                        if (removeCase.getCaseNumber().equalsIgnoreCase(caseNumber)) {

                        }
                    }
                }

//                for (Map.Entry<Integer, List<Case> entry : assignedCaseMap.values()) {
//                    if (removeCase.getCaseNumber().equalsIgnoreCase(caseNumber)) {
//                        
//                    }
//                }
                return false;
            }
        }
        return false;
    }

    /**
     *
     * @param name
     * @param reason
     * @return
     */
    public boolean createCase(String name, String reason) {

        if (!name.isEmpty() && !reason.isEmpty()) {
            Case newCase = new Case(reason, this.id); // TODO: Need changes, add correct parameters. No constructor for extra parameters!
            caseMap.put(newCase.getCaseNumber(), newCase);
            return true;
        } else {
            return false;
        }

    }

    /**
     *
     * @param key
     * @param information
     * @param CaseNumber
     * @return
     */
    public boolean addInformationToCase(String key, String information, String CaseNumber) {

        for (Case c : caseMap.values()) {
            if (c.getCaseNumber().equalsIgnoreCase(CaseNumber)) {
                return c.addInformation(key, information);
            }
        }
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
                return c.closeCase(decision);
            }
        }
        return false;
    }
}
