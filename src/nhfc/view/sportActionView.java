/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;;
import nhfc.classes.Test.backtoMainPage;
import nhfc.classes.Test.mainTexte;
import nhfc.classes.User;

/**
 *
 * @author Clelia
 */
public class sportActionView {
    
    public sportActionView (Stage primaryStage,GridPane pane, String name,  Scene scene, String numberChoice, char initial, User user) {
        
        if(initial == 't'){
            new mainTexte(pane,name + " pour " + numberChoice + " minutes");
        }else {
              new mainTexte(pane,name + " pour " + numberChoice + " kcals");
        }

        Button saveTitle = new Button("Terminer et sauvegarder");
        pane.add(saveTitle, 0, 5);
        
        Button waitTitle = new Button("Pause");
        pane.add(waitTitle, 1, 5);
 
        
        new backtoMainPage(pane, primaryStage, scene, 1, 7, user);
        
        saveTitle.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            float otherUnit = calculOtherUnit(initial,Float.parseFloat(numberChoice));
      
            try {
                new exerciceFinish(primaryStage, pane, name, scene,Float.parseFloat(numberChoice),initial,otherUnit, user);
            } catch (InterruptedException ex) {
                Logger.getLogger(sportActionView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
    
    public float calculOtherUnit(char initial, float numberChoice) {
        if(initial == 't'){
            float otherUnit = numberChoice * 10 / 1; //time*kcal de l'exo si pour une minute 
            return otherUnit;
        }else {
            float otherUnit = numberChoice *1 /10; // kcal souhaite * min exo database / kcal database exo  
            return otherUnit;
        }
    };
       
    
}
