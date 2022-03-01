package leet.soluiton;

import utils.struct.TreeNode;

/**
 * @desc: 对称二叉树
 * @tag: dfs
 */
public class P101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSym(left.right, right.left) && isSym(left.left, right.right);

    }
}
