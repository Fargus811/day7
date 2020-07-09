package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.dao.BookListDAO;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.entity.Library;
import com.sergeev.day6.model.exception.ProgramException;
import com.sergeev.day6.model.util.comparator.BookAuthorComparator;
import com.sergeev.day6.model.util.comparator.BookCostComparator;
import com.sergeev.day6.model.util.comparator.BookNumberOfPagesComparator;
import com.sergeev.day6.model.util.comparator.BookYearOfPublishingComparator;
import com.sergeev.day6.model.validator.BookValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookListDAOImpl implements BookListDAO {

    public boolean addBook(Book book) throws ProgramException {
        return Library.getInstance().addBook(book);
    }

    public boolean removeBook(Book book) throws ProgramException {
        return Library.getInstance().removeBook(book);
    }

    public List<Book> findByTitle(String nameOfBook) {
        BookValidator bookValidator = new BookValidator();
        List<Book> bookList = new ArrayList<>();
        if (bookValidator.validateTitleOfBook(nameOfBook)) {
            for (Book book : Library.getInstance().findAll()) {
                if (nameOfBook.equals(book.getTitle())) {
                    bookList.add(book);
                }
            }
        }
        return bookList;
    }

    public List<Book> findByAuthor(String authorName) {
        BookValidator bookValidator = new BookValidator();
        List<Book> bookList = new ArrayList<>();
        if (bookValidator.validateAuthorOfBook(authorName)) {
            for (Book book : Library.getInstance().findAll()) {
                checkBookByAuthorName(authorName, bookList, book);
            }
        }
        return bookList;
    }

    private void checkBookByAuthorName(String authorName, List<Book> bookList, Book book) {
        for (String author : book.getAuthors()) {
            if (authorName.equals(author)) {
                bookList.add(book);
                break;
            }
        }
    }

    public List<Book> findByCost(double cost) {
        BookValidator bookValidator = new BookValidator();
        List<Book> bookList = new ArrayList<>();
        if (bookValidator.validateCostOfBook(cost)) {
            for (Book book : bookList) {
                if (cost == book.getCost()) {
                    bookList.add(book);
                }
            }
        }
        return bookList;
    }

    public List<Book> findByNumberOfPages(int numberOfPage) {
        BookValidator bookValidator = new BookValidator();
        List<Book> bookList = new ArrayList<>();
        if (bookValidator.validateNumberOfPagesInBook(numberOfPage)) {
            for (Book book : Library.getInstance().findAll()) {
                if (numberOfPage == book.getNumberOfPages()) {
                    bookList.add(book);
                }
            }
        }
        return bookList;
    }

    public List<Book> findByYearOfPublishing(int yearOfPublishing) {
        BookValidator bookValidator = new BookValidator();
        List<Book> bookList = new ArrayList<>();
        if (bookValidator.validateYearOfPublishing(yearOfPublishing)) {
            for (Book book : Library.getInstance().findAll()) {
                if (yearOfPublishing == book.getYearOfPublishing()) {
                    bookList.add(book);
                }
            }
        }
        return bookList;
    }

    public List<Book> sortBooksByTitle() {
        List<Book> sortedList = Library.getInstance().findAll();
        sortedList.sort(Comparator.comparing(Book::getTitle));
        return sortedList;
    }

    public List<Book> sortBooksByAuthors() {
        List<Book> sortedList = Library.getInstance().findAll();
        sortedList.sort(new BookAuthorComparator());
        return sortedList;
    }


    public List<Book> sortBooksByCost() {
        List<Book> sortedList = Library.getInstance().findAll();
        sortedList.sort(new BookCostComparator());
        return sortedList;
    }

    public List<Book> sortBooksByNumberOfPages() {
        List<Book> sortedList = Library.getInstance().findAll();
        sortedList.sort(new BookNumberOfPagesComparator());
        return sortedList;
    }

    public List<Book> sortBooksByYearOfPublishing() {
        List<Book> sortedList = Library.getInstance().findAll();
        sortedList.sort(new BookYearOfPublishingComparator());
        return sortedList;
    }
}
