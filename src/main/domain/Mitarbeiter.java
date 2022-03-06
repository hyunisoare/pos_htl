package domain;

import java.time.Year;

public abstract class Mitarbeiter {
    private String name;
    private char gesch;
    private Year gebJahr;
    private Year eintrittsJahr;

    public Mitarbeiter(String name, char gesch, Year gebJahr, Year eintrittsJahr) {
        setName(name);
        setGesch(gesch);
        setGebJahr(gebJahr);
        setEintrittsJahr(eintrittsJahr);
    }

    public abstract double berechneGehalt();
        //- Mitarbeiter existieren nicht als eigenständige "Individuen"! Sie
        // haben daher keine Implementierung dieser Methode. Es muß allerdings
        // sichergestellt werden, daß alle abgeleiteten Klassen diese Methode
        // implementieren!!!


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null){
            if (!name.isBlank()){
                this.name = name;
            } else{
                System.out.println("Fehler : name ist blank.");
            }
        }
        else{
            System.out.println("Fehler name ist null");
        }

    }

    public char getGesch() {
        return gesch;
    }

    public void setGesch(char gesch) {
        if (gesch == 'f' || gesch == 'm' || gesch == 'd'){
            this.gesch = gesch;
        }
        else{
            System.out.println("Fehler: ungueltige Geschlecht.");
        }

    }

    public Year getGebJahr() {
        return gebJahr;
    }

    // mind. 14 Jahre, max 100 Jahre
    public void setGebJahr(Year gebJahr) {
        if (Year.now().getValue() - gebJahr.getValue() > 14 &&
            Year.now().getValue() - gebJahr.getValue() < 100){
            this.gebJahr = gebJahr;
        }
        else{
            System.out.println("Fehler: ungueltige GebJahr.");
        }
    }

    public Year getEintrittsJahr() { return eintrittsJahr;}

    // mind. heutiges Jahr,
    public void setEintrittsJahr(Year eintrittsJahr) {
        if (eintrittsJahr.getValue() <= Year.now().getValue()){
            this.eintrittsJahr = eintrittsJahr;
        }
        else{
            System.out.println("Fehler...");
        }
    }

    public int berechneAlter(){
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter(){
        return Year.now().getValue() - eintrittsJahr.getValue();
    }



    //Mitarbeiter-Art name - gesch € Gehalt / ev. sonstige Info
    // z.B.: Freelancer Gubensauer – f : € 1600.0 / Stundensatz: € 35.0
    // Manager Schussel - m € 181500.0 / Alter: 65 Jahre
    // Angestellter Hediar - f € 11500.0 / Firmenzugehörigkeit: 15 Jahre
    // Vertreter Starche - m € 7500.0 / Basisgehalt: € 1500.0
    @Override
    public String toString() {
        return     name + " - " + gesch + ": € " +
                    berechneGehalt() + " / ";
    }
    //getClass().getName()+"@"+Integer.toHexString(hashCode())
}
