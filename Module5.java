import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Module5 {

    public static void main(String[] args) {
        Set<String> sortedWords = new TreeSet<>();

        Map<String, Integer> wordCountMap = new HashMap<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", ""); 
                if (!word.isEmpty()) {
                    sortedWords.add(word);  
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            scanner.close();

            System.out.println("words in ASCENDING order:");
            for (String word : sortedWords) {
                System.out.println(word);
            }

            System.out.println("\n words in DESCENDING order:");
            List<String> reversed = new ArrayList<>(sortedWords);
            Collections.reverse(reversed);  
            for (String word : reversed) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: collection_of_words.txt");
        }
    }
}
