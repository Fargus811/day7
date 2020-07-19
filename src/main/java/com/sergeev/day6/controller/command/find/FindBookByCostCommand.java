package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.model.exception.ServiceException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

public class FindBookByCostCommand implements Command {

    private static final String MIN_COST_KEY = "minCost";
    private static final String MAX_COST_KEY = "maxCost";

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryService libraryService = new LibraryService();
        List<Book> bookList;
        try {
            bookList = libraryService.findByCost(params.get(MIN_COST_KEY), params.get(MAX_COST_KEY));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return bookList;
    }
}
