package com.sergeev.day6.controller;

import com.sergeev.day6.model.entity.Book;
import com.sergeev.day6.model.exception.CommandException;

import java.util.List;
import java.util.Map;

public interface Command {

    List<Book> execute(Map<String,String> params) throws CommandException;
}
