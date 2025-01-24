package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

public class Pivo extends Karta {

    private static final String KARTA_NAZOV = "Pivo";

    public Pivo() {
        super(KARTA_NAZOV);
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {

        hracNaTahu.plusZivot();
        System.out.println(" - Bol ti pridany jeden zivot. Pocet tvojich zivotov: " + hracNaTahu.getZivoty());

        odhadzovaciBalicek.pridajKartu(zahrataKarta);
        hracNaTahu.odhodKartu(zahrataKarta);

    }
}
