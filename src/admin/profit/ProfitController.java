/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.profit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adila
 */
public class ProfitController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private void handleClose(MouseEvent event) {
       Node node = (Node) event.getSource();
   Stage stage;
        stage = (Stage) node.getScene().getWindow();
   stage.close();
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
