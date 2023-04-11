package com.base.entities;

import com.base.Oyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kagit extends Nesne {
    private float nüfüz;

    public Kagit() {
    }

    public Kagit(float nüfüz) {
        this.nüfüz = nüfüz;
    }

    public Kagit(float dayaniklilik, float seviyePuani, float nüfüz, ObjectType objectType) {
        super(dayaniklilik, seviyePuani, objectType);
        this.nüfüz = nüfüz;
    }

    @Override
    public float etkiHesapla(Nesne nesne) {
        if (nesne.getObjectType().equals(ObjectType.OZEL_KAGIT)) {
            return 1f;
        } else if (nesne.getObjectType().equals(ObjectType.KAGIT)) {
            return 2f;
        }

        return getEtki() / (
                Oyun.A *(nesne.getObjectType().equals(ObjectType.TAS) || nesne.getObjectType().equals(ObjectType.AGIR_TAS) ? nesne.getEtki() : 5f) +
                        (1f - Oyun.A) *( nesne.getObjectType().equals(ObjectType.MAKAS) ||  nesne.getObjectType().equals(ObjectType.USTA_MAKAS) ? nesne.getEtki() : 0f)
        );
    }

    @Override
    public void durumGuncelle(List<Nesne> nesneList) {
        ArrayList numbers = new ArrayList();
        for(int i = 6; i < 10; i++)
        {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        OzelKagit ozelKagit = new OzelKagit(20, getSeviyePuani(), getNüfüz(), 2f, ObjectType.OZEL_KAGIT);
        ozelKagit.setName((int)numbers.get(0));
        nesneList.add(ozelKagit);
    }

    @Override
    public float getEtki() {
        return getNüfüz();
    }

    public float getNüfüz() {
        return nüfüz;
    }
}
