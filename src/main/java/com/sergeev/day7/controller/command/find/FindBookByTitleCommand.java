package com.sergeev.day7.controller.command.find;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;
import com.sergeev.day7.model.exception.ServiceException;
import com.sergeev.day7.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class FindBookByTitleCommand implements Command {

    private static final String TITLE_KEY = "title";

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        List<Book> books;
        try {
            books = libraryServiceImpl.findByTitle(params.get(TITLE_KEY));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return books;
    }
}
