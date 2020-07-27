package com.sergeev.day7.controller;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.controller.provider.CommandProvider;
import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;

import java.util.List;
import java.util.Map;

public class Controller {

    public List<Book> processRequest(String commandName, Map<String, String> params) throws CommandException {
        Command command = CommandProvider.defineCommand(commandName);
        return command.execute(params);
    }
}
