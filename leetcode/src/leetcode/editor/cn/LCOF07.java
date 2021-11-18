package leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 618 👎 0


import java.util.*;
import leetcode.common.*;

public class LCOF07{
  public static void main(String[] args) {
       Solution solution = new LCOF07().new Solution();
       int[] test = new int[]{};
       int[] test1 = new int[]{};
       System.out.println(solution.buildTree(test, test1));
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    // 左闭右开
    private static TreeNode build(int[] preorder, int[] inorder, int lpre, int rpre, int lin, int rin) {
        if (lpre >= rpre || lin >= rin) {
            return null;
        }

        int root = 0;
        for (int i = lin; i < rin; i++) {
            if (inorder[i] == preorder[lpre]) {
                root = i;
            }
        }
        // 左子树节点数
        int nodeLeft = root - lin;

        TreeNode node = new TreeNode(preorder[lpre]);
        node.left = build(preorder, inorder, lpre + 1, lpre + nodeLeft + 1, lin, root);
        node.right = build(preorder, inorder, lpre + nodeLeft + 1, rpre, root + 1, rin);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}