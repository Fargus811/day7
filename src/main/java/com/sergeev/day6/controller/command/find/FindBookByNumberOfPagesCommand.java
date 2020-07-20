package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class FindBookByNumberOfPagesCommand implements Command {

    private static final String MAX_NUMBER_OF_PAGES_KEY = "minNumberOfPages";
    private static final String MIN_NUMBER_OF_PAGES_KEY = "maxNumberOfPages";

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        List<Book> bookList;
        try {
            bookList = libraryServiceImpl.findByNumberOfPages(params.get(MAX_NUMBER_OF_PAGES_KEY),
                    params.get(MIN_NUMBER_OF_PAGES_KEY));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return bookList;
    }
}
