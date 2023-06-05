/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

import db.Conn;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class SettingController implements Initializable {
    
      @FXML
    private TextField username;
    @FXML
    private TextField user;
    @FXML
    private TextField fullname;

    @FXML
    private Button update;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField city;

    @FXML
    private TextField gender;

    @FXML
    private TextField adresse;
    
    @FXML
    private Label message; 

    
    /***/
    
     Connection con=null ;
     PreparedStatement pst = null;
     ResultSet rs = null;
     
     /***/
    @FXML
    void actionupdate(ActionEvent event) throws SQLException {
        con = Conn.conDB();
        try{
     String sql = "select * from utilisateurs where username=? ";
         
         pst = con.prepareStatement(sql);
         pst.setString(1, username.getText());
         rs = pst.executeQuery();
         while(rs.next()){
     String a = rs.getString("username");
         update.setText(a);}}catch(Exception e){}
          } 
          
    
    
    @FXML
    private void handleClose(MouseEvent event) {
       Node node = (Node) event.getSource();
   Stage stage;
        stage = (Stage) node.getScene().getWindow();
   stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      username.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
                update.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               fullname.requestFocus();
            }
        });

        fullname.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                update.fire();
            } else if (event.getCode() == KeyCode.UP) {
                email.requestFocus();
            }
        });
        
     email.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
               update.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               phone.requestFocus();
            }
        });

        phone.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                update.fire();
            } else if (event.getCode() == KeyCode.UP) {
                city.requestFocus();
            }
        });
       
    city.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
                update.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               gender.requestFocus();
            }
        });

        gender.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                update.fire();
            } else if (event.getCode() == KeyCode.UP) {
                adresse.requestFocus();
            }
        });
    }    

    private void loadDataFromDdatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
