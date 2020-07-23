package com.sergeev.day6.model.dao;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.DAOException;

import java.util.List;

public interface LibraryDao {

    List<Book> findAll() throws DAOException;

    List<Book> addBook(Book book) throws DAOException;

    List<Book> removeBook(Book book) throws DAOException;

    List<Book> findByTitle(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByCost(double minCost, double maxCost);

    List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages);

    List<Book> findByYearOfPublishing(int minYearOfPublishing, int maxYearOfPublishing);

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByCost();

    List<Book> sortBooksByNumberOfPages();

    List<Book> sortBooksByYearOfPublishing();


}
