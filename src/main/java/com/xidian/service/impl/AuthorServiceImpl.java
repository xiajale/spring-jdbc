package com.xidian.service.impl;

import com.xidian.dao.AuthorDao;
import com.xidian.domain.Author;
import com.xidian.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouyibin on 2018/1/6.
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao authorDao;

    @Autowired
    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public int add(Author author) {
        return authorDao.add(author);
    }

    @Override
    public int update(Author author) {
        return authorDao.update(author);
    }

    @Override
    public int delete(int id) {
        return authorDao.delete(id);
    }

    @Override
    public Author findAuthor(int id) {
        return authorDao.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return authorDao.findAuthorList();
    }
}
