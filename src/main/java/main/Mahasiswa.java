package main;

import java.sql.*;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

/**
 *
 * @author Evan Henderson
 */
public class Mahasiswa {

    String nim, nama;
    int id_kelas, no_presensi;

    public Mahasiswa(String nim, String nama, int id_kelas, int no_presensi) {
        this.nim = nim;
        this.nama = nama;
        this.id_kelas = id_kelas;
        this.no_presensi = no_presensi;
    }

    public void create() {
        System.out.print("Masukkan NIM: ");
        this.nim = in.next();
        System.out.print("Masukkan Nama: ");
        this.nama = in.next();
        System.out.print("Masukkan No. Presensi: ");
        this.no_presensi = in.nextInt();
        System.out.println("Kelas yang tersedia");
        Kelas.read();
        System.out.print("\nMasukkan ID Kelas: ");
        this.id_kelas = in.nextInt();
        try {
            st.executeUpdate(String.format("INSERT INTO mahasiswa VALUES('%s','%s',%d,%d)", this.nim, this.nama, this.no_presensi, this.id_kelas));
            System.out.println("Data mahasiswa berhasil dibuat");
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dibuat, pastikan id kelas telah sesuai");
        }
    }

    public void read() {
        try {
            rs = st.executeQuery("SELECT * FROM mahasiswa JOIN kelas ON kelas.id_kelas = Mahasiswa.kelas");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-3s\n", rs.getString("nim"), rs.getString("nama"), rs.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update() {
        read();
        System.out.println("Data mahasiswa yang akan diubah");
        System.out.print("NIM: ");
        this.nim = in.next();
        try {
            rs = st.executeQuery(String.format("SELECT FROM mahasiswa WHERE nim = '%s' ", this.nim));
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-3s\n", rs.getString("nim"), rs.getString("nama"), rs.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            System.out.println("Data mahasiswa tidak ditemukan");
            return;
        }
        System.out.print("Masukkan Nama: ");
        this.nama = in.next();
        System.out.print("Masukkan No. Presensi: ");
        this.no_presensi = in.nextInt();
        System.out.println("Kelas yang tersedia");
        Kelas.read();
        System.out.print("\nMasukkan ID Kelas: ");
        this.id_kelas = in.nextInt();
        try {
            st.executeUpdate(String.format("UPDATE mahasiswa SET VALUES('%s','%s',%d,%d) WHERE nim = '%s'", this.nim, this.nama, this.no_presensi, this.id_kelas, this.nim));
            System.out.println("Data mahasiswa berhasil dibuat");
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
            st.executeUpdate(String.format("DELETE FROM mahasiswa WHERE nim = '%s'", this.nim));
            System.out.println("Data mahasiswa telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data mahasiswa gagal dihapus, pastikan nim telah sesuai");
        }
    }

}
