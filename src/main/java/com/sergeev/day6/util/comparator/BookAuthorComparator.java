package com.sergeev.day6.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        List<String> firstBookAuthors = firstBook.getAuthors();
        List<String> secondBookAuthors = secondBook.getAuthors();
        Collections.sort(firstBookAuthors);
        Collections.sort(firstBookAuthors);
        Iterator<String> firstAuthorsIterator = firstBookAuthors.iterator();
        Iterator<String> secondAuthorsIterator = secondBookAuthors.iterator();
        while (firstAuthorsIterator.hasNext()) {
            String firstBookAuthor = firstAuthorsIterator.next();
            String secondBookAuthor = secondAuthorsIterator.next();
            if (firstBookAuthor.compareTo(secondBookAuthor) != 0) {
                return firstBookAuthor.compareTo(secondBookAuthor);
            }
        }
        return 0;
    }
}
