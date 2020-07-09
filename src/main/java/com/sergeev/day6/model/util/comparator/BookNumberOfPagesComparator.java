package com.sergeev.day6.model.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Comparator;

public class BookNumberOfPagesComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookNumberOfPages = firstBook.getNumberOfPages();
        int secondBookNumberOfPages = secondBook.getNumberOfPages();
        if (firstBookNumberOfPages == secondBookNumberOfPages) {
            return 0;
        }
        return firstBookNumberOfPages > secondBookNumberOfPages ? 1 : -1;
    }

}
