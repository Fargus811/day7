package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.change.AddBookCommand;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class FindBookByTitleCommandTest {

    private FindBookByTitleCommand findBookByTitleCommand;
    private Map<String, String> params;

    @BeforeMethod
    public void setUp() {
        findBookByTitleCommand = new FindBookByTitleCommand();
        params = new HashMap<>();
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "99");
        params.put("year", "2009");
    }

    @Test
    public void testExecute() throws CommandException {
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.execute(params);
        Map<String, String> findMap = new HashMap<>();
        findMap.put("title", "TestBook");
        Book book = new Book();
        book.setTitle("TestBook");
        List<String> authors = new ArrayList<>();
        authors.add("Author 1");
        authors.add("Author 2");
        book.setAuthors(authors);
        book.setCost(20.0);
        book.setNumberOfPages(99);
        book.setYearOfPublishing(2009);
        List<Book> expected = new ArrayList<>();
        expected.add(book);
        List<Book> actual = findBookByTitleCommand.execute(findMap);
        assertEquals(actual, expected);
    }

    @Test
    public void testExecuteNoMatches() throws CommandException {
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.execute(params);
        Map<String, String> findMap = new HashMap<>();
        findMap.put("title", "TestBook1");
        List<Book> expected = new ArrayList<>();
        List<Book> actual = findBookByTitleCommand.execute(findMap);
        assertEquals(actual, expected);
    }

}

