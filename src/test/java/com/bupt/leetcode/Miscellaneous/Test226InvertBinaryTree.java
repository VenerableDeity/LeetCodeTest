package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test226InvertBinaryTree {
    /*
    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

    示例 1：
        输入：root = [4,2,7,1,3,6,9]
        输出：[4,7,2,9,6,3,1]

    示例 2：
        输入：root = [2,1,3]
        输出：[2,3,1]

    示例 3：
        输入：root = []
        输出：[]

    提示：
        树中节点数目范围在 [0, 100] 内
        -100 <= Node.val <= 100
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(9);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        TreeNode res = invertTree(root);
        leverOrder(res);

        System.out.println();

        TreeNode root8 = new TreeNode(2);
        TreeNode root9 = new TreeNode(1);
        TreeNode root10 = new TreeNode(3);
        root8.left = root9;
        root8.right = root10;
        TreeNode res2 = invertTree(root8);
        leverOrder(res2);

        System.out.println();

        TreeNode root11 = null;
        TreeNode res3 = invertTree(root11);
        leverOrder(res3);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;

        // invert(root);
        // return root;
    }

    public void invert(TreeNode root) {
        if (root == null) return;
        else {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        invertTree(root.left);
        invertTree(root.right);
    }

    public void leverOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
