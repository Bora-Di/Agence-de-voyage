/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public Button accueil;
    public Button contact;
    public Button apropos;
    public Button parametres;
    public Button res1;
    public Button info1;
    public Button res2;
    public Button info2;
    public Button res3;
    public Button info3;
    public Button res4; 
    public Button info4;
    public Button deconnexion;
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void home(ActionEvent event){
               accueil.getScene().getWindow().hide();

        try {
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
            stage.setResizable(false);

        } catch (IOException ex) {

        }
    }
    @FXML
    private void cont(ActionEvent event){
               contact.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/contact/contact.fxml"));
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
    private void apros(ActionEvent event){
               apropos.getScene().getWindow();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/aboutus/aboutus.fxml"));
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
    private void para(ActionEvent event){
               parametres.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/setting/setting.fxml"));
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
    private void rese(ActionEvent event){
               res1.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/alhoceima/book/book.fxml"));
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
    private void infos(ActionEvent event){
               info1.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/alhoceima/info/info.fxml"));
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
    private void rese2(ActionEvent event){
               res2.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/nador/book/book.fxml"));
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
    private void infos2(ActionEvent event){
               info2.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/nador/info/info.fxml"));
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
    private void rese3(ActionEvent event){
               res3.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/chefchaouen/book/book.fxml"));
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
    private void infos3(ActionEvent event){
               info3.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/chefchaouen/info/info.fxml"));
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
    private void rese4(ActionEvent event){
               res4.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/tanger/book/book.fxml"));
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
    private void infos4(ActionEvent event){
               info4.getScene();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/tanger/info/info.fxml"));
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
    private void logout(ActionEvent event){
    
    deconnexion.getScene().getWindow().hide();

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
            

        } catch (IOException e) {
            

        }
    
    
    }
    
      @FXML
    private void handleClose(MouseEvent event) {
        System.exit(0);
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
