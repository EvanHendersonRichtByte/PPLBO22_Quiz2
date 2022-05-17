package main;

import java.sql.*;
import static main.Main.conn;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

public class Kelas {

    int id_kelas;
    String nama_kelas;
    // int id_dpa;

    public Kelas(int id_kelas, String nama_kelas) {
        this.id_kelas = id_kelas;
        this.nama_kelas = nama_kelas;
    }

    public void create() {
        System.out.print("Masukkan nama kelas: ");
        this.nama_kelas = in.next();
        try {
            st.executeUpdate(String.format("INSERT INTO kelas VALUES(null,'%s');", this.nama_kelas));
            System.out.println("Data kelas berhasil dibuat");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void read() {
        try {
            rs = st.executeQuery("SELECT * FROM kelas");
            while (rs.next()) {
                System.out.printf("\nID Kelas %-3dNama Kelas %-3s", rs.getInt("id_kelas"), rs.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update() {
        try {
            this.read();
            System.out.println("\nData kelas yang akan diubah");
            System.out.print("ID Kelas: ");
            this.id_kelas = in.nextInt();
            try {
                rs = st.executeQuery(String.format("SELECT * FROM kelas WHERE id_kelas = %d", this.id_kelas));
                while (rs.next()) {
                    System.out.printf("\nID Kelas %-3dNama Kelas %-3s", rs.getInt("id_kelas"), rs.getString("nama_kelas"));
                }
            } catch (SQLException e) {
                System.out.println("Data kelas tidak ditemukan");
            }
            System.out.print("Masukkan nama kelas: ");
            this.nama_kelas = in.next();
            st.executeUpdate(String.format("UPDATE kelas SET nama_kelas VALUES('%s') WHERE id_kelas = %d", this.nama_kelas, this.id_kelas));
            System.out.println("Data kelas telah diubah");
        } catch (SQLException e) {
            System.out.println("Data kelas gagal diubah, pastikan mahasiswa di kelas tersebut kosong");
        }
    }

    public void delete() {
        try {
            this.read();
            System.out.println("\nData kelas yang akan dihapus");
            System.out.print("ID Kelas: ");
            this.id_kelas = in.nextInt();
            st.executeUpdate(String.format("DELETE FROM kelas WHERE id_kelas = %d", this.id_kelas));
            System.out.println("Data kelas telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data kelas gagal dihapus, pastikan mahasiswa di kelas tersebut kosong");
        }
    }
}
