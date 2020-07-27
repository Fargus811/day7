package com.sergeev.day7.controller.command.sort;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class SortByNumberOfPagesCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        return libraryServiceImpl.sortBooksByNumberOfPages();
    }
}
