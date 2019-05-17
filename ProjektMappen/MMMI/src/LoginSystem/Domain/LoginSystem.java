package LoginSystem.Domain;

import LoginSystem.DataLayer.DatabaseHandler;
import LoginSystem.DataLayer.Employee;

public class LoginSystem implements IEmployee, ILogind {

    private String username;
    private String password;
    DatabaseHandler databaseHandler = new DatabaseHandler();

    public LoginSystem() {
    }

    public LoginSystem(String username, String password) {
        databaseHandler.getEmployee(username, password);
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
        System.out.println("im set");
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
        System.out.println("im set2");
    }

    @Override
    public Employee sendEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
