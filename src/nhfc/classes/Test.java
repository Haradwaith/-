/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JButton;
import nhfc.PagePrincipal;

/**
 *
 * @author Clelia
 */
public class Test {
    

    public static class mainTexte {

        public mainTexte(GridPane pane, String text) {
            Text sceneTitle= new Text(text);
            sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
            pane.add(sceneTitle, 0, 0, 2,1);
        }
    }
    
    public static class otherTexte {

        public otherTexte(GridPane pane, String text, int i , int j) {
            Text welcomMessage = new Text(text);
            pane.add(welcomMessage, i, j);
        }
    }
    
    
    public static abstract class button extends JButton{
        public button(GridPane pane,String title, int i, int j){
            Button button = new Button("Back");
            pane.add(button, 1, 5);

        }
    }
    
    
    public static class backtoMainPage {
        public backtoMainPage(GridPane pane, Stage primaryStage,Scene scene, int i , int j) {
            
            Button button = new Button("Retour Page Principal");
            pane.add(button, i, j);
            
            button.setOnAction((ActionEvent event) -> {
                pane.getChildren().clear();
                new PagePrincipal(primaryStage, pane, scene);
            });
        }
    }
    
}
