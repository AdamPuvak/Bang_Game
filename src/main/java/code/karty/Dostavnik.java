package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

public class Dostavnik extends Karta {

    private static final String KARTA_NAZOV = "Dostavnik";

    public Dostavnik() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {

        for(int i=0; i<2; i++) hracNaTahu.pridajKartu(balicek.tahajKartu());

        odhadzovaciBalicek.pridajKartu(zahrataKarta);
        hracNaTahu.odhodKartu(zahrataKarta);
    }
}
