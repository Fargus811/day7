package com.sergeev.day6.model.entity;

import com.sergeev.day6.util.generator.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Library {

    private static Library instance;
    private List<Book> books = new ArrayList<>();
    public static final int MAX_CAPACITY = 25000;
    private SequenceGenerator sequenceGenerator = new SequenceGenerator();

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
        book.setId(sequenceGenerator.getNext());
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public void removeAll() {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
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
