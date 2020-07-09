package com.sergeev.day6.model.reader;

import com.sergeev.day6.model.exception.ProgramException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookReader {

    public String readBookFromFile(String path) throws ProgramException {
        String result = "";
        try {
            result = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new ProgramException("Nothing to read!", e);
        }
        return result;
    }
}
