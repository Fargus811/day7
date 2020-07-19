package com.sergeev.day6.validator;

import com.sergeev.day6.model.entity.Book;

public class BookValidator {

    private static final int MAX_LENGTH_OF_NAME = 50;
    private static final int MIN_LENGTH_OF_NAME = 1;
    private static final int MAX_LENGTH_OF_AUTHOR_NAME = 60;
    private static final int MIN_LENGTH_OF_AUTHOR_NAME = 3;
    private static final double MAX_COST = 10000.0;
    private static final double MIN_COST = 0.1;
    private static final int MAX_NUMBERS_OF_PAGE = 3000;
    private static final int MIN_NUMBERS_OF_PAGE = 20;
    private static final int MAX_YEAR_OF_PUBLISHING = 2020;
    private static final int MIN_YEAR_OF_PUBLISHING = 1000;

    public boolean validateTitleOfBook(String nameOfBook) {
        return nameOfBook.length() <= MAX_LENGTH_OF_NAME && nameOfBook.length() >= MIN_LENGTH_OF_NAME;
    }

    public boolean validateAuthorOfBook(String nameOfAuthor) {
        return nameOfAuthor.length() <= MAX_LENGTH_OF_AUTHOR_NAME && nameOfAuthor.length() >= MIN_LENGTH_OF_AUTHOR_NAME;
    }

    public boolean validateCostOfBook(double cost) {
        return cost <= MAX_COST && cost >= MIN_COST;
    }

    public boolean validateNumberOfPagesInBook(int numbers) {
        return numbers <= MAX_NUMBERS_OF_PAGE && numbers >= MIN_NUMBERS_OF_PAGE;
    }

    public boolean validateYearOfPublishing(int yearOfPublishing) {
        return yearOfPublishing <= MAX_YEAR_OF_PUBLISHING && yearOfPublishing >= MIN_YEAR_OF_PUBLISHING;
    }


    public boolean validateBook(Book book) {
        boolean isValidAuthorName = false;
        for (String authorName : book.getAuthors()) {
            isValidAuthorName = validateAuthorOfBook(authorName);
        }
        return isValidAuthorName && validateCostOfBook(book.getCost()) && validateTitleOfBook(book.getTitle()) &&
                validateNumberOfPagesInBook(book.getNumberOfPages());
    }
}
