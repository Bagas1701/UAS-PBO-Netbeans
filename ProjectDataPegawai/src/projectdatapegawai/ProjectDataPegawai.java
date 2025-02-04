/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdatapegawai;


import controler.koneksi;
import datapegawaimodel.Pegawai;
import datapegawaimodel.Kasir;
import datapegawaimodel.Koki;
import datapegawaimodel.Manager;
import datapegawaimodel.Pelayan;
import datapegawaimodel.Satpam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

   
/**
 *
 * @author Bagas Yoas
 */

public class ProjectDataPegawai {

    private final Connection koneksiDatabase;

    public ProjectDataPegawai() {
        this.koneksiDatabase = koneksi.koneksiDB();
    }

    // Menampilkan semua pegawai
    public List<Pegawai> tampilSemua() {
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, p.gaji, p.Alamat, pr.nama_profesi " +
                       "FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi";
        List<Pegawai> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Pegawai model = createPegawaiInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("gaji"),
                    hasilQuery.getString("Alamat"),
                    hasilQuery.getString("nama_profesi")
                );
                list.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    // Mendapatkan pegawai berdasarkan ID
    public Pegawai byId(int id_pegawai) {
        String query = "SELECT p.*, pr.nama_profesi FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE id_pegawai = ?";
        Pegawai model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setInt(1, id_pegawai);
            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = createPegawaiInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("gaji"),
                    hasilQuery.getString("Alamat"),
                    hasilQuery.getString("nama_profesi")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }

    // Menambahkan data pegawai baru
    public boolean insert(String nama, String nip, String gaji, String alamat, int idProfesi) {
        String query = "INSERT INTO pegawai (Nama, NIP, gaji, Alamat, id_profesi) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nip);
            preparedStatement.setString(3, gaji);
            preparedStatement.setString(4, alamat);
            preparedStatement.setInt(5, idProfesi);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error inserting data", ex);
            return false;
        }
    }

    // Memperbarui data pegawai
    public boolean update(String nama, String nip, String gaji, String alamat, int idProfesi, int id_pegawai) {
        String query = "UPDATE pegawai SET nama = ?, nip = ?, gaji = ?, alamat = ?, id_profesi = ? WHERE id_pegawai = ?";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, nip);
        preparedStatement.setString(3, gaji);
        preparedStatement.setString(4, alamat);
        preparedStatement.setInt(5, idProfesi);
        preparedStatement.setInt(6, id_pegawai);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0; // Mengembalikan true jika ada baris yang diperbarui
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Mengembalikan false jika terjadi kesalahan
        }
    }

    // Menghapus data pegawai
    public boolean delete(int id_pegawai) {
        String query = "DELETE FROM pegawai WHERE id_pegawai = ?";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setInt(1, id_pegawai);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Mengembalikan true jika ada baris yang dihapus
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Mengembalikan false jika terjadi kesalahan
        }
    }

    // Membuat instance Pegawai
private Pegawai createPegawaiInstance(int idPegawai, String nama, String nip, String gaji, String alamat, String namaProfesi) {
    Pegawai pegawai = new Pegawai();
    pegawai.setIdPegawai(idPegawai);
    pegawai.setNama(nama);
    pegawai.setNip(nip);
    pegawai.setGaji(gaji);
    pegawai.setAlamat(alamat);
    pegawai.setNamaProfesi(namaProfesi);
    return pegawai;
}

// Menampilkan semua manager
    public List<Manager> tampilManager() {
        String query = "SELECT pegawai.id_pegawai, pegawai.Nama, pegawai.NIP, profesi.nama_profesi, profesi.tugas " +
               "FROM pegawai " +
               "JOIN profesi ON pegawai.id_profesi = profesi.id_profesi " +
               "WHERE profesi.nama_profesi = 'Manager'";

        List<Manager> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Manager model = createManagerInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("nama_profesi"),
                    hasilQuery.getString("tugas")
                );
                list.add((Manager) model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    
   // Mendapatkan manager berdasarkan ID
    public Manager mngId(int id_pegawai) {
        // Perbaiki query dengan menambahkan placeholder untuk id_pegawai
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, pr.nama_profesi, pr.tugas FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE pr.nama_profesi = 'Manager' AND p.id_pegawai = ?";
        Manager model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            // Set parameter id_pegawai ke dalam query
            preparedStatement.setInt(1, id_pegawai);

            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = createManagerInstance(
                    hasilQuery.getInt("id_pegawai"),  // id_pegawai
                    hasilQuery.getString("Nama"),      // Nama
                    hasilQuery.getString("NIP"),       // NIP
                    hasilQuery.getString("nama_profesi"), // profesi
                    hasilQuery.getString("tugas")      // tugas
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }


    private Manager createManagerInstance(int id, String nama, String nip, String namaProfesi, String tugas) {
    return new Manager(id, nama, nip, namaProfesi, tugas);
    }



// Menampilkan semua Koki
    public List<Koki> tampilKoki() {
        String query = "SELECT pegawai.id_pegawai, pegawai.Nama, pegawai.NIP, profesi.nama_profesi, profesi.tugas " +
               "FROM pegawai " +
               "JOIN profesi ON pegawai.id_profesi = profesi.id_profesi " +
               "WHERE profesi.nama_profesi = 'Koki'";

        List<Koki> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Koki model = createKokiInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("nama_profesi"),
                    hasilQuery.getString("tugas")
                );
                list.add((Koki) model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }
    
    // Mendapatkan kasir berdasarkan ID
    public Koki kkId(int id_pegawai) {
        // Perbaiki query dengan menambahkan placeholder untuk id_pegawai
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, pr.nama_profesi, pr.tugas FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE pr.nama_profesi = 'Koki' AND p.id_pegawai = ?";
        Koki kkmodel = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            // Set parameter id_pegawai ke dalam query
            preparedStatement.setInt(1, id_pegawai);

            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                kkmodel = createKokiInstance(
                    hasilQuery.getInt("id_pegawai"),  // id_pegawai
                    hasilQuery.getString("Nama"),      // Nama
                    hasilQuery.getString("NIP"),       // NIP
                    hasilQuery.getString("nama_profesi"), // profesi
                    hasilQuery.getString("tugas")      // tugas
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return kkmodel;
    }
    
    private Koki createKokiInstance(int id, String nama, String nip, String namaProfesi, String tugas) {
        return new Koki(id, nama, nip, namaProfesi, tugas);
        }
    
 // Menampilkan semua Kasir
    public List<Kasir> tampilKasir() {
        String query = "SELECT pegawai.id_pegawai, pegawai.Nama, pegawai.NIP, profesi.nama_profesi, profesi.tugas " +
               "FROM pegawai " +
               "JOIN profesi ON pegawai.id_profesi = profesi.id_profesi " +
               "WHERE profesi.nama_profesi = 'Kasir'";

        List<Kasir> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Kasir model = createKasirInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("nama_profesi"),
                    hasilQuery.getString("tugas")
                );
                list.add((Kasir) model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    // Mendapatkan kasir berdasarkan ID
    public Kasir ksrId(int id_pegawai) {
        // Perbaiki query dengan menambahkan placeholder untuk id_pegawai
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, pr.nama_profesi, pr.tugas FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE pr.nama_profesi = 'Kasir' AND p.id_pegawai = ?";
        Kasir model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            // Set parameter id_pegawai ke dalam query
            preparedStatement.setInt(1, id_pegawai);

            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = createKasirInstance(
                    hasilQuery.getInt("id_pegawai"),  // id_pegawai
                    hasilQuery.getString("Nama"),      // Nama
                    hasilQuery.getString("NIP"),       // NIP
                    hasilQuery.getString("nama_profesi"), // profesi
                    hasilQuery.getString("tugas")      // tugas
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }
    
    private Kasir createKasirInstance(int id, String nama, String nip, String namaProfesi, String tugas) {
        return new Kasir(id, nama, nip, namaProfesi, tugas);
        }
 
    // Menampilkan semua Pelayan
    public List<Pelayan> tampilPelayan() {
        String query = "SELECT pegawai.id_pegawai, pegawai.Nama, pegawai.NIP, profesi.nama_profesi, profesi.tugas " +
               "FROM pegawai " +
               "JOIN profesi ON pegawai.id_profesi = profesi.id_profesi " +
               "WHERE profesi.nama_profesi = 'Pelayan'";

        List<Pelayan> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Pelayan model = createPelayanInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("nama_profesi"),
                    hasilQuery.getString("tugas")
                );
                list.add((Pelayan) model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    // Mendapatkan kasir berdasarkan ID
    public Pelayan plnId(int id_pegawai) {
        // Perbaiki query dengan menambahkan placeholder untuk id_pegawai
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, pr.nama_profesi, pr.tugas FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE pr.nama_profesi = 'Pelayan' AND p.id_pegawai = ?";
        Pelayan model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            // Set parameter id_pegawai ke dalam query
            preparedStatement.setInt(1, id_pegawai);

            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = createPelayanInstance(
                    hasilQuery.getInt("id_pegawai"),  // id_pegawai
                    hasilQuery.getString("Nama"),      // Nama
                    hasilQuery.getString("NIP"),       // NIP
                    hasilQuery.getString("nama_profesi"), // profesi
                    hasilQuery.getString("tugas")      // tugas
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }
    
    private Pelayan createPelayanInstance(int id, String nama, String nip, String namaProfesi, String tugas) {
        return new Pelayan(id, nama, nip, namaProfesi, tugas);
        }
 
    // Menampilkan semua satpam
    public List<Satpam> tampilSatpam() {
        String query = "SELECT pegawai.id_pegawai, pegawai.Nama, pegawai.NIP, profesi.nama_profesi, profesi.tugas " +
               "FROM pegawai " +
               "JOIN profesi ON pegawai.id_profesi = profesi.id_profesi " +
               "WHERE profesi.nama_profesi = 'Satpam'";

        List<Satpam> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
             ResultSet hasilQuery = preparedStatement.executeQuery()) {
            
            while (hasilQuery.next()) {
                Satpam model = createSatpamInstance(
                    hasilQuery.getInt("id_pegawai"),
                    hasilQuery.getString("Nama"),
                    hasilQuery.getString("NIP"),
                    hasilQuery.getString("nama_profesi"),
                    hasilQuery.getString("tugas")
                );
                list.add((Satpam) model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    // Mendapatkan kasir berdasarkan ID
    public Satpam stmId(int id_pegawai) {
        // Perbaiki query dengan menambahkan placeholder untuk id_pegawai
        String query = "SELECT p.id_pegawai, p.Nama, p.NIP, pr.nama_profesi, pr.tugas FROM pegawai p JOIN profesi pr ON p.id_profesi = pr.id_profesi WHERE pr.nama_profesi = 'Satpam' AND p.id_pegawai = ?";
        Satpam model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            // Set parameter id_pegawai ke dalam query
            preparedStatement.setInt(1, id_pegawai);

            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = createSatpamInstance(
                    hasilQuery.getInt("id_pegawai"),  // id_pegawai
                    hasilQuery.getString("Nama"),      // Nama
                    hasilQuery.getString("NIP"),       // NIP
                    hasilQuery.getString("nama_profesi"), // profesi
                    hasilQuery.getString("tugas")      // tugas
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }
    
    private Satpam createSatpamInstance(int id, String nama, String nip, String namaProfesi, String tugas) {
        return new Satpam(id, nama, nip, namaProfesi, tugas);
        }
    
    
}