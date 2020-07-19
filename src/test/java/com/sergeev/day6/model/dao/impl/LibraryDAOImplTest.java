package com.sergeev.day6.model.dao.impl;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.entity.Library;
import com.sergeev.day6.model.exception.DAOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LibraryDAOImplTest {

    private LibraryDAOImpl libraryDAO;
    private Book bookFirst;
    private Book bookSecond;

    @BeforeMethod
    public void setUp() {
        libraryDAO = new LibraryDAOImpl();
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
    public void testAddBook() throws DAOException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.addBook(bookFirst);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = DAOException.class)
    public void testAddBookDAOException() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookFirst);
    }

    @Test
    public void testRemoveBook() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.removeBook(bookFirst);
        assertTrue(Library.getInstance().findAll().isEmpty());
    }

    @Test(expectedExceptions = DAOException.class)
    public void testRemoveBookDAOException() throws DAOException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        book.setTitle("TestBook1");
        book.setYearOfPublishing(2010);
        book.setNumberOfPages(300);
        book.setCost(20.0);
        book.setAuthors(authors);
        libraryDAO.removeBook(book);
    }

    @Test
    public void testFindByTitle() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.findByTitle("TestBook1");
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByAuthor() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.findByAuthor("Sergeev D.");
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByCost() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.findByCost(10, 100);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByNumberOfPages() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.findByNumberOfPages(100, 400);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByYearOfPublishing() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.findByYearOfPublishing(2008, 2011);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByTitle() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryDAO.sortBooksByTitle();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByAuthors() throws DAOException {
        libraryDAO.addBook(bookFirst);
        libraryDAO.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookSecond);
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.sortBooksByAuthors();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByCost() throws DAOException {
        libraryDAO.addBook(bookSecond);
        libraryDAO.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryDAO.sortBooksByCost();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByNumberOfPages() throws DAOException {
        libraryDAO.addBook(bookSecond);
        libraryDAO.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryDAO.sortBooksByNumberOfPages();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByYearOfPublishing() throws DAOException {
        libraryDAO.addBook(bookSecond);
        libraryDAO.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookSecond);
        expected.add(bookFirst);
        List<Book> actual = libraryDAO.sortBooksByYearOfPublishing();
        assertEquals(actual, expected);
    }
}
