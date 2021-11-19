package leetcode.editor.cn;

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 447 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF11{
  public static void main(String[] args) {
       Solution solution = new LCOF11().new Solution();
       int[] test = new int[]{};
       System.out.println(solution.minArray(test));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r --;
            }
        }
        return numbers[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}