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

public class FindBookByAuthorCommandTest {

    private FindBookByAuthorCommand findBookByAuthorCommand;
    private Map<String, String> params;

    @BeforeMethod
    public void setUp() {
        findBookByAuthorCommand = new FindBookByAuthorCommand();
        params = new HashMap<>();
        params.put("title", "TestBook");
        params.put("authors", "Author 1:Author 2");
        params.put("cost", "20.0");
        params.put("numberOfPages", "20");
        params.put("year", "2009");
    }

    @Test
    public void testExecute() throws CommandException {
        AddBookCommand addBookCommand = new AddBookCommand();
        addBookCommand.execute(params);
        Map<String, String> findMap = new HashMap<>();
        findMap.put("author", "Sergo");
        List<Book> actual = findBookByAuthorCommand.execute(findMap);
        List<Book> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }
}
