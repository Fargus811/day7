package com.sergeev.day6.util.comparator;

import com.sergeev.day6.model.entity.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BookAuthorComparatorTest {

    private BookAuthorComparator bookAuthorComparator;
    private Book bookFirst;
    private Book bookSecond;

    @BeforeMethod
    public void setUp() {
        bookAuthorComparator = new BookAuthorComparator();
        bookFirst = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        bookFirst.setTitle("TestBook1");
        bookFirst.setYearOfPublishing(2010);
        bookFirst.setNumberOfPages(300);
        bookFirst.setCost(20.0);
        bookFirst.setAuthors(authors);
        bookSecond = new Book();
        List<String> authorsSecond = new ArrayList<>();
        authorsSecond.add("Tergeev D.");
        authorsSecond.add("Bemster W.");
        bookSecond.setTitle("TestBook2");
        bookSecond.setYearOfPublishing(2000);
        bookSecond.setNumberOfPages(3000);
        bookSecond.setCost(200);
        bookSecond.setAuthors(authorsSecond);
    }

    @Test
    public void testCompare() {
        int actual = bookAuthorComparator.compare(bookFirst,bookSecond);
        int expected = 6;
        assertEquals(actual,expected);
    }
}
