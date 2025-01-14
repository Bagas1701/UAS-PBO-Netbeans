/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dizzay
 */
public class Koneksi {
    
    private static Connection mysqlkonek;
    
    public static Connection koneksiDB() {
        if(mysqlkonek==null){
            try {
                String nama_database = "project_data_karyawan"; // nama database
                String DB="jdbc:mysql://localhost:3306/"+nama_database;
                String user="root"; // user 
                String pass=""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, pastikan MySQL berjalan !");
            }
        }
        return mysqlkonek;
    }
}
