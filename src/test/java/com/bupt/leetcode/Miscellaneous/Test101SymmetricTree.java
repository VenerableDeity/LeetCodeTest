package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test101SymmetricTree {
    /*
    给你一个二叉树的根节点 root ， 检查它是否轴对称。

    示例 1：
        输入：root = [1,2,2,3,4,4,3]
        输出：true

    示例 2：
        输入：root = [1,2,2,null,3,null,3]
        输出：false

    提示：
        树中节点数目在范围 [1, 1000] 内
        -100 <= Node.val <= 100

    进阶：你可以运用递归和迭代两种方法解决这个问题吗？
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(3);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        System.out.println(isSymmetric(root));

        TreeNode root8 = new TreeNode(1);
        TreeNode root9 = new TreeNode(2);
        TreeNode root10 = new TreeNode(2);
        TreeNode root11 = new TreeNode(3);
        TreeNode root12 = new TreeNode(3);
        root8.left = root9;
        root8.right = root10;
        root9.right = root11;
        root10.right = root12;
        System.out.println(isSymmetric(root8));
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 思路：递归，判断左右子树是否对称
     * @param p
     * @param q
     * @return
     */
//    public boolean check(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//    }

    /**
     * 思路：迭代，使用队列，每次取出两个节点进行比较，然后将左右子树的左右节点按照相反的顺序加入队列
     * @param u
     * @param v
     * @return
     */
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
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
