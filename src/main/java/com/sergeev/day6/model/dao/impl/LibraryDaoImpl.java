package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.dao.LibraryDao;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.DAOException;
import com.sergeev.day6.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LibraryDaoImpl implements LibraryDao {

    private static final String FIND_ALL_BOOKS_SQL = "SELECT id, title, authors, cost, year, numberOfPages FROM book";
    private static final String REGEX_FOR_SPLIT_AUTHORS = ":";


    @Override
    public List<Book> findAll() throws DAOException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_BOOKS_SQL);
             ResultSet rs = ps.executeQuery()) {
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                books.add(makeEntity(rs));
            }
            return books;
        } catch (SQLException e) {
            throw new DAOException(e);
        }finally {
            ConnectionPool.getInstance().close(connection);
        }
    }

    @Override
    public List<Book> addBook(Book book) throws DAOException {

//        List<Book> books = Library.getInstance().findAll();
//        if (books.size() + 1 < Library.MAX_CAPACITY && !books.contains(book)) {
//            Library.getInstance().addBook(book);
//        } else {
//            throw new DAOException("Library is full or contains this book");
//        }
//        return Library.getInstance().findAll();
        return null;
    }

    @Override
    public List<Book> removeBook(Book book) throws DAOException {
//        List<Book> books = Library.getInstance().findAll();
//        if (books.contains(book)) {
//            Library.getInstance().removeBook(book);
//        } else {
//            throw new DAOException("Book not found");
//        }
//        return Library.getInstance().findAll();
        return null;
    }

    @Override
    public List<Book> findByTitle(String nameOfBook) {
//        List<Book> bookList = new ArrayList<>();
//        for (Book book : Library.getInstance().findAll()) {
//            if (nameOfBook.equals(book.getTitle())) {
//                bookList.add(book);
//            }
//        }
//        return bookList;
        return null;
    }

    @Override
    public List<Book> findByAuthor(String authorName) {
//        List<Book> bookList = new ArrayList<>();
//        for (Book book : Library.getInstance().findAll()) {
//            checkBookByAuthorName(authorName, bookList, book);
//        }
//        return bookList;
        return null;
    }

    private void checkBookByAuthorName(String authorName, List<Book> bookList, Book book) {
        for (String author : book.getAuthors()) {
            if (authorName.equals(author)) {
                bookList.add(book);
                break;
            }
        }
    }

    @Override
    public List<Book> findByCost(double minCost, double maxCost) {
//        List<Book> bookList = new ArrayList<>();
//        for (Book book : Library.getInstance().findAll()) {
//            double currentCost = book.getCost();
//            if (currentCost >= minCost && currentCost <= maxCost) {
//                bookList.add(book);
//            }
//        }
        return null;
    }

    @Override
    public List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages) {
//        List<Book> bookList = new ArrayList<>();
//        for (Book book : Library.getInstance().findAll()) {
//            int currentNumberOfPages = book.getNumberOfPages();
//            if (currentNumberOfPages >= minNumberOfPages && currentNumberOfPages <= maxNumberOfPages) {
//                bookList.add(book);
//            }
//        }
//        return bookList;
        return null;
    }

    @Override
    public List<Book> findByYearOfPublishing(int minYearOfPublishing, int maxYearOfPublishing) {
//        List<Book> bookList = new ArrayList<>();
//        for (Book book : Library.getInstance().findAll()) {
//            int currentYearOfPublishing = book.getYearOfPublishing();
//            if (currentYearOfPublishing >= minYearOfPublishing && currentYearOfPublishing <= maxYearOfPublishing) {
//                bookList.add(book);
//            }
//        }
        return null;
    }

    @Override
    public List<Book> sortBooksByTitle() {
//        List<Book> sortedList = new ArrayList<>(Library.getInstance().findAll());
//        sortedList.sort(new BookTitleComparator());
//        return sortedList;
        return null;
    }

    @Override
    public List<Book> sortBooksByAuthors() {
//        List<Book> sortedList = new ArrayList<>();
//        sortedList.addAll(Library.getInstance().findAll());
//        sortedList.sort(new BookAuthorComparator());
//        return sortedList;
        return null;
    }

    @Override
    public List<Book> sortBooksByCost() {
//        List<Book> sortedList = new ArrayList<>();
//        sortedList.addAll(Library.getInstance().findAll());
//        sortedList.sort(new BookCostComparator());
//        return sortedList;
        return null;
    }

    @Override
    public List<Book> sortBooksByNumberOfPages() {
//        List<Book> sortedList = new ArrayList<>();
//        sortedList.addAll(Library.getInstance().findAll());
//        sortedList.sort(new BookNumberOfPagesComparator());
//        return sortedList;
        return null;
    }

    @Override
    public List<Book> sortBooksByYearOfPublishing() {
//        List<Book> books = Library.getInstance().findAll();
//        List<Book> sortedList = new ArrayList<>();
//        sortedList.addAll(books);
//        sortedList.sort(new BookYearOfPublishingComparator());
//        return sortedList;
        return null;
    }


    private Book makeEntity(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle("title");
        book.setAuthors(Arrays.asList(rs.getString("authors").trim().split(REGEX_FOR_SPLIT_AUTHORS)));
        book.setCost(rs.getDouble("cost"));
        book.setYearOfPublishing(rs.getInt("year"));
        book.setNumberOfPages(rs.getInt("numberOfPages"));
        return book;
    }
}
