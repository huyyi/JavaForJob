package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2862 👎 0


import java.util.*;
import leetcode.common.*;

public class TrappingRainWater42{
  public static void main(String[] args) {
       Solution solution = new TrappingRainWater42().new Solution();
       int[] test = new int[]{4,2,0,3,2,5};
       System.out.println(solution.trap(test));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> monoStack = new Stack<>();
        monoStack.push(0);


        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[monoStack.peek()]) {
                // 符合单调栈规则
                monoStack.push(i);
            } else if (height[i] == height[monoStack.peek()]) {
                monoStack.pop();
                monoStack.push(i);
            } else {
                while (!monoStack.empty() && height[i] > height[monoStack.peek()]) {
                    int mid = monoStack.pop();
                    if (!monoStack.isEmpty()) {
                        int h = Math.min(height[i], height[monoStack.peek()]) - height[mid];
                        int w = i - monoStack.peek() - 1;
                        res += Math.max(h * w, 0);
                    }
                }
                monoStack.push(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}