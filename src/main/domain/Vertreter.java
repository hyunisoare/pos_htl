package domain;

import java.time.Year;

public class Vertreter extends Mitarbeiter
{
    private double basisgehalt;
    private double umsatz;

    public Vertreter(String name, char gesch, Year gebJahr, Year eintrittsJahr, double basisgehalt, double umsatz) {
        super(name, gesch, gebJahr, eintrittsJahr);
        this.basisgehalt = basisgehalt;
        this.umsatz = umsatz;
    }

    public double getBasisgehalt() {
        return basisgehalt;
    }

    public double getUmsatz() {
        return umsatz;
    }

    public void setBasisgehalt(double basisgehalt) {
        this.basisgehalt = basisgehalt;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }


    //Vertreter erhalten zu ihrem Basisgehalt 1% ihres Umsatzes.
    @Override
    public double berechneGehalt()
    {
        double einProzent = 0;

        if (umsatz > 0)
        {
            einProzent = umsatz / 0.01;
        }

        return basisgehalt + einProzent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "basisgehalt = € " + basisgehalt;
    }
}
