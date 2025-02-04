/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */
public class Koki extends Pegawai {
    private String tugas;

    // Constructor dengan parameter
    public Koki(int id, String nama, String nip, String gaji, String alamat) {
        super(id, nama, nip, gaji, alamat, "Koki");
        this.tugas = "Memasak makanan dan membuat minuman";
    }

    // Constructor tanpa parameter (default)
    public Koki() {
        super();
        this.setProfesi("Koki");
        this.tugas = "Memasak makanan dan membuat minuman";
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
