package com.xidian.dao.impl;

import com.xidian.dao.AuthorDao;
import com.xidian.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouyibin on 2018/1/6.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorDaoImpl(@Qualifier("twoJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(Author author) {
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values (?, ?)",
                author.getReal_name(), author.getNick_name());
    }

    @Override
    public int update(Author author) {
        return jdbcTemplate.update("update t_author set real_name = ?, nick_name = ? where id = ?",
                author.getReal_name(), author.getNick_name(), author.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from t_author where id = ?", id);
    }

    @Override
    public Author findAuthor(int id) {
        List<Author> list = jdbcTemplate.query("select * from t_author where id = ?",
                new BeanPropertyRowMapper<>(Author.class), id);
        if(null != list && list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Author> findAuthorList() {
        return jdbcTemplate.query("select * from t_author", new BeanPropertyRowMapper<>(Author.class));
    }
}
