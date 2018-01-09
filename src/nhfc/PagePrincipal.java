/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import nhfc.view.choiceTimeOrKcal;
import nhfc.view.ImcPlot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import nhfc.classes.Test.mainTexte;
import nhfc.classes.Test.otherTexte;
import nhfc.view.createOrEditAccount;

/**
 *
 * @author Clelia
 */
public final class PagePrincipal {
    
    public PagePrincipal(Stage primaryStage,GridPane pane, Scene scene){
        
        String Test = "lo";
        String sportName[] = {"Training", "Vélo","Corde à sauter", "Piscine","Escalade","Haltérophilie","Squat","Fitness","Zumba"};
        
        Button modify = new Button("Modifier");
        pane.add(modify, 5,0);
            
        //welcome title        
        new mainTexte(pane,"Home");
        
        new otherTexte(pane, "Welcome " + Test, 0, 2);
        new otherTexte(pane, "Votre imc actuel est: ", 0, 3);
        
        textImcCurrent(pane);
 
        int length = sportName.length ;
        
        Button btSuivis = new Button("Suivis");
        pane.add(btSuivis, 0, length);
        
        btSuivis.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            new ImcPlot(primaryStage,pane);
        });
        
        modify.setOnAction((ActionEvent event) -> {
            pane.getChildren().clear();
            new createOrEditAccount(primaryStage, pane, scene, true);
        });
        
        int y = 0;
        try {
            for(int i = 4; i < length -1; i++){
                for(int j = 0; j < 2; j++){
                    sportView(primaryStage,sportName[y], pane, i, j, scene);
                    ++y; 
                 }
             }
        } catch (Exception e) {
            System.out.println(e);
        }
            
        
        //btSuivis.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: red;"); 
        //modify.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
    }
    
    
    public void sportView(Stage primaryStage, String name, GridPane pane, int i, int j, Scene scene){
        Button bt = new Button(name);
        pane.add(bt, j, i);
        
        bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               pane.getChildren().clear();
               new choiceTimeOrKcal(primaryStage, pane, name, scene);
            }
        });
    }
    
    public void textImcCurrent(GridPane pane){
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
