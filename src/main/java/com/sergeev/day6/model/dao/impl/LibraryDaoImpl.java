package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.dao.LibraryDao;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.DaoException;
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
    private static final String INSERT_BOOK_SQL = "INSERT INTO book (title, authors, cost, year, numberOfPages)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String REMOVE_BOOK_SQL = "DELETE FROM book WHERE id = ?";
    private static final String REGEX_FOR_SPLIT_AUTHORS = ":";
    private static final String FIND_BOOK_BY_TITLE_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE title = ?";
    private static final String FIND_BOOK_BY_COST_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE cost > ? AND cost < ?";
    private static final String FIND_BOOK_BY_NUMBER_OF_PAGES_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE numberOfPages > ? AND numberOfPages < ?";

    @Override
    public List<Book> findAll() throws DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ALL_BOOKS_SQL);
             ResultSet rs = ps.executeQuery()) {
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                books.add(makeEntity(rs));
            }
            return books;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getInstance().close(connection);
        }
    }

    @Override
    public List<Book> addBook(Book book) throws DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthors().toString());
            statement.setDouble(3, book.getCost());
            statement.setInt(4, book.getYearOfPublishing());
            statement.setInt(5, book.getNumberOfPages());
            statement.executeUpdate();
            List<Book> books = findAll();
            return books;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getInstance().close(connection);
        }
    }

    @Override
    public List<Book> removeBook(Book book) throws DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK_SQL)) {
            statement.setInt(1, book.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getInstance().close(connection);
        }
        List<Book> books = findAll();
        return books;
    }

    @Override
    public List<Book> findByTitle(String nameOfBook) throws DaoException {
        List<Book> result = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_TITLE_SQL)) {
            preparedStatement.setString(1, nameOfBook);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                result.add(makeEntity(resultSet));
                return result;
            }
        } catch (SQLException e) {
            throw new DaoException("Problem when trying to find book by title", e);
        } finally {
        ConnectionPool.getInstance().close(connection);
    }
    }

    @Override
    public List<Book> findByCost(double minCost, double maxCost) throws DaoException{
        List<Book> result = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_COST_SQL)) {
            preparedStatement.setDouble(1, minCost);
            preparedStatement.setDouble(2, maxCost);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                result.add(makeEntity(resultSet));
                return result;
            }
        } catch (SQLException e) {
            throw new DaoException("Problem when trying to find book by cost", e);
        } finally {
        ConnectionPool.getInstance().close(connection);
    }
    }

    @Override
    public List<Book> findByNumberOfPages(int minNumberOfPages, int maxNumberOfPages) throws DaoException {
       List<Book> result = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_NUMBER_OF_PAGES_SQL)) {
            preparedStatement.setInt(1, minNumberOfPages);
            preparedStatement.setDouble(2, maxNumberOfPages);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                result.add(makeEntity(resultSet));
                return result;
            }
        } catch (SQLException e) {
            throw new DaoException("Problem when trying to find book by cost", e);
        } finally {
        ConnectionPool.getInstance().close(connection);
    }
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
