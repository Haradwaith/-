/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clelia
 */
public class User {
    private String name,lastname,email; 
    private int age, id; 
    private float poids, taille,imcActuelle;
    private List<Sport> Sport;
    private final String login;
    private int idCompteUser;
    private String password;
    
    public User(String login, String passwd) {
        this.login = login;
        this.password = passwd;
    }

    public String getLogin() {
        return login;
    }

    public int getIdCompteUser() {
        return idCompteUser;
    }

    public void setIdCompteUser(int idCompteUser) {
        this.idCompteUser = idCompteUser;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getImcActuelle() {
        return imcActuelle;
    }

    public void setImcActuelle(float imcActuelle) {
        this.imcActuelle = imcActuelle;
    }

    public List<Sport> getSport() {
        return Sport;
    }

    public void setSport(List<Sport> Sport) {
        this.Sport = Sport;
    }
    
    
    public void choisirSport(Sport sp){
        
    }
    
    public boolean connecterCompte(){
        try {
             System.out.println(Database.getInstance().loginRight(this));
            return true;
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public void modifierCompte(){
        
    }
    
    public void creerCompte(){
        
    }
 
    
}
