package ba.unsa.etf.rpr;

import java.util.Objects;

/**
 * klasa koja predstavlja medunarodni broj
 */
public class MedunarodniBroj extends TelefonskiBroj{

    private String medunarodniBroj; //cuva string medunarodnog broja

    /**
     * konstrukor klase MedunarodniBroj
     * @param drzava kompletan pozivni broj drzave
     * @param broj
     */
    public MedunarodniBroj(String drzava, String broj){
        this.medunarodniBroj = new StringBuilder().append("(").append(drzava).append(")").append(broj).toString();
    }

    /**
     * vraca string medunarodnog broja spreman za ispis
     * @return string medunarodnog broja
     */
    public String ispisi() {
        return medunarodniBroj;
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
        MedunarodniBroj that = (MedunarodniBroj) o;
        return Objects.equals(medunarodniBroj, that.medunarodniBroj);
    }

    /**
     * generisana hashCode metoda
     * @return
     */
    public int hashCode() {
        return Objects.hash(medunarodniBroj);
    }
}
