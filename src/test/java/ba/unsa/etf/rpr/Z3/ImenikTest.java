package ba.unsa.etf.rpr.Z3;

import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {
    private static Imenik imenik  = new Imenik();

    @BeforeAll
    public static void imenikDodavanje(){
        imenik.dodaj("Eldar", new FiksniBroj(Grad.SARAJEVO, "225-883"));
        imenik.dodaj("Dino", new FiksniBroj(Grad.ZENICA, "225-884"));
        imenik.dodaj("Amir", new MobilniBroj(61, "225-885"));
        imenik.dodaj("Chris", new MedunarodniBroj("+44", "7768878794"));
    }

    @Test
    public void testMockExternal(){
        //mocito setup stage
        Imenik i = Mockito.mock(Imenik.class);
        Mockito.when(i.dajBroj("Dino")).thenReturn("Nema trazenog broja!");

        //mocito test stage
        String trazeno = i.dajBroj("Dino");
        assertEquals(trazeno, "Nema trazenog broja!");
    }

    @Test
    public void testMockInternal(){
        //podesavanje mocita
        Map<String, TelefonskiBroj> mapa = Mockito.mock(Map.class);
        Mockito.when(mapa.get("Amir")).thenReturn(new MobilniBroj(62, "999-999"));
        imenik.setImenik(mapa);

        //testiranje
        String broj = imenik.dajBroj("Amir");
        assertNotEquals(broj, "061/225-885");
        assertEquals(broj, "062/999-999");
    }
}
