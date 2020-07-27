package com.sergeev.day7.controller.provider;

import com.sergeev.day7.controller.command.Command;
import com.sergeev.day7.controller.command.CommandType;
import com.sergeev.day7.model.exception.CommandException;

public class CommandProvider {

    public static Command defineCommand(String command) throws CommandException {
        Command current = null;
        if (command == null || command.isEmpty()) {
            return null;
        }
        try {
            CommandType currentType = CommandType.valueOf(command.toUpperCase());
            current = currentType.getCommand();
        } catch (IllegalArgumentException e) {
            throw new CommandException(e);
        }
        return current;
    }
}
