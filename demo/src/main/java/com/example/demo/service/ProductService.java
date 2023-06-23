package com.example.demo.service;

import com.example.demo.dao.hibernate.ProductDao;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    boolean deleteByName(String productDtoName);

    boolean deleteById(Long productDtoId);

    boolean delete(ProductDto productDto);

    List<ProductDto> getProducts();

    ProductDto getProductById(Long id);

    ProductDto getProductByName(String productDtoName);

    List<Product> getProductsWithAssociatedClients();

    ProductDto getProductsWithAssociatedClientsById(Long productDtoId);

    ProductDto getProductsWithAssociatedClientsByName(String productDtoName);
}
