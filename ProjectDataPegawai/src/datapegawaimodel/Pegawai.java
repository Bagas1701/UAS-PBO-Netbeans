package datapegawaimodel;

/**
 *
 * @author Bagas Yoas
 */

public class Pegawai {
    protected int id;
    protected String nama;
    protected String nip;
    protected String gaji;
    protected String alamat;
    protected String profesi;

    public Pegawai(int id, String nama, String nip, String gaji, String alamat, String profesi) {
        this.id = id;
        this.nama = nama;
        this.nip = nip;
        this.gaji = gaji;
        this.alamat = alamat;
        this.profesi = profesi;
    }

    public Pegawai(int id, String nama, String nip, String gaji, String alamat) {
        this.id = id;
        this.nama = nama;
        this.nip = nip;
        this.gaji = gaji;
        this.alamat = alamat;
        this.profesi = "";
    }

    public Pegawai() {
        this.id = 0;
        this.nama = "";
        this.nip = "";
        this.gaji = "";
        this.alamat = "";
        this.profesi = "";
    }

    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNip() { return nip; }
    public void setNip(String nip) { this.nip = nip; }

    public String getGaji() { return gaji; }
    public void setGaji(String gaji) {
        if (Integer.parseInt(gaji) < 0) {
            throw new IllegalArgumentException("Gaji tidak boleh negatif!");
        }
        this.gaji = gaji;
    }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getProfesi() { return profesi; }
    public void setProfesi(String profesi) { this.profesi = profesi; }

    public void tugas() {
        System.out.println("Tugas umum sebagai pegawai restoran.");
    }

    public void setIdPegawai(int idPegawai) {
        this.id = idPegawai;
    }

    public void setNamaProfesi(String namaProfesi) {
        this.profesi = namaProfesi;
    }

    @Override
    public String toString() {
        return "Pegawai{" +
               "id=" + id +
               ", nama='" + nama + '\'' +
               ", nip='" + nip + '\'' +
               ", gaji='" + gaji + '\'' +
               ", alamat='" + alamat + '\'' +
               ", profesi='" + profesi + '\'' +
               '}';
    }
}
