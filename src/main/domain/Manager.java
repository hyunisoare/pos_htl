package domain;

import java.time.Year;

public class Manager extends Mitarbeiter {
    float fixum;

    public Manager(String name, char gesch, Year gebJahr, Year eintrittsJahr, float fixum) {
        super(name, gesch, gebJahr, eintrittsJahr);
        this.fixum = fixum;
    }

    public void setFixum(float fixum) {
        this.fixum = fixum;
    }

    public float getFixum() {
        return fixum;
    }

    //Manager bekommen ein frei vereinbartes monatliches Fixum.
    @Override
    public double berechneGehalt(){
        return fixum;
    }

    @Override
    public String toString() {
        return super.toString() + "fixum = € " + fixum;
    }
}
