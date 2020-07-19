package com.sergeev.day6.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        List<String> firstBookAuthors = firstBook.getAuthors();
        List<String> secondBookAuthors = secondBook.getAuthors();
        Collections.sort(firstBookAuthors);
        Collections.sort(secondBookAuthors);
        if (firstBookAuthors.get(0).compareTo(secondBookAuthors.get(0)) != 0) {
            return firstBookAuthors.get(0).compareTo(secondBookAuthors.get(0));
        }
        return 0;
    }
}
