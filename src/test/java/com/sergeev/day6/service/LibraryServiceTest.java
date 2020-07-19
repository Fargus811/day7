package com.sergeev.day6.service;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.entity.Library;
import com.sergeev.day6.model.exception.ServiceException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LibraryServiceTest {

    private LibraryService libraryService;
    private Book bookFirst;
    private Book bookSecond;

    @BeforeMethod
    public void setUp() {
        libraryService = new LibraryService();
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
    public void testAddBook() throws ServiceException {
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.addBook(bookFirst);
        assertEquals(actual, expected);
    }
    @Test
    public void testAddNullBook() throws ServiceException {
        List<Book> expected = new ArrayList<>();
        List<Book> actual = libraryService.addBook(null);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testAddBookServiceException() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookFirst);
    }

    @Test
    public void testRemoveBook() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.removeBook(bookFirst);
        assertTrue(Library.getInstance().findAll().isEmpty());
    }

    @Test(expectedExceptions = ServiceException.class)
    public void testRemoveBookServiceException() throws ServiceException {
        Book book = new Book();
        List<String> authors = new ArrayList<>();
        authors.add("Sergeev D.");
        authors.add("Hemster W.");
        book.setTitle("TestBook1");
        book.setYearOfPublishing(2010);
        book.setNumberOfPages(300);
        book.setCost(20.0);
        book.setAuthors(authors);
        libraryService.removeBook(book);
    }

    @Test
    public void testFindByTitle() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.findByTitle("TestBook1");
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByAuthor() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.findByAuthor("Sergeev D.");
        assertEquals(actual, expected);

    }

    @Test
    public void testFindByCost() throws ServiceException{
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.findByCost("10","100");
        assertEquals(actual, expected);
    }
    @Test(expectedExceptions = ServiceException.class)
    public void testFindByInvalidCostServiceException() throws ServiceException{
        libraryService.findByCost("1sv","1sac");
    }

    @Test
    public void testFindByNumberOfPages() throws ServiceException{
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.findByNumberOfPages("100","400");
        assertEquals(actual, expected);
    }
    @Test(expectedExceptions = ServiceException.class)
    public void testFindByInvalidNumberOfPagesServiceException() throws ServiceException{
       libraryService.findByNumberOfPages("100asa","400ada");
    }

    @Test
    public void testFindByYearOfPublishing() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        List<Book> actual = libraryService.findByYearOfPublishing("2008", "2011");
        assertEquals(actual, expected);
    }
    @Test(expectedExceptions = ServiceException.class)
    public void testFindByInvalidYearOfPublishingServiceException() throws ServiceException {
        libraryService.findByYearOfPublishing("2008fwf", "2011c");
    }

    @Test
    public void testSortBooksByTitle() throws ServiceException{
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryService.sortBooksByTitle();
        assertEquals(actual, expected);
    }
    
    @Test
    public void testSortBooksByAuthors() throws ServiceException {
        libraryService.addBook(bookFirst);
        libraryService.addBook(bookSecond);
        List<Book> expected = new ArrayList<>();
        expected.add(bookSecond);
        expected.add(bookFirst);
        List<Book> actual = libraryService.sortBooksByAuthors();
        assertEquals(actual, expected);
    }
    @Test
    public void testSortBooksByCost() throws ServiceException {
        libraryService.addBook(bookSecond);
        libraryService.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryService.sortBooksByCost();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByNumberOfPages() throws ServiceException {
        libraryService.addBook(bookSecond);
        libraryService.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookFirst);
        expected.add(bookSecond);
        List<Book> actual = libraryService.sortBooksByNumberOfPages();
        assertEquals(actual, expected);
    }

    @Test
    public void testSortBooksByYearOfPublishing() throws ServiceException {
        libraryService.addBook(bookSecond);
        libraryService.addBook(bookFirst);
        List<Book> expected = new ArrayList<>();
        expected.add(bookSecond);
        expected.add(bookFirst);
        List<Book> actual = libraryService.sortBooksByYearOfPublishing();
        assertEquals(actual, expected);
    }
}
