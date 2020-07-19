package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

public class FindBookByAuthorCommand implements Command {

    private static final String AUTHOR_KEY = "author";

    @Override
    public List<Book> execute(Map<String, String> params) {
        LibraryService libraryService = new LibraryService();
        return libraryService.findByAuthor(params.get(AUTHOR_KEY));
    }
}
