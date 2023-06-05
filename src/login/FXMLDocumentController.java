
package login;

import db.Conn;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
/*import javax.swing.JOptionPane;
import signup.SignupController;
import sun.security.util.Password;*/



public class FXMLDocumentController implements Initializable {
    
      @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    private Button log;

    @FXML
    private Hyperlink mdp;

    @FXML
    private Button sup;

    @FXML
    private Label message;
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    /*******/
    
  Connection con ;
  PreparedStatement pst = null;
  ResultSet rs = null; 
  
    @FXML
    void ActionLogin(ActionEvent event) throws IOException, SQLException {
        
                   String useradmin = Username.getText();
                   String passadmin = Password.getText(); 
// admin connexion
            if( (useradmin.equals("admin")&& passadmin.equals("admin"))){

                log.getScene().getWindow().hide();
                
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/admin/home/home.fxml"));
            
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        }); 
            
            stage.setScene(scene);
            stage.show();
             Username.clear();
	     Password.clear();
      
                
            } else {
            //client connexion
            
     log.setVisible(true);
     
     /********/
     con = Conn.conDB();
     String sql = "select * from utilisateurs where username=? and password=?";

      try {

         pst = con.prepareStatement(sql);
         pst.setString(1, Username.getText()); 
         pst.setString(2, Password.getText());
         rs = pst.executeQuery();

      if(rs.next()){

     message.setVisible(false);
     
     log.getScene().getWindow().hide();
     
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/dashboard/dashboard.fxml"));
            
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
            Username.clear();
	    Password.clear();
  
         }else{
             //JOptionPane.showMessageDialg(null, "login failed");
             message.setVisible(true);
             message.setText("Attention,vérifiez vos informations !!");
	     Username.clear();
	     Password.clear();
      }
        }catch (IOException e) { //JOptionPane.showMessageDialg(null, e); 
        }
      }
    }
    @FXML
    void ActionSignup(ActionEvent event) throws SQLException {
      
             sup.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/signup/signup.fxml"));
            
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        }); 
            
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
               } catch (IOException e) {}
       
    }
      
        
    @FXML
    void LinkForget(ActionEvent event) {
        mdp.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/forgetpassword/forgetpassword.fxml"));
            
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.UNDECORATED);
            
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        }); 
            
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            

        } catch (IOException e) {
            

        }

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
        
        Username.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
                log.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               Password.requestFocus();
            }
        });

        Password.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                log.fire();
            } else if (event.getCode() == KeyCode.UP) {
                Username.requestFocus();
            }
        });
    }    
    
}
