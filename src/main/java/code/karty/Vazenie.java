package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;
import code.utility.ZKlavesnice;

import java.util.Random;

public class Vazenie extends Karta {

    private static final String KARTA_NAZOV = "Vazenie";
    private final Random sanca;

    public Vazenie() {
        super(KARTA_NAZOV);
        sanca = new Random();
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        String trafenyHrac;

        while(true) {
            while(true) {
                int zijeHrac = 0;
                trafenyHrac = (ZKlavesnice.readString(" - Koho chces poslat do vazenia? :"));

                for(Hrac hrac : hraci) {
                    if(hrac.getMeno().equals(trafenyHrac) && !hrac.zije()) {
                        zijeHrac = 1;
                        break;
                    }
                }
                if(trafenyHrac.equals(hracNaTahu.getMeno()))System.out.println(" - Nemozes dat vazenie sam na seba");
                else if(zijeHrac == 1) System.out.println(" - Tento hrac uz nezije");
                else break;
            }

            int spravneMeno = 0;
            for(Hrac hrac : hraci) {
                if(hrac.getMeno().equals(trafenyHrac)) {
                    spravneMeno = 1;

                    int maVazenie = 0;
                    for(Karta karta : hrac.getKartyNaStole()) {
                        if(karta instanceof Vazenie) {
                            maVazenie = 1;
                            break;
                        }
                    }

                    if(maVazenie == 1) {
                        System.out.println(" - Tento hrac uz ma pred sebou vazenie");
                    }
                    else {
                        hrac.vylozModruKartu(zahrataKarta);
                        hracNaTahu.odhodKartu(zahrataKarta);
                        System.out.println(" - Poslal si hraca " + hrac.getMeno() + " do vazenia");
                    }

                }
            }
            if(spravneMeno == 0) System.out.println(" - Neplatne meno hraca, skus to znova");
            else break;
        }

    }

    public boolean skontrolujEfekt(Hrac hracNaTahu, OdhadzovaciBalicek odhadzovaciBalicek) {
        boolean jeVoVazeni = false;

        for(Karta karta : hracNaTahu.getKartyNaStole()) {
            if(karta instanceof Vazenie) {
                System.out.println(" ---------------------------------------\n - Tahanie na vazenie: ");

                int randomVazenie = sanca.nextInt(4);

                if(randomVazenie != 0) jeVoVazeni = true;
                else System.out.println(" - Usiel si z vazenia!");

                hracNaTahu.odhodModruKartu(karta);
                odhadzovaciBalicek.pridajKartu(karta);
                break;
            }
        }
        return jeVoVazeni;
    }
}
