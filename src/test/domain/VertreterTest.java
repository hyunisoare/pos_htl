package domain;

import domain.Vertreter;

import java.time.Year;

public class VertreterTest {
    public static void main(String[] args) {
        // Vertreter Starche - m € 7500.0 / Basisgehalt: € 1500.0
        Vertreter vertreter = new Vertreter("Starche", 'm', Year.of(1990), Year.of(2021),
                                            1500.0, 600_000.0);

        System.out.println(vertreter.toString());
    }
}

/*

 */