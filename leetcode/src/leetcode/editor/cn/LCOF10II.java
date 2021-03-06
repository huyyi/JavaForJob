package leetcode.editor.cn;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 215 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF10II{
  public static void main(String[] args) {
       Solution solution = new LCOF10II().new Solution();
       int[] test = new int[]{};
       System.out.println(solution.numWays(0));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // dp[i] = dp[i - 1] + dp[i - 2]
    public int numWays(int n) {
        int[] prev = new int[]{1, 1};

        if (n < 2) {
            return prev[n];
        }

        for (int i = 2; i <= n; i ++) {
            int val = (prev[0] + prev[1]) % 1000000007;
            prev[0] = prev[1];
            prev[1] = val;
        }
        return prev[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}