import java.util.*;

public class WordCounter {

    static void printFilteredCounts(String text) {
        text = text.toLowerCase();
        text = text.replace(".", "");
        text = text.replace(",", "");

        String[] words = text.split("\\s+");
        String[] ignored = {"the", "was", "and", "a", "is", "of", "in"};
        TreeMap<String, Integer> counts = new TreeMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean skip = false;

            for (int j = 0; j < ignored.length; j++) {
                if (word.equals(ignored[j])) {
                    skip = true;
                    break;
                }
            }

            if (!skip && !word.isEmpty()) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feedback: ");
        String text = sc.nextLine();
        printFilteredCounts(text);
        sc.close();
    }
}
