package ba.unsa.etf.rpr.Z2;


import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class ImenikTest
{
    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void imenikPopuni(){
        imenik.dodaj("Eldar", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj("Dino", new FiksniBroj(Grad.ZENICA, "225-884"));
        imenik.dodaj("Amir", new MobilniBroj(61, "225-885"));
        imenik.dodaj("Chris", new MedunarodniBroj("+44", "7768878794"));
    }
    @Test
    public void dajImeIma(){
        TelefonskiBroj broj = new FiksniBroj(Grad.SARAJEVO, "225-883");
        assertEquals("Eldar", imenik.dajIme(broj));
    }

    @Test
    public void dajImeNema(){
        TelefonskiBroj broj = new MobilniBroj(22, "233-453");
        assertNull(imenik.dajIme(broj));
    }
    /**
     * Rigorous Test :-)
     */
    @Test
    public void dodajFiksniIspravno(){
        TelefonskiBroj broj = new MedunarodniBroj("+387", "7768873516");
        imenik.dodaj("Hamo", broj);

        String brojPovratni = imenik.dajBroj("Hamo");
        assertEquals(brojPovratni, "+3877768873516");
    }

    @Test
    public void dodajFiksniException(){
        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "324-531");
            }
        });
        //preko lambda funkcije:
        //assertThrows(BrojException.class, () -> { new FiksniBroj(null, "324-531");});
    }

    @Test
    public void naSlovoIma(){
        assertEquals("1. Eldar - 033/225-883" + System.lineSeparator(), imenik.naSlovo('E'));
    }

    @Test
    public void izGradaNema(){
        Set<String> imena = imenik.izGrada(Grad.MOSTAR);
        assertTrue(imena.isEmpty());
    }
}
