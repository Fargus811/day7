package com.sergeev.day6.service;

import com.sergeev.day6.model.dao.impl.BookListDAOImpl;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.LibraryException;
import com.sergeev.day6.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    public List<Book> addBook(Book book) throws LibraryException {
        List<Book> isAdded = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateBook(book)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            isAdded = bookListDAO.addBook(book);
        }
        return isAdded;
    }

    public List<Book> removeBook(Book book) throws LibraryException {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateBook(book)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.removeBook(book);
        }
        return books;
    }

    public List<Book> findByTitle(String title) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateTitleOfBook(title)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByTitle(title);
        }
        return books;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateAuthorOfBook(author)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByAuthor(author);
        }
        return books;
    }

    public List<Book> findByCost(String minCostLine, String maxCostLine) {
        List<Book> books = new ArrayList<>();
        double minCost = Double.parseDouble(minCostLine);
        double maxCost = Double.parseDouble(maxCostLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateCostOfBook(minCost) && bookValidator.validateCostOfBook(maxCost)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByCost(minCost, maxCost);
        }
        return books;
    }

    public List<Book> findByNumberOfPages(String minNumberOfPagesLine, String maxNumberOfPagesLine) {
        List<Book> books = new ArrayList<>();
        int minNumberOfPages = Integer.parseInt(minNumberOfPagesLine);
        int maxNumberOfPages = Integer.parseInt(maxNumberOfPagesLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateNumberOfPagesInBook(minNumberOfPages) &&
                bookValidator.validateNumberOfPagesInBook(maxNumberOfPages)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByNumberOfPages(minNumberOfPages, maxNumberOfPages);
        }
        return books;
    }


    public List<Book> findByYearOfPublishing(String minYearOfPublishingLine, String maxYearOfPublishingLine) {
        List<Book> books = new ArrayList<>();
        int minYearOfPublishing = Integer.parseInt(minYearOfPublishingLine);
        int maxYearOfPublishing = Integer.parseInt(maxYearOfPublishingLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateYearOfPublishing(minYearOfPublishing) &&
                bookValidator.validateYearOfPublishing(maxYearOfPublishing)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByNumberOfPages(minYearOfPublishing, maxYearOfPublishing);
        }
        return books;
    }

    public List<Book> sortBooksByTitle() {
        BookListDAOImpl bookListDAO = new BookListDAOImpl();
        return bookListDAO.sortBooksByTitle();
    }

    public List<Book> sortBooksByAuthors() {
        BookListDAOImpl bookListDAO = new BookListDAOImpl();
        return bookListDAO.sortBooksByAuthors();
    }

    public List<Book> sortBooksByCost() {
        BookListDAOImpl bookListDAO = new BookListDAOImpl();
        return bookListDAO.sortBooksByCost();
    }

    public List<Book> sortBooksByNumberOfPages() {
        BookListDAOImpl bookListDAO = new BookListDAOImpl();
        return bookListDAO.sortBooksByNumberOfPages();
    }

    public List<Book> sortBooksByYearOfPublishing() {
        BookListDAOImpl bookListDAO = new BookListDAOImpl();
        return bookListDAO.sortBooksByYearOfPublishing();
    }

}
