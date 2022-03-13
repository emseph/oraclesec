package com.oraclesample.oraclesec.repository;

import com.oraclesample.oraclesec.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
