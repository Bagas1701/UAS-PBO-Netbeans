/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */
public class Satpam extends Pegawai {
    private String tugas;

    // Constructor dengan parameter
    public Satpam(int id, String nama, String nip, String gaji, String alamat) {
        super(id, nama, nip, gaji, alamat, "Satpam");
        this.tugas = "Menjaga keamanan di dalam dan di luar restoran";
    }

    // Constructor tanpa parameter (default)
    public Satpam() {
        super();
        this.setProfesi("Satpam");
        this.tugas = "Menjaga keamanan di dalam dan di luar restoran";
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
