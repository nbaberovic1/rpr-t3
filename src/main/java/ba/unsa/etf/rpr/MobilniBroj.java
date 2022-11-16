package ba.unsa.etf.rpr;

import java.util.Objects;

/**
 * klasa koja predstavlja mobilni broj
 *
 */
public class MobilniBroj extends TelefonskiBroj{

    private String mobilniBroj; //cuva mobilni broj u obliku xxx/xxx-xxx

    /**
     * konstruktor klase MobilniBroj, prima dva parametra
     * @param mobilnaMreza - predstavlja drugu i trecu cifru pozivnog broja
     * @param broj - mobilni broj u obliku xxx-xxx
     */
    public MobilniBroj(int mobilnaMreza, String broj){
        this.mobilniBroj = new StringBuilder().append("0").append(mobilnaMreza).append("/").append(broj).toString();
    }

    /**
     * daje string mobilnog broja spreman za ispis
     * @return string mobilnog broja u obliku xxx/xxx-xxx
     */
    public String ispisi() {
        return mobilniBroj;
    }

    /**
     * generisana equals metoda
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilniBroj that = (MobilniBroj) o;
        return Objects.equals(mobilniBroj, that.mobilniBroj);
    }

    /**
     * generisana hashCode metoda
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(mobilniBroj);
    }
}
