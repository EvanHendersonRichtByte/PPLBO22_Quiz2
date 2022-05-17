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
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void purge() {
        try {
            st.executeUpdate("DELETE FROM mahasiswa");
            st.executeUpdate("DELETE FROM kelas");
            System.out.println("Data has been purged");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
