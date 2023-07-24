import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {
    private Map<String, Integer> wordFrequency;
    private String inputText;

    public WordCounter() {
        wordFrequency = new HashMap<>();
        inputText = "";
    }

    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number '1' to input text manually or number '2' to provide a file path:");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()

        switch (option) {
            case 1:
                System.out.println("Enter the whole text for counting the words:");
                inputText = scanner.nextLine();
                break;

            case 2:
                System.out.println("Enter the file path for which you want to count the word-count:");
                String filePath = scanner.nextLine();
                try {
                    inputText = readFile(filePath);
                } catch (IOException e) {
                    System.out.println("There is some error reading the file: " + e.getMessage());
                    System.exit(1);
                }
                break;

            default:
                System.out.println("You have chose an invalid option. Exiting.");
                System.exit(1);
        }

        scanner.close();
    }

    private String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public void countWords() {
        if (inputText.isEmpty()) {
            System.out.println("No input text is found. Exiting.");
            System.exit(1);
        }

        String[] words = inputText.split("\\s+|\\p{Punct}+");
        int totalWords = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                totalWords++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total words: " + totalWords);
    }

    public void displayWordFrequency() {
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        wordCounter.readInput();
        wordCounter.countWords();
        wordCounter.displayWordFrequency();
    }
}
