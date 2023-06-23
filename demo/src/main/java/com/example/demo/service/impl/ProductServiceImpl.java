package com.example.demo.service.impl;

import com.example.demo.dao.hibernate.ClientDao;
import com.example.demo.dao.hibernate.ManagerDao;
import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.dto.ClientDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Client;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    @Qualifier("ManagerDaoSpringDataJPAImpl")
    private ManagerDao managerDao;

    @Autowired
    @Qualifier("ClientDaoSpringDataJPAImpl")
    private ClientDao clientDao;

    @Autowired
    @Qualifier("ProductDaoSpringDataJPAImpl")
    private ProductDao productDao;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productDto.convertProductDtoToProduct();
        Product savedProduct = productDao.save(product);
        ProductDto savedProductDto = savedProduct.convertProductToProductDto();
        return savedProductDto;
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        Product product = productDto.convertProductDtoToProduct();
        Product updatedProduct = productDao.update(product);
        ProductDto updatedProductDto = updatedProduct.convertProductToProductDto();
        return updatedProductDto;
    }

    @Override
    public boolean deleteByName(String productDtoName) {
        return false;
    }

    @Override
    public boolean deleteById(Long productDtoId) {
        return false;
    }

    @Override
    public boolean delete(ProductDto productDto) {
        return false;
    }

    @Override
    public List<ProductDto> getProducts() {
        return null;
    }

    @Override
    public ProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public ProductDto getProductByName(String productDtoName) {
        return null;
    }

    @Override
    public List<Product> getProductsWithAssociatedClients() {
        return null;
    }

    @Override
    public ProductDto getProductsWithAssociatedClientsById(Long productDtoId) {
        return null;
    }

    @Override
    public ProductDto getProductsWithAssociatedClientsByName(String productDtoName) {
        return null;
    }
}
