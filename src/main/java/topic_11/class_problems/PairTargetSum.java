import java.util.HashSet;

public class PairTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            int required = target - num;

            if (set.contains(required)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};

        System.out.println(hasPairWithSum(nums1, 9));
        System.out.println(hasPairWithSum(nums2, 20));
    }
}