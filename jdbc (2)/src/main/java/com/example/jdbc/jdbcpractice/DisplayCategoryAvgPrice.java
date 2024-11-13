package com.example.jdbc.jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DisplayCategoryAvgPrice {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
        try (Connection con = DriverManager.getConnection(url, "SA", "Komali@123");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT category, AVG(price) AS average_price FROM Products GROUP BY category")) {

            while (rs.next()) {
                System.out.println("Category: " + rs.getString("category") +
                        ", Average Price: " + rs.getDouble("average_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
