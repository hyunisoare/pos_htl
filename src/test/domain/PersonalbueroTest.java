package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class PersonalbueroTest
{
    // TextFixtures
    private Angestellter rene;
    private Angestellter Ana;
    private Angestellter Alex;
    private Angestellter ags4;

    private Personalbuero personalbuero;
    private Personalbuero personalbueroBefuellt;
    //@AfterEach
    //@BeforeAll
    //@AfterAll
    @BeforeEach
    public void beforeEach(){
        rene = new Angestellter("Rene", 'm', Year.of(2000), Year.of(2010));
        Ana = new Angestellter("Ana", 'f', Year.of(2000), Year.of(2010));
        Alex = new Angestellter("Alex", 'f', Year.of(2000), Year.of(2010));
        ags4 = new Angestellter("Alex", 'm', Year.of(2000), Year.of(2010));
        personalbuero = new Personalbuero();

        personalbueroBefuellt = new Personalbuero("Spengergasse");
        personalbueroBefuellt.aufnehmen(rene);
        personalbueroBefuellt.aufnehmen(Ana);
        personalbueroBefuellt.aufnehmen(Alex);

    }

    @Test
    public void frauenquote_returns_vaild_percentage(){
        //when
        double quote = personalbuero.frauenQuote();

        assertEquals(quote, 0);
    }

    @Test
    public void frauenquote_returns_zero_on_empty_mitarbeiters(){
        //given
        personalbuero.aufnehmen(rene);
        personalbuero.aufnehmen(Ana);

        // when
        double quote = personalbuero.frauenQuote();

        assertEquals(quote, 0.);

    }

    @Test
    public void aufnehmen_eines_ersten_mitarbeiters_always_works(){
        // given
        String result = personalbuero.aufnehmen(rene);

        assertEquals("ok", result);
    }

    @Test
    public void aufnehmen_eines_maenlichen_mitarbeiters_triggers_frauenquote(){
        // given
        String result1 = personalbuero.aufnehmen(rene);
        String result2 = personalbuero.aufnehmen(Ana);

        assertEquals("ok", result1);
        //assertEquals("quote", result2);
    }

    @Test
    public void aufnehmen_eines_existierenden_ma_fails(){
        // given
        String result1 = personalbuero.aufnehmen(rene);
        String result2 = personalbuero.aufnehmen(rene);

        assertEquals("ok", result1);
        assertEquals("contains", result2);
    }

    @Test
    public void berechnen_der_gehaltssumme_works(){

        double gehaltssumme = personalbueroBefuellt.berechneGehaltsumme();

        System.out.println(gehaltssumme);

    }

    @Test
    public void zaehlen_von_angestellter_works(){

        int anzAngestellte = personalbueroBefuellt.zaehleAngestellte();

        assertEquals(3, anzAngestellte);
    }

    @Test
    public void kuendigen_MA_per_name_works(){
        Mitarbeiter m = personalbueroBefuellt.kuendigen(rene.getName());

        assertEquals(m, rene);
        assertEquals(2, personalbueroBefuellt.getAnzahl());
    }
}