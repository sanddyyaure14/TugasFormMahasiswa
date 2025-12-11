/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabase;

/**
 *
 * @author HaRIS
 */
public class MahasiswaInternasional extends mahasiswa{
    public MahasiswaInternasional(String nama, String nim, int sks) {
        super(nama, nim, "Internasional", sks);
    }
    
    @Override
    public double hitungBiayaKuliah() {
        return getSks() * 300000 + 5000000;
    }
}
