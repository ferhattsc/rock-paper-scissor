package com.base;

import com.base.entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.base.entities.UtilClass.*;

public class Oyun {

    public static final float A = 2f/10f;
    public static final int MAX_HAMLE = 300;

    public static void main(String[] args) {

        // bilgisayar - kullanici || bilgisayar - bilgisayar secimi yapilir ...

        JFrame f = new JFrame("TAŞ-KAĞIT-MAKAS");

        JButton oyunaBaslaButon = new JButton();
        oyunaBaslaButon.setText("Oyuna Başla");
        oyunaBaslaButon.setBounds(300, 300, 200, 100);



        f.add(oyunaBaslaButon);
        f.setSize(800, 800);
        f.setLayout(null);
        f.setVisible(true);


        JFrame f2 = new JFrame("TAŞ-KAĞIT-MAKAS");
        JButton bilgisayarVsBilgisayarButon = new JButton();
        bilgisayarVsBilgisayarButon.setText("Bilgisayar vs Bilgisayar");
        bilgisayarVsBilgisayarButon.setBounds(100, 300, 200, 100);

        JButton bilgisayarVsKullanici = new JButton();
        bilgisayarVsKullanici.setText("Bilgisayar vs Kullanici");
        bilgisayarVsKullanici.setBounds(400, 300, 200, 100);

        f2.add(bilgisayarVsBilgisayarButon);
        f2.add(bilgisayarVsKullanici);
        f2.setSize(800, 800);
        f2.setLayout(null);

        oyunaBaslaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                f2.setVisible(true);
            }
        });


        // bilgisayar vs bilgisayar execute
        bilgisayarVsBilgisayarButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
                JFrame f3 = new JFrame("Bilgisayar vs Bilgisayar");

                List<Nesne> nesneList = generateRandomNesnelerList();
                List<Nesne> nesneList1 = generateRandomNesnelerList();

                Oyuncu oyuncu1 = new Bilgisayar(1L, "bilgisayar-1", 0L, nesneList);
                Oyuncu oyuncu2 = new Bilgisayar(2L, "bilgisayar-2", 0L, nesneList1);

                Oyuncu kazananOyuncu = sonuc(oyuncu1, oyuncu2);


                f3.setSize(800, 800);
                f3.setLayout(null);
                f3.setVisible(true);
            }
        });



        JFrame f3 = new JFrame("Bilgisayar vs Kullanici");



        JButton tasButon = new JButton();
        tasButon.setText("TAS");
        tasButon.setBounds(100, 100, 200, 50);

        JButton kagitButon = new JButton();
        kagitButon.setText("KAGIT");
        kagitButon.setBounds(400, 100, 200, 50);

        JButton makasButon = new JButton();
        makasButon.setText("MAKAS");
        makasButon.setBounds(700, 100, 200, 50);

        f3.add(tasButon);
        f3.add(kagitButon);
        f3.add(makasButon);

        f3.setSize(800, 800);
        f3.setLayout(null);


        bilgisayarVsKullanici.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
                f3.setVisible(true);
            }
        });

        ClickCounter counter = new ClickCounter();
        JPanel counterPanel = counter.getPanel();
        counterPanel.setBounds(100, 300, 200, 50);
        counterPanel.setName(ObjectType.TAS.toString());

        ClickCounter counter2 = new ClickCounter();
        JPanel counterPanel2 = counter2.getPanel();
        counterPanel2.setBounds(400, 300, 200, 50);
        counterPanel2.setName(ObjectType.KAGIT.toString());

        ClickCounter counter3 = new ClickCounter();
        JPanel counterPanel3 = counter3.getPanel();
        counterPanel3.setBounds(700, 300, 200, 50);
        counterPanel3.setName(ObjectType.MAKAS.toString());


        f3.add(counterPanel);
        f3.add(counterPanel2);
        f3.add(counterPanel3);

        JButton sonrakiSayfayaGeç = new JButton();
        sonrakiSayfayaGeç.setText("Oyunu Baslat");
        sonrakiSayfayaGeç.setBounds(400, 500, 200, 100);

        f3.add(sonrakiSayfayaGeç);


        sonrakiSayfayaGeç.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
                f3.dispose();
                bilgisayarKullaniciOyununuBaslat(counter, counter2, counter3);
            }
        });
    }

    private static void bilgisayarKullaniciOyununuBaslat(ClickCounter ...clickCounters) {
        int tasSayisi = clickCounters[0].getI();
        int kagitSayisi = clickCounters[1].getI();
        int makasSayisi = clickCounters[2].getI();

        List<Nesne> kullaniciNesneList = new ArrayList<>();

        ArrayList numbers = new ArrayList();
        for(int i = 1; i < 6; i++)
        {
            numbers.add(i);
        }

        for (int i = 0; i < tasSayisi; i++) {
            Nesne nesne = NesneGenerator.generate(ObjectType.TAS);
            nesne.setName((int)numbers.get(0));
            numbers.remove(0);
            kullaniciNesneList.add(nesne);
        }
        for (int i = 0; i < kagitSayisi; i++) {
            Nesne nesne = NesneGenerator.generate(ObjectType.KAGIT);
            nesne.setName((int)numbers.get(0));
            numbers.remove(0);
            kullaniciNesneList.add(nesne);
        }
        for (int i = 0; i < makasSayisi; i++) {
            Nesne nesne = NesneGenerator.generate(ObjectType.MAKAS);
            nesne.setName((int)numbers.get(0));
            numbers.remove(0);
            kullaniciNesneList.add(nesne);
        }

        List<Nesne> bilgisayaraNesneList = generateRandomNesnelerList();

        Oyuncu oyuncu1 = new Bilgisayar(1L, "bilgisayar", 0L, bilgisayaraNesneList);
        Oyuncu oyuncu2 = new Kullanici(2L, "kullanici", 0L, kullaniciNesneList);

        JFrame f5 = new JFrame("Bilgisayar vs Kullanici Oyunu");

        guiListeyiGüncelle(f5, oyuncu1, oyuncu2);
        // tıklanilan buttonlari i sil

    }

    private static void guiListeyiGüncelle(JFrame jFrame, Oyuncu ...oyuncu) {
        Oyuncu oyuncu1 = oyuncu[0];
        Oyuncu oyuncu2 = oyuncu[1];

        for (int i = 0; i < oyuncu1.getNesnelerList().size(); i++) {
            JButton button = new JButton();
            button.setText("" + i);
            button.setBounds(100, 100 * i, 150, 100);
            jFrame.add(button);
        }


        final String[] buttonText = new String[1];
        for (int i = 0; i < oyuncu2.getNesnelerList().size(); i++) {
            JButton button = new JButton();
            button.setText(oyuncu2.getNesnelerList().get(i).getName());
            button.setBounds(400, 100 * i, 150, 100);
            jFrame.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    Oyuncu kazananOyuncu = kazananOyuncuyuBelirle(null, oyuncu1, oyuncu2);
                    if (kazananOyuncu != null) {
                        JFrame f3 = new JFrame("Oyun sonucu");

                        JButton button = new JButton();
                        button.setText(kazananOyuncu.getOyuncuTipi().toString());
                        button.setBounds(400, 100, 150, 100);
                        f3.add(button);

                        jFrame.dispose();

                        f3.setSize(800, 800);
                        f3.setLayout(null);
                        f3.setVisible(true);
                        return;
                    }

                    buttonText[0] = e.getActionCommand();
                    System.out.println("secilen kart -> " + buttonText[0]);
                    Nesne nesne1 = oyuncu1.nesneSec(oyuncu1.getNesnelerList(), "");
                    Nesne nesne2 = oyuncu2.nesneSec(oyuncu2.getNesnelerList(), buttonText[0]);

                    etkiHesaplamalariniYap(nesne1, nesne2);

                    // karsi tarafin dayanikliligini 0 in altina dusuren nesnenin seviye puanini 20 artir...
                    seviyePuaniArtir(nesne1, nesne2);
                    seviyePuaniArtir(nesne2, nesne1);


                    // seviye puani 30 un ustune cikan nesneleri ozel yap...
                    nesneninKademesiniYukselt(nesne1, oyuncu1);
                    nesneninKademesiniYukselt(nesne2, oyuncu2);


                    dayanikligiBitenNesneleriListedenCikar(Arrays.asList(oyuncu1, oyuncu2));

                    JFrame f5 = new JFrame("Bilgisayar vs Kullanici Oyunu");

                    f5.setSize(800, 800);
                    f5.setLayout(null);
                    f5.setVisible(true);

                    jFrame.dispose();
                    guiListeyiGüncelle(f5, oyuncu1, oyuncu2);

                }
            });
        }

        jFrame.setSize(800, 800);
        jFrame.setLayout(null);
        jFrame.setVisible(true);

    }
}
