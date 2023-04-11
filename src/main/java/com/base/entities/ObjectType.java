package com.base.entities;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum ObjectType {
    TAS,
    KAGIT,
    MAKAS,
    USTA_MAKAS,
    AGIR_TAS,
    OZEL_KAGIT;

    private static final Random PRNG = new Random();

    public static ObjectType randomDirection()  {
        List<ObjectType> directions = Arrays.asList(ObjectType.TAS, ObjectType.KAGIT, ObjectType.MAKAS);
        return directions.get(PRNG.nextInt(directions.size()));
    }
}
