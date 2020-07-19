package com.sergeev.day6.controller.command.change;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.creator.BookCreator;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

public class AddBookCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        BookCreator bookCreator = new BookCreator();
        LibraryService libraryService = new LibraryService();
        List<Book> result;
        Book bookToAdd = bookCreator.createBookFromMap(params).orElse(null);
        try {
            result = libraryService.addBook(bookToAdd);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
