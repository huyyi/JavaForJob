package leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 454 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF12{
  public static void main(String[] args) {
       Solution solution = new LCOF12().new Solution();
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
      public boolean exist(char[][] board, String word) {
          int h = board.length, w = board[0].length;
          boolean[][] visited = new boolean[h][w];
          for (int i = 0; i < h; i++) {
              for (int j = 0; j < w; j++) {
                  boolean flag = check(board, visited, i, j, word, 0);
                  if (flag) {
                      return true;
                  }
              }
          }
          return false;
      }

      public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
          if (board[i][j] != s.charAt(k)) {
              return false;
          } else if (k == s.length() - 1) {
              return true;
          }
          visited[i][j] = true;
          int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
          boolean result = false;
          for (int[] dir : directions) {
              int newi = i + dir[0], newj = j + dir[1];
              if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                  if (!visited[newi][newj]) {
                      boolean flag = check(board, visited, newi, newj, s, k + 1);
                      if (flag) {
                          result = true;
                          break;
                      }
                  }
              }
          }
          visited[i][j] = false;
          return result;
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

  
}