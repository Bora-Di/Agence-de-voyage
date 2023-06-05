/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package destinations.nador.book;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author User
 */
public class BookController implements Initializable {

    @FXML
    public Label lab1;
    public Label lab2;
    public Label lab3;
    private double xOffset = 0;
    private double yOffset = 0;

    public Label total;
    public DatePicker date;
    public Button paiement;
    public Hyperlink book;
  
    @FXML
    public ComboBox<String> numofppl;
    
    ObservableList<String> list=FXCollections.observableArrayList("1 personne","2 personnes");

    ObservableList<String> list2=FXCollections.observableArrayList("chambre individuelle","chambre double","chambre double (twin)","chambres individuelles");


    @FXML
    public ComboBox<String> roomtype;
   
    @FXML
    private void handleClose(MouseEvent event) {
        Node node = (Node) event.getSource();
   Stage stage;
        stage = (Stage) node.getScene().getWindow();
   stage.close(); 
    }
    @FXML
    private void pay(ActionEvent event){
     
         if (roomtype.getValue() == null || numofppl.getValue() == null || date.getValue() == null){
            lab3.setText("Attention, vérifiez vos informations !!");
            book=new Hyperlink("www.paypal.com");
        }else{lab3.setText("");
        
        paiement.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/destinations/nador/paypal/paypal.fxml"));
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
    }}
    @FXML
    private void combo(ActionEvent event) {
        lab1.setText(numofppl.getValue());
        lab2.setText(roomtype.getValue());
        if (roomtype.getValue() == null || numofppl.getValue() == null ){
            total.setText("00.00€");
        }
        
        if (roomtype.getValue() == "chambre individuelle" && numofppl.getValue() == "1 personne"){
            total.setText("50.00€");
        }
         if (roomtype.getValue() == "chambre double" && numofppl.getValue() == "1 personne"){
            total.setText("60.00€");
        }
         if (roomtype.getValue() == "chambre double (twin)" && numofppl.getValue() == "1 personne"){
            total.setText("70.00€");
        }
         if (roomtype.getValue() == "chambres individuelles" && numofppl.getValue() == "1 personne"){
            total.setText("100.00€");
        }
         if (roomtype.getValue() == "chambre individuelle" && numofppl.getValue() == "2 personnes"){
            total.setText("50.00€");
        }
         if (roomtype.getValue() == "chambre double" && numofppl.getValue() == "2 personnes"){
            total.setText("60.00€");
        }
         if (roomtype.getValue() == "chambre double (twin)" && numofppl.getValue() == "2 personnes"){
            total.setText("70.00€");
        }
         if (roomtype.getValue() == "chambres individuelles" && numofppl.getValue() == "2 personnes"){
            total.setText("100.00€");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numofppl.setItems(list);
        numofppl.getItems().add(null);;
        roomtype.setItems(list2);
        roomtype.getItems().add(null);;

    }    
    
}
