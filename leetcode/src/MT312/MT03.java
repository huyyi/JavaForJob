package MT312;

import java.util.*;

public class MT03 {
    public static void main(String[] args) {
        Scanner san = new Scanner(System.in);
        int n = san.nextInt();
        int m = san.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = san.nextInt();
            nums[i][1] = san.nextInt();
        }

        System.out.println(process(0, set, nums));

    }

    private static int process(int i, HashSet<Integer> set, int[][] nums) {
        if (i == nums.length) {
            return 0;
        }
        if (set.contains(nums[i][0]) || set.contains(nums[i][1])) {
            return process(i + 1, set, nums);
        } else {
            HashSet<Integer> set1 = new HashSet<>(set);
            int a = process(i + 1, set, nums);
            set1.add(nums[i][0]);
            set1.add(nums[i][1]);
            return Math.max(1 + process(i + 1, set1, nums), a);
        }
    }
}
