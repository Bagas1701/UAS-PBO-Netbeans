/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdatapegawai;

//import com.ubp.config.Koneksi;
//import com.ubp.model.*;
import controler.koneksi;
import datapegawaimodel.Pegawai;
import datapegawaimodel.Pegawai.Profesi;
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
 * @author Dizzay
 */

public class ProjectDataPegawai {

    private final Connection koneksiDatabase;

    public ProjectDataPegawai() {
        this.koneksiDatabase = koneksi.koneksiDB();
    }

    // Menampilkan semua pegawai
    public List<Pegawai> tampilSemua() {
        String query = "SELECT * from pegawai";
        List<Pegawai> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            ResultSet hasilQuery = preparedStatement.executeQuery();

            while (hasilQuery.next()) {
                Pegawai model = new Pegawai();
                model.setId(hasilQuery.getInt("id_pegawai"));
                model.setNama(hasilQuery.getString("nama"));
                model.setNip(hasilQuery.getString("nip"));
                model.setGaji(hasilQuery.getString("gaji"));
                model.setAlamat(hasilQuery.getString("alamat"));
                model.setProfesi(Profesi.valueOf(hasilQuery.getString("profesi").toUpperCase())); // Konversi string ke enum
                list.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching all data", ex);
        }

        return list;
    }

    // Mendapatkan pegawai berdasarkan ID
    public Pegawai byId(int id_pegawai) {
        String query = "SELECT * FROM pegawai WHERE id_pegawai = ?";
        Pegawai model = null;

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setInt(1, id_pegawai);
            ResultSet hasilQuery = preparedStatement.executeQuery();

            if (hasilQuery.next()) {
                model = new Pegawai();
                model.setId(hasilQuery.getInt("id_pegawai"));
                model.setNama(hasilQuery.getString("nama"));
                model.setNip(hasilQuery.getString("nip"));
                model.setGaji(hasilQuery.getString("gaji"));
                model.setAlamat(hasilQuery.getString("alamat"));
                model.setProfesi(Profesi.valueOf(hasilQuery.getString("profesi").toUpperCase())); // Konversi string ke enum
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error fetching data by ID", ex);
        }

        return model;
    }

    // Menambahkan data pegawai baru
    public boolean insert(String nama, String nip, String gaji, String alamat, Profesi profesi) {
        String query = "INSERT INTO pegawai (nama, nip, gaji, alamat, profesi) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nip);
            preparedStatement.setString(3, gaji);
            preparedStatement.setString(4, alamat);
            preparedStatement.setString(5, profesi.name()); // Konversi enum ke string
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error inserting data", ex);
            return false;
        }
    }

    // Memperbarui data pegawai
    public boolean update(String nama, String nip, String gaji, String alamat, Profesi profesi, int id_pegawai) {
        String query = "UPDATE pegawai SET nama = ?, nip = ?, gaji = ?, alamat = ?, profesi = ? WHERE id_pegawai = ?";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, nip);
            preparedStatement.setString(3, gaji);
            preparedStatement.setString(4, alamat);
            preparedStatement.setString(5, profesi.name()); // Konversi enum ke string
            preparedStatement.setInt(6, id_pegawai);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error updating data", ex);
            return false;
        }
    }

    // Menghapus data pegawai berdasarkan ID
    public boolean delete(int id_pegawai) {
        String query = "DELETE FROM pegawai WHERE id_pegawai = ?";

        try (PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query)) {
            preparedStatement.setInt(1, id_pegawai);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDataPegawai.class.getName()).log(Level.SEVERE, "Error deleting data", ex);
            return false;
        }
    }

    public boolean update(String nama, String nik, String gaji, String alamat, String profesi, Integer id) {
    String query = "UPDATE pegawai SET nama = ?, nip = ?, gaji = ?, alamat = ?, profesi = ? WHERE id_pegawai = ?";
        try (PreparedStatement stmt = koneksiDatabase.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, nik);
            stmt.setString(3, gaji);
            stmt.setString(4, alamat);
            stmt.setString(5, profesi);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public void insert(String nama, String nip, String gaji, String alamat, String profesi) {
        String query = "INSERT INTO pegawai (nama, nip, gaji, alamat, profesi) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = koneksiDatabase.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, nip);
            stmt.setString(3, gaji);
            stmt.setString(4, alamat);
            stmt.setString(5, profesi);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(String id_pegawai) {
        String query = "DELETE FROM pegawai WHERE id_pegawai = ?";
        try (PreparedStatement stmt = koneksiDatabase.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(id_pegawai));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

    /*private Pegawai createPegawaiInstance(String profesi, int id, String nama, String nik, String gaji, String alamat) {
        return switch (profesi.toLowerCase()) {
            case "Manager" -> new manager(id, nama, nik, gaji, alamat);
            case "Pelayan" -> new pelayan(id, nama, nik, gaji, alamat);
            case "Satpam" -> new satpam(id, nama, nik, gaji, alamat);
            case "Kasir" -> new kasir(id, nama, nik, gaji, alamat);
            case "Koki" -> new koki(id, nama, nik, gaji, alamat);
            default -> new Pegawai(id, nama, nik, gaji, alamat, profesi);
        };
    }*/