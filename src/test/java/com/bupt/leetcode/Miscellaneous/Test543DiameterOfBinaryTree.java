package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test543DiameterOfBinaryTree {
    /*
    给你一棵二叉树的根节点，返回该树的 直径 。
    二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
    两节点之间路径的 长度 由它们之间边数表示。

    示例 1：
        输入：root = [1,2,3,4,5]
        输出：3
        解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。

    示例 2：
        输入：root = [1,2]
        输出：1

    提示：
    树中节点数目在范围 [1, 10^4] 内
    -100 <= Node.val <= 100
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        System.out.println(diameterOfBinaryTree(root));

        ans = 0;

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(diameterOfBinaryTree(root2));
    }

    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1; // 下面 +1 后，对于叶子节点就刚好是 0
        }
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        ans = Math.max(ans, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }
}
