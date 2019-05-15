
package LoginSystem.Domain;

import MMMI.Data_layer.Employee;

/**
 *
 * @author steff
 */
public interface IEmployee {
    
    /**
     *sends an object to MMMI 
     * @return Employee - int employeeID, String firstName, String lastName, int roleID, int departmentID 
     * 
     */
    Employee sendEmployee();
    
    
}




