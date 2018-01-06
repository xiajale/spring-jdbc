package com.xidian.controller;

import com.xidian.domain.Author;
import com.xidian.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhouyibin on 2018/1/6.
 */
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/author")
    public int add(@RequestBody Author author){
        return authorService.add(author);
    }

    @PutMapping(value = "/author")
    public int update(@RequestBody Author author){
        return authorService.update(author);
    }

    @DeleteMapping(value = "/author/{id}")
    public int delete(@PathVariable int id){
        return authorService.delete(id);
    }

    @GetMapping(value = "/author/{id}")
    public Author findAuthor(@PathVariable int id){
        return authorService.findAuthor(id);
    }

    @GetMapping(value = "/authors")
    public List<Author> findAuthorList(){
        return authorService.findAuthorList();
    }
}
