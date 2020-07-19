package com.sergeev.day6.model.entity;

import com.sergeev.day6.util.generator.GeneratorId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private static Library instance;
    private List<Book> books = new ArrayList<>();
    public static final int MAX_CAPACITY = 25000;

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

    public boolean addBook(Book book) {
        book.setId(GeneratorId.generateId());
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Library{");
        sb.append("books=").append(books);
        sb.append('}');
        return sb.toString();
    }
}
