package com.base.entities;

import com.base.Oyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tas extends Nesne {
    private float katilik;

    public Tas(){
    }

    public Tas(float katilik) {
        this.katilik = katilik;
    }

    public Tas(float dayaniklilik, float seviyePuani, float katilik, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, objectType);
        this.katilik = katilik;
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.AGIR_TAS)) {
            return 1f;
        } else if (nesne.getObjectType().equals(ObjectType.TAS)) {
            return 2f;
        }
        return getEtki() / (Oyun.A *(nesne.getObjectType().equals(ObjectType.MAKAS) || nesne.getObjectType().equals(ObjectType.USTA_MAKAS) ? nesne.getEtki() : 5f) + (1f - Oyun.A) *( nesne.getObjectType().equals(ObjectType.KAGIT) ||  nesne.getObjectType().equals(ObjectType.OZEL_KAGIT) ? nesne.getEtki() : 0f));
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
        ArrayList numbers = new ArrayList();
        for(int i = 6; i < 10; i++)
        {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        AgirTas agirTas = new AgirTas(20, getSeviyePuani(), getKatilik(), 2f, ObjectType.AGIR_TAS);
        agirTas.setName((int)numbers.get(0));
        nesneList.add(agirTas);
    }

    @Override
    public float getEtki() {
        return getKatilik();
    }

    public float getKatilik() {
        return katilik;
    }
}
