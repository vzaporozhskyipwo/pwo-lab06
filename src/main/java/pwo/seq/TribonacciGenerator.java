package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator dla ciągu Tribonacci,
 * dziedzicząca po klasie {@link FibonacciGenerator}.
 *
 * @author Vlad
 * @version 1.0.0
 */

public class TribonacciGenerator extends
        FibonacciGenerator {

    /**
     * Konstruktor inicjalizujący wartość f_3 na 0.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda resetująca generator, ustawiająca f_3 na 0 i wywołująca
     * reset na klasie nadrzędnej.
     */
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
    }

    /**
     * Metoda generująca kolejny element ciągu Tribonacci.
     * Jeżeli lastIndex > 2, generuje element na podstawie trzech poprzednich.
     * W przeciwnym razie ustala wartość na 1, gdy lastIndex == 2, lub na 0, gdy lastIndex < 2.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}