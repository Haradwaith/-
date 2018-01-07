/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nhfc.PagePrincipal;
import nhfc.classes.Test.mainTexte;



/**
 *
 * @author Clelia
 */
public class choiceTimeOrKcal {
    
    public choiceTimeOrKcal(Stage primaryStage, GridPane pane, String name,  Scene scene){
        
         //welcome title
        new mainTexte(pane, "Choix pour " + name );
        
        Button choixDuree = new Button("Duree de l'exercice (min)");
        pane.add(choixDuree, 0, 2 );  
        
        Button bt = new Button("Retour à la page principal");
        pane.add(bt, 0, 5);
            
        bt.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            new PagePrincipal(primaryStage, pane, scene);
        });
        
        choixDuree.setOnAction((ActionEvent event) -> {
            inputChoice(primaryStage,"Temps", " minutes", pane,name,scene,'t',bt);
        });
        
        Button choixKcal = new Button("Calories à bruler(kcal)");
        pane.add(choixKcal, 1, 2 ); 
          
        choixKcal.setOnAction((ActionEvent event) -> {
            System.out.println(pane.getChildren());
            inputChoice(primaryStage,"Calories", " kcal", pane, name,scene, 'k',bt);
        });
    }
    
    public void inputChoice(Stage primaryStage, String choice, String unité,GridPane pane, String sportName, Scene scene, char initial, Button bt){
        Label userNameTitle = new Label(choice + unité);
        pane.add(userNameTitle, 0, 4);
        
        TextField input = new TextField();
        pane.add(input, 1, 4);
        
        Button saveButton = new Button("Save");

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().addAll(saveButton,bt);
        pane.add(hbox, 1, 7);
        
        saveButton.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            new sportActionView(primaryStage,pane, sportName,scene,input.getText(), initial);
        });
    }

}
