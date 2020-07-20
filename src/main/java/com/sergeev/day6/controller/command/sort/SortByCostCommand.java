package com.sergeev.day6.controller.command.sort;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Map;

public class SortByCostCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        return libraryServiceImpl.sortBooksByCost();
    }
}
