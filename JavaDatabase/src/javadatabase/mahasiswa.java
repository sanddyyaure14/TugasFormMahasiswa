/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author HaRIS
 */
public class mahasiswa {
  private String nim,nama;
  private int id;
  private int sks;
  private String jenis_mahasiswa;
  private double biaya_kuliah;
  
  
  mahasiswa (){  
  }
  
  mahasiswa (String nama, String nim, String jenis_mahasiswa, int sks){
      this.nim = nim;
      this.nama = nama;
      this.jenis_mahasiswa = jenis_mahasiswa;
      this.sks = sks;
  }
  
  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_mahasiswa() {
        return jenis_mahasiswa;
    }

    public void setJenis_mahasiswa(String jenis_mahasiswa) {
        this.jenis_mahasiswa = jenis_mahasiswa;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public double getBiaya_Kuliah() {
        return biaya_kuliah;
    }

    public void setBiaya_Kuliah(double biaya_kuliah) {
        this.biaya_kuliah = biaya_kuliah;
    }
  
  public double hitungBiayaKuliah() {
    return 0; 
}

  
  
  
  
  
  
  
  
  
  public void insert (){
       try {
            Connection con = DbConnection.connect();
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO mahasiswa (nama, nim, jenis_mahasiswa, sks, biaya_kuliah) VALUES (?, ?, ?, ?, ?)"
            );
            pst.setString(1, getNama());
            pst.setString(2, getNim());
            pst.setString(3, getJenis_mahasiswa());
            pst.setInt(4, getSks());
            pst.setDouble(5, getBiaya_Kuliah());
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
 public void update() {
    try {
        Connection con = DbConnection.connect();
        PreparedStatement pst = con.prepareStatement(
            "UPDATE mahasiswa SET nama=?, nim=?, jenis_mahasiswa=?, sks=? WHERE id=?"
        );
        pst.setString(1, nama);                  
        pst.setString(2, nim);                 
        pst.setString(3, jenis_mahasiswa);     
        pst.setInt(4, sks);                     
        pst.setInt(5, id);                      
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

  
  mahasiswa (String nama, String nim){
     // this.id =id;
      this.nim = nim;
      this.nama = nama;
  }
  
  public static void importFromCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 0;
            int inserted = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;

                // skip header
                if (lineNo == 1 && line.toLowerCase().contains("nama")) continue;

                String[] data = line.split(",");
                if (data.length < 2) {
                    System.out.println("Baris " + lineNo + " tidak valid: " + line);
                    continue;
                }

                String nama = data[0].trim();
                String nim = data[1].trim();

                mahasiswa m = new mahasiswa(nama, nim);
                m.insert();
                inserted++;
            }

            JOptionPane.showMessageDialog(null, 
                "Upload CSV selesai! Data ditambahkan: " + inserted + " baris.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal membaca file CSV: " + e.getMessage());
        }
    }
}

