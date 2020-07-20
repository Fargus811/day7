package com.sergeev.day6.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Comparator;

public class BookYearOfPublishingComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        return Integer.compare(firstBook.getYearOfPublishing(), secondBook.getYearOfPublishing());
    }
}
