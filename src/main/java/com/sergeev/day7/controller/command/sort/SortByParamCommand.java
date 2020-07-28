package com.sergeev.day7.controller.command.sort;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;
import com.sergeev.day7.model.exception.ServiceException;
import com.sergeev.day7.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class SortByParamCommand implements Command {

    private static final String PARAMETER_KEY = "parameter";

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        List<Book> result = null;
        try {
            result = libraryServiceImpl.sortBooksBy(params.get(PARAMETER_KEY));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return result;
    }
}
