package wordplay;

import java.nio.file.Path;

/**
 * This class is the main class of the application. The application simply
 * prints out names that are also words in Finnish. The names that are also
 * words need to be printed in alphabetical order.
 *
 * The words are read from a text file with the help of the DictionaryReader
 * class implemented on the first part of the exercise. The names are read from
 * CSV files with the help of the NamesReader implemented on the second part of
 * the exercise.
 */
public class App {

    /* Path to the file containing Finnish words. */
    private static Path dictionaryFile = Path.of("data", "kaikkisanat.txt");

    /* Paths to the files containing names. */
    private static Path namesFileLadies = Path.of("data", "etunimitilasto-naiset-ensimmainen.csv");
    private static Path namesFileGentlemen = Path.of("data", "etunimitilasto-miehet-ensimmainen.csv");

    public static void main(String[] args) {
        /*
         * TODO: Implement the application here.
         *
         * Implement the main method so that the application prints out the names
         * that are also words in Finnish. The names that are also words need to be
         * printed in alphabetical order and contain both names of women and men.
         *
         * Your application is not allowed to ask for any input from the user.
         *
         * Note that the same word can be in lowercase in one file and capitalized in
         * the other.
         */
        System.out.println("Hello world!");
    }
}
