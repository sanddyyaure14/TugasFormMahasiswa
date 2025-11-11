/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaDatabase2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javadatabase.DbConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author HaRIS
 */
public class Mahasiswa {
  protected String id,nim,nama;
 // protected int tahunMasuk;
  
  Mahasiswa (String nim, String nama){
     // this.id =id;
      this.nim = nim;
      this.nama = nama;
     // this.tahunMasuk = tahunMasuk;
  }
  
  Mahasiswa (){
      
  }
  
  
}
