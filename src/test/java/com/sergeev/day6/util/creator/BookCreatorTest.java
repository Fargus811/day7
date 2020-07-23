package com.sergeev.day6.util.creator;

import com.sergeev.day6.model.entity.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class BookCreatorTest {

    private BookCreator bookCreator;
    private static final String AUTHOR_KEY = "authors";
    private static final String COST_KEY = "cost";
    private static final String NUMBER_OF_PAGES_KEY = "numberOfPages";
    private static final String TITLE_KEY = "title";
    private static final String YEAR_KEY = "year";

    @BeforeMethod
    public void setUp() {
        bookCreator = new BookCreator();
    }

    @Test
    public void testCreateBookFromMap() {
        Map<String, String> params = new HashMap<>();
        params.put(TITLE_KEY, "TestBook1");
        params.put(AUTHOR_KEY, "Sergeev D.:Hemster W.");
        params.put(COST_KEY, "20.0");
        params.put(NUMBER_OF_PAGES_KEY, "300");
        params.put(YEAR_KEY, "2010");
        Book actual = bookCreator.createBookFromMap(params).get();
        Book expected = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        expected.setTitle("TestBook1");
        expected.setYearOfPublishing(2010);
        expected.setNumberOfPages(300);
        expected.setCost(20.0);
        expected.setAuthors(authors);
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateBookFromEmptyMap() {
        Map<String, String> params = new HashMap<>();
        Optional<Book> actual = bookCreator.createBookFromMap(params);
        assertFalse(actual.isPresent());
    }
}
