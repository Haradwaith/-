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
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Clelia
 */
public final class PagePrincipal {
    
    public PagePrincipal(Stage primaryStage,GridPane pane, Scene scene){
        
        String Test = "lo";
        String sportName[] = {"Training", "Vélo","Corde à sauter", "Piscine","Escalade","Haltérophilie","Squat","Fitness","Zumba"};
        
        Button modify = new Button("Modifier");
        pane.add(modify, 0,0);
            
        //welcome title
        Text sceneTitle= new Text("Home");
        sceneTitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        pane.add(sceneTitle, 0, 1, 2,1);
        
        
        Text welcomMessage = new Text();
        welcomMessage.setText("Welcome " + Test);
        pane.add(welcomMessage, 0, 2);
        
        Text imcInfo = new Text("Votre imc actuel est: ");
        pane.add(imcInfo, 0, 3);
        
        imcActuel(pane);
 
        int length = sportName.length ;
        
        int y = 0;
        try {
            for(int i = 4; i < length -1; i++){
                for(int j = 0; j < 2; j++){
                    System.out.println(i);
                     test(primaryStage,sportName[y], pane, i, j, scene);
                     ++y; 
                 }
             }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        Button btSuivis = new Button("Suivis");
        pane.add(btSuivis, 0, length);
        
        btSuivis.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                new ImcPlot(primaryStage,pane);
            }
        });
        
        modify.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               pane.getChildren().clear();
               new userProfil(primaryStage, pane, scene);
            }
        });
            
        
        //btSuivis.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: red;"); 
        //modify.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    public void test(Stage primaryStage, String name, GridPane pane, int i, int j, Scene scene){
        Button bt = new Button(name);
        pane.add(bt, j, i);
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
               new choiceSportOrTime( pane, scene, name);
             
            }
        });
    }
    
    public void imcActuel(GridPane pane){
        int imc = 70;                     //IMC = taille/poid²
        Label imcReponse = new Label();
        
        if(imc < 25){
            imcReponse.setText("Etat de maigreur");
            
        }else if( 25 < imc && imc < 30 ){
            imcReponse.setText("Surpoids");
            
        } else if(18.5 < imc && imc < 25){
            imcReponse.setText("Corpulence normale");
            
        } else if(30 < imc){
            imcReponse.setText("Obésité sévère");            
        }
        pane.add(imcReponse, 1, 3);
    }
    
}
