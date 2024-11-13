package com.example.jdbc.jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertProduct {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID: ");
            int prodId = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Product Name: ");
            String prodName = scanner.nextLine();
            System.out.print("Enter Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();

            String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
            try (Connection con = DriverManager.getConnection(url, "SA", "Komali@123");
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO Products (prod_id, prod_name, category, price) VALUES (?, ?, ?, ?)")) {

                pstmt.setInt(1, prodId);
                pstmt.setString(2, prodName);
                pstmt.setString(3, category);
                pstmt.setDouble(4, price);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
