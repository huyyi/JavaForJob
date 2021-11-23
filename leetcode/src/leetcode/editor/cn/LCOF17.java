package leetcode.editor.cn;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 👍 162 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF17{
  public static void main(String[] args) {
       Solution solution = new LCOF17().new Solution();
       int[] test = new int[]{};
       SolutionOfBigNums.printNumbers(2);
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public int[] printNumbers(int n) {
          int end = (int)Math.pow(10, n) - 1;
          int[] res = new int[end];
          for(int i = 0; i < end; i++)
              res[i] = i + 1;
          return res;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)
  class SolutionOfBigNums{
      public static void printNumbers(int n) {
          String a = "1";
          for (int i = 0; i < n; i++) {
              StringBuilder builder = new StringBuilder();
              a += '0';
              builder.append(i);
              process(1, n, builder);
          }

      }

      public static void process(int k, int n, StringBuilder builder) {
          System.out.println(builder.toString());
          if (k == n) {
              return;
          }
          for (int i = 0; i < 10; i++) {
              if (builder.isEmpty() && i == 0) {
                  continue;
              }
              builder.append(i);
              process(k + 1, n, builder);
              builder.deleteCharAt(builder.length() - 1);
          }
      }
}
  
}