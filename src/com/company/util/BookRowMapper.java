package com.company.util;

import com.company.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/25.
 */
//public class BookRowMapper implements RowMapper<Book> {
//    public List<Book> mapRow(ResultSet resultSet) throws SQLException {
//        Book book = new Book();
//        if(resultSet.next()){
//
//            book.setBisbn(resultSet.getString("bisbn"));
//            book.setBname(resultSet.getString("bname"));
//            book.setBauthor(resultSet.getNString("bauthor"));
//            book.setBpublisher(resultSet.getString("bpublisher"));
//            book.setBprice(resultSet.getFloat("bprice"));
//            book.setBcategory(resultSet.getString("bcategory"));
//        }
//
//        return book;
//    }

//    public List<Book> mapRowList(ResultSet resultSet) throws SQLException {
//        List<Book> bookList = new ArrayList<>();
//
//        while (resultSet.next()){
//            Book book = new Book();
//
//            book.setBisbn(resultSet.getString("bisbn"));
//            book.setBname(resultSet.getString("bname"));
//            book.setBauthor(resultSet.getString("bauthor"));
//            book.setBpublisher(resultSet.getString("bpublisher"));
//            book.setBprice(resultSet.getFloat("bprice"));
//            book.setBcategory(resultSet.getString("bcategory"));
//            book.setBnum(resultSet.getInt("bnum"));
//
//            bookList.add(book);
//        }
//
//        return bookList;
//
//    }
//}
