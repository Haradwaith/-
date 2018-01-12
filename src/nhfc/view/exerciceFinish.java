/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nhfc.classes.Test.backtoMainPage;
import nhfc.classes.Test.otherTexte;
import nhfc.classes.Test.mainTexte;
import nhfc.classes.User;

/**
 *
 * @author Clelia
 */
public class exerciceFinish {
    
    public exerciceFinish(Stage primaryStage, GridPane pane, String name,Scene scene, float numberChoice, char initial, float otherUnite, User user) throws InterruptedException{
        new mainTexte(pane,"Félicitation pour l'exercice "+ name );
        new otherTexte(pane, "vous avez fait:", 0, 1);
        
        if(initial == 't'){
            new otherTexte(pane, "Temps: " + numberChoice + " min", 0, 2);
            new otherTexte(pane, "Calories: " + otherUnite + " kcal", 0, 3);
        }else {
            new otherTexte(pane, "Calories: " + numberChoice + " kcal", 0, 2);
            new otherTexte(pane, "Temps: " + otherUnite + " min", 0, 3);
        }

        new backtoMainPage(pane, primaryStage, scene, 2, 5, user);
   
       
    }
    
}
