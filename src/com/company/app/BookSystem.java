package com.company.app;

import com.company.dao.BookDao;
import com.company.entity.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Created by yanfeng-mac on 2017/2/25.
 */
public class BookSystem {

    Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("欢迎使用图书管理系统！---");
        System.out.println("1.添加书籍");
        System.out.println("2.修改书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.查找书籍");
        System.out.println("5.查找所有书籍");
        System.out.println("0.退出系统");

        System.out.println("请选择菜单：");
        int index = scanner.nextInt();

        if(index == 1) {
            addBook();
        }
        if(index == 2){
            updateBook();
        }
        if(index == 3){
            deleteBook();
        }
        if(index == 4){
            queryBook();
        }
        if(index == 5){
            queryAllBook();
        }
    }

    public void addBook(){
        Book book = new Book();

        System.out.println("请输入添加书籍的ISBN号！");
        String isbn = scanner.next();
        book.setBisbn(isbn);

        System.out.println("请输入添加书籍的名称！");
        String name = scanner.next();
        book.setBname(name);

        System.out.println("请输入添加书籍的作者！");
        String author = scanner.next();
        book.setBauthor(author);

        System.out.println("请输入添加书籍的出版社名称！");
        String publisher = scanner.next();
        book.setBpublisher(publisher);

        System.out.println("请输入添加书籍的价格！");
        Float price = scanner.nextFloat();
        book.setBprice(price);

        System.out.println("请输入添加书籍的类别！");
        String category = scanner.next();
        book.setBcategory(category);

        System.out.println("请输入添加书籍的库存数量！");
        Integer num = scanner.nextInt();
        book.setBnum(num);

        BookDao bookDao = new BookDao();
        bookDao.addBook(book);
    }

    public void updateBook(){
        BookDao bookDao = new BookDao();
        Scanner input = new Scanner(System.in);

        System.out.println("请输入要修改书籍的ISBN:");
        String isbn = input.next();

        Book book = bookDao.findBookByBisbn(isbn);

        if(book == null) {
            System.out.println("未找到该书籍");
        } else {
            System.out.println("是否修改书籍名称?(Y|N)");
            String answer = input.next();

            if("y".equalsIgnoreCase(answer)) {
                System.out.println("请输入新的书籍名称");
                String name = input.next();

                book.setBname(name);
            }

            System.out.println("是否修改书籍作者?(Y|N)");
            answer = input.next();
            if("y".equalsIgnoreCase(answer)) {
                System.out.println("请输入作者：");
                String author = input.next();

                book.setBauthor(author);
            }

            System.out.println("是否要修改图书价格？(Y|N)");
            answer = input.next();
            if("y".equalsIgnoreCase(answer)){
                System.out.println("请输入图书价格");
                float price = input.nextFloat();
                book.setBprice(price);
            }

            System.out.println("是否要修改书籍的出版社？(Y|N)");
            answer = input.next();
            if("y".equalsIgnoreCase(answer)){
                System.out.println("请输入出版社名称！");
                String publisher = input.next();
                book.setBpublisher(publisher);
            }

            System.out.println("是否要修改图书类别？(Y|N)");
            answer = input.next();
            if("y".equalsIgnoreCase(answer)){
                System.out.println("请输入图书类别");
                String category = input.next();
                book.setBcategory(category);
            }


        }

        bookDao.updateBook(book);

        start();
    }

    public void deleteBook(){
        BookDao bookDao = new BookDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除书籍的ISBN号！");
        String isbn = scanner.next();

        bookDao.deleteBook(isbn);

        start();

    }

    public void queryBook(){

        BookDao bookDao = new BookDao();
        System.out.println("请输入要查找书籍的ISBN！");

        String isbn = scanner.next();

        Book book = bookDao.findBookByBisbn(isbn);

        System.out.println(book);

        start();
    }

    public void queryAllBook(){
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.findAllBook();
        for(Book book : bookList){
            System.out.println(book);
        }

        start();
    }
}
