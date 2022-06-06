package main;

import java.sql.*;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

public class Mahasiswa {

    String nim, nama;
    int id_kelas, no_presensi;

//    public Mahasiswa(String nim, String nama, int id_kelas, int no_presensi) {
//        this.nim = nim;
//        this.nama = nama;
//        this.id_kelas = id_kelas;
//        this.no_presensi = no_presensi;
//    }
    public void create(String nim, String nama, int no_presensi, int id_kelas) {
//        System.out.print("Masukkan NIM: ");
//        this.nim = in.next();
//        in.nextLine();
//        System.out.print("Masukkan Nama: ");
//        this.nama = in.nextLine();
//        System.out.print("Masukkan No. Presensi: ");
//        this.no_presensi = in.nextInt();
//        System.out.println("Kelas yang tersedia");
//        Kelas.read();
//        System.out.print("\nMasukkan ID Kelas: ");
//        this.id_kelas = in.nextInt();
        try {
            st.executeUpdate(String.format("INSERT INTO mahasiswa VALUES('%s','%s',%d,%d)", this.nim, this.nama, this.no_presensi, this.id_kelas));
            System.out.println("Data mahasiswa berhasil dibuat");
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
    }

    public static Object[][] read() {
        rs = null;
        Object[][] resultSet = null;
        try {
            rs = st.executeQuery("SELECT * FROM mahasiswa JOIN kelas ON kelas.id_kelas = mahasiswa.id_kelas ORDER BY mahasiswa.id_kelas, mahasiswa.nama");
            System.out.println("NIM        Nama                                               No  Kelas");
            while (rs.next()) {
                System.out.printf("%-10s %-50s %-3d %-3s\n", rs.getString("nim"), rs.getString("nama"), rs.getInt("no_presensi"), rs.getString("nama_kelas"));
            }
//            int rows = rs.getRow();
//            int columns = 3;
//            
//            resultSet = new Object[rows][columns];
//            int row = 0;
//            while (rs.next()) {
//                for (int i = 0; i < columns; i++) {
//                    resultSet[row][i] = rs.getObject(i + 1);
//                }
//                row++;
//            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return resultSet;
    }
    
    public static void main(String[] args) {
        read();
    }

    public void update() {
        read();
        System.out.println("Data mahasiswa yang akan diubah");
        System.out.print("NIM: ");
        this.nim = in.next();
        in.nextLine();
        try {
            System.out.println(String.format("SELECT * FROM mahasiswa WHERE nim = '%s' ", this.nim));
            rs = st.executeQuery(String.format("SELECT * FROM mahasiswa WHERE nim = '%s' ", this.nim));
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-3s\n", rs.getString("nim"), rs.getString("nama"), rs.getInt("no_presensi"));
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa tidak ditemukan");
            return;
        }
        System.out.print("Masukkan Nama: ");
        this.nama = in.nextLine();
        System.out.print("Masukkan No. Presensi: ");
        this.no_presensi = in.nextInt();
        System.out.println("Kelas yang tersedia");
        Kelas.read();
        System.out.print("\nMasukkan ID Kelas: ");
        this.id_kelas = in.nextInt();
        try {
            st.executeUpdate(String.format("UPDATE mahasiswa SET nama = '%s', no_presensi = %d, id_kelas = %d WHERE nim = '%s'", this.nama, this.no_presensi, this.id_kelas, this.nim));
            System.out.println("Data mahasiswa berhasil diubah");
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
    }

    public void delete() {
        read();
        System.out.println("Data mahasiswa yang akan dihapus");
        System.out.print("NIM: ");
        this.nim = in.next();
        try {
            System.out.println(String.format("DELETE FROM mahasiswa WHERE nim = '%s'", this.nim));
            st.executeUpdate(String.format("DELETE FROM mahasiswa WHERE nim = '%s'", this.nim));
            System.out.println("Data mahasiswa telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dihapus, pastikan nim telah sesuai dan nilai yang dimiliki kosong!");
        }
    }
}
