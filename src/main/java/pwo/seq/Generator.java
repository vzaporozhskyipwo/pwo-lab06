package pwo.seq;

import java.math.BigDecimal;

import pwo.utils.SequenceGenerator;

/**
 * Abstrakcyjna klasa Generator implementująca interfejs {@link SequenceGenerator}
 * Posiada podstawowe metody do generowania ciągów.
 *
 * @author Vlad
 * @version 1.0.0
 */
abstract class Generator implements SequenceGenerator {

    /**
     * Indeks ostatniego wygenerowanego elementu ciągu.
     */
    protected int lastIndex = 0;

    /**
     * Obecny element ciągu.
     */
    protected BigDecimal current = null;

    /**
     * Trzy poprzednie elementy ciągu (f_1, f_2, f_3).
     */
    protected BigDecimal
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Resetuje indeks ostatniego wygenerowanego elementu ciągu.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Pobiera wartość elementu o indeksie i.
     * Jeżeli i < 0, zgłasza błąd. Jeżeli i < lastIndex, resetuje generator.
     * Generuje elementy do momentu osiągnięcia indeksu i.
     *
     * @param i Indeks elementu ciągu.
     * @return Wartość elementu o indeksie i.
     * @throws IllegalArgumentException jeżeli i < 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) throw new IllegalArgumentException(); /**< Rzuca wyjątek, jeżeli i < 0 */
        if (i < lastIndex) reset(); /**< Resetuje generator, jeżeli i < lastIndex */
        while (lastIndex <= i) nextTerm(); /**< Generuje elementy do momentu osiągnięcia indeksu i */
        return current; /**< Zwraca obecny element ciągu */
    }
}