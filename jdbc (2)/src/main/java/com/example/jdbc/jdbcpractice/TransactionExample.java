package com.example.jdbc.jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
        try (Connection con = DriverManager.getConnection(url, "SA", "Komali@123");
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter first Product ID to update: ");
            int prodId1 = scanner.nextInt();
            System.out.print("Enter new Price for first Product: ");
            double newPrice1 = scanner.nextDouble();
            System.out.print("Enter second Product ID to update: ");
            int prodId2 = scanner.nextInt();
            System.out.print("Enter new Price for second Product: ");
            double newPrice2 = scanner.nextDouble();

            con.setAutoCommit(false); 

            try (PreparedStatement pstmt1 = con.prepareStatement("UPDATE Products SET price = ? WHERE prod_id = ?");
                 PreparedStatement pstmt2 = con.prepareStatement("UPDATE Products SET price = ? WHERE prod_id = ?")) {

                pstmt1.setDouble(1, newPrice1);
                pstmt1.setInt(2, prodId1);
                pstmt1.executeUpdate();

                pstmt2.setDouble(1, newPrice2);
                pstmt2.setInt(2, prodId2);
                pstmt2.executeUpdate();

                con.commit(); 
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                con.rollback();
                System.out.println("Transaction failed, rolling back changes.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
