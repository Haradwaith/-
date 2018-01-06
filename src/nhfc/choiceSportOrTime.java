/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    
    public choiceSportOrTime(Stage primaryStage,GridPane pane, Scene scene){
        
         //welcome title
        Text sceneTitle= new Text("Choix");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 1, 2,1);
        
        Button choixDuree = new Button("Duree de l'exercice (min)");
        pane.add(choixDuree, 0, 2 );  
        
        Button choixKcal = new Button("Calories à bruler(kcal)");
        pane.add(choixKcal, 1, 2 ); 
    }
    
    
}
