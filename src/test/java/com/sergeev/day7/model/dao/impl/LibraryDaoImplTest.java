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

    @BeforeMethod
    public void setup() throws DaoException, SQLException {
        libraryDao = new LibraryDaoImpl();

        Connection connection = ConnectionPool.getInstance().takeConnection();
        Statement statement = connection.createStatement();
        statement.execute("create table book (id integer auto_increment, title varchar , authors varchar , cost double , year integer " +
                ", numberOfPages integer ) ");
        statement.execute("INSERT INTO book (title, authors, cost, year , numberOfPages)" +
                " VALUES ('TestBook1', 'Sergeev D.,Hemster W.', 20.0,2010, 300 )");
        statement.execute("INSERT INTO book (title, authors, cost, year , numberOfPages)" +
                " VALUES ('TestBook2', 'Tergeev D.,Bemster W.', 200,2000, 3000 )");
        connection.commit();
        connection.close();
    }


    @Test
    public void testFindAll() throws DaoException {
        List<Book> expected = new ArrayList<>();
        Book bookFirst = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        bookFirst.setId(1);
        bookFirst.setTitle("TestBook1");
        bookFirst.setYearOfPublishing(2010);
        bookFirst.setNumberOfPages(300);
        bookFirst.setCost(20.0);
        bookFirst.setAuthors(authors);
        Book bookSecond = new Book();
        List<String> authorsSecond = new ArrayList<>();
        authorsSecond.add("Tergeev D.");
        authorsSecond.add("Bemster W.");
        bookSecond.setId(2);
        bookSecond.setTitle("TestBook2");
        bookSecond.setYearOfPublishing(2000);
        bookSecond.setNumberOfPages(3000);
        bookSecond.setCost(200);
        bookSecond.setAuthors(authorsSecond);
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryDao.findAll();
        assertEquals(actual,expected);
    }

    @Test
    public void testAddBook() throws DaoException, SQLException {


    }
/*
    @Test
    public void testRemoveBook() {
    }

    @Test
    public void testFindByTitle() {
    }

    @Test
    public void testFindByCost() {
    }

    @Test
    public void testFindByNumberOfPages() {
    }

    @Test
    public void testFindByYearOfPublishing() {
    }

    @Test
    public void testSortBooksByTitle() {
    }

    @Test
    public void testSortBooksByAuthors() {
    }

    @Test
    public void testSortBooksByCost() {
    }

    @Test
    public void testSortBooksByNumberOfPages() {
    }

    @Test
    public void testSortBooksByYearOfPublishing() {
    }*/

    @AfterMethod
    public void after() throws SQLException, DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE book");
    }
}
