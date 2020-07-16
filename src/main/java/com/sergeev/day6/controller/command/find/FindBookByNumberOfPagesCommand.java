package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

import static com.sergeev.day6.util.Regex.RegularExpression.MAX_NUMBER_OF_PAGES_KEY;
import static com.sergeev.day6.util.Regex.RegularExpression.MIN_NUMBER_OF_PAGES_KEY;

public class FindBookByNumberOfPagesCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryService libraryService = new LibraryService();
        return libraryService.findByNumberOfPages(params.get(MAX_NUMBER_OF_PAGES_KEY),
                params.get(MIN_NUMBER_OF_PAGES_KEY));
    }
}
