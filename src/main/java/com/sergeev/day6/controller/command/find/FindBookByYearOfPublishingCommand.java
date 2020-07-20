package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class FindBookByYearOfPublishingCommand implements Command {

    private static final String MIN_YEAR_KEY = "minYear";
    private static final String MAX_YEAR_KEY = "maxYear";

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        List<Book> bookList;
        try {
            bookList = libraryServiceImpl.findByYearOfPublishing(params.get(MIN_YEAR_KEY), params.get(MAX_YEAR_KEY));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return bookList;
    }
}
