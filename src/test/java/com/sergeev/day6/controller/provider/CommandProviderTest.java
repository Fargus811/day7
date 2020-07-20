package com.sergeev.day6.controller.provider;

import com.sergeev.day6.controller.command.Command;
import com.sergeev.day6.controller.command.change.AddBookCommand;
import com.sergeev.day6.controller.command.find.FindBookByCostCommand;
import com.sergeev.day6.controller.command.sort.SortByCostCommand;
import com.sergeev.day6.model.exception.CommandException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CommandProviderTest {

    @Test
    public void testDefineAddCommand() throws CommandException {
        Command actual = CommandProvider.defineCommand("add");
        assertEquals(actual.getClass(), AddBookCommand.class);
    }

    @Test
    public void testDefineSortCommand() throws CommandException {
        Command actual = CommandProvider.defineCommand("sort_by_cost");
        assertEquals(actual.getClass(), SortByCostCommand.class);
    }

    @Test
    public void testDefineFindCommand() throws CommandException {
        Command actual = CommandProvider.defineCommand("find_by_cost");
        assertEquals(actual.getClass(), FindBookByCostCommand.class);
    }
}
