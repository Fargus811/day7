package com.sergeev.day7.util.creator;

import com.sergeev.day7.model.entity.Book;

import java.util.Map;
import java.util.Optional;

public class BookCreator {

    private static final String AUTHOR_KEY = "authors";
    private static final String COST_KEY = "cost";
    private static final String NUMBER_OF_PAGES_KEY = "numberOfPages";
    private static final String TITLE_KEY = "title";
    private static final String YEAR_KEY = "year";

    public Optional<Book> createBookFromMap(Map<String, String> params) {
        Book book = null;
        if (!params.isEmpty()) {
            book = new Book();
            book.setTitle(params.get(TITLE_KEY));
            book.setAuthors(params.get(AUTHOR_KEY));
            book.setCost(Double.parseDouble(params.get(COST_KEY)));
            book.setNumberOfPages(Integer.parseInt(params.get(NUMBER_OF_PAGES_KEY)));
            book.setYearOfPublishing(Integer.parseInt(params.get(YEAR_KEY)));
        }
        return Optional.ofNullable(book);
    }
}
