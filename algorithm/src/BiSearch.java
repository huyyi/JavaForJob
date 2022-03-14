import java.util.InputMismatchException;

public class BiSearch {
    public static int biSearch(int[] nums, int l, int r, int target) {
        if (l >= r) return -1;

        int i = l - 1, j = r + 1;
        while (i + 1 != j) {
            int mid = i + j >> 1;

            if (isBlue(nums[mid], target)) i = mid;
            else j = mid;
        }
        return i;   // 根据实际情况选择返回i或者j或者mid
    }

    public static boolean isBlue(int mid, int target){
        return mid < target;  // 最终i指向target左边第一个比target小的数，j是第一个大于等于target的数
    }

    public static void main(String[] args) {
        // 找某个数

    }
}
