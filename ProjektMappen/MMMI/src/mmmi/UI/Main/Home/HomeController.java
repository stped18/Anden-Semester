package mmmi.UI.Main.home;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

public class HomeController implements Initializable {

    @FXML
    private ListView<?> employeeCases;
    @FXML
    private ListView<?> alternativeNotes;
    @FXML
    private TextField employeeName;
    @FXML
    private TextField numberOfCases;
    @FXML
    private ObservableList<String> cases = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> notes = FXCollections.observableArrayList();
    
    
    IDomain department = new Department(); // TODO: need a constructor with out any parameters.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String fullName = department.getEmployee().getName();
        employeeName.setText(fullName);
        
        
        Map<String, String> caseMap = department.getEmployee().getEmployeeCases();
        numberOfCases.setText(caseMap.size() + "");
        
        for (Map.Entry<String, String> entry : caseMap.entrySet()) {
            String key = entry.getKey();
            String valuve = entry.getValue();
            cases.add(key + "\t" + valuve);
        }
        
    }

}
