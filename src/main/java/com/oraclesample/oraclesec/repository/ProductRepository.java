package com.oraclesample.oraclesec.repository;


import com.oraclesample.oraclesec.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategoryId(int id);
    List<Product> findAllByCategory(String name);

}
