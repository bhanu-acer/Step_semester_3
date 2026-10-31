import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);

        System.out.println(Arrays.toString(marks1));
        System.out.println("Swaps = " + swaps1);

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);

        System.out.println(Arrays.toString(marks2));
        System.out.println("Swaps = " + swaps2);

        int[] marks3 = {30, 85, 20, 95};
        int swaps3 = prizeTable(marks3);

        System.out.println(Arrays.toString(marks3));
        System.out.println("Swaps = " + swaps3);
    }
}