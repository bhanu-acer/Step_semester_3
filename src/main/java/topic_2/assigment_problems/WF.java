import java.util.*;

public class WF {
    static void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = feedback.split("\\s+");
        String[] ignored = {"the", "was", "and", "a", "is", "of", "in"};
        String[] unique = new String[words.length];
        int[] counts = new int[words.length];
        int size = 0;

        for (String word : words) {
            boolean skip = word.isEmpty();
            for (String item : ignored) {
                if (word.equals(item)) {
                    skip = true;
                    break;
                }
            }
            if (!skip) {
                int index = -1;
                for (int i = 0; i < size; i++) {
                    if (unique[i].equals(word)) {
                        index = i;
                        break;
                    }
                }
                if (index == -1) {
                    unique[size] = word;
                    counts[size] = 1;
                    size++;
                } else {
                    counts[index]++;
                }
            }
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (counts[j] > counts[i]) {
                    int tempCount = counts[i];
                    counts[i] = counts[j];
                    counts[j] = tempCount;
                    String tempWord = unique[i];
                    unique[i] = unique[j];
                    unique[j] = tempWord;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.println(unique[i] + ": " + counts[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
        sc.close();
    }
}
