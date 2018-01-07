/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nhfc.PagePrincipal;
import nhfc.classes.Test;
import nhfc.classes.Test.mainTexte;

/**
 *
 * @author Clelia
 */
public class sportActionView {
    
    public sportActionView (Stage primaryStage,GridPane pane, String name,  Scene scene, String numberChoice, char initial) {
        
        if(initial == 't'){
            new mainTexte(pane,name + " pour " + numberChoice + " minutes");
        }else {
              new mainTexte(pane,name + " pour " + numberChoice + " kcals");
        }

        Button saveTitle = new Button("Terminer et sauvegarder");
        pane.add(saveTitle, 0, 5);
        
        Button waitTitle = new Button("Pause");
        pane.add(waitTitle, 1, 5);
 
        
        new Test.backtoMainPage(pane, primaryStage, scene, 2, 5);
        
        saveTitle.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            float otherUnit = calculOtherUnit(initial,Float.parseFloat(numberChoice));
      
            try {
                new exerciceFinish(primaryStage, pane, name, scene,Float.parseFloat(numberChoice),initial,otherUnit);
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
