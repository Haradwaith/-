/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

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
import nhfc.NHFC;
import nhfc.PagePrincipal;
import nhfc.classes.User;

/**
 *
 * @author Clelia
 */
public class LoginPage {
    
    /**
     *
     * @param primaryStage
     * @param pane
     * @param scene
     */
    public LoginPage(Stage primaryStage,GridPane pane, Scene scene){

        //welcome title
        Text sceneTitle= new Text("Connection!");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 0, 2,1);
        
        Label userNameTitle = new Label("Nom de connection:");
        pane.add(userNameTitle, 0, 1);
        
        TextField userName = new TextField();
        pane.add(userName, 1, 1);
        
        Label passwordTitle = new Label("Mot de passe:");
        pane.add(passwordTitle, 0, 2);
        
        PasswordField password = new PasswordField();
        pane.add(password, 1, 2);
        
        Button connected = new Button("Connecté");
        
        
        connected.setOnAction((ActionEvent event) -> {
            if(!userName.getText().isEmpty() && !password.getText().isEmpty()){
                User users = new User(userName.getText(), password.getText());
                users = users.connecterCompte();
                if(users != null){
                    pane.getChildren().clear();
                    new PagePrincipal(primaryStage, pane, scene, users);
                };
            }else{
                Label error = new Label("Probleme avec un des champs");
                pane.add(error, 0, 5); 
            }
           
         
        });
        
        Button back = new Button("Retour");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().addAll(connected,back);
        pane.add(hbox, 1, 4);
      
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               new NHFC().start(primaryStage);
            }
        });

    }    
}
