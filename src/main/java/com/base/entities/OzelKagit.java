package com.base.entities;

import com.base.Oyun;

import java.util.List;

public class OzelKagit extends Kagit{

    private float kalinlik;

    public OzelKagit() {
    }

    public OzelKagit(float kalinlik) {
        this.kalinlik = kalinlik;
    }

    public OzelKagit(float nüfüz, float kalinlik) {
        super(nüfüz);
        this.kalinlik = kalinlik;
    }

    public OzelKagit(float dayaniklilik, float seviyePuani, float nüfüz, float kalinlik, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, nüfüz, objectType);
        this.kalinlik = kalinlik;
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
    }

    @Override
    public float getEtki() {
        return getKalinlik() * getNüfüz();
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.KAGIT)) {
            return 4f;
        } else if (nesne.getObjectType().equals(ObjectType.OZEL_KAGIT)) {
            return 2f;
        }

        return getEtki() / (
                Oyun.A *(nesne.getObjectType().equals(ObjectType.TAS) || nesne.getObjectType().equals(ObjectType.AGIR_TAS) ? nesne.getEtki() : 5) +
                        (1L - Oyun.A) *( nesne.getObjectType().equals(ObjectType.MAKAS) ||  nesne.getObjectType().equals(ObjectType.USTA_MAKAS) ? nesne.getEtki() : 10f / 8f)
        );
    }

    public float getKalinlik() {
        return kalinlik;
    }
}
