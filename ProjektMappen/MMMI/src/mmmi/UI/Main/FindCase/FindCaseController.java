/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    ObservableList<String> obslistResult;
    List<Map<String, String>> result;
    
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
//String nextRoom = lvAvailableExits.getSelectionModel().getSelectedItem(); // save selected item in String
//        if (event.getClickCount() == 2) {
//            moveRoom(nextRoom);
//        }
    @FXML
    private void actionEventHandler(ActionEvent event) {
        if(event.getSource() == BTN_search) {
            String searchKey = searchOption.getSelectedToggle().getUserData().toString();
            String searchValue = TF_searchText.getText();
            result = domain.Search(searchKey, searchValue);
            List<String> listViewStrings = new ArrayList();
            for (Map<String, String> map : result) {
                String info = map.values().toString();
                listViewStrings.add(info);
            }
            obslistResult = FXCollections.observableArrayList(listViewStrings);
        }
    }
    
    @FXML
    private void mouseEventHandler(MouseEvent event) {
        
        if(event.getSource() == LV_searchCaseList) {
            if (event.getClickCount() == 2) {
                int listviewIndex = LV_searchCaseList.getFocusModel().getFocusedIndex();
                Map<String, String> m = result.get(listviewIndex);
                String caseID = m.keySet().toString();
                // Open case
            }
        }
    }

}

