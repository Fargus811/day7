package com.sergeev.day6.util.generator;

public class SequenceGenerator {

    private int id;

    public int getNext() {
        return id++;
    }
}
