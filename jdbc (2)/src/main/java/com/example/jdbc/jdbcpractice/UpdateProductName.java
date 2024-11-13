package com.example.jdbc.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProductName {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID to update: ");
            int prodId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Product Name: ");
            String newName = scanner.nextLine();

            String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
            try (Connection con = DriverManager.getConnection(url, "SA", "Komali@123");
                 PreparedStatement pstmt = con.prepareStatement("UPDATE Products SET prod_name = ? WHERE prod_id = ?")) {

                pstmt.setString(1, newName);
                pstmt.setInt(2, prodId);
                int rowsUpdated = pstmt.executeUpdate();
                System.out.println(rowsUpdated + " row(s) updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

