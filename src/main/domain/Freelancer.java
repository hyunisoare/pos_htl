package domain;

import java.time.Year;

public class Freelancer extends Mitarbeiter {

    private double stundenSatz;
    private int stunden;

    public Freelancer(String name, char gesch, Year gebJahr, Year eintrittsJahr, float stundenSatz, int stunden) {
        super(name, gesch, gebJahr, eintrittsJahr);
        this.stundenSatz = stundenSatz;
        this.stunden = stunden;
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStundenSatz(double stundenSatz) {
        this.stundenSatz = stundenSatz;
    }

    public void setStunden(int stunden) {
        this.stunden = stunden;
    }


    //- Freelancer erhalten Stunden * Stundensatz sowie einen zusätzlichen
    // Bonus von € 100,- für jeweils 100 volle geleistete Stunden
    // (z.B. für 111 Stunden zusätzlich € 100 Bonus, für 195 Stunden
    // ebenfalls nur € 100 Bonus, für 205 Stunden zusätzlich € 200 Bonus ).
    @Override
    public double berechneGehalt(){
        int bonus = 0;
        if (stunden >= 100)
        {
            bonus = stunden / 100;
        }
        return (double)(stunden * stundenSatz) + bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                " stundenSatz = € " + stundenSatz;
    }
}
