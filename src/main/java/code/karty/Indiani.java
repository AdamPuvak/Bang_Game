package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

public class Indiani extends Karta {

    private static final String KARTA_NAZOV = "Indiani";

    public Indiani() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        System.out.println(" - Indiani");

        for(Hrac hrac : hraci) {
            int maBang = 0;

            if(hrac == hracNaTahu) continue;

            if(hrac.zije()) {
                for(Karta karta : hrac.getKartyNaRuke()) {
                    if(karta instanceof Bang) {
                        hrac.odhodKartu(karta);
                        odhadzovaciBalicek.pridajKartu(karta);
                        System.out.println(" - Hrac " + hrac.getMeno() + " zahral Bang");
                        maBang = 1;
                        break;
                    }
                }
                if(maBang == 0) {
                    hrac.minusZivot();
                    System.out.println(" - Hrac " + hrac.getMeno() + " nema Bang a straca 1 zivot. Pocet jeho zivotov: " + hrac.getZivoty());
                }
            }
        }
        odhadzovaciBalicek.pridajKartu(zahrataKarta);
        hracNaTahu.odhodKartu(zahrataKarta);
    }
}
