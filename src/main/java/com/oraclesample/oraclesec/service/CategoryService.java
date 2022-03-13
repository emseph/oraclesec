package com.oraclesample.oraclesec.service;

import java.util.List;

import com.oraclesample.oraclesec.model.Category;
import com.oraclesample.oraclesec.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
