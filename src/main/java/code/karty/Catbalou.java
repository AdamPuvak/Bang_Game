package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;
import code.utility.ZKlavesnice;

import java.util.Random;

public class Catbalou extends Karta {

    private static final String KARTA_NAZOV = "Catbalou";

    public Catbalou() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        String trafenyHrac;
        int majuHraciKarty = 0;

        for(Hrac hrac : hraci) {
            if(hrac == hracNaTahu) continue;
            if(hrac.getKartyNaRuke().size() > 0) majuHraciKarty++;
            if(hrac.getKartyNaStole().size() > 0) majuHraciKarty++;
        }
        if(majuHraciKarty == 0) {
            System.out.println(" - Ostatni hraci nemaju ziadne karty, nemozes zahrat catbalou");
            return;
        }

        System.out.println(" - Pocet kariet jednotlivych hracov");
        for(Hrac hrac : hraci) {
            if(hrac.zije() && hrac != hracNaTahu)
                System.out.println("  " + hrac.getMeno() + ":  na ruke - " + hrac.getKartyNaRuke().size() + "  na stole  - " + hrac.getKartyNaStole().size());
        }

        while(true) {
            while(true) {
                int zijeHrac = 0;
                trafenyHrac = (ZKlavesnice.readString("\n - Na koho chces zahrat catbalou? :"));

                for(Hrac hrac : hraci) {
                    if(hrac.getMeno().equals(trafenyHrac) && !hrac.zije()) {
                        zijeHrac = 1;
                        break;
                    }
                }
                if(trafenyHrac.equals(hracNaTahu.getMeno()))System.out.println(" - Nemozes dat catbalou sam na seba");
                else if(zijeHrac == 1) System.out.println(" - Tento hrac uz nezije");
                else break;
            }

            int spravneMeno = 0;
            for(Hrac hrac : hraci) {
                if(hrac.getMeno().equals(trafenyHrac)) {
                    spravneMeno = 1;
                    int farbaKarty;

                    if(hrac.getKartyNaStole().size() == 0 && hrac.getKartyNaRuke().size() == 0) {
                        System.out.println(" - Hrac " + hrac.getMeno() + " nema ziadne karty");
                        return;
                    }
                    else if(hrac.getKartyNaStole().size() == 0) {
                        farbaKarty = 1;
                    }
                    else if(hrac.getKartyNaRuke().size() == 0) {
                        farbaKarty = 2;
                    }
                    else {
                        while(true) {
                            farbaKarty = (ZKlavesnice.readInt(" - Aku kartu mu chces vyhodit (hneda: 1 modra: 2) ? :"));
                            if(farbaKarty == 1 || farbaKarty == 2) break;
                            else System.out.println(" - Musis zadat 1 - (hneda) alebo 2 - (modra)");
                        }
                    }

                    Random sanca = new Random();
                    int cisloKarty;
                    if(farbaKarty == 1) {
                        cisloKarty = sanca.nextInt(hrac.getKartyNaRuke().size());
                        System.out.println(" - Hracovi " + hrac.getMeno() + " si vyhodil kartu: " + hrac.getKartyNaRuke().get(cisloKarty).getNazov() + " z ruky");

                        odhadzovaciBalicek.pridajKartu(hrac.getKartyNaRuke().get(cisloKarty));
                        hrac.odhodKartu(hrac.getKartyNaRuke().get(cisloKarty));

                    }
                    else {
                        cisloKarty = sanca.nextInt(hrac.getKartyNaStole().size());
                        System.out.println(" - Hracovi " + hrac.getMeno() + " si vyhodil kartu: " + hrac.getKartyNaStole().get(cisloKarty).getNazov() + " zo stola");

                        odhadzovaciBalicek.pridajKartu(hrac.getKartyNaStole().get(cisloKarty));
                        hrac.odhodModruKartu(hrac.getKartyNaStole().get(cisloKarty));

                    }
                    odhadzovaciBalicek.pridajKartu(zahrataKarta);
                    hracNaTahu.odhodKartu(zahrataKarta);
                }
            }
            if(spravneMeno == 0) System.out.println(" - Neplatne meno hraca, skus to znova");
            else break;
        }
    }
}
