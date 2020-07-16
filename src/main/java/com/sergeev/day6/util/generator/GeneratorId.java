package com.sergeev.day6.util.generator;

public class GeneratorId {

    private static int id;

    public static int generateId() {
        return id++;
    }
}
