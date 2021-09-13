package com.lc.vuedemospringboot.service;

import com.lc.vuedemospringboot.dao.CategoryDAO;
import com.lc.vuedemospringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> list(){

        Sort sort=Sort.by(Sort.Direction.DESC,"id");

        List<Category> categoryList = categoryDAO.findAll(sort);

        return categoryList;
    }

    public Category get(int id){
        return categoryDAO.findById(id).orElse(null);
    }

}
