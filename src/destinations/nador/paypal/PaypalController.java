/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destinations.nador.paypal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PaypalController implements Initializable {

    @FXML
    private WebView webvview;
  
   @FXML
    private void handleClose(MouseEvent event) {
        Node node = (Node) event.getSource();
   Stage stage;
        stage = (Stage) node.getScene().getWindow();
   stage.close(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         final WebEngine web=webvview.getEngine();
          String urlweb="https://www.paypal.com/fr/signin";
        web.load(urlweb);
        
    }  
   
    
}
