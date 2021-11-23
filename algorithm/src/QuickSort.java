import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 1, 2, 4, 4, 7, 8, 4};
        quickSortTemplate(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot);
        quickSort(nums, pivot + 1, r);
    }

    public static int partition(int [] nums, int l, int r) {
        int pivot = nums[r - 1];

        int le = l - 1;  // 指向比主元小的最后一个元素

        for (int i = l; i < r - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, ++le, i);
            }
        }
        swap(nums, ++le, r - 1);  // 主元放到正确的位置
        return le;
    }

    // 交换数组中两个位置上的数
    public static void swap(int[] nums, int pos1, int pos2) {
        assert pos1 >= 0 && pos1 < nums.length && pos2 >= 0 && pos2 < nums.length;
        if (nums[pos1] == nums[pos2]) {  // 一定要处理相等元素
            return;
        }
        nums[pos1] = nums[pos1] ^ nums[pos2];
        nums[pos2] = nums[pos1] ^ nums[pos2];
        nums[pos1] = nums[pos1] ^ nums[pos2];
    }

    public static void quickSortTemplate(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int less = l - 1;
        int greater = r + 1;
        int x = nums[l + r >> 1];

        while (less < greater) {
            do less ++; while (nums[less] < x);
            do greater --; while (nums[greater] > x);
            if (less < greater) swap(nums, less, greater);
        }
        quickSortTemplate(nums, l, greater);
        quickSortTemplate(nums, greater + 1, r);
    }
}
