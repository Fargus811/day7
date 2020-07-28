package com.sergeev.day7.controller.command;

import com.sergeev.day7.controller.command.change.AddBookCommand;
import com.sergeev.day7.controller.command.change.RemoveBookByTitleCommand;
import com.sergeev.day7.controller.command.find.FindBookByCostCommand;
import com.sergeev.day7.controller.command.find.FindBookByNumberOfPagesCommand;
import com.sergeev.day7.controller.command.find.FindBookByTitleCommand;
import com.sergeev.day7.controller.command.find.FindBookByYearOfPublishingCommand;
import com.sergeev.day7.controller.command.sort.SortByParamCommand;

public enum CommandType {
    ADD(new AddBookCommand()),
    REMOVE(new RemoveBookByTitleCommand()),
    SORT_BY_PARAM(new SortByParamCommand()),
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
