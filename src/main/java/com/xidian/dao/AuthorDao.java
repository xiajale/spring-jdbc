package com.xidian.dao;

import com.xidian.domain.Author;

import java.util.List;

/**
 * Created by zhouyibin on 2018/1/6.
 */
public interface AuthorDao {
    int add(Author author);
    int update(Author author);
    int delete(int id);
    Author findAuthor(int id);
    List<Author> findAuthorList();
}
