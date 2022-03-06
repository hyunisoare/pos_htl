package domain;

import java.time.Year;

import static java.time.LocalTime.now;

public class Angestellter extends Mitarbeiter
{
    public Angestellter(String name, char gesch, Year gebJahr, Year eintrittsJahr) {
        super(name, gesch, gebJahr, eintrittsJahr);
    }

    //Angestellte verdienen ein Grundgehalt von € 1500,- plus € 50,- pro
    //Jahr ihrer Firmenzugehörigkeit.
    @Override
    public double berechneGehalt()
    {
        int dauer = Year.now().getValue() - getEintrittsJahr().getValue();
        return 1500 + (dauer * 50);
    }

    @Override
    public String toString()
    {
       return this.getClass().getSimpleName() + " " + super.toString() +
               " / Firmenzugehörigkeit : " + "gehalt: " + berechneGehalt();
    }
}
