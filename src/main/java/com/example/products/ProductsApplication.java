package com.example.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ProductsApplication {

    public static final String URL = "jdbc:mysql://localhost:3306/productdatabase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                ProductsApplication.URL, ProductsApplication.USERNAME, ProductsApplication.PASSWORD);
        return connection;
    }

}
