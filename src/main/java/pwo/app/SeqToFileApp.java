package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;

import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Klasa reprezentująca aplikację SeqToFileApp, zapisującą ciąg do pliku.
 *
 * @author Vlad
 * @version 1.0.0
 */
class SeqToFileApp {

    /**
     * Typ ciągu.
     */
    protected SeqType seqType = null;

    /**
     * Zakres generowanych elementów ciągu.
     */
    protected Integer from = null, to = null;

    /**
     * Nazwa pliku, do którego zapisywany jest ciąg.
     */
    protected String fileName = null;

    /**
     * Metoda pobierająca argumenty wejściowe i sprawdzająca ich poprawność.
     * Sprawdza poprawność typu ciągu, zakresu oraz nazwy pliku.
     *
     * @param args Argumenty wejściowe.
     * @return True, jeżeli argumenty są poprawne; false w przeciwnym razie.
     */
    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            return false;
        }

        try {
            // Sprawdzenie poprawności ścieżki pliku
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        // Sprawdzenie, czy seqType nie jest nullem, a from i to są nieujemne
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Metoda zapisująca ciąg do pliku.
     * Wykorzystuje narzędzia SequenceTools do zapisu ciągu.
     *
     * @return True, jeżeli zapis się powiódł; false w przeciwnym razie.
     */
    protected boolean wirteSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(), from, to, fileName);
    }

    /**
     * Metoda uruchamiająca aplikację SeqToFileApp, zapisującą ciąg do pliku.
     *
     * @param args Argumenty wejściowe.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        // Sprawdzenie i obsługa argumentów
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to fileName");
            return;
        }

        // Sprawdzenie i obsługa zapisu ciągu do pliku
        if (!wirteSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}