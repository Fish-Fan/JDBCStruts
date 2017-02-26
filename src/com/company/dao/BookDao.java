package com.company.dao;

import com.company.entity.Book;
import com.company.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/25.
 */
public class BookDao {
    public void addBook(Book book){
        String sql = "INSERT INTO book(bisbn,bname,bauthor,bpublisher,bprice,bcategory,bnum) VALUES(?,?,?,?,?,?,?)";
        DBHelp.executeUpdate(sql,book.getBisbn(),book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory(),book.getBnum());
    }

    public void updateBook(Book book){
        String sql = "UPDATE book SET bname = ?,bauthor = ?,bpublisher = ?,bprice = ?,bcategory = ? WHERE bisbn = ?";
        DBHelp.executeUpdate(sql,book.getBname(),book.getBauthor(),book.getBpublisher(),book.getBprice(),book.getBcategory(),book.getBisbn());
    }

    public void deleteBook(String bisbn){
        String sql = "DELETE FROM book WHERE bisbn = ?";
        DBHelp.executeUpdate(sql,bisbn);
    }

    public Book findBookByBisbn(String bisbn){
        String sql = "SELECT * FROM book WHERE bisbn = ?";
        return DBHelp.executeQuery(sql,new BeanRowMapper<>(Book.class),bisbn);
    }

    public List<Book> findAllBook(){
        String sql = "SELECT * FROM book";
        return DBHelp.executeQuery(sql,new BeanListMapper<>(Book.class));
    }
}
