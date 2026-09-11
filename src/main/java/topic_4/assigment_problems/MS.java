import java.util.*;

public class MS {

    static int maxSubArray(int[] nums) {

        int current = nums[0];
        int maximum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            current = Math.max(nums[i], current + nums[i]);

            maximum = Math.max(maximum, current);
        }

        return maximum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));

        sc.close();
    }
}
