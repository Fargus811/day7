package com.sergeev.day6.model.util.comparator;

import com.sergeev.day6.model.entity.Book;

import java.util.Comparator;

public class BookCostComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        double costFirstBook = firstBook.getCost();
        double costSecondBook = secondBook.getCost();
        if (costFirstBook == costSecondBook) {
            return 0;
        }
        return costFirstBook > costSecondBook ? 1 : -1;
    }
}
