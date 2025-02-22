/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dataPegawaiTampilan;

import Login.LoginUI;
import dataPegawaiTampilan.KasirUI;
import dataPegawaiTampilan.KokiUI;
import dataPegawaiTampilan.ManagerUI;
import dataPegawaiTampilan.PelayanUI;
import dataPegawaiTampilan.SatpamUI;
import projectdatapegawai.ProjectDataPegawai;
import datapegawaimodel.Pegawai;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Bagas Yoas
 */
public class PegawaiUI extends javax.swing.JFrame {

    /**
     * Creates new form PegawaiUI
     */
    DefaultTableModel tableModel;
    ProjectDataPegawai ProjectDataPegawai;
    boolean sedangDiEdit = false;

    public PegawaiUI() {
        initComponents();
        setTitle("Pegawai UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Agar form muncul di tengah layar
        
        this.ProjectDataPegawai = new ProjectDataPegawai();
        tampilDataTable();
    }

    private void tampilDataTable() {
    String[] kolom = {"ID", "Nama", "NIP", "Gaji", "Alamat", "Profesi"};
    tableModel = new DefaultTableModel(null, kolom);

    for (Pegawai model : ProjectDataPegawai.tampilSemua()) {
        String[] row = new String[kolom.length];
        row[0] = String.valueOf(model.getId());
        row[1] = model.getNama();
        row[2] = model.getNip();
        row[3] = model.getGaji();
        row[4] = model.getAlamat();
        row[5] = model.getProfesi(); // Tambahkan profesi

        tableModel.addRow(row);
    }

    tbl_pegawai.setModel(tableModel);
    tbl_pegawai.clearSelection();
}


    private void refresh() {
        tampilDataTable();
        clearData();
        sedangDiEdit = false;
    }

    private void clearData() {
        tf_nama.setText("");
        tf_nip.setText("");
        tf_gaji.setText("");
        tf_alamat.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_nip = new javax.swing.JTextField();
        tf_gaji = new javax.swing.JTextField();
        tf_alamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_profesi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pegawai = new javax.swing.JTable();
        bt_simpan = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_refresh = new javax.swing.JButton();
        bt_manager = new javax.swing.JButton();
        bt_kasir = new javax.swing.JButton();
        bt_koki = new javax.swing.JButton();
        bt_pelayan = new javax.swing.JButton();
        bt_Satpam = new javax.swing.JButton();
        bt_logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(34, 45, 73));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PEGAWAI RESTORAN");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIP");

        tf_nip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nipActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gaji");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Alamat");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Profesi");

        cb_profesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Kasir", "Koki", "Pelayan", "Satpam" }));

        tbl_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pegawai);

        bt_simpan.setText("Simpan");
        bt_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_simpanMouseClicked(evt);
            }
        });

        bt_hapus.setText("Hapus");
        bt_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_hapusMouseClicked(evt);
            }
        });

        bt_refresh.setText("Refresh");
        bt_refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_refreshMouseClicked(evt);
            }
        });
        bt_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refreshActionPerformed(evt);
            }
        });

        bt_manager.setText("Manager");
        bt_manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_managerActionPerformed(evt);
            }
        });

        bt_kasir.setText("Kasir");
        bt_kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kasirActionPerformed(evt);
            }
        });

        bt_koki.setText("Koki");
        bt_koki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kokiActionPerformed(evt);
            }
        });

        bt_pelayan.setText("Pelayan");
        bt_pelayan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pelayanActionPerformed(evt);
            }
        });

        bt_Satpam.setText("Satpam");
        bt_Satpam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SatpamActionPerformed(evt);
            }
        });

        bt_logout.setText("Logout");
        bt_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_logoutMouseClicked(evt);
            }
        });
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_nama)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_nip, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(tf_gaji, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(tf_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_profesi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(bt_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(bt_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bt_manager, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(bt_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(bt_koki, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_pelayan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(bt_Satpam)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_logout)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_manager)
                            .addComponent(bt_kasir)
                            .addComponent(bt_koki)
                            .addComponent(bt_pelayan)
                            .addComponent(bt_Satpam))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(tf_gaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_profesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_hapus)
                            .addComponent(bt_simpan))
                        .addGap(18, 18, 18)
                        .addComponent(bt_refresh)
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nipActionPerformed

    private void bt_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_refreshActionPerformed

    private void bt_managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_managerActionPerformed
        // TODO add your handling code here:
        this.toBack();
        ManagerUI mng= new ManagerUI();
        mng.setVisible(true);
        mng.toFront();
    }//GEN-LAST:event_bt_managerActionPerformed

    private void bt_kasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kasirActionPerformed
        // TODO add your handling code here:
        this.toBack();
        KasirUI ksr= new KasirUI();
        ksr.setVisible(true);
        ksr.toFront();
    }//GEN-LAST:event_bt_kasirActionPerformed

    private void bt_kokiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kokiActionPerformed
        // TODO add your handling code here:
        this.toBack();
        KokiUI kk= new KokiUI();
        kk.setVisible(true);
        kk.toFront();
    }//GEN-LAST:event_bt_kokiActionPerformed

    private void bt_pelayanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pelayanActionPerformed
        // TODO add your handling code here:
        this.toBack();
        PelayanUI pln= new PelayanUI();
        pln.setVisible(true);
        pln.toFront();
    }//GEN-LAST:event_bt_pelayanActionPerformed

    private void bt_SatpamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SatpamActionPerformed
        // TODO add your handling code here:
        this.toBack();
        SatpamUI spm= new SatpamUI();
        spm.setVisible(true);
        spm.toFront();
    }//GEN-LAST:event_bt_SatpamActionPerformed

    private void bt_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_simpanMouseClicked
        // TODO add your handling code here:
        String nama = tf_nama.getText();
        String nip = tf_nip.getText();
        String gaji = tf_gaji.getText();
        String alamat = tf_alamat.getText();
        int idProfesi = cb_profesi.getSelectedIndex() + 1; // Pastikan ID sesuai dengan tabel profesi

        if (!nama.isEmpty() && !nip.isEmpty() && !gaji.isEmpty() && !alamat.isEmpty()) {
            if (sedangDiEdit) {
                String id = (String) tbl_pegawai.getValueAt(tbl_pegawai.getSelectedRow(), 0);
                ProjectDataPegawai.update(nama, nip, gaji, alamat, idProfesi, Integer.parseInt(id));
            } else {
                ProjectDataPegawai.insert(nama, nip, gaji, alamat, idProfesi);
            }
            refresh();
        } else {
            JOptionPane.showMessageDialog(null, "Tidak boleh ada yang kosong!");
        }
    }//GEN-LAST:event_bt_simpanMouseClicked

    private void bt_refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_refreshMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_bt_refreshMouseClicked

    private void bt_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_hapusMouseClicked
        // TODO add your handling code here:
       int selectedRow = tbl_pegawai.getSelectedRow();
    
    if (selectedRow != -1) { // Pastikan ada baris yang dipilih
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                int idPegawai = (int) tbl_pegawai.getValueAt(selectedRow, 0); // Ambil ID sebagai int
                boolean success = ProjectDataPegawai.delete(idPegawai); // Panggil delete
                if (success) {
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    refresh(); // Refresh data di tabel
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data. Silakan coba lagi.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus!");
    }
    }//GEN-LAST:event_bt_hapusMouseClicked

    private void tbl_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pegawaiMouseClicked
        // TODO add your handling code here:
        sedangDiEdit = true;
        String id = (String) tbl_pegawai.getValueAt(tbl_pegawai.getSelectedRow(), 0);
        Pegawai model = ProjectDataPegawai.byId(Integer.valueOf(id));
        tf_nama.setText(model.getNama());
        tf_nip.setText(model.getNip());
        tf_gaji.setText(model.getGaji());
        tf_alamat.setText(model.getAlamat());
    }//GEN-LAST:event_tbl_pegawaiMouseClicked

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
      int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose(); // Tutup PegawaiUI
            LoginUI loginForm = new LoginUI();
            loginForm.setVisible(true);
            loginForm.setLocationRelativeTo(null); // Form login muncul di tengah
        }
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void bt_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_logoutMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_logoutMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PegawaiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PegawaiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PegawaiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PegawaiUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PegawaiUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Satpam;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_kasir;
    private javax.swing.JButton bt_koki;
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_manager;
    private javax.swing.JButton bt_pelayan;
    private javax.swing.JButton bt_refresh;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JComboBox<String> cb_profesi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_pegawai;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_gaji;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nip;
    // End of variables declaration//GEN-END:variables
 }
