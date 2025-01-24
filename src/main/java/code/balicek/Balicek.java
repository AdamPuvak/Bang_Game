package code.balicek;

import code.karty.*;

import java.util.ArrayList;
import java.util.Collections;

public class Balicek {

    private final ArrayList<Karta> balicek;

    public Balicek() {

        balicek = new ArrayList<>();

        for(int i=0; i<30; i++) {
            balicek.add(new Bang());
        }
        for(int i=0; i<15; i++) {
            balicek.add(new Vedla());
        }
        for(int i=0; i<8; i++) {
            balicek.add(new Pivo());
        }
        for(int i=0; i<6; i++) {
            balicek.add(new Catbalou());
        }
        for(int i=0; i<4; i++) {
            balicek.add(new Dostavnik());
        }
        for(int i=0; i<3; i++) {
            balicek.add(new Vazenie());
        }
        for(int i=0; i<2; i++) {
            balicek.add(new Indiani());
            balicek.add(new Barrel());
        }
        balicek.add(new Dynamit());

        Collections.shuffle(balicek);
    }

    public ArrayList<Karta> getBalicek() { return balicek; }

    public Karta tahajKartu() { return balicek.remove(0); }

}
