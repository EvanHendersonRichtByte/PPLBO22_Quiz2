package main;

import java.sql.SQLException;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

public class Matkul {

    int id_matkul;
    String nama_matkul;
    static int id_dosen;
    // int id_dosen;

//    public Matkul(int id_matkul, String nama_matkul) {
//        this.id_matkul = id_matkul;
//        this.nama_matkul = nama_matkul;
//    }
    public void create() {
        System.out.print("Masukkan nama matkul: ");
        this.nama_matkul = in.nextLine();
        Dosen.read();
        System.out.print("Masukkan id pengajar: ");
        id_dosen = in.nextInt();
        in.nextLine();
        try {
            st.executeUpdate(String.format("INSERT INTO matkul VALUES(null,'%s', %d)", this.nama_matkul, id_dosen));
            System.out.println("Data matkul berhasil dibuat");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void read() {
        try {
            rs = st.executeQuery("SELECT * FROM matkul JOIN dosen ON matkul.id_dosen = dosen.id_dosen");
            while (rs.next()) {
                System.out.printf("\nID Matkul: %-3d\nNama Matkul: %-15s\nNama Pengajar: %-50s\n", rs.getInt("id_matkul"), rs.getString("nama_matkul"), rs.getString("nama_dosen"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update() {
        try {
            read();
            System.out.println("\nData matkul yang akan diubah");
            System.out.print("ID Matkul: ");
            this.id_matkul = in.nextInt();
            in.nextLine();
            try {
                rs = st.executeQuery(String.format("SELECT * FROM matkul JOIN dosen ON matkul.id_dosen = dosen.id_dosen WHERE id_matkul = %d", this.id_matkul));
                while (rs.next()) {
                    System.out.printf("\nID Matkul: %-3d\nNama Matkul: %-15s\nNama Pengajar: %-50s\n", rs.getInt("id_matkul"), rs.getString("nama_matkul"), rs.getString("nama_dosen"));
                }
            } catch (SQLException e) {
                System.out.println("Data matkul tidak ditemukan");
            }
            System.out.print("Masukkan nama matkul: ");
            this.nama_matkul = in.nextLine();
            Dosen.read();
            System.out.print("Masukkan id pengajar: ");
            id_dosen = in.nextInt();
            in.nextLine();
            st.executeUpdate(String.format("UPDATE matkul SET nama_matkul = '%s', id_dosen = %d WHERE id_matkul = %d", this.nama_matkul, id_dosen, this.id_matkul));
            System.out.println("Data matkul telah diubah");
        } catch (SQLException e) {
            System.out.println("Data matkul gagal diubah, pastikan mahasiswa di matkul tersebut kosong");
        }
    }

    public void delete() {
        try {
            read();
            System.out.println("\nData matkul yang akan dihapus");
            System.out.print("ID Matkul: ");
            this.id_matkul = in.nextInt();
            st.executeUpdate(String.format("DELETE FROM matkul WHERE id_matkul = %d", this.id_matkul));
            System.out.println("Data matkul telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data matkul gagal dihapus, pastikan data pada tabel mahasiswa dan nilai di matkul tersebut kosong");
        }
    }
}
