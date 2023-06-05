/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.home;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    public Button active;
    public Button client;
    public Button profit;
    public Button logout;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void des(ActionEvent event){
               active.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/admin/active/active.fxml"));
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
    private void cli(ActionEvent event){
               client.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/admin/clients/clients.fxml"));
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
    private void prof(ActionEvent event){
               profit.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/admin/profit/profit.fxml"));
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
    
    //deconnexion
      @FXML
    private void actionLogout(ActionEvent event){
     
         logout.getScene();

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
    
    // fermer button
    
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
