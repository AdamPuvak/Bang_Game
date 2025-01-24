package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

public abstract class Karta {

    private final String nazov;

    public Karta(String nazov) { this.nazov = nazov; }

    public String getNazov(){
        return nazov;
    }

    public abstract void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek);

}
