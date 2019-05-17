package LoginSystem.Domain;

import LoginSystem.DataLayer.Employee;

public interface IEmployee {
    
    /**
     *sends an object to MMMI 
     * @return Employee - int employeeID, String firstName, String lastName, int roleID, int departmentID 
     * 
     */
    Employee sendEmployee();
    
    
}




