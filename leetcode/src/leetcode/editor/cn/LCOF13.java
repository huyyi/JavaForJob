package leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 👍 383 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF13{
  public static void main(String[] args) {
       Solution solution = new LCOF13().new Solution();
       int[] test = new int[]{};
       System.out.println(solution.movingCount(14, 14, 5));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      // 每移动一步，各位和最多+1（不为9，+1，为9，至少-8）
      // (x,y)可达的条件是上或左可达且各位和满足条件
      // 只依赖上左，可一维DP
    public int movingCount(int m, int n, int k) {
        boolean[] dp = new boolean[n];
        int res = 1;
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] && isValid(0, i, k);
            if (dp[i]) res ++;
        }

        for (int i = 1; i < m; i++) {
            boolean allFalse = true;
            dp[0] = dp[0] && isValid(i, 0, k);
            if (dp[0]) {
                res ++;
                allFalse = false;
            }
            for (int j = 1; j < n; j++) {
                dp[j] = (dp[j] || dp[j - 1]) && isValid(i, j, k);
                if (dp[j]) {
                    res ++;
                    allFalse = false;
                }
            }
            if (allFalse) {
                break;
            }
        }
        return res;
    }

    static boolean isValid(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}