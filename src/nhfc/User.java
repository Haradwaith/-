/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

/**
 *
 * @author Clelia
 */
public class User {
    private String name,lastName, gender;
    private int Age;
    private float poid;
    private int id; 
    private final String login;         //ne pourra pas être modifier

    public User(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setPoid(int poid) {
        this.poid = poid;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return Age;
    }

    public float getPoid() {
        return poid;
    }
}
