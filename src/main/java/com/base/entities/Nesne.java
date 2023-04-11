package com.base.entities;

import java.util.List;

public abstract class Nesne {
    private String name;
    private float dayaniklilik;
    private float seviyePuani;
    private ObjectType objectType;

    public Nesne() {
    }

    public Nesne(float dayaniklilik, float seviyePuani, ObjectType objectType) {
        this.dayaniklilik = dayaniklilik;
        this.seviyePuani = seviyePuani;
        this.objectType = objectType;
    }

    public float getDayaniklilik() {
        return dayaniklilik;
    }

    public void setDayaniklilik(float dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    public float getSeviyePuani() {
        return seviyePuani;
    }

    public void setSeviyePuani(float seviyePuani) {
        this.seviyePuani = seviyePuani;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public float nesnePuaniGoster() {
        return getSeviyePuani();
    }

    public abstract float etkiHesapla(Nesne nesne);

    public abstract void durumGuncelle(List<Nesne> nesneList);

    public abstract float getEtki();

    public String getName() {
        return name;
    }

    public void setName(int asdf) {
        this.name = getObjectType().name() + asdf;
    }
}
