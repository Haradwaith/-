/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public boolean loginRight(User user){
        try {
            System.out.println(user.getLogin());
            String query="Select * from users Where login='" + user.getLogin()+ "'";
            Connection con = Database.getInstance().getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            
            if(rs.next()){
                System.out.println(rs.getString("Firstname"));
                return true;
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

}
