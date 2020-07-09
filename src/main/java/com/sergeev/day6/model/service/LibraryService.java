package com.sergeev.day6.model.service;

import com.sergeev.day6.model.dao.impl.BookListDAOImpl;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.ProgramException;
import com.sergeev.day6.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    public boolean addBook(Book book) throws ProgramException {
        boolean isAdded = false;
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateBook(book)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            isAdded = bookListDAO.addBook(book);
        }
        return isAdded;
    }

    public boolean removeBook(Book book) throws ProgramException {
        boolean isRemoved = false;
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateBook(book)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            isRemoved = bookListDAO.removeBook(book);
        }
        return isRemoved;
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

    public List<Book> findByCost(double cost) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateCostOfBook(cost)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByCost(cost);
        }
        return books;
    }

    public List<Book> findByNumberOfPages(int numberOfPages) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateNumberOfPagesInBook(numberOfPages)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByNumberOfPages(numberOfPages);
        }
        return books;
    }


    public List<Book> findByYearOfPublishing(int yearOfPublishing) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateYearOfPublishing(yearOfPublishing)) {
            BookListDAOImpl bookListDAO = new BookListDAOImpl();
            books = bookListDAO.findByNumberOfPages(yearOfPublishing);
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


}
