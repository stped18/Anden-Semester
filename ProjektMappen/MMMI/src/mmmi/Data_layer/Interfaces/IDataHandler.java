package mmmi.Data_layer.Interfaces;

import mmmi.Data_layer.Case;
import mmmi.Data_layer.Citizen;
import mmmi.Data_layer.Employee;
import mmmi.Data_layer.SearchCase;
import java.util.List;

public interface IDataHandler {

    /**
     *
     * Reads from database based on caseID.
     *
     * Returns case object where caseContents has information from the specific
     * caseID and has regarding citizen object which refereces to case content
     * based on the regarding Citizen id. And if it has a requestingCitizen
     * bound to the specific case, then it will return it in a List of citizen
     * objects.
     *
     * @param caseID int
     * @return Case object
     */
    public Case readCase(int caseID);

    /**
     * Creates a list of Citizen objects with all the cases for the current
     * department.
     *
     * Method looks up the data for a specific Citizen and creates an object of
     * Citizen with the data found in table citizen. Then it searches for the
     * Citizens cases and adds them in a list on the Citizen object.
     *
     * @param citizenID int
     * @return Citizen object
     */
    public Citizen readCitizen(int citizenID);

    /**
     *
     * @param employeeID int
     * @return Employee object
     */
    public Employee readEmployee(int employeeID);
	
	/**
	 * 
	 * @param caseID int
	 * @return The alternative note from the database as a String.
	 */
    public String readAlternativeNotets(int caseID);

    /**
     * 
     * Method return: Returns a boolean value based on if the write to database
     * was successful, else false if an error occured
     *
     * information from theCase
     *
     * @param theCase, Case object.
     * @return boolean, true if the write to database was successful, false if
     * error occured.
     */
    public boolean writeCase(Case theCase);

    /**
     * Adds a new citizen to database.
     *
     * This method takes a Citizen object and creates a new row in table
     * citizen.
     *
     * Method returns either the ID of the citizen created in the database or -1
     * if something happened and the citizen was not created.
     *
     * @param citizen, Citizen
     * @return int citizenID
     */
    public int writeCitizen(Citizen citizen);
	
	/**
	 * @TODO Need implenteation if this method need to be used
	 * 
	 * @param employee Employee from mmmi.Data_layer
	 * @return boolean @TODO need implement
	 */
    //public boolean writeEmployee(Employee employee);
	
	/**
	 * 
	 * @param caseID int
	 * @param note String
	 * @return boolean, True if the note has been inserted in the database
	 */
    public boolean writeAlternativeNote(int caseID, String note);

    /**
     * Updates an existing citizen in database.
     *
     * This method take a Citizen object and updates the coorsponding row in
     * table citizen.
     *
     * Method return: true if citizen was updated. false if the citizen was not
     * found.
     *
     * @param citizen, Citizen
     * @return boolean
     */
    public boolean updateCitizen(Citizen citizen);

    /**
     *
     * @return A new Case object, where everything is empty if String and
	 * -1 if int
     */
    public Case createCase();

    /**
     * This method has to be called before {@link mmmi.Data_layer.DataHandler.createCase()},
	 * to make sure there is a citizen in the database before creating a new case.
	 * 
     * @return A Citizen object
     */
    public Citizen createCitizen();

    /**
     * Searches the database for information based on searchKey and searchValue.
     *
     * searchKey is used to determine how to search the database. If the
     * searchKey is citizen, the search is based on the citizen table. If the
     * searchKey is Case, the search is based on the case table.
     *
     * searchValue is used search in the database for the required data.
     *
     * Method always returns a List of 1 or more SearchCase object(s), created
     * with the data found in the database.
     *
     * @param searchKey String
     * @param searchValue String
     * @return List<SearchCase>
     */
    public List<SearchCase> search(String searchKey, String searchValue);

}
