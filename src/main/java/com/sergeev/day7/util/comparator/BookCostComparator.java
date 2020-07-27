package com.sergeev.day7.util.comparator;

import com.sergeev.day7.model.entity.Book;

import java.util.Comparator;

public class BookCostComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        return Double.compare(firstBook.getCost(), secondBook.getCost());
    }
}
