/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Evan Henderson
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    static Scanner in = new Scanner(System.in);
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    public MainGUI() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pplbo_quiz2", "root", "");
            System.out.println("Connected to database");
            st = conn.createStatement();
        } catch (Exception e) {
        }
        initComponents();
        this.tampilDataMahasiswa();
    }

    public String deleteMahasiswa(String nim) {
        try {
            System.out.println(String.format("DELETE FROM mahasiswa WHERE nim = '%s'", nim));
            st.executeUpdate(String.format("DELETE FROM mahasiswa WHERE nim = '%s'", nim));
            System.out.println("Data mahasiswa telah dihapus");
            this.tampilDataMahasiswa();
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dihapus, pastikan nim telah sesuai dan nilai yang dimiliki kosong!");
        }
        return nim;
    }

    public void tampilDataMahasiswa() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            rs = st.executeQuery("SELECT nim,nama,no_presensi,nama_kelas FROM mahasiswa JOIN kelas ON kelas.id_kelas = mahasiswa.id_kelas ORDER BY mahasiswa.id_kelas, mahasiswa.nama");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("no_presensi"),
                    rs.getString("nama_kelas"),});
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
        this.tabelMahasiswa.setModel(model);
    }

    public void tampilDataDosen() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            rs = st.executeQuery("SELECT * FROM dosen");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_dosen"),
                    rs.getString("nama_dosen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
        this.tabelMahasiswa.setModel(model);
    }

    public void tampilDataNilai() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            rs = st.executeQuery("SELECT * FROM nilai");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_data_nilai"),
                    rs.getString("nim"),
                    rs.getInt("id_matkul"),
                    rs.getFloat("tugas1"),
                    rs.getFloat("tugas2"),
                    rs.getFloat("tugas3"),
                    rs.getFloat("tugas4"),
                    rs.getFloat("tugas5"),
                    rs.getFloat("quiz1"),
                    rs.getFloat("quiz2"),
                    rs.getFloat("uts"),
                    rs.getFloat("uas"),
                    rs.getFloat("total_nilai")
                });
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
        this.tabelMahasiswa.setModel(model);
    }

    public void tampilDataKelas() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            rs = st.executeQuery("SELECT * FROM kelas");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_kelas"),
                    rs.getString("nama_kelas")
                });
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
        this.tabelMahasiswa.setModel(model);
    }

    public void tampilDataMatkul() {
        DefaultTableModel model = new DefaultTableModel();
        try {
            rs = st.executeQuery("SELECT id_matkul,nama_matkul,nama_dosen FROM matkul JOIN dosen ON matkul.id_dosen = dosen.id_dosen");
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_matkul"),
                    rs.getString("nama_matkul"),
                    rs.getString("nama_dosen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
        this.tabelMahasiswa.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tabelMahasiswa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sidebarMahasiswa = new javax.swing.JButton();
        sidebarDosen = new javax.swing.JButton();
        sidebarNilai = new javax.swing.JButton();
        sidebarMatkul = new javax.swing.JButton();
        sidebarKelas = new javax.swing.JButton();
        plusMHS = new javax.swing.JButton();
        plusDSN = new javax.swing.JButton();
        plusN = new javax.swing.JButton();
        plusKLS = new javax.swing.JButton();
        plusMK = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Penilaian Mahasiswa");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        getContentPane().setLayout(null);

        tabelMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelMahasiswa.setToolTipText("");
        jScrollPane2.setViewportView(tabelMahasiswa);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(160, 30, 710, 240);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        sidebarMahasiswa.setText("Mahasiswa");
        sidebarMahasiswa.setBorder(null);
        sidebarMahasiswa.setBorderPainted(false);
        sidebarMahasiswa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMahasiswaActionPerformed(evt);
            }
        });

        sidebarDosen.setText("Dosen");
        sidebarDosen.setBorder(null);
        sidebarDosen.setBorderPainted(false);
        sidebarDosen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarDosenActionPerformed(evt);
            }
        });

        sidebarNilai.setText("Nilai");
        sidebarNilai.setBorder(null);
        sidebarNilai.setBorderPainted(false);
        sidebarNilai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarNilaiActionPerformed(evt);
            }
        });

        sidebarMatkul.setText("Matkul");
        sidebarMatkul.setBorder(null);
        sidebarMatkul.setBorderPainted(false);
        sidebarMatkul.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarMatkulActionPerformed(evt);
            }
        });

        sidebarKelas.setText("Kelas");
        sidebarKelas.setBorder(null);
        sidebarKelas.setBorderPainted(false);
        sidebarKelas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sidebarKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sidebarKelasActionPerformed(evt);
            }
        });

        plusMHS.setText("+");
        plusMHS.setBorder(null);
        plusMHS.setBorderPainted(false);
        plusMHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusMHSActionPerformed(evt);
            }
        });

        plusDSN.setText("+");
        plusDSN.setBorder(null);
        plusDSN.setBorderPainted(false);
        plusDSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusDSNActionPerformed(evt);
            }
        });

        plusN.setText("+");
        plusN.setBorder(null);
        plusN.setBorderPainted(false);
        plusN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusNActionPerformed(evt);
            }
        });

        plusKLS.setText("+");
        plusKLS.setBorder(null);
        plusKLS.setBorderPainted(false);
        plusKLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusKLSActionPerformed(evt);
            }
        });

        plusMK.setText("+");
        plusMK.setBorder(null);
        plusMK.setBorderPainted(false);
        plusMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusMKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sidebarDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusDSN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sidebarNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(plusN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(sidebarMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plusMK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(sidebarKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(plusKLS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(sidebarMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(plusMHS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidebarMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusMHS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidebarDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusDSN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidebarNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidebarKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusKLS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sidebarMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plusMK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 130, 180);

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 911, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void sidebarMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMahasiswaActionPerformed
        // TODO add your handling code here:
        this.tampilDataMahasiswa();
    }//GEN-LAST:event_sidebarMahasiswaActionPerformed

    private void sidebarNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarNilaiActionPerformed
        // TODO add your handling code here:
        this.tampilDataNilai();
    }//GEN-LAST:event_sidebarNilaiActionPerformed

    private void sidebarMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMatkulActionPerformed
        // TODO add your handling code here:
        this.tampilDataMatkul();
    }//GEN-LAST:event_sidebarMatkulActionPerformed

    private void sidebarKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarKelasActionPerformed
        // TODO add your handling code here:
        this.tampilDataKelas();
    }//GEN-LAST:event_sidebarKelasActionPerformed

    private void sidebarDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarDosenActionPerformed
        // TODO add your handling code here:
        this.tampilDataDosen();
    }//GEN-LAST:event_sidebarDosenActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void plusMHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusMHSActionPerformed
        // TODO add your handling code here:
        new AddMahasiswa().setVisible(true);
    }//GEN-LAST:event_plusMHSActionPerformed

    private void plusDSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusDSNActionPerformed
        // TODO add your handling code here:
        new AddDosen().setVisible(true);
    }//GEN-LAST:event_plusDSNActionPerformed

    private void plusNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusNActionPerformed
        // TODO add your handling code here:
        new AddNilai().setVisible(true);
    }//GEN-LAST:event_plusNActionPerformed

    private void plusKLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusKLSActionPerformed
        // TODO add your handling code here:
        new AddKelas().setVisible(true);
    }//GEN-LAST:event_plusKLSActionPerformed

    private void plusMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusMKActionPerformed
        // TODO add your handling code here:
        new AddMatkul().setVisible(true);
    }//GEN-LAST:event_plusMKActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton plusDSN;
    private javax.swing.JButton plusKLS;
    private javax.swing.JButton plusMHS;
    private javax.swing.JButton plusMK;
    private javax.swing.JButton plusN;
    private javax.swing.JButton sidebarDosen;
    private javax.swing.JButton sidebarKelas;
    private javax.swing.JButton sidebarMahasiswa;
    private javax.swing.JButton sidebarMatkul;
    private javax.swing.JButton sidebarNilai;
    private javax.swing.JTable tabelMahasiswa;
    // End of variables declaration//GEN-END:variables
}
