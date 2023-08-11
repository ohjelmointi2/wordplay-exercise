package wordplay;

import java.util.List;

public class App {

    public static void main(String[] args) {

        DictionaryReader dictReader = new DictionaryReader();
        List<String> words = dictReader.readWords("kaikkisanat.txt");

        System.out.println("The first word in the file is " + words.get(0));
        System.out.println("The last word in the file is " + words.get(words.size() - 1));

        // TODO: use NamesReader to read two name files into Java lists.
        // Then print out those names that also exist in the `words` list.
    }
}
