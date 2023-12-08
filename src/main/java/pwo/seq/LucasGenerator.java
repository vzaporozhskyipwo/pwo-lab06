package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator dla ciągu Lucasa,
 * dziedzicząca po klasie {@link FibonacciGenerator}.
 *
 * @author Vlad
 * @version 1.0.0
 */

public class LucasGenerator extends FibonacciGenerator {

    /**
     * Konstruktor inicjalizujący wartości current i f_2 na 2.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Metoda resetująca generator, ustawiająca wartości current i f_2 na 2
     * i wywołująca reset na klasie nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    /**
     * Metoda generująca kolejny element ciągu Lucasa.
     * Jeżeli lastIndex == 0, ustawia wartość na 2 i zwraca 2.
     * W przeciwnym razie używa metody nextTerm z klasy nadrzędnej.
     *
     * @return Kolejny element ciągu Lucasa.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
}