package com.example.jdbc.jdbcpractice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTables {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=msdb;encrypt=true;trustServerCertificate=true;";
        String user = "SA";
        String password = "Komali@123";


        String insertProduct1 = "INSERT INTO Products (prod_id, prod_name, category, price) VALUES (1, 'Laptop', 'Electronics', 999.99)";
        String insertProduct2 = "INSERT INTO Products (prod_id, prod_name, category, price) VALUES (2, 'Headphones', 'Electronics', 199.99)";
        String insertProduct3 = "INSERT INTO Products (prod_id, prod_name, category, price) VALUES (3, 'Coffee Maker', 'Kitchen', 89.99)";
        String insertProduct4 = "INSERT INTO Products (prod_id, prod_name, category, price) VALUES (4, 'Smartphone', 'Electronics', 799.99)";
        String insertProduct5 = "INSERT INTO Products (prod_id, prod_name, category, price) VALUES (5, 'Blender', 'Kitchen', 49.99)";

        

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {


            stmt.executeUpdate(insertProduct1);
            stmt.executeUpdate(insertProduct2);
            stmt.executeUpdate(insertProduct3);
            stmt.executeUpdate(insertProduct4);
            stmt.executeUpdate(insertProduct5);
            System.out.println("Sample data inserted into 'Products' table.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
