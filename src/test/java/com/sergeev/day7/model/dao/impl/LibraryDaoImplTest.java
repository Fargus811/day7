package com.sergeev.day7.model.dao.impl;

import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.DaoException;
import com.sergeev.day7.pool.ConnectionPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LibraryDaoImplTest {

    private LibraryDaoImpl libraryDao;
    private Connection connection;
    private Statement statement;
    private Book bookFirst;
    private Book bookSecond;
    private Book bookThird;

    @BeforeMethod
    public void setup() throws DaoException, SQLException {
        libraryDao = new LibraryDaoImpl();
        bookFirst = new Book();
        bookSecond = new Book();
        bookThird = new Book();
        String authors = "Sergeev D.,Hemster W.";
        bookFirst.setId(1);
        bookFirst.setTitle("AestBook1");
        bookFirst.setYearOfPublishing(2010);
        bookFirst.setNumberOfPages(300);
        bookFirst.setCost(20.0);
        bookFirst.setAuthors(authors);
        String authorsSecond = "Tergeev D.,Bemster W.";
        bookSecond.setId(2);
        bookSecond.setTitle("BestBook2");
        bookSecond.setYearOfPublishing(2000);
        bookSecond.setNumberOfPages(3000);
        bookSecond.setCost(200);
        bookSecond.setAuthors(authorsSecond);
        String authorsThird = "Tergeev D.,Bemster W.";
        bookThird.setId(3);
        bookThird.setTitle("GestBook3");
        bookThird.setYearOfPublishing(2012);
        bookThird.setNumberOfPages(100);
        bookThird.setCost(2);
        bookThird.setAuthors(authorsThird);
        connection = ConnectionPool.getInstance().takeConnection();
        statement = connection.createStatement();
        statement.execute("create table book (id integer auto_increment, title varchar , authors varchar , cost double , year integer " +
                ", numberOfPages integer ) ");
        statement.execute("INSERT INTO book (title, authors, cost, year , numberOfPages)" +
                " VALUES ('AestBook1', 'Sergeev D.,Hemster W.', 20.0,2010, 300 )");
        statement.execute("INSERT INTO book (title, authors, cost, year , numberOfPages)" +
                " VALUES ('BestBook2', 'Tergeev D.,Bemster W.', 200,2000, 3000 )");
        connection.commit();
        connection.close();
    }


    @Test
    public void testFindAll() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryDao.findAll();
        assertEquals(actual, expected);
    }

    @Test
    public void testAddBook() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        expected.add(bookThird);
        List<Book> actual = libraryDao.addBook(bookThird);
        assertEquals(actual, expected);
    }

    @Test
    public void testRemoveBookById() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDao.removeBookByTitle(bookSecond);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByTitle() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDao.findByTitle("AestBook1");
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByCost() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDao.findByCost(10.0, 30.0);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByNumberOfPages() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDao.findByNumberOfPages(100, 350);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByYearOfPublishing() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDao.findByYearOfPublishing(2009, 2011);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByParameter() throws DaoException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookSecond);
        expected.add(bookFirst);
        List<Book> actual = libraryDao.sortBooksBy("year");
        assertEquals(actual, expected);
    }


    @AfterMethod
    public void after() throws SQLException, DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE book");
    }
}
