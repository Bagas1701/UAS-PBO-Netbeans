/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Bagas Yoas
 */
public class koneksi {
    private static Connection mysqlkonek;
    
    public static Connection koneksiDB() {
        if(mysqlkonek==null){
            try {
                String nama_database = "pegawai_restoran"; // nama database
                String DB="jdbc:mysql://localhost:3306/"+nama_database;
                String user="root"; // user 
                String pass=""; // password database
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, pastikan MySQL berjalan !");
            }
        }
        return mysqlkonek;
    }
}
