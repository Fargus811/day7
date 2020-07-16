package com.sergeev.day6.controller.command.find;

import com.sergeev.day6.controller.Command;
import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;
import com.sergeev.day6.service.LibraryService;

import java.util.List;
import java.util.Map;

import static com.sergeev.day6.util.Regex.RegularExpression.MAX_COST_KEY;
import static com.sergeev.day6.util.Regex.RegularExpression.MIN_COST_KEY;

public class FindBookByCostCommand implements Command {

    @Override
    public List<Book> execute(Map<String, String> params) throws CommandException {
        LibraryService libraryService = new LibraryService();
        return libraryService.findByCost(params.get(MIN_COST_KEY),
                params.get(MAX_COST_KEY));
    }
}
