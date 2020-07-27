package com.sergeev.day7.util.generator;

public class SequenceGenerator {

    private int id;

    public int getNext() {
        return id++;
    }
}
