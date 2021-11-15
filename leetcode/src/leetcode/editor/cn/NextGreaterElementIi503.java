package leetcode.editor.cn;

//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 数组 单调栈 👍 513 👎 0


import java.util.*;
import leetcode.common.*;

public class NextGreaterElementIi503{
  public static void main(String[] args) {
       Solution solution = new NextGreaterElementIi503().new Solution();
       int[] test = new int[]{1, 2, 1};
       int[] res = solution.nextGreaterElements(test);
       System.out.println(Arrays.toString(res));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);

        for (int i = 0; i < nums.length * 2; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i % nums.length]) {
                res[st.peek()] = nums[i % nums.length];
                st.pop();
            }
            st.push(i % nums.length);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}