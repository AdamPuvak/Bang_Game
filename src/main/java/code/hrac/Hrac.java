package code.hrac;

import code.karty.Karta;

import java.util.ArrayList;

public class Hrac {

    private final String meno;
    private int zivoty;
    private final ArrayList<Karta> kartyNaRuke;
    private final ArrayList<Karta> kartyNaStole;

    public Hrac(String meno) {
        this.kartyNaRuke = new ArrayList<>();
        this.kartyNaStole = new ArrayList<>();
        this.meno = meno;
        this.zivoty = 4;
    }

    public String getMeno() { return meno; }

    public int getZivoty() { return zivoty; }

    public ArrayList<Karta> getKartyNaRuke() { return this.kartyNaRuke; }

    public ArrayList<Karta> getKartyNaStole() { return this.kartyNaStole; }

    public boolean zije() { return this.zivoty > 0; }

    public void minusZivot() {
        this.zivoty--;
        if(zivoty <= 0) System.out.println(" - " + meno + " je vyradeny z hry");
    }

    public void plusZivot() {
        this.zivoty++;
    }

    public ArrayList<Karta> odhodKarty() {
        ArrayList<Karta> odhodeneKarty = new ArrayList<>(this.kartyNaRuke);
        this.kartyNaRuke.clear();
        return odhodeneKarty;
    }

    public ArrayList<Karta> odhodModreKarty() {
        ArrayList<Karta> odhodeneModreKarty = new ArrayList<>(this.kartyNaStole);
        this.kartyNaStole.clear();
        return odhodeneModreKarty;
    }

    public void pridajKartu(Karta karta) { this.kartyNaRuke.add(karta); }

    public void vylozModruKartu(Karta karta) { this.kartyNaStole.add(karta); }

    public void odhodKartu(Karta karta) { this.kartyNaRuke.remove(karta); }

    public void odhodModruKartu(Karta karta) { this.kartyNaStole.remove(karta); }





}
