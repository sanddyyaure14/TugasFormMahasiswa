/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HaRIS
 */
public class mahasiswa {
  protected String nim,nama;
  protected int id;
  
  mahasiswa (){
      
  }
  
  mahasiswa (String nama, String nim){
     // this.id =id;
      this.nim = nim;
      this.nama = nama;
  }
  
  public void insert (){
       try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)"
            );
            pst.setString(1, nama);
            pst.setString(2, nim);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  }
  
  public  mahasiswa (int id){
      this.id = id;
  }
  
  public void delete (){
        try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement("DELETE FROM mahasiswa WHERE id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
     //       loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
  }
  
    public mahasiswa (int id, String nim, String nama){
      this.id = id;
      this.nama = nama;
      this.nim = nim;
  }
  public void update (){
      try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement(
                "UPDATE mahasiswa SET nama=?, nim=? WHERE id=?"
            );
            pst.setString(1, nama);
            pst.setString(2, nim);
            pst.setInt(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
           // loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
  }
}
