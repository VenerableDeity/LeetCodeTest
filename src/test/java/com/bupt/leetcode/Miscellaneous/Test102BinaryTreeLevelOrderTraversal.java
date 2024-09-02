package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test102BinaryTreeLevelOrderTraversal {
    /*
    给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

    示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：[[3],[9,20],[15,7]]

    示例 2：
        输入：root = [1]
        输出：[[1]]

    示例 3：
        输入：root = []
        输出：[]

    提示：
    树中节点数目在范围 [0, 2000] 内
    -1000 <= Node.val <= 1000
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(root));

        TreeNode root2 = new TreeNode(1);
        System.out.println(levelOrder(root2));

        TreeNode root3 = null;
        System.out.println(levelOrder(root3));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        int count = 0;
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode sentinel = new TreeNode();
        queue.offer(root);
        queue.offer(sentinel);
        res.add(count, new ArrayList<>());
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t != sentinel) {
                List<Integer> l = res.get(count);
                l.add(t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
            } else {
                count++;
                if (!queue.isEmpty()) {
                    res.add(count, new ArrayList<Integer>());
                    queue.offer(sentinel);
                }
            }
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
