package ba.unsa.etf.rpr;

/**
 * izuzetak BrojException naslijeden iz RuntimeException
 */
public class BrojException extends RuntimeException{
    /**
     * komstruktor izuzetka klase BrojException
     * @param msg poruka za detaljniji opis razloga bacanja izuzetka
     */
    public BrojException(String msg){
        super(msg);
    }
}
