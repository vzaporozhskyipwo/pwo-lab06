package pwo.app;

/**
 * Klasa reprezentująca aplikację Sequence,
 * uruchamiającą odpowiednią aplikację w zależności od liczby argumentów.
 *
 * @author Vlad
 * @version 1.0.0
 */
public class Sequence {

    /**
     * Metoda główna aplikacji, uruchamiająca odpowiednią aplikację w zależności
     * od liczby argumentów.
     *
     * @param args Argumenty wejściowe.
     */
    public static void main(String[] args) {

        switch (args.length) {
            case 3:
                // Uruchomienie aplikacji SeqToOutApp dla trzech argumentów
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                // Uruchomienie aplikacji SeqToFileApp dla czterech argumentów
                (new SeqToFileApp()).run(args);
                break;
            default:
                // Wyświetlenie komunikatu w przypadku niepoprawnej liczby argumentów
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}