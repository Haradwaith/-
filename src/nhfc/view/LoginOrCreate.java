/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import nhfc.view.createOrEditAccount;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import nhfc.PagePrincipal;

/**
 *
 * @author Clelia
 */
public class LoginOrCreate {
    
    public LoginOrCreate(Stage primaryStage,GridPane pane, Scene scene){
              
        Button connected = new Button("Login");
        HBox hbox = new HBox(20);
        hbox.getChildren().add(connected);
        pane.add(hbox, 0, 4);
        
        Button createAccount = new Button("Create Account");
        HBox hboxL = new HBox(10);
        hboxL.getChildren().add(createAccount);
        pane.add(hboxL, 0, 2);
        
        connected.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pane.getChildren().clear();
                //new LoginPage(primaryStage,pane,scene);
                new PagePrincipal(primaryStage, pane, scene);
            }
        });
        
        createAccount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                pane.getChildren().clear();
                new createOrEditAccount(primaryStage, pane, scene, false);
            }
        });
      
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
