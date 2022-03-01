package leet.soluiton;

import utils.struct.TreeNode;

/**
 * @desc: 翻转二叉树
 * @tag:
 */
public class P226 {

    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.left);
        reverse(root.right);
    }

}
