/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Clelia
 */
public class Database {
    
    private static Database dbIsntance;
    private static Connection con ;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static Database getInstance() throws Exception{
        if(dbIsntance==null){
            dbIsntance= new Database();
        }
        return dbIsntance;
    }
  
    public Connection getConnection() {
        if(con ==null){
            try {
                String url = "jdbc:mysql://localhost/nhfc?";
                String dbName = "Clelia";
                String passwd = "clelia";

                con = DriverManager.getConnection(url+ "user=" + dbName+ "&password=" + passwd);
                return con;
               
            } catch (SQLException ex) {
            }
        }
        return null;   
    } 
    
    static void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
    // il se connecte et existe
    public User loginRight(User loginUser){
        User user = null;
        try {
            String query="Select * from users Where login='" + loginUser.getLogin()+ "'";
            String sql = "Update users set connecté=1 where login='" + loginUser.getLogin()+ "'";
            Connection con = Database.getInstance().getConnection();
            stmt = con.createStatement();
            PreparedStatement myStmt = con.prepareStatement(sql);
            rs = stmt.executeQuery(query);
            
            int i = myStmt.executeUpdate();
            if(i>0){
                System.out.println("ça marche");
            }
            
            
            if(rs.next()){
                String name = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                float weight = rs.getFloat("weight");
                int height = rs.getInt("height");
                int age = rs.getInt("age");
                String login = rs.getString("login");
                String gender = rs.getString("gender");
                
                user = new User(name,lastname,email,age,weight,height,login,password, gender);
                return user;
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
    public boolean createUser(User user) throws Exception{
        String sql = "insert into users "
			+ " (firstname, lastname, email, weight, height, age, login, password, gender, idSport)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = Database.getInstance().getConnection();
        PreparedStatement myStmt = con.prepareStatement(sql);
        myStmt.setString(1, user.getName());
        myStmt.setString(2, user.getLastname());
        myStmt.setString(3, user.getEmail());
        myStmt.setFloat(4, user.getPoids());
        myStmt.setFloat(5, user.getTaille());
        myStmt.setInt(6, user.getAge());
        myStmt.setString(7, user.getLogin());
        myStmt.setString(8, user.getMdp());
        myStmt.setString(9, user.getGender());
        myStmt.setString(10, "1");
        
        boolean i = myStmt.execute();
        if(i){
            return true;
        }else {
            return false;
        }
    
    }
    
    public boolean updateUser(User user){
       	Connection con;
        try {
            System.out.println(user.getEmail());
            String sql = "UPDATE users" +" SET email=''"+ "Where login='" + user.getLogin()+ "'";
            con = Database.getInstance().getConnection();
            PreparedStatement myStmt = con.prepareStatement(sql);
             
            int i = myStmt.executeUpdate();
            if(i > 0){
                return true;
            }
            
            myStmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       	
    }
    
    
    public void deconnecté(User user){
            String sql = "Update users set connecté=0 where login='" + user.getLogin()+ "'";
            Connection con;
        try {
            con = Database.getInstance().getConnection();
            PreparedStatement myStmt = con.prepareStatement(sql);
            
            int i = myStmt.executeUpdate();
            if(i>0){
                System.out.println("ça marche");
            }
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }


}
