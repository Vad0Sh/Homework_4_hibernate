package org.example.Homework_4_hibernate;

import org.example.Homework_4_hibernate.Entity.Book;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookHelper bh = new BookHelper();
        String[] names = {"War and Peace", "Eneida", "Kobzar"};

        for (String name : names) {
            Book book = new Book();
            book.setName(name);
            bh.add(book);
        }

        List<Book> bookList = bh.getAll();

        for (Book book : bookList) {
            System.out.println(book.getId() + " " + book.getName());
        }

        Book book = bh.getById(2);
        System.out.println(book.getName());
    }

}
