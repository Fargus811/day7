package com.sergeev.day6.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Comparator;

public class BookNumberOfPagesComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        return Integer.compare(firstBook.getNumberOfPages(), secondBook.getNumberOfPages());
    }
}
