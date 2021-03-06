package com.lc.vuedemospringboot.service;

import com.lc.vuedemospringboot.dao.BookDAO;
import com.lc.vuedemospringboot.dao.CategoryDAO;
import com.lc.vuedemospringboot.pojo.Book;
import com.lc.vuedemospringboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookDAO bookDAO;

    public List<Book> list(){

        Sort sort=Sort.by(Sort.Direction.DESC,"id");
        List<Book> bookList = bookDAO.findAll(sort);
        return bookList;
    }

    public void addOrUpdate(Book book){
         bookDAO.save(book);
    }

    public void deleteById(int id){

        Book book = bookDAO.findById(id);
        String substring = "D:/workspace/vuedemospringboot/img/"+book.getCover().substring(31);
        File file=new File(substring);
        if (file.exists()){
            file.delete();
        }

        bookDAO.deleteById(id);

    }

    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        List<Book> allByCategory = bookDAO.findAllByCategory(category);
        return allByCategory;
    }

    public List<Book> findAllByTitleLikeOrAuthorLike(String title,String author){
      return   bookDAO.findAllByTitleLikeOrAuthorLike(title,author);
    }

}
