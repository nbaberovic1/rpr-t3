package ba.unsa.etf.rpr;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    private String fiksniBroj; //String fiksnog broja u formi xxx/xxx-xxx

    /**
     * enum klasa grad koja sadrzi imena glavnih gradova kantona i regija
     * i njihove pozivne brojeve fiksne telefonije
     */
    public enum Grad { TRAVNIK("030/"), ORAŠJE("031/"), ZENICA("032/"), SARAJEVO("033/"), LIVNO("034/"),
        TUZLA("035/"), MOSTAR("036/"), BIHAĆ("037/"), GORAŽDE("038/"), ŠIROKI_BRIJEG("039/"),
        BRČKO("049/"), MRKONJIĆ_GRAD("050/"), BANJA_LUKA("051/"), PRIJEDOR("052/"), DOBOJ("053/"),
        ŠAMAC("054/"), BIJELJINA("055/"), ZVORNIK("056/"), PALE("057/"), FOČA("058/"), TREBINJE("059/");

        private String pozivniBroj;  //string koji sadrzi pozivni broj u obliku xxx/

        //metoda koja vraća pozivni broj
        public String getPozivniBroj() {
            return pozivniBroj;
        }

        //privatni konstuktor koji inicijalizira privatni atribut pozivniBroj
        private Grad(String pozivniBroj){
            this.pozivniBroj = pozivniBroj;
        }
    }

    /**
     * konstruktor koji kreira objekat FiksniBroj
     * @param grad - glavni grad nekog kantona ili regije u BiH
     * @param broj - fiksni broj bez pozivnog u obliku xxx-xxx
     */
    public FiksniBroj(Grad grad, String broj){
        this.fiksniBroj = grad.getPozivniBroj() + broj;
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
