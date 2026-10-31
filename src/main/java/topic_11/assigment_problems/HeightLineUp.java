import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        int pass = 1;

        while (true) {
            boolean swapped = false;

            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;

                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 5, 1};

        lineUp(heights);

        int[] heights2 = {1, 3, 2, 4};

        lineUp(heights2);
    }
}