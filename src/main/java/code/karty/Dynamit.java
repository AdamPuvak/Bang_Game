package code.karty;

import code.balicek.OdhadzovaciBalicek;
import code.balicek.Balicek;
import code.hrac.Hrac;

import java.util.Random;

public class Dynamit extends Karta {

    private static final String KARTA_NAZOV = "Dynamit";

    private final Random sanca;

    public Dynamit() {
        super(KARTA_NAZOV);
        sanca = new Random();
    }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {

        hracNaTahu.vylozModruKartu(zahrataKarta);
        hracNaTahu.odhodKartu(zahrataKarta);
        System.out.println(" - Dynamit bol vylozeny pred teba");

    }

    public boolean skontrolujEfekt(Hrac hracNaTahu, Hrac[] hraci, OdhadzovaciBalicek odhadzovaciBalicek) {
        boolean prezilPoDynamite = true;

        for(Karta karta : hracNaTahu.getKartyNaStole()) {
            if(karta instanceof Dynamit) {
                System.out.println(" ---------------------------------------\n - Tahanie na dynamit: ");

                int randomDynamit = sanca.nextInt(8);

                if(randomDynamit == 0) {
                    System.out.println(" - VYBUCHOL ti dynamit! Si vybaveny :)");
                    hracNaTahu.odhodModruKartu(karta);
                    odhadzovaciBalicek.pridajKartu(karta);

                    for(int i=0; i<3; i++) {
                        hracNaTahu.minusZivot();
                        if(!hracNaTahu.zije()) {
                            prezilPoDynamite = false;
                            break;
                        }
                    }
                    if(prezilPoDynamite) System.out.println(" - Pocet tvojich zivotov: " + hracNaTahu.getZivoty());
                }
                else {
                    System.out.println(" - Nevybuchol ti dynamit. Mas stastie");
                    hracNaTahu.odhodModruKartu(karta);

                    int pocitadlo = 0;
                    for(Hrac hrac : hraci) {
                        pocitadlo++;
                        if(hrac == hracNaTahu) break;
                    }
                    pocitadlo--;
                    if(pocitadlo == 0) pocitadlo = hraci.length;

                    boolean posunulDynamit = false;
                    for(int i=pocitadlo-1; i>=0; i--) {
                        if(hraci[i].zije()) {
                            hraci[i].vylozModruKartu(karta);
                            posunulDynamit = true;
                            break;
                        }
                    }
                    if(!posunulDynamit) {
                        for(int i=hraci.length-1; i>pocitadlo; i--) {
                            if(hraci[i].zije()) {
                                hraci[i].vylozModruKartu(karta);
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
        return prezilPoDynamite;
    }
}
