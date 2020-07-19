package com.sergeev.day6.service;

import com.sergeev.day6.model.dao.impl.LibraryDAOImpl;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.DAOException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.model.parser.NumberParser;
import com.sergeev.day6.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    public List<Book> addBook(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            try {
                result = bookListDAO.addBook(book);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    public List<Book> removeBook(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            try {
                result = bookListDAO.removeBook(book);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    public List<Book> findByTitle(String title) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateTitleOfBook(title)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByTitle(title);
        }
        return books;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateAuthorOfBook(author)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByAuthor(author);
        }
        return books;
    }

    public List<Book> findByCost(String minCostLine, String maxCostLine) throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        double minCost = numberParser.parseToDouble(minCostLine);
        double maxCost = numberParser.parseToDouble(maxCostLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateCostOfBook(minCost) && bookValidator.validateCostOfBook(maxCost)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByCost(minCost, maxCost);
        }
        return books;
    }

    public List<Book> findByNumberOfPages(String minNumberOfPagesLine, String maxNumberOfPagesLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minNumberOfPages = numberParser.parseToInt(minNumberOfPagesLine);
        int maxNumberOfPages = numberParser.parseToInt(maxNumberOfPagesLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateNumberOfPagesInBook(minNumberOfPages) &&
                bookValidator.validateNumberOfPagesInBook(maxNumberOfPages)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByNumberOfPages(minNumberOfPages, maxNumberOfPages);
        }
        return books;
    }

    public List<Book> findByYearOfPublishing(String minYearOfPublishingLine, String maxYearOfPublishingLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minYearOfPublishing = numberParser.parseToInt(minYearOfPublishingLine);
        int maxYearOfPublishing = numberParser.parseToInt(maxYearOfPublishingLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateYearOfPublishing(minYearOfPublishing) &&
                bookValidator.validateYearOfPublishing(maxYearOfPublishing)) {
            LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
            books = bookListDAO.findByYearOfPublishing(minYearOfPublishing, maxYearOfPublishing);
        }
        return books;
    }

    public List<Book> sortBooksByTitle() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByTitle();
    }

    public List<Book> sortBooksByAuthors() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByAuthors();
    }

    public List<Book> sortBooksByCost() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByCost();
    }

    public List<Book> sortBooksByNumberOfPages() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByNumberOfPages();
    }

    public List<Book> sortBooksByYearOfPublishing() {
        LibraryDAOImpl bookListDAO = new LibraryDAOImpl();
        return bookListDAO.sortBooksByYearOfPublishing();
    }

}
