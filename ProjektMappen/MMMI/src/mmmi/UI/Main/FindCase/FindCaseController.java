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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
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
    private ListView<?> LV_searchCaseList;
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

    IDomain domain; // Singleton?
    ObservableList<String> obslistResult;
    @FXML
    private AnchorPane caseNumberPane;
    @FXML
    private AnchorPane citizenPane;

    List<Map<String, String>> result;

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
        RB_searchOptionCaseNo.setUserData("Case");
        RB_searchOptionCitizen.setUserData("Citizen");

    }

    /**
     *
     * @param event
     */
    @FXML
    private void actionEventHandler(ActionEvent event) {
        if (event.getSource() == BTN_search) {
            String searchKey = searchOption.getSelectedToggle().getUserData().toString();
            String searchValue;
            if (searchKey.equals("Case")) {
                searchValue = TF_searchCaseNumber.getText();
            } else {
                searchValue = TF_searchCitizenName.getText() + "%" + TF_searchCitizenAddress + "%" + TF_searchCitizenZipcode;
            }
            result = domain.Search(searchKey, searchValue);
            List<String> listViewStrings = new ArrayList();
            for (Map<String, String> map : result) {
                String info = map.values().toString();
                listViewStrings.add(info);
            }
            obslistResult = FXCollections.observableArrayList(listViewStrings);
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
        Map<String, String> m = result.get(listviewIndex);
        String caseID = m.keySet().toString();
        // Open case
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
