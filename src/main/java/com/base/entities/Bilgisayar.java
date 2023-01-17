package com.base.entities;

import java.util.List;
import java.util.SplittableRandom;

public class Bilgisayar extends Oyuncu {

    public Bilgisayar(Long oyuncuID, String oyuncuAdi, Long skor, List<Nesne> nesneList) {
        super(oyuncuID, oyuncuAdi, skor, nesneList, OyuncuTipi.BILGISAYAR);
    }

    @Override
    public Long skorGoster() {
        return null;
    }

    @Override
    public Nesne nesneSec(List<Nesne> nesneList, String name) {
        if (nesneList.size() == 1) {
            return nesneList.get(0);
        }

        int randomInt = new SplittableRandom().ints(1, 1, nesneList.size()).findFirst().getAsInt();
        return nesneList.get(randomInt);
    }

}
