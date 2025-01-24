package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

import java.util.Random;

public class Barrel extends Karta {

    private static final String KARTA_NAZOV = "Barrel";

    public Barrel() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        int maUzBarrel = 0;

        for(Karta karta : hracNaTahu.getKartyNaStole()) {
            if(karta instanceof Barrel) {
                maUzBarrel = 1;
                break;
            }
        }

        if(maUzBarrel == 1) {
            System.out.println(" - Uz mas vylozeny barrel");
        }
        else {
            hracNaTahu.vylozModruKartu(zahrataKarta);
            hracNaTahu.odhodKartu(zahrataKarta);
            System.out.println(" - Vylozil si pred seba barrel");
        }
    }

    public boolean skontrolujEfekt(Hrac trafenyHrac) {
        boolean zafungovalBarrel = false;

        Random sanca = new Random();
        int tahNaBarrel = sanca.nextInt(4);

        if(tahNaBarrel == 0) {
            System.out.println(" - " + trafenyHrac.getMeno() + " ma barrel a zafungoval mu");
            zafungovalBarrel = true;
        }
        else {
            System.out.println(" - " + trafenyHrac.getMeno() + " ma barrel a nezafungoval mu");
        }

        return zafungovalBarrel;
    }

}
