package com.sergeev.day6.validator;

import com.sergeev.day6.model.entity.Book;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BookValidatorTest {

    private BookValidator bookValidator;

    @BeforeMethod
    public void setUp() {
        bookValidator = new BookValidator();
    }

    @Test
    public void testValidateTitleOfBookPositive() {
        boolean actual = bookValidator.validateTitleOfBook("Test");
        assertTrue(actual);
    }

    @Test
    public void testValidateTitleOfBookNegative() {
        boolean actual = bookValidator.validateTitleOfBook("");
        assertFalse(actual);
    }

    @Test
    public void testValidateAuthorOfBookPositive() {
        boolean actual = bookValidator.validateAuthorOfBook("Daniil S.");
        assertTrue(actual);
    }

    @Test
    public void testValidateAuthorOfBookNegative() {
        boolean actual = bookValidator.validateAuthorOfBook("S");
        assertFalse(actual);
    }

    @Test
    public void testValidateCostOfBookPositive() {
        boolean actual = bookValidator.validateCostOfBook(30);
        assertTrue(actual);
    }

    @Test
    public void testValidateCostOfBookNegative() {
        boolean actual = bookValidator.validateCostOfBook(0);
        assertFalse(actual);
    }

    @Test
    public void testValidateNumberOfPagesInBookPositive() {
        boolean actual = bookValidator.validateNumberOfPagesInBook(30);
        assertTrue(actual);
    }

    @Test
    public void testValidateNumberOfPagesInBookNegative() {
        boolean actual = bookValidator.validateNumberOfPagesInBook(0);
        assertFalse(actual);
    }

    @Test
    public void testValidateYearOfPublishingPositive() {
        boolean actual = bookValidator.validateYearOfPublishing(2001);
        assertTrue(actual);
    }

    @Test
    public void testValidateYearOfPublishingNegative() {
        boolean actual = bookValidator.validateYearOfPublishing(21);
        assertFalse(actual);
    }

    @Test
    public void testValidateBookPositive() {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        book.setTitle("TestBook1");
        book.setYearOfPublishing(2010);
        book.setNumberOfPages(300);
        book.setCost(20.0);
        book.setAuthors(authors);
        boolean actual = bookValidator.validateBook(book);
        assertTrue(actual);
    }

    @Test
    public void testValidateBookNegative() {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        book.setTitle("TestBook1");
        book.setYearOfPublishing(201000);
        book.setNumberOfPages(300000);
        book.setCost(20.0);
        book.setAuthors(authors);
        boolean actual = bookValidator.validateBook(book);
        assertFalse(actual);
    }
}
