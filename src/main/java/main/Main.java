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
            st = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
