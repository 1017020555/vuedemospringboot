package com.lc.vuedemospringboot.dao;

import com.lc.vuedemospringboot.pojo.Book;
import com.lc.vuedemospringboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookDAO extends JpaRepository<Book,Integer> {

    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String title,String author);

}

