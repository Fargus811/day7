package com.sergeev.day7.controller.command.change;

import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;
import com.sergeev.day7.model.exception.DaoException;
import com.sergeev.day7.pool.ConnectionPool;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AddBookCommandTest {

    private AddBookCommand addBookCommand;
    private Connection connection;
    private Statement statement;
    private Book bookFirst;
    private Book bookSecond;
    private Book bookThird;

    @BeforeMethod
    public void setup() throws DaoException, SQLException {
        addBookCommand = new AddBookCommand();
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
    public void testExecute() throws CommandException {
        Map<String, String> params = new HashMap<>();
        params.put("title", "GestBook3");
        params.put("authors", "Tergeev D.,Bemster W.");
        params.put("cost", "2.0");
        params.put("numberOfPages", "100");
        params.put("year", "2012");
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        expected.add(bookThird);
        List<Book> actual = addBookCommand.execute(params);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CommandException.class)
    public void testAddBookTwiceDaoException() throws CommandException {
        Map<String, String> params = new HashMap<>();
        params.put("title", "BestBook2");
        params.put("authors", "Tergeev D.,Bemster W.");
        params.put("cost", "200.0");
        params.put("numberOfPages", "3000");
        params.put("year", "2000");
        addBookCommand.execute(params);
    }

    @AfterMethod
    public void after() throws SQLException, DaoException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE book");
    }
}
