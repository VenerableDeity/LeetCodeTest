package com.bupt.leetcode.Miscellaneous;


import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Test637AverageOfLevelsInBinaryTree {
    /*
    给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10^-5 以内的答案可以被接受。

    示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：[3.00000,14.50000,11.00000]
        解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
        因此返回 [3, 14.5, 11] 。

    示例 2:
        输入：root = [3,9,20,15,7]
        输出：[3.00000,14.50000,11.00000]

    提示：
        树中节点数量在 [1, 10^4] 范围内
        -2^31 <= Node.val <= 2^31 - 1
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
        System.out.println(averageOfLevels(root));

        TreeNode root6 = new TreeNode(3);
        TreeNode root7 = new TreeNode(9);
        TreeNode root8 = new TreeNode(20);
        TreeNode root9 = new TreeNode(15);
        TreeNode root10 = new TreeNode(7);
        root6.left = root7;
        root6.right = root8;
        root8.left = root9;
        root8.right = root10;
        System.out.println(averageOfLevels(root6));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            int i = size;
            while (i-- > 0) {
                TreeNode tmp = queue.poll();
                sum += tmp.val;
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            res.addLast(sum / size);
        }
        return res;
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
