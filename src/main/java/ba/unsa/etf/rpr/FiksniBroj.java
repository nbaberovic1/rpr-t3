package ba.unsa.etf.rpr;

import java.util.Map;
import java.util.Objects;

/**
 * klasa koja predstavlja fiksni broj
 */
public class FiksniBroj extends TelefonskiBroj{
    private Grad grad;
    private String fiksniBroj; //String fiksnog broja u formi xxx/xxx-xxx

    /**
     * konstruktor koji kreira objekat FiksniBroj
     * @param grad - glavni grad nekog kantona ili regije u BiH
     * @param broj - fiksni broj bez pozivnog u obliku xxx-xxx
     */
    public FiksniBroj(Grad grad, String broj){
        this.fiksniBroj = grad.getPozivniBroj() + broj;
        this.grad = grad;
    }

    public Grad getGrad(){
        return this.grad;
    }

    /**
     * vraća String fiksnog broja spreman za ispis
     * @return String fiksnog broja u obliku xxx/xxx-xxx
     */
    public  String ispisi(){
        return fiksniBroj;
    }

    //standardna equals metoda generisana intellij-jem
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return Objects.equals(fiksniBroj, that.fiksniBroj);
    }

    /**
     * generisana intellij-jem
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(fiksniBroj);
    }
}
