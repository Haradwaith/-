/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
public class userProfil {
    
    public userProfil(Stage primaryStage, GridPane pane, Scene scene){
        
        //welcome title
        Text sceneTitle= new Text("Profil");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 0, 2,1);
        
        Label userNameTitle = new Label("User Name:");
        pane.add(userNameTitle, 0, 1);
        
        TextField userName = new TextField();
        pane.add(userName, 1, 1);
        
        Label lastNameTitle = new Label("Last Name:");
        pane.add(lastNameTitle, 0, 2);
        
        TextField lastName = new TextField();
        pane.add(lastName, 1, 2);
        
        Label weightLabel = new Label("Weight:");
        pane.add(weightLabel, 0, 3);
        
        TextField weight = new TextField();
        pane.add(weight, 1, 3);
        
        Label genderLabel = new Label("Gender: ");
        pane.add(genderLabel, 0, 4);
        
        CheckBox genderH = new CheckBox("Man");
        pane.add(genderH, 1, 4);
        
        CheckBox genderF = new CheckBox("Female");
        pane.add(genderF, 2, 4);
        
        Label ageLabel = new Label("Age:");
        pane.add(ageLabel, 0, 5);
        
        TextField age = new TextField();
        pane.add(age, 1, 5);
        
        Label tailleLabel = new Label("Taille:");
        pane.add(tailleLabel, 0, 6);
        
        TextField taille = new TextField();
        pane.add(taille, 1, 6);
                
        Button connected = new Button("Save");
        HBox hbox = new HBox(20);
        hbox.getChildren().add(connected);
        pane.add(hbox, 0, 10);
       
        connected.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NumberVerification(weight,pane);
                NumberVerification(age, pane);
                NumberVerification(taille, pane);
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    };
        
    
    public void NumberVerification(TextField weight, GridPane pane){
       
    }
    
    
}
