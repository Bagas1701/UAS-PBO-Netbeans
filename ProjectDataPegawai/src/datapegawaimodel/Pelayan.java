/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */
public class Pelayan extends Pegawai {
    private String tugas;

    // Constructor dengan parameter
    public Pelayan(int id, String nama, String nip, String gaji, String alamat) {
        super(id, nama, nip, gaji, alamat, "Pelayan");
        this.tugas = "Melayani dan menyajikan pesanan pembeli";
    }

    // Constructor tanpa parameter (default)
    public Pelayan() {
        super();
        this.setProfesi("Pelayan");
        this.tugas = "Melayani dan menyajikan pesanan pembeli";
    }

    @Override
    public void tugas() {
        System.out.println(tugas);
    }

    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    public String getTugas() {
        return this.tugas;
    }
}
