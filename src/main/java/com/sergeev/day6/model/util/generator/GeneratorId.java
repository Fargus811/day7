package com.sergeev.day6.model.util.generator;

import java.util.UUID;

public class GeneratorId {

    public static String gererateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
