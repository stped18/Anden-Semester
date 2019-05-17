/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.home;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class HomeController implements Initializable {

    @FXML
    private ListView<?> employeeCases;
    @FXML
    private ListView<?> alternativeNotes;
    @FXML
    private TextField employeeName;
    @FXML
    private TextField numberOfCases;

    IDomain department = new Department(0); // TODO: need a constructor with out any parameters.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String fullName = department.getEmployee().getFirstName() + " " + department.getEmployee().getLastname();
        employeeName.setText(fullName);

        // Snak med Aslak og Mathias om hvordan Search er håndteret.
        List<Map<String, String>> somemap = department.Search("caseid", String.valueOf(department.getEmployee().getId()));

        numberOfCases.setText(somemap.size() + "");
    }

}
