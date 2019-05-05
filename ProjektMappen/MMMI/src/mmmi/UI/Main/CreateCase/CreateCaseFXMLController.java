/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.createCase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import mmmi.UI.Main.RunFxmlLoader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;

public class CreateCaseFXMLController extends RunFxmlLoader implements Initializable {


    @FXML
    private Button fxnextBtn;
    @FXML
    private Button fxBackBtn;

    @FXML
    private Button fxSaveBtn;

    @FXML
    private AnchorPane fxSubSubpane;
    
    ObservableList<String> list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
                this.list = FXCollections.observableArrayList();
                list.add(0, "caseOpening/caseOpeningFXML.fxml");
                list.add(1, "caseInvestigation/caseInvestigationFXML.fxml"); 
                list.add(2, "caseOpening/caseOpeningFXML.fxml");
                changeFxml(fxSubSubpane, list.get(0));


    }

    @FXML
    private void buttonHandler(ActionEvent event) {
        int count=0; 
           if(event.getSource()==fxnextBtn){
               if(count==0){
                   changeFxml(fxSubSubpane, list.get(1));
                   count = 1;
               }
               if(count ==1){
                    changeFxml(fxSubSubpane, list.get(2));
               }
           } 
        
         
  
       
    }


}


















































































