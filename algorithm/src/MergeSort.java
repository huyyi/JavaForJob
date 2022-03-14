import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for (int m = l, n = 0; m <= r;m ++, n ++) {
            nums[m] = tmp[n];
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 5, 1, 2, 4, 4, 7, 8, 4};
        mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
