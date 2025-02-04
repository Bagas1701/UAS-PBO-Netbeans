/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */
public class Kasir extends Pegawai {
    private String tugas; // Tambahkan atribut untuk tugas jika belum ada

    // Constructor dengan parameter
    public Kasir(int id, String nama, String nip, String gaji, String alamat) {
        super(id, nama, nip, gaji, alamat, "Kasir");
        this.tugas = "Melakukan semua transaksi penjualan dengan pembeli";
    }

    // Constructor tanpa parameter (default)
    public Kasir() {
        super(); // Panggil constructor default dari superclass
        this.setProfesi("Kasir");
        this.tugas = "Melakukan semua transaksi penjualan dengan pembeli";
    }

    @Override
    public void tugas() {
        System.out.println(tugas); // Outputkan tugas
    }

    // Setter untuk tugas
    public void setTugas(String tugas) {
        this.tugas = tugas;
    }

    // Getter untuk tugas (opsional jika diperlukan)
    public String getTugas() {
        return this.tugas;
    }
}

