package main;

import java.sql.*;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

public class Dosen {

    int id_dosen;
    String nama_dosen;

    //    public Dosen(int id_dosen, String nama_dosen) {
    //        this.id_dosen = id_dosen;
    //        this.nama_dosen = nama_dosen;
    //    }
    public void create() {
        System.out.print("Masukkan nama dosen: ");
        this.nama_dosen = in.nextLine();
        try {
            st.executeUpdate(String.format("INSERT INTO dosen VALUES(null,'%s');", this.nama_dosen));
            System.out.println("Data dosen berhasil dibuat");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void read() {
        try {
            rs = st.executeQuery("SELECT * FROM dosen");
            while (rs.next()) {
                System.out.printf("ID Dosen: %-3dNama Dosen: %-3s\n", rs.getInt("id_dosen"), rs.getString("nama_dosen"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update() {
        try {
            read();
            System.out.println("\nData dosen yang akan diubah");
            System.out.print("ID Dosen: ");
            this.id_dosen = in.nextInt();
            in.nextLine();
            try {
                rs = st.executeQuery(String.format("SELECT * FROM dosen WHERE id_dosen = %d", this.id_dosen));
                while (rs.next()) {
                    System.out.printf("ID Dosen: %-3dNama Dosen: %-3s\n", rs.getInt("id_dosen"), rs.getString("nama_dosen"));
                }
            } catch (SQLException e) {
                System.out.println("Data dosen tidak ditemukan");
            }
            System.out.print("\nMasukkan nama dosen: ");
            this.nama_dosen = in.nextLine();
            st.executeUpdate(String.format("UPDATE dosen SET nama_dosen = '%s' WHERE id_dosen = %d", this.nama_dosen, this.id_dosen));
            System.out.println("Data dosen telah diubah");
        } catch (SQLException e) {
            System.out.println("Data dosen gagal diubah, pastikan data dosen di kelas kosong");
        }
    }

    public void delete() {
        try {
            read();
            System.out.println("\nData dosen yang akan dihapus");
            System.out.print("ID Dosen: ");
            this.id_dosen = in.nextInt();
            st.executeUpdate(String.format("DELETE FROM dosen WHERE id_dosen = %d", this.id_dosen));
            System.out.println("Data dosen telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data dosen gagal dihapus, pastikan mahasiswa di dosen tersebut kosong");
        }
    }
}
