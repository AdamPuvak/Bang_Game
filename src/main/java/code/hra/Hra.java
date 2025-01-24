package code.hra;

import code.balicek.Balicek;
import code.balicek.OdhadzovaciBalicek;
import code.hrac.Hrac;
import code.karty.Dynamit;
import code.karty.Karta;
import code.karty.Vazenie;
import code.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Collections;


public class Hra {

    private final Hrac[] hraci;
    private int aktualnyHrac;
    private final Balicek balicek;
    private final OdhadzovaciBalicek odhadzovaciBalicek;


    public Hra() {
        System.out.println("\n---------------------------------------\n     ! Vitajte na divokom zapade !\n---------------------------------------\n");
        int pocetHracov = 0;

        while (pocetHracov < 2 || pocetHracov > 4) {
            pocetHracov = ZKlavesnice.readInt(" - Zadaj pocet hracov (2-4): ");
            if (pocetHracov < 2 || pocetHracov > 4) {
                System.out.println(" - Neplatny pocet hracov, skus to znova !");
            }
        }

        this.hraci = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++) {
            this.hraci[i] = new Hrac(ZKlavesnice.readString(" - Napis meno pre HRACA " + (i+1) + " : "));
        }

        balicek = new Balicek();
        odhadzovaciBalicek = new OdhadzovaciBalicek();

        for (Hrac hrac : hraci) {
            for (int i = 0; i < 4; i++) {
                hrac.getKartyNaRuke().add(balicek.tahajKartu());
            }
        }

        this.startHry();
    }

    public void startHry() {

        System.out.println("\n - Hra zacina!");

        while (this.pocetAktivnychHracov() > 1) {

            Hrac hracNaTahu = this.hraci[this.aktualnyHrac];

            if (!hracNaTahu.zije()) {
                ArrayList<Karta> kartyDoBalicka = hracNaTahu.odhodKarty();
                for (Karta karta : kartyDoBalicka) {
                    odhadzovaciBalicek.pridajKartu(karta);
                }
                kartyDoBalicka = hracNaTahu.odhodModreKarty();
                for (Karta karta : kartyDoBalicka) {
                    odhadzovaciBalicek.pridajKartu(karta);
                }
                this.aktualnyHrac++;
                this.aktualnyHrac %= this.hraci.length;
                continue;
            }

            if(balicek.getBalicek().size()<10) {
                Collections.shuffle(odhadzovaciBalicek.getOdhadzovaciBalicek());
                for(int i = 0; i< odhadzovaciBalicek.getOdhadzovaciBalicek().size(); i++){
                    balicek.getBalicek().add(odhadzovaciBalicek.getOdhadzovaciBalicek().remove(0));
                }
            }

            System.out.println("\n ---------------------------------------");
            System.out.println(" - Hrac " + hracNaTahu.getMeno() + " je na tahu");
            System.out.println(" - Pocet zivotov: " + hracNaTahu.getZivoty());

            this.zahrajTah(hracNaTahu);
            this.aktualnyHrac++;
            this.aktualnyHrac %= this.hraci.length;
        }

        System.out.println("\n ---------------------------------------\n - Koniec hry!");
        System.out.println(" - Vitaz: " + ktoVyhral().getMeno());

    }

    private void zahrajTah(Hrac hracNaTahu) {

        for(Karta karta : hracNaTahu.getKartyNaStole()) {
            if(karta instanceof Dynamit) {
                boolean prezilPoDynamite = ((Dynamit) karta).skontrolujEfekt(hracNaTahu, hraci, odhadzovaciBalicek);
                if(!prezilPoDynamite) return;
                break;
            }
        }

        for(Karta karta : hracNaTahu.getKartyNaStole()) {
            if(karta instanceof Vazenie) {
                boolean jeVoVazeni = ((Vazenie) karta).skontrolujEfekt(hracNaTahu, odhadzovaciBalicek);
                if(jeVoVazeni) {
                    System.out.println(" - Ostavas vo vazeni");
                    return;
                }
                break;
            }
        }

        for(int i=0; i<2; i++) {
            hracNaTahu.getKartyNaRuke().add(balicek.tahajKartu());
        }

        int cisloKarty;
        while (true) {

            if(hracNaTahu.getKartyNaRuke().size() == 0){
                System.out.println("\n - Uz nemas ziadne karty na ruke, koniec tahu");
                break;
            }

            if(hracNaTahu.getKartyNaStole().size() != 0) {
                System.out.println("  ---------------------------------------\n - Karty na stole: \n");
                for (int i = 0; i < hracNaTahu.getKartyNaStole().size() ; i++) {
                    System.out.println(i+1 + ". " + hracNaTahu.getKartyNaStole().get(i).getNazov());
                }
            }

            System.out.println("  ---------------------------------------\n - Karty na ruke: \n");
            for (int i = 0; i < hracNaTahu.getKartyNaRuke().size() ; i++) {
                System.out.println(i+1 + ". " + hracNaTahu.getKartyNaRuke().get(i).getNazov());
            }

            cisloKarty = (ZKlavesnice.readInt("\n - Aku kartu chces zahrat? (Ukoncit tah = zadaj 0) Cislo: "));

            if(cisloKarty < 0 || cisloKarty > hracNaTahu.getKartyNaRuke().size()) {
                System.out.println(" - Neplatne cislo karty, skus to znova !");
            }
            else if( cisloKarty == 0) {
                if(hracNaTahu.getZivoty() < hracNaTahu.getKartyNaRuke().size()) {
                    System.out.println(" - Vyhodenie prebytocnych kariet: ");
                    prebytocneKarty(hracNaTahu);
                }
                System.out.println("\n - Koniec tahu");
                break;
            }
            else {
                Karta hranaKarta = hracNaTahu.getKartyNaRuke().get(cisloKarty-1);
                hranaKarta.zahrajKartu(hracNaTahu, this.hraci, hranaKarta, balicek, odhadzovaciBalicek);

                if(this.pocetAktivnychHracov() < 2) break;
            }
        }

    }

    private void prebytocneKarty(Hrac hracNaTahu) {
        int cisloKarty;

        while(hracNaTahu.getZivoty() < hracNaTahu.getKartyNaRuke().size()) {
            System.out.println(" - Karty:");
            for (int i = 0; i < hracNaTahu.getKartyNaRuke().size() ; i++) {
                System.out.println(i+1 + ". " + hracNaTahu.getKartyNaRuke().get(i).getNazov());
            }
            while(true) {
                cisloKarty = (ZKlavesnice.readInt("\n - Aku kartu chces vyhodit? Cislo: "));

                if (cisloKarty < 1 || cisloKarty > hracNaTahu.getKartyNaRuke().size()) {
                    System.out.println(" - Neplatne cislo karty, skus to znova !");
                }
                else {
                    odhadzovaciBalicek.getOdhadzovaciBalicek().add(hracNaTahu.getKartyNaRuke().get(cisloKarty-1));
                    hracNaTahu.getKartyNaRuke().remove(cisloKarty-1);
                    break;
                }
            }
        }
    }

    private int pocetAktivnychHracov() {
        int pocet = 0;
        for (Hrac hrac : this.hraci) {
            if (hrac.zije()) {
                pocet++;
            }
        }
        return pocet;
    }

    private Hrac ktoVyhral() {
        for (Hrac hrac : this.hraci) {
            if (hrac.zije()) {
                return hrac;
            }
        }
        return null;
    }

}
