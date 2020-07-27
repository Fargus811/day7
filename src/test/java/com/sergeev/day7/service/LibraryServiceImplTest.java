//package com.sergeev.day7.service;
//
//import com.sergeev.day7.model.entity.Book;
//import com.sergeev.day7.model.exception.ServiceException;
//import com.sergeev.day7.service.impl.LibraryServiceImpl;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class LibraryServiceImplTest {
//
//    private LibraryServiceImpl libraryServiceImpl;
//    private Book bookFirst;
//    private Book bookSecond;
//
//    @BeforeMethod
//    public void setUp() {
//        libraryServiceImpl = new LibraryServiceImpl();
//        bookFirst = new Book();
//        List<String> authors = new ArrayList<>();
//        authors.add("Sergeev D.");
//        authors.add("Hemster W.");
//        bookFirst.setTitle("TestBook1");
//        bookFirst.setYearOfPublishing(2010);
//        bookFirst.setNumberOfPages(300);
//        bookFirst.setCost(20.0);
//        bookFirst.setAuthors(authors);
//        bookSecond = new Book();
//        List<String> authorsSecond = new ArrayList<>();
//        authorsSecond.add("Tergeev D.");
//        authorsSecond.add("Bemster W.");
//        bookSecond.setTitle("TestBook2");
//        bookSecond.setYearOfPublishing(2000);
//        bookSecond.setNumberOfPages(3000);
//        bookSecond.setCost(200);
//        bookSecond.setAuthors(authorsSecond);
//    }
//
//    @Test
//    public void testAddBook() throws ServiceException {
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.addBook(bookFirst);
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testAddNullBook() throws ServiceException {
//        List<Book> expected = new ArrayList<>();
//        List<Book> actual = libraryServiceImpl.addBook(null);
//        assertEquals(actual, expected);
//    }
//
//    @Test(expectedExceptions = ServiceException.class)
//    public void testAddBookServiceException() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookFirst);
//    }
//
//    @Test
//    public void testRemoveBook() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.removeBook(bookFirst);
//        assertTrue(Library.getInstance().findAll().isEmpty());
//    }
//
//    @Test(expectedExceptions = ServiceException.class)
//    public void testRemoveBookServiceException() throws ServiceException {
//        Book book = new Book();
//        List<String> authors = new ArrayList<>();
//        authors.add("Sergeev D.");
//        authors.add("Hemster W.");
//        book.setTitle("TestBook1");
//        book.setYearOfPublishing(2010);
//        book.setNumberOfPages(300);
//        book.setCost(20.0);
//        book.setAuthors(authors);
//        libraryServiceImpl.removeBook(book);
//    }
//
//    @Test
//    public void testFindByTitle() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.findByTitle("TestBook1");
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testFindByAuthor() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.findByAuthor("Sergeev D.");
//        assertEquals(actual, expected);
//
//    }
//
//    @Test
//    public void testFindByCost() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.findByCost("10", "100");
//        assertEquals(actual, expected);
//    }
//
//    @Test(expectedExceptions = ServiceException.class)
//    public void testFindByInvalidCostServiceException() throws ServiceException {
//        libraryServiceImpl.findByCost("1sv", "1sac");
//    }
//
//    @Test
//    public void testFindByNumberOfPages() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.findByNumberOfPages("100", "400");
//        assertEquals(actual, expected);
//    }
//
//    @Test(expectedExceptions = ServiceException.class)
//    public void testFindByInvalidNumberOfPagesServiceException() throws ServiceException {
//        libraryServiceImpl.findByNumberOfPages("100asa", "400ada");
//    }
//
//    @Test
//    public void testFindByYearOfPublishing() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.findByYearOfPublishing("2008", "2011");
//        assertEquals(actual, expected);
//    }
//
//    @Test(expectedExceptions = ServiceException.class)
//    public void testFindByInvalidYearOfPublishingServiceException() throws ServiceException {
//        libraryServiceImpl.findByYearOfPublishing("2008fwf", "2011c");
//    }
//
//    @Test
//    public void testSortBooksByTitle() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        expected.add(bookSecond);
//        List<Book> actual = libraryServiceImpl.sortBooksByTitle();
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testSortBooksByAuthors() throws ServiceException {
//        libraryServiceImpl.addBook(bookFirst);
//        libraryServiceImpl.addBook(bookSecond);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookSecond);
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.sortBooksByAuthors();
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testSortBooksByCost() throws ServiceException {
//        libraryServiceImpl.addBook(bookSecond);
//        libraryServiceImpl.addBook(bookFirst);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        expected.add(bookSecond);
//        List<Book> actual = libraryServiceImpl.sortBooksByCost();
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testSortBooksByNumberOfPages() throws ServiceException {
//        libraryServiceImpl.addBook(bookSecond);
//        libraryServiceImpl.addBook(bookFirst);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookFirst);
//        expected.add(bookSecond);
//        List<Book> actual = libraryServiceImpl.sortBooksByNumberOfPages();
//        assertEquals(actual, expected);
//    }
//
//    @Test
//    public void testSortBooksByYearOfPublishing() throws ServiceException {
//        libraryServiceImpl.addBook(bookSecond);
//        libraryServiceImpl.addBook(bookFirst);
//        List<Book> expected = new ArrayList<>();
//        expected.add(bookSecond);
//        expected.add(bookFirst);
//        List<Book> actual = libraryServiceImpl.sortBooksByYearOfPublishing();
//        assertEquals(actual, expected);
//    }
//}
