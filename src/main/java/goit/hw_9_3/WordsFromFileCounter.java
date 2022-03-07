package goit.hw_9_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordsFromFileCounter {
    public void countWordsIn(String filename) {
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File: " + filename + " doesn't exist! Please chose another file.");

            return;
        }
        ArrayList<String> words = getWordsFrom(file);
        Map<String, Integer> wordsWithCounter = countWords(words);

        LinkedHashMap<String, Integer> sortedWordsByCount
                = wordsWithCounter.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        )
                );

        sortedWordsByCount.forEach((key, val) -> System.out.println(key + " " + val));
    }

    private ArrayList<String> getWordsFrom(File file) {
        ArrayList<String> words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return words;
    }

    private HashMap<String, Integer> countWords(ArrayList<String> words) {
        HashMap<String, Integer> wordsWithCounter = new HashMap<>();
        words.forEach(w -> wordsWithCounter.compute(w, (key, val) -> (val == null) ? 1 : ++val));

        return wordsWithCounter;
    }
}
