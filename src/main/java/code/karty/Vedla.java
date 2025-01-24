package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

public class Vedla extends Karta {

    private static final String KARTA_NAZOV = "Vedla";

    public Vedla() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        System.out.println(" - Karta vedla sa da zahrat iba ako odpoved na Bang");
    }
}
