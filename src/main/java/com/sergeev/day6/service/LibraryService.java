package com.sergeev.day6.service;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.ServiceException;

import java.util.List;

public interface LibraryService {

    List<Book> addBook(Book book) throws ServiceException;

    List<Book> removeBook(Book book) throws ServiceException;

    List<Book> findByTitle(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByCost(String minCost, String maxCost) throws ServiceException;

    List<Book> findByNumberOfPages(String minNumberOfPages, String maxNumberOfPages) throws ServiceException;

    List<Book> findByYearOfPublishing(String minYearOfPublishing, String maxYearOfPublishing) throws ServiceException;

    List<Book> sortBooksByTitle();

    List<Book> sortBooksByAuthors();

    List<Book> sortBooksByCost();

    List<Book> sortBooksByNumberOfPages();

    List<Book> sortBooksByYearOfPublishing();
}
