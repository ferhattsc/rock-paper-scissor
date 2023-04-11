package com.base.entities;

import com.base.Oyun;

import java.util.List;

public class UstaMakas extends Makas{

    private float direnc;

    public UstaMakas(){
    }

    public UstaMakas(float direnc) {
        this.direnc = direnc;
    }

    public UstaMakas(float keskinlik, float direnc) {
        super(keskinlik);
        this.direnc = direnc;
    }

    public UstaMakas(float dayaniklilik, float seviyePuani, float keskinlik, float direnc, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, keskinlik, objectType);
        this.direnc = direnc;
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
    }

    @Override
    public float getEtki() {
        return getDirenc() * getKeskinlik();
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.USTA_MAKAS)) {
            return 4f;
        } else if (nesne.getObjectType().equals(ObjectType.MAKAS)) {
            return 2f;
        }

        return getEtki() / (Oyun.A *(nesne.getObjectType().equals(ObjectType.KAGIT) || nesne.getObjectType().equals(ObjectType.OZEL_KAGIT) ? nesne.getEtki() : 5f) +
                (1f - Oyun.A) *( nesne.getObjectType().equals(ObjectType.TAS) ||  nesne.getObjectType().equals(ObjectType.AGIR_TAS) ? nesne.getEtki() : 10f / 8f));
    }

    public float getDirenc() {
        return direnc;
    }
}
