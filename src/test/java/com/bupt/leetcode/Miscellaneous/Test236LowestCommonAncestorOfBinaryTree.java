package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test236LowestCommonAncestorOfBinaryTree {
    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

    示例 1：
        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出：3
        解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

    示例 2：
        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出：5
        解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

    示例 3：
        输入：root = [1,2], p = 1, q = 2
        输出：1

    提示：
        树中节点数目在范围 [2, 10^5] 内。
        -10^9 <= Node.val <= 10^9
        所有 Node.val 互不相同 。
        p != q
        p 和 q 均存在于给定的二叉树中。
     */

    /**
     * 思路：递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 先看根节点是不是祖先
        if (root == null || root == p || root == q) return root;
        // 2. 如果根节点是祖先，是否有更近的祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);  // 看左子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);  // 看右子树
        // 3. 如果有的话显然只会在一侧 判断
        if (left == null) return right;
        if (right == null) return left;
        // 4. 如果没有更近的，默认还是返回root
        return root;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */