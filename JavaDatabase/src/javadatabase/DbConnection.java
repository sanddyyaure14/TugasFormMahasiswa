/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Yusuf
 */
public class DbConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/kuliah";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Kutisari13";
    
    
    
    public DbConnection(){
        
    }
    
    public static Connection connect(){
        try {
             Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
