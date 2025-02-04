/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */
public class Manager extends Pegawai {
    private String tugas;

    // Constructor dengan parameter
    public Manager(int id, String nama, String nip, String gaji, String alamat) {
        super(id, nama, nip, gaji, alamat, "Manager");
        this.tugas = "Mengelola seluruh aktivitas restoran";
    }

    // Constructor tanpa parameter (default)
    public Manager() {
        super();
        this.setProfesi("Manager");
        this.tugas = "Mengelola seluruh aktivitas restoran";
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


