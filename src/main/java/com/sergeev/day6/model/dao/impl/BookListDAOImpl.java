package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.dao.BookListDAO;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.entity.Library;
import com.sergeev.day6.model.exception.LibraryException;
import com.sergeev.day6.util.comparator.BookAuthorComparator;
import com.sergeev.day6.util.comparator.BookCostComparator;
import com.sergeev.day6.util.comparator.BookNumberOfPagesComparator;
import com.sergeev.day6.util.comparator.BookYearOfPublishingComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookListDAOImpl implements BookListDAO {

    public List<Book> addBook(Book book) throws LibraryException {
        Library.getInstance().addBook(book);
        return Library.getInstance().findAll();
    }

    public List<Book> removeBook(Book book) throws LibraryException {
        Library.getInstance().removeBook(book);
        return Library.getInstance().findAll();
    }

    public List<Book> findByTitle(String nameOfBook) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : Library.getInstance().findAll()) {
            if (nameOfBook.equals(book.getTitle())) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findByAuthor(String authorName) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : Library.getInstance().findAll()) {
            checkBookByAuthorName(authorName, bookList, book);
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

    public List<Book> findByCost(double minCost, double maxCost) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : bookList) {
            double currentCost = book.getCost();
            if (currentCost >= minCost && currentCost <= maxCost) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : Library.getInstance().findAll()) {
            int currentNumberOfPages = book.getNumberOfPages();
            if (currentNumberOfPages >= minNumberOfPages && currentNumberOfPages <= maxNumberOfPages) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findByYearOfPublishing(int minYearOfPublishing, int maxYearOfPublishing) {
        List<Book> bookList = new ArrayList<>();
        for (Book book : Library.getInstance().findAll()) {
            int currentYearOfPublishing = book.getYearOfPublishing();
            if (currentYearOfPublishing >= minYearOfPublishing && currentYearOfPublishing <= maxYearOfPublishing) {
                bookList.add(book);
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
