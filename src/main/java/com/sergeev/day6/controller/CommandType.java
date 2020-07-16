package com.sergeev.day6.controller;

import com.sergeev.day6.controller.command.AddBookCommand;
import com.sergeev.day6.controller.command.RemoveBookCommand;
import com.sergeev.day6.controller.command.find.FindBookByAuthorCommand;
import com.sergeev.day6.controller.command.sort.*;

public enum CommandType {
    ADD {
        {
            command = new AddBookCommand();
        }
    },
    REMOVE {
        {
            command = new RemoveBookCommand();
        }
    },
    SORT_BY_AUTHORS{
        {
            command = new SortByAuthorsCommand();
        }
    },
    SORT_BY_COST{
        {
            command = new SortByCostCommand();
        }
    },
    SORT_BY_NUMBER_OF_PAGES{
        {
            command = new SortByNumberOfPagesCommand();
        }
    },
    SORT_BY_TITLE{
        {
            command = new SortByTitleCommand();
        }
    },
    SORT_BY_YEAR{
        {
            command = new SortByYearOfPublishing();
        }
    },
    FIND_BY_AUTHOR{
        {
            command = new FindBookByAuthorCommand();
        }
    },
    ;
    Command command;
    public Command getCommand() {
        return command;
    }
}
