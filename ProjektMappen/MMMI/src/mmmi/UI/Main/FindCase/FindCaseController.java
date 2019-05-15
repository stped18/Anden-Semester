/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.FindCase;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import mmmi.Domain.Department;
import mmmi.Domain.Interfaces.IDomain;

/**
 * FXML Controller class
 *
 * @author steff
 */
public class FindCaseController implements Initializable {

    @FXML
    private TextField TF_searchText;
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

    IDomain domain; // Singleton?
    ObservableList<Map<String, String>> obslistResult;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // domain = Domain::getInstance(); Domain facade instantiation, how?
        RB_searchOptionCaseNo.setUserData("Case");
        RB_searchOptionCitizen.setUserData("Citizen");

    }

    @FXML
    private void actionEventHandler(ActionEvent event) {
        if(event.getSource() == BTN_search) {
            String searchKey = searchOption.getSelectedToggle().getUserData().toString();
            String searchValue = TF_searchText.getText();
            List<Map<String, String>> result = domain.Search(searchKey, searchValue);
            obslistResult = FXCollections.observableArrayList(result);
        }
    }

}

