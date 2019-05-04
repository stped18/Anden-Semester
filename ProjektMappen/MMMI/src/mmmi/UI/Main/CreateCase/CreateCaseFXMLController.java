/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmmi.UI.Main.CreateCase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
public class CreateCaseFXMLController  implements Initializable {


    @FXML
    private Button fxnextBtn;
    @FXML
    private Button fxBackBtn;

    @FXML
    private Button fxSaveBtn;

    private AnchorPane fxCreateCase;

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL url, ResourceBundle rb) {
      
        
           
          
            
      
}

    @FXML
    private void buttonHandler(ActionEvent event) { 
        if(event.getSource()==fxnextBtn) {
            fxCreateCase.setVisible(true);
        }
    }


   
  
    


    
    
    
}













































