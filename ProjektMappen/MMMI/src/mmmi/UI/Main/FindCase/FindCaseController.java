package mmmi.UI.Main.FindCase;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

/**
 *
 * @author Gruppe 2
 */
public class FindCaseController implements Initializable {

    @FXML
    private ListView<String> LV_searchCaseList;
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
    ObservableList<String> obslistResult;
    Map<String, Map<String, String>> result;
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // domain = Domain::getInstance(); Domain facade instantiation, how?
        domain = new Department(1);
        RB_searchOptionCaseNo.setUserData("Case");
        RB_searchOptionCitizen.setUserData("Citizen");
        obslistResult = FXCollections.observableArrayList();
        LV_searchCaseList.setItems(obslistResult);
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
                    String info = "";
                    for (Map.Entry<String, String> entry : map.getValue().entrySet()) {
                        info += entry.getValue() + " ";
                    }
                    obslistResult.add(info);
                }
                LV_searchCaseList.refresh();
            } else {
                //Error, no data input
            }
        } else if (event.getSource() == BTN_openCase) {
            openCase();
        } else if (event.getSource() == RB_searchOptionCaseNo) {
            caseNumberPane.setVisible(true);
            citizenPane.setVisible(false);
        } else if (event.getSource() == RB_searchOptionCitizen) {
            caseNumberPane.setVisible(false);
            citizenPane.setVisible(true);
        }
    }

    private void openCase() {
        int listviewIndex = LV_searchCaseList.getFocusModel().getFocusedIndex();
        if(listviewIndex > -1) {
            Map<String, String> m = result.get(listviewIndex);
            String caseID = m.keySet().toString();
            System.out.println(caseID);
            // Open case
        }
    }

    /**
     *
     * @param event
     */
    private void mouseEventHandler(MouseEvent event) {

        if (event.getSource() == LV_searchCaseList) {
            if (event.getClickCount() == 2) {
                openCase();
            }
        }
    }

}
