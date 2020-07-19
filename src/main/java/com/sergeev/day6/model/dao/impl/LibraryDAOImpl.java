package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.dao.LibraryDAO;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.entity.Library;
import com.sergeev.day6.model.exception.DAOException;
import com.sergeev.day6.util.comparator.*;

import java.util.ArrayList;
import java.util.List;


public class LibraryDAOImpl implements LibraryDAO {

    public List<Book> addBook(Book book) throws DAOException {
        List<Book> books = Library.getInstance().findAll();
        if (books.size() + 1 < Library.MAX_CAPACITY && !books.contains(book)) {
            Library.getInstance().addBook(book);
        } else {
            throw new DAOException("Library is full or contains this book");
        }
        return Library.getInstance().findAll();
    }

    public List<Book> removeBook(Book book) throws DAOException {
        List<Book> books = Library.getInstance().findAll();
        if (books.contains(book)) {
            Library.getInstance().removeBook(book);
        } else {
            throw new DAOException("Book not found");
        }
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
        for (Book book : Library.getInstance().findAll()) {
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
        List<Book> books = Library.getInstance().findAll();
        List<Book> sortedList = new ArrayList<>();
        sortedList.addAll(books);
        sortedList.sort(new BookTitleComparator());
        return sortedList;
    }

    public List<Book> sortBooksByAuthors() {
        List<Book> books = Library.getInstance().findAll();
        List<Book> sortedList = new ArrayList<>();
        sortedList.addAll(books);
        sortedList.sort(new BookAuthorComparator());
        return sortedList;
    }


    public List<Book> sortBooksByCost() {
        List<Book> books = Library.getInstance().findAll();
        List<Book> sortedList = new ArrayList<>();
        sortedList.addAll(books);
        sortedList.sort(new BookCostComparator());
        return sortedList;
    }

    public List<Book> sortBooksByNumberOfPages() {
        List<Book> books = Library.getInstance().findAll();
        List<Book> sortedList = new ArrayList<>();
        sortedList.addAll(books);
        sortedList.sort(new BookNumberOfPagesComparator());
        return sortedList;
    }

    public List<Book> sortBooksByYearOfPublishing() {
        List<Book> books = Library.getInstance().findAll();
        List<Book> sortedList = new ArrayList<>();
        sortedList.addAll(books);
        sortedList.sort(new BookYearOfPublishingComparator());
        return sortedList;
    }
}
