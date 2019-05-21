package mmmi.UI.Main.FindCase;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;
import mmmi.UI.Main.MainController;

/**
 *
 * @author Gruppe 2
 */
public class FindCaseController extends MainController implements Initializable {

    @FXML
    private Button BTN_search;
    @FXML
    private RadioButton RB_searchOptionCitizen;
    @FXML
    private ToggleGroup searchOption;
    @FXML
    private RadioButton RB_searchOptionCaseNo;
    @FXML
    private Button BTN_openCase;
    @FXML
    private TextField TF_searchCaseNumber;
    @FXML
    private TextField TF_searchCitizenName;
    @FXML
    private TextField TF_searchCitizenAddress;
    @FXML
    private TextField TF_searchCitizenZipcode;
    @FXML
    private AnchorPane caseNumberPane;
    @FXML
    private AnchorPane citizenPane;
    @FXML
    private TextField TF_searchCitizenCPR;
    
    IDomain domain; // Singleton?
    ObservableList<SearchResult> obslistResult;
    Map<String, Map<String, String>> result;
    @FXML
    private TableView<SearchResult> TV_searchCase;
    @FXML
    private TableColumn<SearchResult, String> caseIDColumn;
    @FXML
    private TableColumn<SearchResult, String> citizenNameColumn;
    @FXML
    private TableColumn<SearchResult, String> caseStatusColumn;
    @FXML
    private TableColumn<SearchResult, String> currentDateColumn;
    @FXML
    private TableColumn<SearchResult, String> employeeNameColumn;
    @FXML
    private TableColumn<SearchResult, String> reasonColumn;
    @FXML
    private TableColumn<SearchResult, String> createdDateColumn;
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        domain = Department.getInstance(); 
        RB_searchOptionCaseNo.setUserData("Case");
        RB_searchOptionCitizen.setUserData("Citizen");
        obslistResult = FXCollections.observableArrayList();
        TV_searchCase.setPlaceholder(new Label());
        TV_searchCase.setItems(obslistResult);
        caseIDColumn.setCellValueFactory(cellData -> cellData.getValue().caseIDProperty());
        citizenNameColumn.setCellValueFactory(cellData -> cellData.getValue().citizenNameProperty());
        caseStatusColumn.setCellValueFactory(cellData -> cellData.getValue().caseStatusProperty());
        currentDateColumn.setCellValueFactory(cellData -> cellData.getValue().currentCaseDateProperty());
        employeeNameColumn.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        reasonColumn.setCellValueFactory(cellData -> cellData.getValue().reasonProperty());
        createdDateColumn.setCellValueFactory(cellData -> cellData.getValue().createdCaseDateProperty());
    }

    /**
     *
     * @param event
     */
    @FXML
    private void actionEventHandler(ActionEvent event) {
        if (event.getSource() == BTN_search) {
            obslistResult.removeAll(obslistResult);
            String searchKey = searchOption.getSelectedToggle().getUserData().toString();
            String searchValue = "";
            if (searchKey.equals("Case")) {
                searchValue = TF_searchCaseNumber.getText();
            } else {
                searchValue = TF_searchCitizenCPR.getText()
                        + "%" + TF_searchCitizenName.getText() 
                        + "%" + TF_searchCitizenAddress.getText()
                        + "%" + TF_searchCitizenZipcode.getText();
            }
            System.out.println(searchValue);
            if(!searchValue.equals("") && !searchValue.equals("%%%")) {
                result = domain.search(searchKey, searchValue);
                for (Map.Entry<String, Map<String, String>> map : result.entrySet()) {
                    System.out.println(map);
                    String caseid = map.getKey();

                    obslistResult.add(new SearchResult(map.getValue().get("citizenName"), caseid, map.getValue().get("caseStatus"), map.getValue().get("currentCaseDate"), map.getValue().get("createdCaseDate"), map.getValue().get("caseReason"), map.getValue().get("caseEmployeeName")));
                }
                TV_searchCase.refresh();
            } else {
                //Error, no data input
            }
        } else if (event.getSource() == BTN_openCase) {
            openCase(TV_searchCase.getSelectionModel().getSelectedItem());
        } else if (event.getSource() == RB_searchOptionCaseNo) {
            caseNumberPane.setVisible(true);
            citizenPane.setVisible(false);
        } else if (event.getSource() == RB_searchOptionCitizen) {
            caseNumberPane.setVisible(false);
            citizenPane.setVisible(true);
        }
    }

    private void openCase(SearchResult sr) {
        System.out.println(sr.getCaseID());
//            for(int i=0;i<=listviewIndex;i++) {
//                if(i == listviewIndex) {
//                    Set k = result.keySet();
//                    
//                }
//            }
            //Map<String, String> m = result.get("caseid");
            //String caseID = m.keySet().toString();
            //System.out.println(caseID);
            // Open case
    }

}

