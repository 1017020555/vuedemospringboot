package com.lc.vuedemospringboot.controller;

import com.lc.vuedemospringboot.pojo.Book;
import com.lc.vuedemospringboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class LibraryController {

    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list(){
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public void addOrUpdate(@RequestBody Book book){
        bookService.addOrUpdate(book);
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book){
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid){

        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> findAllByTitleLikeOrAuthorLike(@RequestParam("keywords") String keywords){
        if ("".equals(keywords)){
            return bookService.list();
        }else {
          return   bookService.findAllByTitleLikeOrAuthorLike('%'+keywords+'%','%'+keywords+'%');
        }
    }

    @CrossOrigin
    @PostMapping("/api/covers")
    public String uploadImg(MultipartFile file){
        String folder = "D:/workspace/vuedemospringboot/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, UUID.randomUUID().toString() + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
