package code.karty;

import code.balicek.Balicek;
import code.balicek.OdhadzovaciBalicek;
import code.hrac.Hrac;
import code.utility.ZKlavesnice;

public class Bang extends Karta {

    private static final String KARTA_NAZOV = "Bang!";

    public Bang() { super(KARTA_NAZOV); }

    @Override
    public void zahrajKartu(Hrac hracNaTahu, Hrac[] hraci, Karta zahrataKarta, Balicek balicek, OdhadzovaciBalicek odhadzovaciBalicek) {
        String trafenyHrac;

        System.out.println(" - Pocet zivotov jednotlivych hracov");
        for(Hrac hrac : hraci) {
            if(hrac.zije() && hrac != hracNaTahu) System.out.println("   " + hrac.getMeno() + ": " + hrac.getZivoty());
        }

        while(true) {
            while(true) {
                int zijeHrac = 0;
                trafenyHrac = (ZKlavesnice.readString(" - Na koho chces zahrat Bang? :"));

                for(Hrac hrac : hraci) {
                    if(hrac.getMeno().equals(trafenyHrac) && !hrac.zije()){
                        zijeHrac = 1;
                        break;
                    }
                }
                if(trafenyHrac.equals(hracNaTahu.getMeno()))System.out.println(" - Nemozes vystrelit sam na seba");
                else if(zijeHrac == 1) System.out.println(" - Tento hrac uz nezije");
                else break;
            }

            int spravneMeno = 0;
            for(Hrac hrac : hraci) {
                if(hrac.getMeno().equals(trafenyHrac)) {
                    spravneMeno = 1;
                    boolean zafungovalBarrel = false;

                    for(Karta karta : hrac.getKartyNaStole()) {
                        if(karta instanceof Barrel) {
                            zafungovalBarrel = ((Barrel) karta).skontrolujEfekt(hrac);
                            break;
                        }
                    }

                    if(!zafungovalBarrel) {
                        int maVedla = 0;
                        for(Karta karta : hrac.getKartyNaRuke()) {
                            if(karta instanceof Vedla) {
                                System.out.println(" - " + hrac.getMeno() + " hadze vedla");
                                hrac.odhodKartu(karta);
                                odhadzovaciBalicek.pridajKartu(karta);
                                maVedla = 1;
                                break;
                            }
                        }
                        if(maVedla == 0) {
                            if(hrac.getZivoty() == 1) System.out.println(" - " + hrac.getMeno() + " nema vedla, straca 1 zivot ");
                            else System.out.println(" - " + hrac.getMeno() + " nema vedla, straca 1 zivot. Pocet jeho zivotov: " + (hrac.getZivoty()-1));
                            hrac.minusZivot();
                        }

                    }

                }
            }
            if(spravneMeno == 0) System.out.println(" - Neplatne meno hraca, skus to znova");
            else break;
        }
        odhadzovaciBalicek.pridajKartu(zahrataKarta);
        hracNaTahu.odhodKartu(zahrataKarta);
    }

}
