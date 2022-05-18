package main;

import java.sql.*;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pplbo_quiz2", "root", "");
            System.out.println("Connected to database");
            st = conn.createStatement();
            int pil1, pil2;
            OUTER:
            while (true) {
                System.out.println("=== MENU ===");
                System.out.println("1. Mahasiswa");
                System.out.println("2. Mata Kuliah");
                System.out.println("3. Kelas");
                System.out.println("4. Nilai");
                System.out.println("5. Keluar");
                System.out.print("Pilihan menu : ");
                pil1 = in.nextInt();
                switch (pil1) {
                    case 1 -> {
                        Mahasiswa mhs = new Mahasiswa();
                        menu();
                        pil2 = in.nextInt();
                        switch (pil2) {
                            case 1 -> {
                                in.nextLine();
                                mhs.create();
                            }
                            case 2 -> mhs.read();
                            case 3 -> mhs.update();
                            case 4 -> mhs.delete();
                            default -> {
                                    }
                        }
                    }
                    case 2 -> {
                        Matkul mk = new Matkul();
                        menu();
                        pil2 = in.nextInt();
                        switch (pil2) {
                            case 1 -> {
                                in.nextLine();
                                mk.create();
                            }
                            case 2 -> Matkul.read();
                            case 3 -> mk.update();
                            case 4 -> mk.delete();
                        }
                    }
                    case 3 -> {
                        Kelas kls = new Kelas();
                        menu();
                        pil2 = in.nextInt();
                        switch (pil2) {
                            case 1 -> kls.create();
                            case 2 -> Kelas.read();
                            case 3 -> kls.update();
                            case 4 -> kls.delete();
                        }
                    }
                    case 4 -> {
//                        Nilai n = new Nilai();
                        menu();
                        pil2 = in.nextInt();
                        switch (pil2) {
                            case 1 -> {
                        }
                            case 2 -> {
                        }
                            case 3 -> {
                        }
                            case 4 -> {
                        }
                            default -> {
                        }
                        }
//                            n.create();
//                            n.read();
//                            n.update();
//                            n.delete();
                                        }
                    case 5 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Menu tidak ada");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void menu() {
        System.out.println("--------------------");
        System.out.println("|1. Input Data     |");
        System.out.println("|2. Tampilkan Data |");
        System.out.println("|3. Ubah Data      |");
        System.out.println("|4. Hapus Data     |");
        System.out.println("|5. Kembali        |");
        System.out.println("--------------------");
        System.out.print("Pilihan : ");
    }

    public void purge() {
        try {
            st.executeUpdate("DELETE FROM nilai");
            st.executeUpdate("DELETE FROM mahasiswa");
            st.executeUpdate("DELETE FROM matkul");
            st.executeUpdate("DELETE FROM kelas");
            st.executeUpdate("DROP TABLE nilai");
            st.executeUpdate("DROP TABLE mahasiswa");
            st.executeUpdate("DROP TABLE matkul");
            st.executeUpdate("DROP TABLE kelas");
            System.out.println("Data has been purged");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
