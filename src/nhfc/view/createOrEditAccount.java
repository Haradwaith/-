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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nhfc.NHFC;
import nhfc.PagePrincipal;
import nhfc.classes.Test;
import nhfc.classes.User;

/**
 *
 * @author Clelia
 */
public class createOrEditAccount {
    
    public createOrEditAccount(Stage primaryStage, GridPane pane, Scene scene, boolean edit, User user){
        
        //welcome title
        new Test.mainTexte(pane, "Création de compte");
        
        //Creation du formulaire
        
        Label lastNameTitle = new Label("Nom");
        pane.add(lastNameTitle, 0, 1);
        
        TextField lastName = new TextField();
        pane.add(lastName, 1, 1);
        
        Label firstNameTitle = new Label("Prénom:");
        pane.add(firstNameTitle, 0, 2);
        
        TextField firstName = new TextField();
        pane.add(firstName, 1, 2);        
        
        Label genderLabel = new Label("Sexe: ");
        pane.add(genderLabel, 0, 3);
        
        final ToggleGroup group = new ToggleGroup();
        
        RadioButton genderH = new RadioButton("Homme");
        genderH.setToggleGroup(group);
        pane.add(genderH, 1, 3);
        genderH.setSelected(true);
        
        RadioButton genderF = new RadioButton("Femme");
        genderF.setToggleGroup(group);
        pane.add(genderF, 2, 3);
       
        
        Label ageLabel = new Label("Age:");
        pane.add(ageLabel, 0, 4);
        
        TextField age = new TextField();
        pane.add(age, 1, 4);
        
        Label weightLabel = new Label("Poids (kg):");
        pane.add(weightLabel, 0, 5);
        
        TextField weight = new TextField();
        pane.add(weight, 1, 5);
       
        Label heightLabel = new Label("Taille (cm):");
        pane.add(heightLabel, 0, 6);
        
        TextField height = new TextField();
        pane.add(height, 1, 6);
        
        Label emailTitle = new Label("Email:");
        pane.add(emailTitle, 0, 7);      
        
        TextField email = new TextField();
        pane.add(email, 1, 7);
        
        Label loginTitle = new Label("Login");
        pane.add(loginTitle, 0, 8);
        
        TextField logintext = new TextField();
        pane.add(logintext, 1, 8);
        
        Label passwordTitle = new Label("Mot de passe:");
        pane.add(passwordTitle, 0, 9);
        
        PasswordField password = new PasswordField();
        pane.add(password, 1, 9);
        
        Label pwdConfirmTitle = new Label("Confirmation mdp:");
        pane.add(pwdConfirmTitle, 0, 10);
        
        PasswordField pwdConfirm = new PasswordField();
        pane.add(pwdConfirm, 1, 10);
        
        //le texte du bouton change en fonction de l'edition ou non
        Button connected = new Button();
        Button back = new Button();
         
        //si on edit notre compte
        if(!edit) {
          
            
        
            connected.setText("Créer");
            back.setText("Retour");
        }else {

            lastName.setText(user.getLastname());
            firstName.setText(user.getName());
            age.setText(Integer.toString(user.getAge()));
            weight.setText(Float.toString(user.getPoids()));
            height.setText(Float.toString(user.getTaille()));
            email.setText(user.getEmail());
            logintext.setText(user.getLogin());
            
            
            
            connected.setText("Sauvegarder");
            back.setText("Retour à la page principal");
        }
       
        
        
        //button de retour + action des boutons
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().addAll(connected,back);
        pane.add(hbox, 0, 2, 2, 13);
        
        back.setOnAction((ActionEvent t) -> {
            pane.getChildren().clear();
            if(!edit){
                new NHFC().start(primaryStage);
            }else {
                new PagePrincipal(primaryStage, pane, scene, user);
            }
            
        });
        
        connected.setOnAction((ActionEvent event) -> {
            if(
                verificationText(lastName, "Nom", pane, edit) &&
                verificationText(firstName, "Prénom", pane,edit) &&
                verificationNumber(age, "Age", pane, 99, edit) &&
                verificationNumber(weight, "Poids", pane, 140,edit) &&
                verificationNumber(height, "Taille", pane, 200,edit)&&
                isEmailAdress(email,pane,edit) &&
                verificationPwd(password, pwdConfirm, pane,edit))
            {
                if(!edit){
                    User user1 = new User(lastName.getText(), firstName.getText(), email.getText(), Integer.parseInt(age.getText()), Integer.parseInt(weight.getText()), Integer.parseInt(height.getText()), logintext.getText(), password.getText(), "homme"); 
                    if(user.creerCompte(user)){
                        pane.getChildren().clear();
                        new PagePrincipal(primaryStage, pane, scene,user1); 
                    } 
                }else {
                    user.setAge(Integer.parseInt(age.getText()));
                    user.setLastname(firstName.getText());
                    user.setEmail(email.getText());
                    user.setPoids( Float.parseFloat(weight.getText()));
                    user.setTaille( Float.parseFloat(height.getText()));
                    user.setMdp(password.getText());
                    if(user.modifierCompte(user)){
                        pane.getChildren().clear();
                        new PagePrincipal(primaryStage, pane, scene,user);
                    }
                }
            }
        });
    }
     
    public boolean verificationPwd(PasswordField pwd, PasswordField pwdConfirm, GridPane pane, Boolean edit){
        if(pwd.getText().isEmpty() && edit){
            return true;
        }
        if( pwd.getText().isEmpty() || !pwd.getText().equals(pwdConfirm.getText()))
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

    public boolean isEmailAdress(TextField email, GridPane pane, Boolean edit){
        Label error = new Label("Erreur email");
        if(email.getText().isEmpty() && edit){
            return true;
        }
        if (!email.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+") 
                || email.getText().isEmpty()) {
            pane.add(error, 0, 15);
            return false;
        }else {
            return true;
        }
    };
    
    public boolean verificationText(TextField text, String name, GridPane pane, Boolean edit){
        Label error = new Label("Erreur dans le champs " + name);
        if(text.getText().isEmpty() && !edit){
            pane.add(error, 0, 16);
            return false;
        } else {
            return true; 
        }
    };
    
    public boolean verificationNumber(TextField number, String name, GridPane pane, int maxLength, Boolean edit){
        Label error = new Label("Erreur dans le champs " + name);
        
        if(number.getText().isEmpty() && edit){
            return true;
        }
        if(!number.getText().isEmpty() && number.getText().matches("\\d*\\.?\\d*") && Float.parseFloat(number.getText()) < maxLength){
            return true; 
        } else {
           pane.add(error, 0, 16);
            return false; 
        }
    };
}
