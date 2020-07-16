package com.sergeev.day6.model.entity;

import com.sergeev.day6.model.exception.LibraryException;
import com.sergeev.day6.util.generator.GeneratorId;

import java.util.Collections;
import java.util.List;

public class Library {

    private static Library instance;
    private List<Book> books;
    private final static int MAX_CAPACITY = 25000;

    private Library() {
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> findAll() {
        return Collections.unmodifiableList(books);
    }

    public boolean addBook(Book book) throws LibraryException {
        if (books.size() + 1 > MAX_CAPACITY && !books.contains(book)) {
            book.setId(GeneratorId.generateId());
            return books.add(book);
        } else {
            throw new LibraryException("Library is full");
        }
    }


    public boolean removeBook(Book book) throws LibraryException {
        if (books.contains(book)) {
            return books.remove(book);
        } else {
            throw new LibraryException("Book not found");
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Library{");
        sb.append("books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
