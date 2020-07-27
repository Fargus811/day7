//package com.sergeev.day7.controller.command.sort;
//
//import com.sergeev.day7.model.entity.Book;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import static org.testng.Assert.assertEquals;
//
//public class SortByCostCommandTest {
//
//    private SortByCostCommand sortByCostCommand;
//    private Book bookFirst;
//    private Book bookSecond;
//    private Library library;
//
//    @BeforeMethod
//    public void setUp() {
//        sortByCostCommand = new SortByCostCommand();
//        bookFirst = new Book();
//        bookSecond = new Book();
//        library = Library.getInstance();
//    }
//
//    @Test
//    public void testExecute() {
//        List<String> authors = new ArrayList<>();
//        authors.add("Sergeev D.");
//        authors.add("Hemster W.");
//        bookFirst.setTitle("TestBook1");
//        bookFirst.setYearOfPublishing(2010);
//        bookFirst.setNumberOfPages(300);
//        bookFirst.setCost(20.0);
//        bookFirst.setAuthors(authors);
//        List<String> authorsSecond = new ArrayList<>();
//        authorsSecond.add("Tergeev D.");
//        authorsSecond.add("Bemster W.");
//        bookSecond.setTitle("TestBook2");
//        bookSecond.setYearOfPublishing(2000);
//        bookSecond.setNumberOfPages(3000);
//        bookSecond.setCost(200);
//        bookSecond.setAuthors(authorsSecond);
//        library.addBook(bookFirst);
//        library.addBook(bookSecond);
//        List<Book> actual = sortByCostCommand.execute(new HashMap<>());
//        List<Book> expected = Library.getInstance().findAll();
//        assertEquals(actual, expected);
//    }
//}
