package ba.unsa.etf.rpr;

abstract class TelefonskiBroj {
    public abstract String ispisi(); //vraća broj u tekstualnoj formi pogodnoj za ispis
    @Override
    public abstract int hashCode(); //vraća hash code
}