package com.example.products;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) {


        try {
            System.out.println("Connecting to database: " + ProductsApplication.URL);
            Connection connection = DriverManager.getConnection(ProductsApplication.URL, ProductsApplication.USERNAME,
                    ProductsApplication.PASSWORD);
            System.out.println("Connection successful!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}
