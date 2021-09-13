package com.lc.vuedemospringboot.controller;

import com.lc.vuedemospringboot.pojo.Book;
import com.lc.vuedemospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list(){
        return bookService.list();
    }

    @PostMapping("/api/books")
    public void addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
    }

    @GetMapping("/api/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid){

        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

}
