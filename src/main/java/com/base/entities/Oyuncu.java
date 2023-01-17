package com.base.entities;

import java.util.List;

public abstract class Oyuncu {

    private Long oyuncuID;
    private String oyuncuAdi;
    private Long skor;
    private List<Nesne> nesneList;
    private OyuncuTipi oyuncuTipi;

    protected Oyuncu() {
    }

    protected Oyuncu(Long oyuncuID, String oyuncuAdi, Long skor, List<Nesne> nesneList, OyuncuTipi oyuncuTipi) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
        this.nesneList = nesneList;
        this.oyuncuTipi = oyuncuTipi;
    }

    public abstract Long skorGoster();

    public abstract Nesne nesneSec(List<Nesne> nesneList, String name);

    public Long getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(Long oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public Long getSkor() {
        return skor;
    }

    public void setSkor(Long skor) {
        this.skor = skor;
    }

    public List<Nesne> getNesnelerList() {
        return nesneList;
    }

    public void setNesnelerList(List<Nesne> nesneList) {
        this.nesneList = nesneList;
    }

    public OyuncuTipi getOyuncuTipi() {
        return oyuncuTipi;
    }

    public void setOyuncuTipi(OyuncuTipi oyuncuTipi) {
        this.oyuncuTipi = oyuncuTipi;
    }
}
