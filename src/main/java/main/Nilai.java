package main;

import java.sql.*;
import static main.Main.in;
import static main.Main.rs;
import static main.Main.st;

public class Nilai {

    String nim, format = "";
    int id_matkul;
    float nilai[] = new float[9];

    public void create() {
        new Mahasiswa().read();
        in.nextLine();
        System.out.print("Masukkan NIM mahasiswa: ");
        nim = in.nextLine();
        new Matkul().read();
        System.out.print("Masukkan ID Mata Kuliah: ");
        id_matkul = in.nextInt();
        for (int i = 0; i < nilai.length; i++) {
            if (i < 5) {
                System.out.printf("Masukkan nilai TUGAS %d: ", i + 1);
            } else if (i > 4 && i < 7) {
                System.out.printf("Masukkan nilai QUIZ %d: ", i - 4);
            } else if (i == 7) {
                System.out.printf("Masukkan nilai UTS: ");
            } else {
                System.out.printf("Masukkan nilai UAS: ");
            }
            nilai[i] = in.nextFloat();
            format = format + nilai[i] + ",";
        }
        try {
            st.executeUpdate(String.format("INSERT INTO nilai VALUES (NULL, '%s', %d, %s NULL)", nim, id_matkul, format));
            System.out.println("Data nilai berhasil dibuat");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void read(String kondisi) {
        try {
            if (kondisi.equals("0")) {
                rs = st.executeQuery("SELECT * FROM nilai");
            } else {
                rs = st.executeQuery(String.format("SELECT * FROM nilai WHERE nim='%s'", kondisi));
            }
            System.out.printf("%-10s | ID Mata Kuliah | Tugas 1 | Tugas 2 | Tugas 3 | Tugas 4 | Tugas 5 | QUIZ 1 | QUIZ 2 | %-6s | %-6s | Nilai Akhir\n", "NIM", "UTS", "UAS");
            while (rs.next()) {
                System.out.printf("%10s | %14d | %7.2f | %7.2f | %7.2f | %7.2f | %7.2f | %6.2f | %6.2f | %6.2f | %6.2f | %6.2f\n",
                        rs.getString("nim"), rs.getInt("id_matkul"), rs.getFloat("tugas1"), rs.getFloat("tugas2"), rs.getFloat("tugas3"), rs.getFloat("tugas4"), rs.getFloat("tugas5"), rs.getFloat("quiz1"), rs.getFloat("quiz2"), rs.getFloat("uts"), rs.getFloat("uas"), rs.getFloat("total_nilai"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update() {
        try {
            new Mahasiswa().read();
            in.nextLine();
            System.out.println("Data nilai yang ingin diubah");
            System.out.print("NIM: ");
            nim = in.nextLine();
            read(nim);
            new Matkul().read();
            System.out.println("ID Mata Kuliah yang ingin diubah");
            System.out.print("ID: ");
            id_matkul = in.nextInt();
            System.out.println("""
                               Pilihan Nilai(1-9)
                               1. Tugas 1
                               2. Tugas 2
                               3. Tugas 3
                               4. Tugas 4
                               5. Tugas 5
                               6. QUIZ 1
                               7. QUIZ 2
                               8. UTS
                               9. UAS""");
            System.out.print("Masukkan Pilihan Nilai yang ingin diubah: ");
            int p = in.nextInt();
            float nilaiBaru;
            switch (p) {
                case 1, 2, 3, 4, 5 -> {
                    System.out.printf("Masukkan Nilai Tugas %d yang baru: ", p);
                    nilaiBaru = in.nextFloat();
                    st.executeUpdate(String.format("UPDATE nilai SET tugas%d = %.2f WHERE nim = '%s' AND id_matkul = %d", p, nilaiBaru, nim, id_matkul));
                }
                case 6, 7 -> {
                    System.out.printf("Masukkan Nilai QUIZ %d yang baru: ", p - 5);
                    nilaiBaru = in.nextFloat();
                    st.executeUpdate(String.format("UPDATE nilai SET quiz%d = %.2f WHERE nim = '%s' AND id_matkul = %d", p - 5, nilaiBaru, nim, id_matkul));
                }
                case 8 -> {
                    System.out.print("Masukkan Nilai UTS yang baru: ");
                    nilaiBaru = in.nextFloat();
                    st.executeUpdate(String.format("UPDATE nilai SET uts = %.2f WHERE nim = '%s' AND id_matkul = %d", nilaiBaru, nim, id_matkul));
                }
                case 9 -> {
                    System.out.print("Masukkan Nilai UAS yang baru: ");
                    nilaiBaru = in.nextFloat();
                    st.executeUpdate(String.format("UPDATE nilai SET uas = %.2f WHERE nim = '%s' AND id_matkul = %d", nilaiBaru, nim, id_matkul));
                }
                default -> {
                }
            }
            System.out.println("Data nilai telah diubah");
        } catch (SQLException e) {
            System.out.println("Data nilai gagal diubah, pastikan masukkan telah benar");
            System.out.println(e);
        }
    }

    public void delete() {
        try {
            read("0");
            in.nextLine();
            System.out.println("\nData nilai yang akan dihapus");
            System.out.print("NIM: ");
            nim = in.nextLine();
            read(nim);
            new Matkul().read();
            System.out.println("\nID Matkul yang akan dihapus");
            System.out.print("ID Matkul: ");
            id_matkul = in.nextInt();
            st.executeUpdate(String.format("DELETE FROM nilai WHERE nim = '%s' AND id_matkul = %d", nim, id_matkul));
            System.out.println("Data nilai telah dihapus");
        } catch (SQLException e) {
            System.out.println("Data nilai gagal dihapus, pastikan data masukkan telah benar");
        }
    }
}
