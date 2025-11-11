/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDatabase2;
import java.sql.*;
/**
 *
 * @author HaRIS
 */

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Javadatabase2 {
    private static final String URL = "jdbc:postgresql://localhost:5432/kuliah";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Kutisari13";
    
    public static void main(String[] args) {
        Connection conn = null;
        try {
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Berhasil");
        Mahasiswa m = new Mahasiswa ("09020624033", "Haris Sandy Setiawan");
        
        // INSERT
        String sql = "INSERT INTO mahasiswa (nim,nama) VALUES (?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,m.nim);
        ps.setString(2,m.nama);
       // ps.setInt(3,m.tahunMasuk);
        ps.executeUpdate();
        System.out.println("data berhasil dimasukkan");
        
        /*
        //UPDATE
        String updatesql = "UPDATE mahasiswa SET nama = ? WHERE nim = ? ";
        PreparedStatement updateps = conn.prepareStatement(updatesql);
        updateps.setString(1, "haris sandy setiawan");
        updateps.setString(2, m.nim);
        updateps.execute();
        System.out.println("Data Berhasil Di Update");
        
        //DELETE
        String deletesql = "DELETE FROM mahasiswa WHERE nim = ?";
        PreparedStatement deleteps = conn.prepareStatement (deletesql);
        deleteps.setString(1,m.nim);
        deleteps.execute();
        System.out.println("Data Berhasil di hapus");
        
*/
        conn.close();
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        Logger.getLogger(Javadatabase2.class.getName()).log(Level.SEVERE, null, ex);
        
            }
    }
}
