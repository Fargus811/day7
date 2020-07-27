package com.sergeev.day7.controller.command;

import com.sergeev.day7.model.entity.Book;
import com.sergeev.day7.model.exception.CommandException;

import java.util.List;
import java.util.Map;

public interface Command {

    List<Book> execute(Map<String, String> params) throws CommandException;
}
