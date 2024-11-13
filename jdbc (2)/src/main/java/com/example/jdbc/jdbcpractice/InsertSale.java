package com.example.jdbc.jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertSale {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Product ID: ");
            int prodId = scanner.nextInt();
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter Total Price: ");
            double totalPrice = scanner.nextDouble();

            String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
            try (Connection con = DriverManager.getConnection(url, "SA", "Komali@123");
                 PreparedStatement pstmt = con.prepareStatement("INSERT INTO Sales (prod_id, sale_date, quantity, total_price) VALUES (?, GETDATE(), ?, ?)")) {

                pstmt.setInt(1, prodId);
                pstmt.setInt(2, quantity);
                pstmt.setDouble(3, totalPrice);
                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " sale record inserted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
