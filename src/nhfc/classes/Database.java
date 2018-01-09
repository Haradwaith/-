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
  
    public Database() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/nhfc?"
                    + "user=Clelia&password=clelia");
            
            String requete = "SELECT * FROM users"; 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(requete);
           
            while (rs.next()) {
                System.out.print(rs.getString("FirstName"));
                System.out.print(" , ");
                System.out.println(rs.getString("LastName"));
            }
      
            // Do something with the Connection
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(rs != null){
                try {
                    rs.close();
                    rs =null;
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException ex) {
                    Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } 

}
