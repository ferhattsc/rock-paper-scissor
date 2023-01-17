package com.base.entities;

import com.base.Oyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilClass {


    public static Oyuncu sonuc(Oyuncu oyuncu1, Oyuncu oyuncu2) {

        int i = 0;
        while (Stream.of(oyuncu1.getNesnelerList(), oyuncu2.getNesnelerList()).noneMatch(List::isEmpty) && i < Oyun.MAX_HAMLE) {
            Nesne nesne1 = oyuncu1.nesneSec(oyuncu1.getNesnelerList(), null);
            Nesne nesne2 = oyuncu2.nesneSec(oyuncu2.getNesnelerList(), null);

            etkiHesaplamalariniYap(nesne1, nesne2);

            // karsi tarafin dayanikliligini 0 in altina dusuren nesnenin seviye puanini 20 artir...
            seviyePuaniArtir(nesne1, nesne2);
            seviyePuaniArtir(nesne2, nesne1);


            // seviye puani 30 un ustune cikan nesneleri ozel yap...
            nesneninKademesiniYukselt(nesne1, oyuncu1);
            nesneninKademesiniYukselt(nesne2, oyuncu2);


            dayanikligiBitenNesneleriListedenCikar(Arrays.asList(oyuncu1, oyuncu2));


            i++;
        }

        // herhangi birinin elinde kart kalmadiysa ve digerinin elinde kart varsa kazanini belirle (nesne tukenme durumu)
        // oyuncularin her ikisinde de nesne varsa toplam dayaniklilik puani yuksek olan kazanacak...( max hamleden sonra ki durum)

        return kazananOyuncuyuBelirle(null, oyuncu1, oyuncu2);
    }


    public static Oyuncu kazananOyuncuyuBelirle(Oyuncu kazananOyuncu, Oyuncu ...oyuncu) {
        if (oyuncu[0].getNesnelerList().isEmpty() && !oyuncu[1].getNesnelerList().isEmpty()) {
            kazananOyuncu = oyuncu[1];
        } else if (oyuncu[1].getNesnelerList().isEmpty() && !oyuncu[0].getNesnelerList().isEmpty()) {
            kazananOyuncu = oyuncu[0];
        } else if (!oyuncu[1].getNesnelerList().isEmpty() && !oyuncu[0].getNesnelerList().isEmpty()) {
            double collect = oyuncu[0].getNesnelerList().stream().mapToDouble(Nesne::getDayaniklilik).sum();
            double sum = oyuncu[1].getNesnelerList().stream().mapToDouble(Nesne::getDayaniklilik).sum();

            if (collect > sum) {
                kazananOyuncu = oyuncu[0];
            }else {
                kazananOyuncu = oyuncu[1];
            }
        }
        return kazananOyuncu;
    }

    public static void seviyePuaniArtir(Nesne nesne3, Nesne nesne4) {
        if (nesne4.getDayaniklilik() - nesne3.etkiHesapla(nesne4) < 0) {
            nesne3.setSeviyePuani(nesne3.getSeviyePuani() + 20);
        }
    }

    public static void nesneninKademesiniYukselt(Nesne nesne, Oyuncu oyuncu) {
        if (nesne.getObjectType() != ObjectType.AGIR_TAS && nesne.getObjectType() != ObjectType.USTA_MAKAS && nesne.getObjectType() != ObjectType.OZEL_KAGIT) {
            if (nesne.getSeviyePuani() > 30) {
                oyuncu.getNesnelerList().remove(nesne);
                nesne.durumGuncelle(oyuncu.getNesnelerList());
            }
        }
    }

    public static List<Nesne> secilenNesneyiListedenCikar(List<Nesne> nesneList, Nesne secilenNesne) {
        return nesneList.stream()
                .filter(nesneler -> nesneler != secilenNesne)
                .collect(Collectors.toList());
    }

    public static void dayanikligiBitenNesneleriListedenCikar(List<Oyuncu> oyuncular) {
        oyuncular.forEach(each ->
                each.setNesnelerList(
                        each.getNesnelerList()
                                .stream()
                                .filter(each1 -> each1.getDayaniklilik() > 0)
                                .collect(Collectors.toList())
                )
        );
    }

    public static void etkiHesaplamalariniYap(Nesne ...nesne) {
        float oyuncuNesnesiEtki1 = nesne[0].etkiHesapla(nesne[1]);
        float dayaniklilik = nesne[0].getDayaniklilik();

        float oyuncuNesnesiEtki2 = nesne[1].etkiHesapla(nesne[0]);
        float dayaniklilik2 = nesne[1].getDayaniklilik();

        nesne[0].setDayaniklilik(dayaniklilik - oyuncuNesnesiEtki2);
        nesne[1].setDayaniklilik(dayaniklilik2 - oyuncuNesnesiEtki1);
    }

    public static List<Nesne> generateRandomNesnelerList() {
        ArrayList numbers = new ArrayList();
        for(int i = 1; i < 6; i++)
        {
            numbers.add(i);
        }

        List<Nesne> nesneList = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++) {
            Nesne nesne = NesneGenerator.generate(ObjectType.randomDirection());
            nesne.setName((int)numbers.get(i));
            nesneList.add(nesne);
        }
        return nesneList;
    }

}
