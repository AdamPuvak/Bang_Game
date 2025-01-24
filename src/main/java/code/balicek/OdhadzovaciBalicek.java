package code.balicek;

import code.karty.*;

import java.util.ArrayList;

public class OdhadzovaciBalicek {

    private final ArrayList<Karta> odhadzovaciBalicek;

    public OdhadzovaciBalicek() { odhadzovaciBalicek = new ArrayList<>(); }

    public ArrayList<Karta> getOdhadzovaciBalicek() {
        return odhadzovaciBalicek;
    }

    public void pridajKartu(Karta karta){
        this.odhadzovaciBalicek.add(karta);
    }

}


