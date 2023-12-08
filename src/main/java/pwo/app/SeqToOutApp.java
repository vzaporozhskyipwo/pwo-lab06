package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa reprezentująca aplikację SeqToOutApp,
 * dziedzicząca po klasie {@link SeqToFileApp}.
 * Odpowiada za generowanie ciągu i wyświetlanie go w terminalu.
 *
 * @author Vlad
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Metoda rozszerzająca funkcjonalność z klasy nadrzędnej w celu sprawdzenia
     * poprawności argumentów.
     * Argumenty są poprawne, jeżeli są poprawne w klasie nadrzędnej
     * i seqType nie jest nullem, a from i to są nieujemne.
     *
     * @param args Argumenty wejściowe.
     * @return True, jeżeli argumenty są poprawne; false w przeciwnym razie.
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) return true;

        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda rozszerzająca funkcjonalność z klasy nadrzędnej w celu wygenerowania
     * ciągu i wyświetlenia go w terminalu.
     *
     * @return Zawsze true, ponieważ metoda zawsze wykonuje się pomyślnie.
     */
    @Override
    protected boolean wirteSeq() {
        // Wyświetlenie wygenerowanego ciągu w terminalu
        System.out.println(SequenceTools.getTermsAsColumn(seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Metoda uruchamiająca aplikację SeqToOutApp, wyświetlającą ciąg w terminalu.
     *
     * @param args Argumenty wejściowe.
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");

        // Sprawdzenie i obsługa argumentów
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        // Wygenerowanie i wyświetlenie ciągu
        wirteSeq();
    }
}