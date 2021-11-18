package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1631 👎 0


import java.util.*;
import leetcode.common.*;

public class LargestRectangleInHistogram84{
  public static void main(String[] args) {
       Solution solution = new LargestRectangleInHistogram84().new Solution();
       int[] test = new int[]{2,4};
       System.out.println(solution.largestRectangleArea(test));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 递减栈
    public int largestRectangleArea(int[] heights) {
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        int res = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < heights.length; i++) {
            // 递增栈，新来的元素比栈顶元素更小时要弹栈

            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int w = i - st.peek() - 1;
                res = Math.max(res, w * h);
            }
            st.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}