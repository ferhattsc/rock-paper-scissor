package com.base.entities;


public class NesneGenerator {

    public static Nesne generate(ObjectType objectType) {
        if (ObjectType.TAS.equals(objectType)) {
            return new Tas(20f,0f,2f,ObjectType.TAS);
        }else if (ObjectType.MAKAS.equals(objectType)) {
            return new Makas(20f,0f,2f,ObjectType.MAKAS);
        }else if (ObjectType.KAGIT.equals(objectType)) {
            return new Kagit(20f,0f,2f,ObjectType.KAGIT);
        }
        return null;
    }

}


