package com.sergeev.day6.controller.command.change;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class AddBookCommandTest {

    private AddBookCommand addBookCommand;
    private Map<String, String> params;

    @BeforeMethod
    public void setUp() {
        addBookCommand = new AddBookCommand();
        params = new HashMap<>();
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
    }

    @Test
    public void testExecute() throws CommandException {
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
        List<Book> actual = addBookCommand.execute(params);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CommandException.class)
    public void testExecuteNullMapCommandException() throws CommandException {
        addBookCommand.execute(params);
        addBookCommand.execute(params);
    }
}
