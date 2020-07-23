package com.sergeev.day6.controller;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ControllerTest {

    private Controller controller;

    @BeforeMethod
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void testProcessRequestAddCommand() throws CommandException {
        Map<String, String> params = new HashMap<>();
        String commandName = "add";
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
        Book book = new Book();
        book.setTitle("TestBook");
        List<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        book.setAuthors(authors);
        book.setCost(20.0);
        book.setNumberOfPages(20);
        book.setYearOfPublishing(2009);
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        List<Book> actual = controller.processRequest(commandName, params);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CommandException.class)
    public void testProcessRequestAddCommandException() throws CommandException {
        Map<String, String> params = new HashMap<>();
        String commandName = "add";
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
        controller.processRequest(commandName, params);
        controller.processRequest(commandName, params);
    }

    @Test
    public void testProcessRequestRemoveCommand() throws CommandException {
        Map<String, String> params = new HashMap<>();
        String commandNameToRemove = "remove";
        String commandNameToAdd = "add";
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
        Book book = new Book();
        book.setTitle("TestBook");
        List<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        book.setAuthors(authors);
        book.setCost(20.0);
        book.setNumberOfPages(20);
        book.setYearOfPublishing(2009);
        List<Book> expected = new ArrayList<>();
        controller.processRequest(commandNameToAdd, params);
        List<Book> actual = controller.processRequest(commandNameToRemove, params);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CommandException.class)
    public void testProcessRequestRemoveCommandException() throws CommandException {
        Map<String, String> params = new HashMap<>();
        String commandNameToRemove = "remove";
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
        controller.processRequest(commandNameToRemove, params);
    }

    @Test
    public void testProcessRequestFindByCostCommand() throws CommandException {
        Map<String, String> params = new HashMap<>();
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
        String commandNameToFind = "find_by_cost";
        String commandNameToAdd = "add";
        controller.processRequest(commandNameToAdd, params);
        Map<String, String> findMap = new HashMap<>();
        findMap.put("minCost", "38");
        findMap.put("maxCost", "58");
        List<Book> actual = controller.processRequest(commandNameToFind, findMap);
        List<Book> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CommandException.class)
    public void testProcessRequestFindByCostCommandException() throws CommandException {
        String commandNameToFind = "find_by_cost";
        Map<String, String> findMap = new HashMap<>();
        findMap.put("minCost", "38dfd");
        findMap.put("maxCost", "58cvc");
        List<Book> actual = controller.processRequest(commandNameToFind, findMap);
        List<Book> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }

    @Test
    public void testProcessRequestSortByCostCommand() throws CommandException {
        Library library = Library.getInstance();
        String commandName = "sort_by_cost";
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        Book bookFirst = new Book();
        bookFirst.setTitle("TestBook1");
        bookFirst.setYearOfPublishing(2010);
        bookFirst.setNumberOfPages(300);
        bookFirst.setCost(20.0);
        bookFirst.setAuthors(authors);
        List<String> authorsSecond = new ArrayList<>();
        authorsSecond.add("Tergeev D.");
        authorsSecond.add("Bemster W.");
        Book bookSecond = new Book();
        bookSecond.setTitle("TestBook2");
        bookSecond.setYearOfPublishing(2000);
        bookSecond.setNumberOfPages(3000);
        bookSecond.setCost(200);
        bookSecond.setAuthors(authorsSecond);
        library.addBook(bookFirst);
        library.addBook(bookSecond);
        List<Book> actual = controller.processRequest(commandName, new HashMap<>());
        List<Book> expected = Library.getInstance().findAll();
        assertEquals(actual, expected);
    }
}
