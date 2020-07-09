package com.sergeev.day6.model.dao;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.ProgramException;

import java.util.List;
import java.util.Optional;

public interface BookListDAO {

    boolean addBook(Book book) throws ProgramException;

    boolean removeBook(Book book) throws ProgramException;

    List<Book> findByTitle(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByCost(double cost);

    List<Book> findByNumberOfPages(int numberOfPage);

    List<Book> findByYearOfPublishing( int yearOfPublishing);

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByCost();

    List<Book> sortBooksByNumberOfPages();
}
