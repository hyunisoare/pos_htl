package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Personalbuero {
    private List<Mitarbeiter> mitarbeiters;
    private String name;

    public Personalbuero(String name)
    {
        this.name = name;
        mitarbeiters = new ArrayList<>();
    } // init. 10 boxes

    public int getAnzahl(){
        return mitarbeiters.size();
    }
    public double frauenQuote() {
        int anzFrauen = 0;

        for (Mitarbeiter mitarbeiter : mitarbeiters) {
            if (mitarbeiter.getGesch() == 'f')
                anzFrauen++;
        }
        return mitarbeiters.isEmpty()
            ? 0
            : anzFrauen / mitarbeiters.size()* 100.0;

    }

    public String aufnehmen(Mitarbeiter mitarbeiter)
    { // shortcut: inn ifn
        if (mitarbeiter != null) {
            if (mitarbeiters.size() < 100) {
                if (!mitarbeiters.contains(mitarbeiter)){
                    if (mitarbeiter.getGesch() =='f'){
                        mitarbeiters.add(mitarbeiter);
                        return "ok";
                    }
                    if (mitarbeiters.isEmpty() || frauenQuote() >= 40.0){
                        mitarbeiters.add(mitarbeiter);
                        return "ok";
                    }
                }
              else
                {
                    System.out.println("fehler : dieser MA existiert schon!");
                    return "contains";
                }
            }
            else{
                System.out.println("Fehler...voll");
                return "voll";
            }
           return "quote";
        }
        else {
            System.out.println("mitarbeiter ist null.");
            return "null";
        }
    }
    public boolean kuendigen(int pos){
        if (pos >= 0 && pos < mitarbeiters.size()){
            mitarbeiters.remove(pos);
            return true;
        }
        else
        {
            System.out.println("Fehler: ungultige Position");
            return false;
        }
    }

    public Mitarbeiter kuendigen(String m){
        if (m != null)
        {
            if (!m.isBlank())
            {
                for (Mitarbeiter mitarbeiter : mitarbeiters)
                {
                    if (mitarbeiter.getName == m)
                    {
                        mitarbeiters.remove(mitarbeiter);
                        return mitarbeiter;
                    }
                }
            }
            else
            {
                System.out.println("Fehler...");
            }
        }
        else
        {
            System.out.println("fehler");
        }
        return null;
    }

    public Mitarbeiter kuendigen(String name)
    {
        if (name != null) {
            Iterator<Mitarbeiter> iterator = mitarbeiters.iterator();
            while(iterator.hasNext()){
                Mitarbeiter mitarbeiter = iterator.next();
                if (mitarbeiter.getName().equals(name)){
                    iterator.remove();
                    System.out.println("mitarbeiter " + mitarbeiter + "wird gekündigt.");
                    return mitarbeiter;
                }
                else{
                    System.out.println("kein mitarbeiter mit diesem Name gefunden.");
                    return null;
                }
            }
        }
        else{
            System.out.println("name is null");
            return null;
        }
        return null;
    }

//    berechneGehaltsumme() berechnet die Gesamt-Summe der Monatsgehälter aller Mitarbeiter
    public double berechneGehaltsumme(){
        double gehaltsumme = 0;
        for (Mitarbeiter mitarbeiter : mitarbeiters) {
            gehaltsumme += mitarbeiter.berechneGehalt();
        }

        return gehaltsumme;
    }

//    zaehleAngestellte() gibt die Anzahl der Angestellten zurück.
    public int zaehleAngestellte(){
        int sum = 0;
        // ForEach ist Syntactic Sugar

//        for (Mitarbeiter m : mitarbeiters) {
//            if (m instanceof Angestellter){
//                sum++;
//            }
//        }
//        return sum;

        Iterator<Mitarbeiter> iterator = mitarbeiters.iterator();
        while(iterator.hasNext()){
            Mitarbeiter m = iterator.next();
            if(m instanceof Angestellter){
                sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Personalbuero: %s\n").append(name);
        sb.append(String.format("Anzahl: %d\n", getAnzahl()));
        sb.append(String.format("Gehaltssumme: %.2f\n", berechneGehaltsumme()));

        // we use for-each because we don't modify the collection.
        for (Mitarbeiter mitarbeiter : mitarbeiters) {
            sb.append(mitarbeiter.toString()).append("\n");
        }

        return sb.toString();
    }
}

// Iterator nur bei entfernen.