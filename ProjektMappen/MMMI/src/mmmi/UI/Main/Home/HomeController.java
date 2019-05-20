package mmmi.UI.Main.home;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.Home.UIEmployee;

public class HomeController implements Initializable {

    @FXML
    private TableView<UIEmployee> caseTable;
    TableColumn<UIEmployee, String> number;
    TableColumn<UIEmployee, String> name;
    @FXML
    private Label employeeName;
    @FXML
    private Label numberOfCases;
    @FXML
    private TextArea alterentativeNotets;
    
    private ObservableList<UIEmployee> casesNo;

    private IDomain department = Department.getInstance();
    @FXML
    private Button Savebtn;
    
    String caseid = "";
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        casesNo = FXCollections.observableArrayList();
        
        number = new TableColumn("sags nummer");
        name = new TableColumn("borger navn");
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        caseTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        caseTable.getColumns().addAll(number, name);

        String fullName = department.getEmployee().getName();
        employeeName.setText(fullName);

        Map<String, String> caseMap = department.getEmployee().getEmployeeCases();
        numberOfCases.setText(caseMap.size() + "");

        for (Map.Entry<String, String> entry : caseMap.entrySet()) {
            String key = entry.getKey();
            String valuve = entry.getValue();

            casesNo.add(new UIEmployee(key, valuve));
        }
        caseTable.setItems(casesNo);

    }

    @FXML
    private void eventnote(MouseEvent event) {

        if (event.getSource() == caseTable) {
            if (event.getClickCount() >= 2) {
                System.out.println("2 click");
            } else {
                caseid = caseTable.getSelectionModel().getSelectedItem().getNumber();

            }
        }
    }

    @FXML
    private void eventnotes(ActionEvent event) {
        System.out.println("Gemmer!!!");
        department.writenote(caseid, alterentativeNotets.getText());
    }
}
