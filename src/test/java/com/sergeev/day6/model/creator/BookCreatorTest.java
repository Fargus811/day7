package com.sergeev.day6.model.creator;

import com.sergeev.day6.model.entity.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BookCreatorTest {

    private BookCreator bookCreator;

    @BeforeMethod
    public void setUp() {
        bookCreator = new BookCreator();
    }

    @Test
    public void testCreateListOfBooksFromLines() {
        List<Book> expected = new ArrayList<>();
        Book bookFirst = new Book();
        bookFirst.setTitle("TestBook1");
        List<String> authorsFirst = new ArrayList<>();
        authorsFirst.add("Sergeev D.");
        authorsFirst.add("Hemster W.");
        bookFirst.setAuthors(authorsFirst);
        bookFirst.setCost(20.0);
        bookFirst.setNumberOfPages(300);
        bookFirst.setYearOfPublishing(2001);
        expected.add(bookFirst);
        Book bookSecond = new Book();
        bookSecond.setTitle("TestBook2");
        List<String> authorsSecond = new ArrayList<>();
        authorsSecond.add("Garsia H.");
        authorsSecond.add("Roster Ch.");
        bookSecond.setAuthors(authorsSecond);
        bookSecond.setCost(23.0);
        bookSecond.setNumberOfPages(230);
        bookSecond.setYearOfPublishing(2018);
        expected.add(bookSecond);
        List<Book> actual = bookCreator.createListOfBooksFromLines("TestBook1; Sergeev D.:Hemster W. ; 20.0; 300; 2001\n" +
               "TestBook2; Garsia H.:Roster Ch. ; 23.0 ; 230; 2018");
       assertEquals(actual,expected);
    }
}
