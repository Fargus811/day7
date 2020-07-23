package com.sergeev.day6.model.entity;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LibraryTest {

    private Library library;
    private Book bookFirst;

    @BeforeMethod
    public void setUp() {
        library = Library.getInstance();
        bookFirst = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        bookFirst.setTitle("TestBook1");
        bookFirst.setYearOfPublishing(2010);
        bookFirst.setNumberOfPages(300);
        bookFirst.setCost(20.0);
        bookFirst.setAuthors(authors);
    }

    @Test
    public void testAddBook() {
        boolean actual = library.addBook(bookFirst);
        assertTrue(actual);
    }

    @Test
    public void testRemoveBook() {
        boolean actual = library.removeBook(bookFirst);
        assertFalse(actual);
    }
}
