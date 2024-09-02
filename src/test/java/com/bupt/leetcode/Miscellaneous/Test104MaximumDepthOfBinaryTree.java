package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Test104MaximumDepthOfBinaryTree {
    /*
    给定一个二叉树 root ，返回其最大深度。二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。

    示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：3

    示例 2：
        输入：root = [1,null,2]
        输出：2

    提示：
        树中节点的数量在 [0, 10^4] 区间内。
        -100 <= Node.val <= 100
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        System.out.println(maxDepth(root));

        TreeNode root6 = new TreeNode(1);
        TreeNode root7 = new TreeNode(2);
        root6.right = root7;
        System.out.println(maxDepth(root6));
    }

    /**
     * 思路：层序遍历，每遍历完一层，count++
     * 要点：添加一个标记节点，每遍历完一层，count++，并且在队列不为空的情况下，再次添加标记节点
     * @param root
     * @return
     */
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int count = 0;
//        TreeNode tmp = new TreeNode();
//        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        queue.offer(tmp);
//        while (!queue.isEmpty()) {
//            TreeNode p = queue.poll();
//            if (p != tmp && p.left != null) {
//                queue.offer(p.left);
//            }
//            if (p != tmp && p.right != null) {
//                queue.offer(p.right);
//            }
//            if (p == tmp) {
//                count++;
//                if (!queue.isEmpty()) {
//                    queue.offer(tmp);
//                }
//            }
//        }
//        return count;
//    }

    /**
     * 思路：递归，即树的深度等于左右子树的最大深度+1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
