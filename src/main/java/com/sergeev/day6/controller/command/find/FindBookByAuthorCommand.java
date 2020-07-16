package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

import static com.sergeev.day6.util.Regex.RegularExpression.AUTHOR_KEY;

public class FindBookByAuthorCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryService libraryService = new LibraryService();
        return libraryService.findByAuthor(params.get(AUTHOR_KEY));
    }
}
