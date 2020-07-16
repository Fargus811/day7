package com.sergeev.day6.model.dao;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.LibraryException;

import java.util.List;

public interface BookListDAO {

    List<Book> addBook(Book book) throws LibraryException;

    List<Book> removeBook(Book book) throws LibraryException;

    List<Book> findByTitle(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByCost(double minCost, double maxCost);

    List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages);

    List<Book> findByYearOfPublishing( int minYearOfPublishing, int maxYearOfPublishing);

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByCost();

    List<Book> sortBooksByNumberOfPages();
}
