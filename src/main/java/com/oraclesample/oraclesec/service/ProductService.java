package com.oraclesample.oraclesec.service;

import java.util.*;


import com.oraclesample.oraclesec.model.Product;
import com.oraclesample.oraclesec.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProductById(int id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }

    public List<Product> getAllProductByCategoryName(String name) {
        return productRepository.findAllByCategory(name);
    }
}
