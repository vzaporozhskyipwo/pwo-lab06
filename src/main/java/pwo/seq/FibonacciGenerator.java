package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa reprezentująca generator dla ciągu Fibonacciego,
 * dziedzicząca po klasie {@link Generator}.
 *
 * @author Vlad
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor inicjalizujący wartości current, f_1 i f_2.
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0); /**< Inicjalizacja wartości current na 0 */
        f_1 = new BigDecimal(1); /**< Inicjalizacja wartości f_1 na 1 */
        f_2 = new BigDecimal(0); /**< Inicjalizacja wartości f_2 na 0 */
    }

    /**
     * Metoda resetująca generator, ustawiająca wartości current, f_1 i f_2 na początkowe.
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0); /**< Resetowanie wartości current na 0 */
        f_1 = new BigDecimal(1); /**< Resetowanie wartości f_1 na 1 */
        f_2 = new BigDecimal(0); /**< Resetowanie wartości f_2 na 0 */
    }

    /**
     * Metoda generująca kolejny element ciągu Fibonacciego.
     * Jeżeli lastIndex > 1, generuje element na podstawie dwóch poprzednich.
     * W przeciwnym razie ustala wartość na 1, gdy lastIndex == 1, lub na 0, gdy lastIndex == 0.
     *
     * @return Kolejny element ciągu Fibonacciego.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            // Generowanie kolejnego elementu na podstawie dwóch poprzednich
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1); /**< Ustawienie wartości na 1 dla lastIndex == 1 */
        } else {
            current = new BigDecimal(0); /**< Ustawienie wartości na 0 dla lastIndex == 0 */
        }

        lastIndex++;
        return current;
    }
}