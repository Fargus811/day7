package com.sergeev.day7.controller.command.change;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;
import com.sergeev.day7.model.exception.ServiceException;
import com.sergeev.day7.service.impl.LibraryServiceImpl;
import com.sergeev.day7.util.creator.BookCreator;

import java.util.List;
import java.util.Map;

public class RemoveBookCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        BookCreator bookCreator = new BookCreator();
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        List<Book> result;
        Book bookToDelete = bookCreator.createBookFromMap(params).orElse(null);
        try {
            result = libraryServiceImpl.removeBook(bookToDelete);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
