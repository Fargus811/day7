package com.sergeev.day6.controller;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;

import java.util.List;
import java.util.Map;

public class Controller {

    public List<Book> processRequest(String commandName, Map<String,String> params) throws CommandException {
        Command command = CommandProvider.defineCommand(commandName);
        return command.execute(params);
    }
}
