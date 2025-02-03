/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */

public class Pegawai {

    // Deklarasi enum di dalam kelas Pegawai
   public enum Profesi {
        MANAGER,
        KASIR,
        KOKI,
        PELAYAN,
        SATPAM
    }

    // Properti kelas Pegawai
    private int id;
    private String nama;
    private String nip;
    private String gaji;
    private String alamat;
    private Profesi profesi; // Properti tipe enum Profesi

    // Konstruktor kosong
    public Pegawai() {
    }

    // Konstruktor dengan parameter
    public Pegawai(int id, String nama, String nip, String gaji, String alamat, Profesi profesi) {
        this.id = id;
        this.nama = nama;
        this.nip = nip;
        this.gaji = gaji;
        this.alamat = alamat;
        this.profesi = profesi;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Profesi getProfesi() {
        return profesi;
    }

    public void setProfesi(Profesi profesi) {
        this.profesi = profesi;
    }
}
