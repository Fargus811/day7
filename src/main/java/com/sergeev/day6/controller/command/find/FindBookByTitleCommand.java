package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class FindBookByTitleCommand implements Command {

    private static final String TITLE_KEY = "title";

    @Override
    public List<Book> execute(Map<String, String> params) {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        return libraryServiceImpl.findByTitle(params.get(TITLE_KEY));
    }
}
