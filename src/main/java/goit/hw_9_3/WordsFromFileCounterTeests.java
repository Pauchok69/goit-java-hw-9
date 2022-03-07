package goit.hw_9_3;

public class WordsFromFileCounterTeests {
    public static final String FILE_WITH_WORDS = "./src/main/java/goit/hw_9_3/words.txt";

    public static void main(String[] args) {
        new WordsFromFileCounter().countWordsIn(FILE_WITH_WORDS);
    }
}
