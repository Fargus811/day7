package com.sergeev.day6.model.creator;

import com.sergeev.day6.model.entity.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookCreator {

    private static final String REGEX_FOR_AUTHORS = ":";
    private static final String REGEX_FOR_PARAMS = ";";

    public List<Book> createListOfBooksFromLines(String lineOfBooks) {
        List<Book> result = new ArrayList<>();
        if (!lineOfBooks.isEmpty()) {
            String[] books = lineOfBooks.split("\n");
            for (String book : books) {
                Book resultBook = createBookFromLine(book).get();
                if (resultBook != null) {
                    result.add(resultBook);
                }
            }
        }
        return result;
    }

    private Optional<Book> createBookFromLine(String bookLine) {
        Book book = null;
        String[] params = bookLine.split(REGEX_FOR_PARAMS);
        if (params.length == 5) {
            book = new Book();
            book.setTitle(params[0]);
            book.setAuthors(Arrays.asList(params[1].trim().split(REGEX_FOR_AUTHORS)));
            book.setCost(Double.parseDouble(params[2].trim()));
            book.setNumberOfPages(Integer.parseInt(params[3].trim()));
            book.setYearOfPublishing(Integer.parseInt(params[4].trim()));
        }
        return Optional.ofNullable(book);
    }
}
