package com.sergeev.day7.controller.command;

import com.sergeev.day7.controller.command.change.AddBookCommand;
import com.sergeev.day7.controller.command.change.RemoveBookCommand;
import com.sergeev.day7.controller.command.find.FindBookByCostCommand;
import com.sergeev.day7.controller.command.find.FindBookByNumberOfPagesCommand;
import com.sergeev.day7.controller.command.find.FindBookByTitleCommand;
import com.sergeev.day7.controller.command.find.FindBookByYearOfPublishingCommand;
import com.sergeev.day7.controller.command.sort.SortByCostCommand;
import com.sergeev.day7.controller.command.sort.SortByNumberOfPagesCommand;
import com.sergeev.day7.controller.command.sort.SortByTitleCommand;
import com.sergeev.day7.controller.command.sort.SortByYearOfPublishingCommand;

public enum CommandType {
    ADD(new AddBookCommand()),
    REMOVE(new RemoveBookCommand()),
    SORT_BY_COST(new SortByCostCommand()),
    SORT_BY_NUMBER_OF_PAGES(new SortByNumberOfPagesCommand()),
    SORT_BY_TITLE(new SortByTitleCommand()),
    SORT_BY_YEAR(new SortByYearOfPublishingCommand()),
    FIND_BY_COST(new FindBookByCostCommand()),
    FIND_BY_NUMBER_OF_PAGES(new FindBookByNumberOfPagesCommand()),
    FIND_BY_TITLE(new FindBookByTitleCommand()),
    FIND_BY_YEAR(new FindBookByYearOfPublishingCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
