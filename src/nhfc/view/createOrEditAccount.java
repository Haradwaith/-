/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nhfc.NHFC;
import nhfc.PagePrincipal;
import nhfc.classes.Test;

/**
 *
 * @author Clelia
 */
public class createOrEditAccount {
    
    public createOrEditAccount(Stage primaryStage, GridPane pane, Scene scene, boolean edit){
        
        //welcome title
        new Test.mainTexte(pane, "Création de compte");
        
        //Creation du formulaire
        
        Label lastNameTitle = new Label("Nom");
        pane.add(lastNameTitle, 0, 1);
        
        TextField lastName = new TextField();
        pane.add(lastName, 1, 1);
        
        Label userNameTitle = new Label("Prénom:");
        pane.add(userNameTitle, 0, 2);
        
        TextField userName = new TextField();
        pane.add(userName, 1, 2);
        
        Label genderLabel = new Label("Sexe: ");
        pane.add(genderLabel, 0, 3);
        
        CheckBox genderH = new CheckBox("Homme");
        pane.add(genderH, 1, 3);
        
        CheckBox genderF = new CheckBox("Femme");
        pane.add(genderF, 2, 3);
        
        Label ageLabel = new Label("Age:");
        pane.add(ageLabel, 0, 4);
        
        TextField age = new TextField();
        pane.add(age, 1, 4);
        
        
        Label weightLabel = new Label("Poids:");
        pane.add(weightLabel, 0, 5);
        
        TextField weight = new TextField();
        pane.add(weight, 1, 5);
       
        Label heightLabel = new Label("Taille:");
        pane.add(heightLabel, 0, 6);
        
        TextField height = new TextField();
        pane.add(height, 1, 6);
        
        Label emailTitle = new Label("Email:");
        pane.add(emailTitle, 0, 7);      
        
        TextField email = new TextField();
        pane.add(email, 1, 7);
        
        Label passwordTitle = new Label("Mot de passe:");
        pane.add(passwordTitle, 0, 8);
        
        PasswordField password = new PasswordField();
        pane.add(password, 1, 8);
        
        Label pwdConfirmTitle = new Label("Confirmation mdp:");
        pane.add(pwdConfirmTitle, 0, 9);
        
        PasswordField pwdConfirm = new PasswordField();
        pane.add(pwdConfirm, 1, 9);
        
        //le texte du bouton change en fonction de l'edition ou non
        Button connected = new Button();
         
        //si on edit notre compte
        if(!edit) {
          
            
           
            connected.setText("Créer");
        }else {
            connected.setText("Sauvegarder");
        }
        
        
       
        //button de retour + action des boutons
        Button back = new Button("Retour à la page principal");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().addAll(connected,back);
        pane.add(hbox, 0, 2, 2, 13);
        
        back.setOnAction((ActionEvent t) -> {
            new NHFC().start(primaryStage);
        });
        
        connected.setOnAction((ActionEvent event) -> {
            if(
                verificationPwd(password, pwdConfirm, pane) && 
                isEmailAdress(email,pane) &&
                verificationText(userName, "Prénom", pane) &&
                verificationText(lastName, "Nom", pane) &&
                verificationNumber(weight, "Poids", pane) &&
                verificationNumber(height, "Poids", pane)    
            ){
                pane.getChildren().clear();
                new PagePrincipal(primaryStage, pane, scene);
            }
            
        });
      
    }
     
    public boolean verificationPwd(PasswordField pwd, PasswordField pwdConfirm, GridPane pane){
        if(!pwd.getText().equals(pwdConfirm.getText()) 
            || pwd.getText().isEmpty())
        {
            Label error = new Label("Erreur mot de passe");
            pane.add(error, 0, 15);
            return false;
        } else if (pwd.getLength() < 4) {
            Label error = new Label("Le mdp doit contenir au moins 7 caractères");
            pane.add(error, 0, 15);
            return false;
        } else {
            return true;
        }
    };

    public boolean isEmailAdress(TextField email, GridPane pane){
        Label error = new Label("Erreur email");
        if (!email.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+") 
                || email.getText().isEmpty()) {
            pane.add(error, 0, 15);
            return false;
        }else {
            return true;
        }
    };
    
    public boolean verificationText(TextField text, String name, GridPane pane){
        Label error = new Label("Erreur dans le champs " + name);
        if(text.getText().isEmpty()){
            pane.add(error, 0, 16);
            return false;
        } else {
            return true; 
        }
    };
    
    public boolean verificationNumber(TextField number, String name, GridPane pane){
        Label error = new Label("Erreur dans le champs " + name);
        
        if(!number.getText().isEmpty() && number.getText().matches("[0-9]*") && Integer.parseInt(number.getText()) < 100){
            return true; 
        } else {
           pane.add(error, 0, 16);
            return false; 
        }
    };
}
