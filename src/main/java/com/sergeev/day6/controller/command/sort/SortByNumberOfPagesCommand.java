package com.sergeev.day6.controller.command.sort;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

public class SortByNumberOfPagesCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryService libraryService = new LibraryService();
        return libraryService.sortBooksByNumberOfPages();
    }
}
