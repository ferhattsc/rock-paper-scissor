package com.base.entities;

import com.base.Oyun;

import java.util.List;

public class AgirTas extends Tas{
    private float sicaklik;

    public AgirTas(){
    }

    public AgirTas(float sicaklik) {
        this.sicaklik = sicaklik;
    }

    public AgirTas(float katilik, float sicaklik) {
        super(katilik);
        this.sicaklik = sicaklik;
    }

    public AgirTas(float dayaniklilik, float seviyePuani, float katilik, float sicaklik, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, katilik, objectType);
        this.sicaklik = sicaklik;
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
    }

    @Override
    public float getEtki() {
        return getSicaklik() * getKatilik();
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.AGIR_TAS)) {
            return 4f;
        } else if (nesne.getObjectType().equals(ObjectType.TAS)) {
            return 2f;
        }

        return getEtki() / (Oyun.A *(nesne.getObjectType().equals(ObjectType.MAKAS) || nesne.getObjectType().equals(ObjectType.USTA_MAKAS) ? nesne.getEtki() : 5f) +
                (1f - Oyun.A) * (nesne.getObjectType().equals(ObjectType.KAGIT) ||  nesne.getObjectType().equals(ObjectType.OZEL_KAGIT) ? nesne.getEtki() : 10f / 8f));
    }

    public float getSicaklik() {
        return sicaklik;
    }
}
