/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubp.manager;

import com.ubp.config.Koneksi;
import com.ubp.model.KaryawanModel;
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
public class KaryawanManager {
    
    private final Connection koneksiDatabase;

    public KaryawanManager() {
        this.koneksiDatabase = Koneksi.koneksiDB();
    }
    
    public List<KaryawanModel> tampilSemua(){
        String namaTable = "karyawan";
        String query = "SELECT * FROM "+namaTable;
        KaryawanModel model;
        List<KaryawanModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new KaryawanModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setNik(hasilQuery.getString("nik"));
                model.setGaji(hasilQuery.getString("gaji"));
                model.setAlamat(hasilQuery.getString("alamat"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public KaryawanModel byId(int id){
        String namaTable = "karyawan";
        String query = "SELECT * FROM "+namaTable+" WHERE id = "+id;
        KaryawanModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new KaryawanModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setNik(hasilQuery.getString("nik"));
                model.setGaji(hasilQuery.getString("gaji"));
                model.setAlamat(hasilQuery.getString("alamat"));
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
    
    public boolean insert(String nama, String nik, String gaji, String alamat) {
        String namaTable = "karyawan";
        String query = "INSERT INTO "+namaTable+" (`nama`, `nik`, `gaji`, `alamat`) VALUES ('"+nama+"', '"+nik+"','"+gaji+"', '"+alamat+"');";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean update(String nama, String nik, String gaji, String alamat, int id) {
        String namaTable = "karyawan";
        String query = "UPDATE "+namaTable+" SET `nama`='"+nama+"', `nik`='"+nik+"', `gaji`='"+gaji+"', `alamat`='"+alamat+"'  WHERE  `id`="+id+";";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(String id) {
        String namaTable = "karyawan";
        String query = "DELETE FROM "+namaTable+" WHERE id = "+id;
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KaryawanManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}