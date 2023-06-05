
package forgetpassword;

import db.Conn;
import java.io.IOException;
import javax.mail.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;




public class ForgetpasswordController implements Initializable {

    @FXML
    public Label note;
    public TextField email;
    
    @FXML
    public Button edit;
    public Button log;
    public Button sup;
    private double xOffset = 0;
    private double yOffset = 0;
    
    //
     Connection con ;
     PreparedStatement pst = null;
     ResultSet rs = null;
    // fermer button
      @FXML
    private void handleClose(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
   
    }
    
    // récupérer le mot de passe par l'envoyer en gmail
    
   @FXML
    private void sendmail (ActionEvent event) throws SQLException, AddressException, MessagingException{
        
         con = Conn.conDB();
     String sql = "select * from utilisateurs where email=? ";
         pst = con.prepareStatement(sql);
         pst.setString(1, email.getText()); 
         rs = pst.executeQuery();
         
  while (rs.next()){
 
       note.setText("Bien reçu !!");
      
       try{
      
    
    String to = email.getText();
    String host = "smtp.gmail.com";
    String from = "rifvoyage@gmail.com";
    String pass="Rif-V-03";
    String subject="Récupérer le mot de passe";
    String message ="votre mot de passe : "  +   rs.getString("password") +"\n"
            + "Si vous avez une question, contactez-nous, nous sommes au service de nos clients ! " ;
    final String emailuser=email.getText();   
 boolean sessionDebug = false;
//setup mail server
  Properties pro = System.getProperties();
  pro.put("mail.smtp.auth","true");
  pro.put("mail.smtp.starttls.enable","true");
  pro.put("mail.smtp.host","smtp.gmail.com");
  pro.put("mail.smtp.port","587");
  pro.put("mail.smtp.starttls.required", "true");
  
  java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
  
  Session session;
        session = Session.getInstance(pro, new javax.mail.Authenticator() {
            
          @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(from,pass);
            }
        });
      session.setDebug(sessionDebug);

     Message n = new MimeMessage(session);
          n.setFrom(new InternetAddress(from));
          n.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
          n.setSubject(subject);
          n.setText(message);
// send mail
Transport transport = session.getTransport("smtp");
transport.connect(host, from, pass);
transport.sendMessage(n, n.getAllRecipients());
transport.close();
}catch(MessagingException e){
 e.printStackTrace();
 note.setText(" Erreur !!");
}
        

         
  }    
    
    }
    
    // connexion button
    
    // connexion button
    
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
    private void sign(ActionEvent event){
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

        } catch (IOException ex) {

        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
