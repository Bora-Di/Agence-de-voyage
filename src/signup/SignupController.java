package signup;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SignupController implements Initializable {

    @FXML
    private TextField username;
 @FXML
    private TextField fullname;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;

    @FXML
    private TextField city;
    @FXML
    private PasswordField password;

    @FXML
    private Button acc;

    @FXML
    private Button log;
    
    @FXML
    private Label message;

    private double xOffset = 0;
    private double yOffset = 0;
    
    /**********************/
    
     Connection conn=null ;
     PreparedStatement pst = null;
     ResultSet rs = null;
     
     /*******************/
    
    
    @FXML
    private void login(ActionEvent event){
               log.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/login/FXMLDocument.fxml"));
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

        } catch (IOException ex) {

        }
    }
    
   @FXML
    private void Account(ActionEvent event) throws SQLException, IOException{

         acc.getScene().getWindow().hide();
     
          conn=Conn.conDB();
        String sql = "insert into utilisateurs(username, fullname, email, phone, city, password) values(?,?,?,?,?,?)";
     
        try {
               
            pst = conn.prepareStatement(sql);
            pst.setString(1, username.getText());
            pst.setString(2, fullname.getText());
            pst.setString(3, email.getText());
            pst.setString(4, phone.getText());
            pst.setString(5, city.getText());
            pst.setString(6, password.getText());
           if( pst.executeUpdate()>0){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/dashboard/dashboard.fxml"));
            
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
            stage.setResizable(false);}
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
        
        username.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
                acc.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               email.requestFocus();
            }
        });
        
         email.setOnKeyPressed((KeyEvent event) -> {
         if (event.getCode() == KeyCode.ENTER) {
                acc.fire();
            } else if (event.getCode() == KeyCode.DOWN) {
               password.requestFocus();
            }
        });

        password.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                acc.fire();
            } else if (event.getCode() == KeyCode.UP) {
                email.requestFocus();
            }
        });
    }    
    
}
      
        
    