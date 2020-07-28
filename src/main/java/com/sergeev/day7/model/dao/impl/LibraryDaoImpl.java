package com.sergeev.day7.model.dao.impl;

import com.sergeev.day7.model.dao.LibraryDao;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.DaoException;
import com.sergeev.day7.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LibraryDaoImpl implements LibraryDao {

    private static final String FIND_ALL_BOOKS_SQL = "SELECT id, title, authors, cost, year, numberOfPages FROM book";
    private static final String INSERT_BOOK_SQL = "INSERT INTO book (title, authors, cost, year, numberOfPages)" +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String REMOVE_BOOK_BY_TITLE_SQL = "DELETE FROM book WHERE title = ?";
    private static final String FIND_BOOK_BY_TITLE_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE title = ?";
    private static final String FIND_BOOK_BY_COST_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE cost > ? AND cost < ?";
    private static final String FIND_BOOK_BY_NUMBER_OF_PAGES_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE numberOfPages > ? AND numberOfPages < ?";
    private static final String FIND_BOOK_BY_YEAR_SQL = "SELECT id, title, authors, cost, year, numberOfPages " +
            "FROM book WHERE year > ? AND year < ?";
    private static final String SORT_BOOK_SQL_BY_PARAMETER = "SELECT id, title, authors, cost, year, numberOfPages FROM" +
            " book ORDER BY ";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHORS = "authors";
    private static final String COLUMN_COST = "cost";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_NUMBER_OF_PAGES = "numberOfPages";

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
            statement.setString(2, book.getAuthors());
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
    public List<Book> removeBookByTitle(Book book) throws DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement statement = connection.prepareStatement(REMOVE_BOOK_BY_TITLE_SQL)) {
            statement.setString(1, book.getTitle());
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
    public List<Book> findByCost(double minCost, double maxCost) throws DaoException {
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
            throw new DaoException("Problem when trying to find book by number of pages", e);
        } finally {
            ConnectionPool.getInstance().close(connection);
        }
    }

    @Override
    public List<Book> findByYearOfPublishing(int minYearOfPublishing, int maxYearOfPublishing) throws DaoException {
        List<Book> result = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().takeConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BOOK_BY_YEAR_SQL)) {
            preparedStatement.setInt(1, minYearOfPublishing);
            preparedStatement.setDouble(2, maxYearOfPublishing);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                result.add(makeEntity(resultSet));
                return result;
            }
        } catch (SQLException e) {
            throw new DaoException("Problem when trying to find book by year of publishing", e);
        } finally {
            ConnectionPool.getInstance().close(connection);
        }
    }

    @Override
    public List<Book> sortBooksBy(String sortParameter) throws DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String resultSql = SORT_BOOK_SQL_BY_PARAMETER.concat(sortParameter);
        try (PreparedStatement ps = connection.prepareStatement(resultSql);
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

    private Book makeEntity(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt(COLUMN_ID));
        book.setTitle(resultSet.getString(COLUMN_TITLE));
        book.setAuthors(resultSet.getString(COLUMN_AUTHORS));
        book.setCost(resultSet.getDouble(COLUMN_COST));
        book.setYearOfPublishing(resultSet.getInt(COLUMN_YEAR));
        book.setNumberOfPages(resultSet.getInt(COLUMN_NUMBER_OF_PAGES));
        return book;
    }
}
