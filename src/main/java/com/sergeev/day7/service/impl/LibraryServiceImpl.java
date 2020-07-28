package com.sergeev.day7.service.impl;

import com.sergeev.day7.model.dao.impl.LibraryDaoImpl;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.DaoException;
import com.sergeev.day7.model.exception.ServiceException;
import com.sergeev.day7.service.LibraryService;
import com.sergeev.day7.util.parser.NumberParser;
import com.sergeev.day7.validator.BookValidator;

import java.util.ArrayList;
import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Book> addBook(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
            try {
                checkBookInLibrary(book, bookListDAO);
                result = bookListDAO.addBook(book);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return result;
    }

    private void checkBookInLibrary(Book book, LibraryDaoImpl bookListDAO) throws DaoException, ServiceException {
        List<Book> allBooks = bookListDAO.findAll();
        for (Book bookFromLibrary : allBooks) {
            bookFromLibrary.setId(0);
        }
        if (allBooks.contains(book)) {
            throw new ServiceException("This book is already exists");
        }
    }

    @Override
    public List<Book> removeBookByTitle(Book book) throws ServiceException {
        List<Book> result = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (book != null && bookValidator.validateBook(book)) {
            LibraryDaoImpl libraryDao = new LibraryDaoImpl();
            try {
                result = libraryDao.removeBookByTitle(book);
            } catch (DaoException e) {
                throw new ServiceException("This book is not exist", e);
            }
        }
        return result;
    }

    @Override
    public List<Book> findByTitle(String title) throws ServiceException {
        List<Book> books = new ArrayList<>();
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateTitleOfBook(title)) {
            LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
            try {
                books = bookListDAO.findByTitle(title);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByCost(String minCostLine, String maxCostLine) throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        double minCost = numberParser.parseToDouble(minCostLine);
        double maxCost = numberParser.parseToDouble(maxCostLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateCostOfBook(minCost) && bookValidator.validateCostOfBook(maxCost)) {
            LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
            try {
                books = bookListDAO.findByCost(minCost, maxCost);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByNumberOfPages(String minNumberOfPagesLine, String maxNumberOfPagesLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minNumberOfPages = numberParser.parseToInt(minNumberOfPagesLine);
        int maxNumberOfPages = numberParser.parseToInt(maxNumberOfPagesLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateNumberOfPagesInBook(minNumberOfPages) &&
                bookValidator.validateNumberOfPagesInBook(maxNumberOfPages)) {
            LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
            try {
                books = bookListDAO.findByNumberOfPages(minNumberOfPages, maxNumberOfPages);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return books;
    }

    @Override
    public List<Book> findByYearOfPublishing(String minYearOfPublishingLine, String maxYearOfPublishingLine)
            throws ServiceException {
        List<Book> books = new ArrayList<>();
        NumberParser numberParser = new NumberParser();
        int minYearOfPublishing = numberParser.parseToInt(minYearOfPublishingLine);
        int maxYearOfPublishing = numberParser.parseToInt(maxYearOfPublishingLine);
        BookValidator bookValidator = new BookValidator();
        if (bookValidator.validateYearOfPublishing(minYearOfPublishing) &&
                bookValidator.validateYearOfPublishing(maxYearOfPublishing)) {
            LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
            try {
                books = bookListDAO.findByYearOfPublishing(minYearOfPublishing, maxYearOfPublishing);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return books;
    }

    @Override
    public List<Book> sortBooksBy(String parameter) throws ServiceException {
        LibraryDaoImpl bookListDAO = new LibraryDaoImpl();
        List<Book> result;
        try {
            result = bookListDAO.sortBooksBy(parameter);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return result;
    }
}
