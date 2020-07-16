package com.sergeev.day6.model.creator;

import com.sergeev.day6.model.entity.Book;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import static com.sergeev.day6.util.Regex.RegularExpression.*;

public class BookCreator {

    public Optional<Book> createBookFromMap(Map<String, String> params) {
        Book book = null;
        if (!params.isEmpty()) {
            book = new Book();
            book.setTitle(params.get(TITLE_KEY));
            book.setAuthors(Arrays.asList(params.get(AUTHOR_KEY).trim().split(REGEX_FOR_SPLIT_AUTHORS)));
            book.setCost(Double.parseDouble(params.get(COST_KEY)));
            book.setNumberOfPages(Integer.parseInt(params.get(NUMBER_OF_PAGES_KEY)));
            book.setYearOfPublishing(Integer.parseInt(params.get(YEAR_KEY)));
        }
        return Optional.of(book);
    }
}
