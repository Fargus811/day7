package com.sergeev.day6.model.entity;

import com.sergeev.day6.model.exception.ProgramException;
import com.sergeev.day6.model.util.generator.GeneratorId;

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
        return books;
    }

    public boolean addBook(Book book) throws ProgramException {
        if (books.size() < MAX_CAPACITY && !books.contains(book)) {
            book.setId(GeneratorId.gererateId());
            return books.add(book);
        } else {
            throw new ProgramException("Library is full");
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean removeBook(Book book) throws ProgramException {
        if (books.contains(book)) {
            return books.remove(book);
        } else {
            throw new ProgramException("Book not found");
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
