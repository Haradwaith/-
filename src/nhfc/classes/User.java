/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import nhfc.classes.Sport;
import java.util.List;

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

    public void setPassword(String password) {
        this.password = password;
    }
    private int idCompteUser;
    private String password;
    
    public User(String login) {
        this.login = login;
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
    
    public void connecterCompte(){
        
    }
    
    public void déconnecterCompte(){
        
    }
    
    public void modifierCompte(){
        
    }
    
    public void creerCompte(){
        
    }
 
    
}
