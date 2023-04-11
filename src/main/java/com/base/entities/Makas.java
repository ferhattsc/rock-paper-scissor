package com.base.entities;

import com.base.Oyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Makas extends Nesne {
    private float keskinlik;

    public Makas(){
    }

    public Makas(float keskinlik) {
        this.keskinlik = keskinlik;
    }

    public Makas(float dayaniklilik, float seviyePuani, float keskinlik, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, objectType);
        this.keskinlik = keskinlik;
    }

    public float getKeskinlik() {
        return keskinlik;
    }

    @Override
    public float getEtki() {
        return getKeskinlik();
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.USTA_MAKAS)) {
            return 1f;
        } else if (nesne.getObjectType().equals(ObjectType.MAKAS)) {
            return 2f;
        }
        return getEtki() / (Oyun.A *(nesne.getObjectType().equals(ObjectType.KAGIT) || nesne.getObjectType().equals(ObjectType.OZEL_KAGIT) ? nesne.getEtki() : 5f) + (1f - Oyun.A) *( nesne.getObjectType().equals(ObjectType.TAS) ||  nesne.getObjectType().equals(ObjectType.AGIR_TAS) ? nesne.getEtki() : 0f));
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
        ArrayList numbers = new ArrayList();
        for(int i = 6; i < 10; i++)
        {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        UstaMakas ustaMakas = new UstaMakas(20, getSeviyePuani(), 2f, 2f, ObjectType.USTA_MAKAS);
        ustaMakas.setName((int)numbers.get(0));
        nesneList.add(ustaMakas);
    }
}
