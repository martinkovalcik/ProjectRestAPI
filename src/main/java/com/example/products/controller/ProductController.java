package com.example.products.controller;


import com.example.products.ProductsApplication;
import com.example.products.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/list")
    public List<Product> getAllMovies() {
        Product product;
        List<Product> list = new ArrayList<>();

        try {
            PreparedStatement statement = ProductsApplication.getConnection().prepareStatement(
                    "select * from products");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));

                list.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = new Product();

        try {
            PreparedStatement statement = ProductsApplication.getConnection().prepareStatement(
                    "select * from products where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
