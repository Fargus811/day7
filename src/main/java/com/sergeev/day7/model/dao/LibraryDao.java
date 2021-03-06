package com.sergeev.day7.model.dao;

import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.DaoException;

import java.util.List;

public interface LibraryDao {

    List<Book> findAll() throws DaoException;

    List<Book> addBook(Book book) throws DaoException;

    List<Book> removeBookByTitle(Book book) throws DaoException;

    List<Book> findByTitle(String name) throws DaoException;

    List<Book> findByCost(double minCost, double maxCost) throws DaoException;

    List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages) throws DaoException;

    List<Book> findByYearOfPublishing(int minYearOfPublishing, int maxYearOfPublishing) throws DaoException;

    List<Book> sortBooksBy(String parameter) throws DaoException;
}
