package com.example.jdbc.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    
        Connection con = DriverManager.getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=test;encrypt=true;trustServerCertificate=true;",
            "sa", "Komali@123");

        String createTableSQL = "CREATE TABLE Employees ("
                + "EmployeeID INT PRIMARY KEY IDENTITY(1,1), "
                + "FirstName NVARCHAR(50) NOT NULL, "
                + "LastName NVARCHAR(50), "
                + "Position NVARCHAR(50), "
                + "Salary DECIMAL(18, 2), "
                + "HireDate DATE"
                + ")";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'Employees' created successfully in the MSDB database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }
}














