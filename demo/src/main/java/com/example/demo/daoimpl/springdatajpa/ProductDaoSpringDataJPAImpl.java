package com.example.demo.daoimpl.springdatajpa;

import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.daoimpl.repository.ProductRepository;
import com.example.demo.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProductDaoSpringDataJPAImpl")
public class ProductDaoSpringDataJPAImpl implements ProductDao {

    private Logger logger = LoggerFactory.getLogger(ProductDaoSpringDataJPAImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public Product update(Product product) {
        Product updateProduct = productRepository.save(product);
        return updateProduct;
    }

    @Override
    public boolean deleteByName(String product1Name) {
        return false;
    }

    @Override
    public boolean deleteById(Long productId) {
        return false;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product getProductByName(String projectName) {
        return null;
    }

    @Override
    public List<Product> getProductsWithAssociatedClients() {
        return null;
    }

    @Override
    public Product getProductsWithAssociatedClientsById(Long productId) {
        return null;
    }

    @Override
    public Product getProductsWithAssociatedClientsByName(String productName) {
        return null;
    }
}
