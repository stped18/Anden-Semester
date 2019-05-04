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

    @FXML
    private AnchorPane fxCreateCase;
    @FXML
    private ChoiceBox<String> fxinquiryChoisBoks;

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL url, ResourceBundle rb) {
        //Use a stackpane for a simple layout of the controls

           fxinquiryChoisBoks.getItems().add("Borger");
           fxinquiryChoisBoks.getItems().add("Pårørende ");
           fxinquiryChoisBoks.getItems().add("Læge ");
           fxinquiryChoisBoks.getItems().add("Hospital");
           fxinquiryChoisBoks.getItems().add( "Anden forvaltning ");
           fxinquiryChoisBoks.getItems().add( "Igangværende indsats ");
           fxinquiryChoisBoks.getItems().add("Anden kommune ");
           fxinquiryChoisBoks.getItems().add("Andre ");
        
           
          
            
      
}

    @FXML
    private void buttonHandler(ActionEvent event) { 
        if(event.getSource()==fxnextBtn) {
            fxCreateCase.setVisible(true);
        }
    }

    @FXML
    private void choisehandler(MouseEvent event) {
        String choise = fxinquiryChoisBoks.getValue();
        if(choise.equals("Pårørende ") || (choise.equals("Læge  ")) || (choise.equals("Hospital  ")) || (choise.equals("Anden forvaltning  ")) || (choise.equals("Igangværende indsats ")) || (choise.equals("Andre "))){
            System.out.println("klik");
        }
         
        
    }
   
  
    


    
    
    
}











































