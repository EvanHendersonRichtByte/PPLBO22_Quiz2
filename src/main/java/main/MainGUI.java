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

        inputMahasiswa = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nim1 = new javax.swing.JTextField();
        nama1 = new javax.swing.JTextField();
        kelas1 = new javax.swing.JTextField();
        submitTambahMahasiswa1 = new javax.swing.JButton();
        header1 = new javax.swing.JLabel();
        no_presensi1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelMahasiswa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        sidebarMahasiswa = new javax.swing.JButton();
        sidebarDosen = new javax.swing.JButton();
        sidebarNilai = new javax.swing.JButton();
        sidebarMatkul = new javax.swing.JButton();
        sidebarKelas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel5.setText("Kelas");

        jLabel6.setText("NIM");

        jLabel7.setText("Nama");

        jLabel8.setText("No Presensi");

        nim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nim1ActionPerformed(evt);
            }
        });

        kelas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelas1ActionPerformed(evt);
            }
        });

        submitTambahMahasiswa1.setText("Submit");
        submitTambahMahasiswa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitTambahMahasiswa1ActionPerformed(evt);
            }
        });

        header1.setText("Tambah Mahasiswa");

        no_presensi1.setActionCommand("<Not Set>");
        no_presensi1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout inputMahasiswaLayout = new javax.swing.GroupLayout(inputMahasiswa.getContentPane());
        inputMahasiswa.getContentPane().setLayout(inputMahasiswaLayout);
        inputMahasiswaLayout.setHorizontalGroup(
            inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputMahasiswaLayout.createSequentialGroup()
                .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputMahasiswaLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(no_presensi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputMahasiswaLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(header1)))
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputMahasiswaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputMahasiswaLayout.createSequentialGroup()
                        .addComponent(submitTambahMahasiswa1)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputMahasiswaLayout.createSequentialGroup()
                        .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(nim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        inputMahasiswaLayout.setVerticalGroup(
            inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputMahasiswaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(submitTambahMahasiswa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(header1)
                .addGap(61, 61, 61)
                .addComponent(kelas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(no_presensi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(nim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(inputMahasiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(inputMahasiswaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(nama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

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
        jScrollPane2.setBounds(160, 30, 452, 240);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebarDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidebarMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidebarMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sidebarMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 120, 180);

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

        setBounds(0, 0, 669, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void sidebarMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMahasiswaActionPerformed
        // TODO add your handling code here:
        this.tampilDataMahasiswa();
        new AddMahasiswa().setVisible(true);
    }//GEN-LAST:event_sidebarMahasiswaActionPerformed

    private void sidebarNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarNilaiActionPerformed
        // TODO add your handling code here:
        this.tampilDataNilai();
        new AddNilai().setVisible(true);
    }//GEN-LAST:event_sidebarNilaiActionPerformed

    private void sidebarMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarMatkulActionPerformed
        // TODO add your handling code here:
        this.tampilDataMatkul();
        new AddMatkul().setVisible(true);
    }//GEN-LAST:event_sidebarMatkulActionPerformed

    private void sidebarKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarKelasActionPerformed
        // TODO add your handling code here:
        this.tampilDataKelas();
        new AddKelas().setVisible(true);
    }//GEN-LAST:event_sidebarKelasActionPerformed

    private void submitTambahMahasiswa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitTambahMahasiswa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitTambahMahasiswa1ActionPerformed

    private void kelas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelas1ActionPerformed

    private void nim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nim1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nim1ActionPerformed

    private void sidebarDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sidebarDosenActionPerformed
        // TODO add your handling code here:
        new AddDosen().setVisible(true);
        this.tampilDataDosen();
    }//GEN-LAST:event_sidebarDosenActionPerformed

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
    private javax.swing.JLabel header1;
    private javax.swing.JFrame inputMahasiswa;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kelas1;
    private javax.swing.JTextField nama1;
    private javax.swing.JTextField nim1;
    private javax.swing.JTextField no_presensi1;
    private javax.swing.JButton sidebarDosen;
    private javax.swing.JButton sidebarKelas;
    private javax.swing.JButton sidebarMahasiswa;
    private javax.swing.JButton sidebarMatkul;
    private javax.swing.JButton sidebarNilai;
    private javax.swing.JButton submitTambahMahasiswa1;
    private javax.swing.JTable tabelMahasiswa;
    // End of variables declaration//GEN-END:variables
}
