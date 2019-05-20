
package LoginSystem.Domain;

import LoginSystem.DataLayer.DbEmployee;
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
    DbEmployee sendEmployee();
    
    
}





