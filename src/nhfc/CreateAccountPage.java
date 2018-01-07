/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Clelia
 */
public class CreateAccountPage {
    
    public CreateAccountPage(Stage primaryStage, GridPane pane, Scene scene, boolean edit){
        
        //welcome title
        Text sceneTitle= new Text("Create Account");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 0, 2, 1);
        
        Label userNameTitle = new Label("User Name:");
        pane.add(userNameTitle, 0, 1);
        
        Label lastNameTitle = new Label("Last Name:");
        pane.add(lastNameTitle, 0, 2);
        
        TextField lastName = new TextField();
        pane.add(lastName, 1, 2);
        
        Label emailTitle = new Label("Email:");
        pane.add(emailTitle, 0, 3);
        
        Label passwordTitle = new Label("Password:");
        pane.add(passwordTitle, 0, 4);
        
        Label pwdConfirmTitle = new Label("Confirm Password:");
        pane.add(pwdConfirmTitle, 0, 5);
        
        if(!edit) {
            TextField userName = new TextField();
            pane.add(userName, 1, 1);
            PasswordField password = new PasswordField();
            pane.add(password, 1, 4);
            TextField emailName = new TextField();
            pane.add(emailName, 1, 3);
            PasswordField pwdConfirm = new PasswordField();
            pane.add(pwdConfirm, 1, 5);
        }
        
        Button connected = new Button("Login");
        
        Button back = new Button("Back");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().addAll(connected,back);
        pane.add(hbox, 1, 7);
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               new NHFC().start(primaryStage);
            }
        });
        
        connected.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            }
        });
      
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    public void verificationAccount(PasswordField pwd, PasswordField pwdConfirm, GridPane pane){
        Label error = new Label("Erreur mot de passe");
        if(pwd != pwdConfirm){
            pane.add(error, 0, 8);
        }
    } ;
    
}
