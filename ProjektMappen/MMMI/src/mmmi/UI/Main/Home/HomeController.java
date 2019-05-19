package mmmi.UI.Main.home;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.Home.Table;

public class HomeController implements Initializable {

    @FXML
    private TableView<Table> caseTable;
    @FXML
    TableColumn<Table, String> number;
    @FXML
    TableColumn<Table, String> name;
    @FXML
    private TextField employeeName;
    @FXML
    private TextField numberOfCases;
    @FXML
    private TextArea alterentativeNotets;
    @FXML
    private Button savebtn;

    private final ObservableList<Table> casesNo = FXCollections.observableArrayList();

    IDomain department = new Department();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

            casesNo.add(new Table(key, valuve));
        }
        caseTable.setItems(casesNo);

    }

    @FXML
    private void eventnote(MouseEvent event) {
        
        String caseid = "";
        
        if (event.getSource() == savebtn) {
            Map<String, String> noteMap = new HashMap<>();
            noteMap.put("caseid", caseid);
            noteMap.put("alternativenotes", alterentativeNotets.getText());
            department.saveCase(noteMap);
        }

        if (event.getSource() == caseTable) {
            if (event.getClickCount() >= 2) {
                System.out.println("2 click");
            } else {
                caseid = caseTable.getSelectionModel().getSelectedItem().getNumber();
                List<Map<String, String>> returnSearch = department.Search("case", caseid);

                for (int i = 0; i < returnSearch.size(); i++) {

                    Map<String, String> newMap;
                    newMap = returnSearch.get(i);

                    for (Map.Entry<String, String> entry : newMap.entrySet()) {
                        if ("alternativenotes".equals(entry.getKey())) {
                            alterentativeNotets.setText(entry.getValue());
                        }
                    }
                }
            }
        }
    }
}