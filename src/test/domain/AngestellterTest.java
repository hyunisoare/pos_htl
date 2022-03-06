package domain;

import domain.Angestellter;
import domain.Mitarbeiter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AngestellterTest {

    private Angestellter ags;
    //@AfterEach
    //@BeforeAll
    //@AfterAll
    @BeforeEach
    public void beforeEach(){
        ags = new Angestellter("Jun", 'f', Year.of(2000), Year.of(2010));
    }


    /*
    public static void main(String[] args) {
            Angestellter ags = new Angestellter("Hediar", 'f', Year.of(1960), Year.of(2007));
        System.out.println(ags.berechneGehalt()); // 1500 + 50 * 12
        //System.out.println(ags.toString());
    }
    */
    @Test
    public void setiing_of_Name_works(){
        //given
        //Angestellter ags = new Angestellter("Jun", 'f', Year.of(2000), Year.of(2010));

        //when
        ags.setName("Ana");
        //then
        assertEquals(ags.getName(), "Ana");
    }

    @Test
    public void berechne_Gehalt_works(){
        //given
        //Angestellter ags = new Angestellter("Jun", 'f', Year.of(2000), Year.of(2010));
        // when
        double gehalt = ags.berechneGehalt();
        // then
        assertEquals(gehalt, 2100);
    }
}
