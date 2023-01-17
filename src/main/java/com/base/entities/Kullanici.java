package com.base.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Kullanici extends Oyuncu {

    public Kullanici(Long oyuncuID, String oyuncuAdi, Long skor, List<Nesne> nesneList) {
        super(oyuncuID, oyuncuAdi, skor, nesneList, OyuncuTipi.KULLANICI);
    }

    @Override
    public Long skorGoster() {
        return getSkor();
    }

    @Override
    public Nesne nesneSec(List<Nesne> nesneList, String name) {
        return nesneList.stream().filter(nesne -> nesne.getName().contains(name)).collect(Collectors.toList()).get(0);
    }

}
