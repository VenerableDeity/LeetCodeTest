package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Test222CountCompleteTreeNodes {
    /*
    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^h 个节点。

    示例 1：
        输入：root = [1,2,3,4,5,6]
        输出：6

    示例 2：
        输入：root = []
        输出：0

    示例 3：
        输入：root = [1]
        输出：1

    提示：
        树中节点的数目范围是[0, 5 * 10^4]
        0 <= Node.val <= 5 * 10^4
        题目数据保证输入的树是 完全二叉树

    进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(countNodes(root));

        TreeNode root2 = null;
        System.out.println(countNodes(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(countNodes(root3));
    }

    /**
     * 思路：层序遍历，统计节点个数
     * @param root
     * @return
     */
//    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        int count = 0;
//        while (!queue.isEmpty()) {
//            TreeNode p = queue.poll();
//            count++;
//            if (p.left != null) queue.offer(p.left);
//            if (p.right != null) queue.offer(p.right);
//        }
//        return count;
//    }

    /**
     * 思路：利用完全二叉树的性质，如果左子树的高度等于右子树的高度，说明左子树是满二叉树，否则右子树是满二叉树
     *      如果左子树是满二叉树，那么左子树的节点个数为2^h - 1，加上根节点，总节点个数为2^h
     *      如果右子树是满二叉树，那么右子树的节点个数为2^(h-1) - 1，加上根节点，总节点个数为2^(h-1)
     *      递归计算左右子树的节点个数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
