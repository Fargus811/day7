package com.sergeev.day7.util.comparator;

import com.sergeev.day7.model.entity.Book;

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
        return firstBookAuthors.get(0).compareTo(secondBookAuthors.get(0));
    }
}
