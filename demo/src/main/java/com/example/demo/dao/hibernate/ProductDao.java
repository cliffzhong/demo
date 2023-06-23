package com.example.demo.dao.hibernate;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    Product save(Product product);
    Product update(Product product);
    boolean deleteByName(String product1Name);
    boolean deleteById(Long productId);
    boolean delete(Product product);
    List<Product> getProducts();
    Product getProductById(Long id);
    Product getProductByName(String projectName);
    List<Product> getProductsWithAssociatedClients();
    Product getProductsWithAssociatedClientsById(Long productId);
    Product getProductsWithAssociatedClientsByName(String productName);
}
