package leet.soluiton;

import utils.Tool;
import utils.struct.TreeNode;

/**
 * @desc:
 * @tag: dfs
 */
public class P543 {
    public static void main(String[] args) {
        P543 p = new P543();
        int ans = p.diameterOfBinaryTree(Tool.createTreeByLevel(new Integer[]{1, 2, 3, 4, 5, null, null}));
        System.out.println(ans);
    }


    int ans = 0;  // 节点数

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans-1;  // 长度 = 节点数-1
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = dfs(node.left);
        int r = dfs(node.right);
        ans = Math.max(ans, l+r+1);
        return Math.max(l, r) + 1;  // 返回的时到达最深所经过的节点数
    }
}
