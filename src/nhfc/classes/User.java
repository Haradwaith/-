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
    private String name,lastname,email, gender; 
    private int age, idCompteUser; 
    private float poids, taille,imcActuelle;
    private List<Sport> Sport;
    private final String login;
    private String mdp;
    private Boolean connecté;
    
    public User(String login, String passwd) {
        this.login = login;
        this.mdp = passwd;
    }
    
    public User(String name, String lastname, String email, int age, float poids, float taille, String login, String mdp, String gender) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.poids = poids;
        this.taille = taille;
        this.login = login;
        this.mdp = mdp;
        this.gender = gender;
    }
    
    public Boolean getConnecté() {
        return connecté;
    }

    public void setConnecté(Boolean connecté) {
        this.connecté = connecté;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getMdp() {
        return mdp;
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
    
    public User connecterCompte(){
        User user = null;
        try {
            user = Database.getInstance().loginRight(this);
            return user;
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }
    
    public boolean modifierCompte(User user){
        try {
            System.out.println(user.getAge());
            return Database.getInstance().updateUser(user);
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean creerCompte(User user){
        try {
            return Database.getInstance().createUser(user);
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
 
    
}
