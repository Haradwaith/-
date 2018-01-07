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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Clelia
 */
public class choiceSportOrTime {
    
    public choiceSportOrTime(GridPane pane, Scene scene, String name){
        
         //welcome title
        Text sceneTitle= new Text("Choix pour " + name);
        
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 1, 2,1);
        
        Button choixDuree = new Button("Duree de l'exercice (min)");
        pane.add(choixDuree, 0, 2 );  
        
        choixDuree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                inputChoice("Temps", " en minutes", pane);
            }
        });
        
        Button choixKcal = new Button("Calories à bruler(kcal)");
        pane.add(choixKcal, 1, 2 ); 
        
          
        choixKcal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(pane.getChildren());
                inputChoice("Calories", "kcal", pane);
            }
        });
    }
    
    
     public void inputChoice(String name, String unité,GridPane pane){
        Label userNameTitle = new Label(name + unité );
        pane.add(userNameTitle, 0, 4);
        
        TextField input = new TextField();
        pane.add(input, 1, 4);
        
        Button saveTitle = new Button("Save");
        pane.add(saveTitle, 1, 5);

    }

}
