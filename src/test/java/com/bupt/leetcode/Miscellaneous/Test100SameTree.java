package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test100SameTree {
    /*
    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

    示例 1：
        输入：p = [1,2,3], q = [1,2,3]
        输出：true

    示例 2：
        输入：p = [1,2], q = [1,null,2]
        输出：false

    示例 3：
        输入：p = [1,2,1], q = [1,1,2]
        输出：false

    提示：
        两棵树上的节点数目都在范围 [0, 100] 内
        -10^4 <= Node.val <= 10^4
     */
    @Test
    public void test() {
        TreeNode p = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p.left = p2;
        p.right = p3;
        TreeNode q = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        q.left = q2;
        q.right = q3;
        System.out.println(isSameTree(p, q));

        TreeNode p4 = new TreeNode(1);
        TreeNode p5 = new TreeNode(2);
        p4.left = p5;
        TreeNode q4 = new TreeNode(1);
        TreeNode q5 = new TreeNode(2);
        q4.right = q5;
        System.out.println(isSameTree(p4, q4));

        TreeNode p6 = new TreeNode(1);
        TreeNode p7 = new TreeNode(2);
        TreeNode p8 = new TreeNode(1);
        p6.left = p7;
        p6.right = p8;
        TreeNode q6 = new TreeNode(1);
        TreeNode q7 = new TreeNode(1);
        TreeNode q8 = new TreeNode(2);
        q6.left = q7;
        q6.right = q8;
        System.out.println(isSameTree(p6, q6));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null || p != null && q == null) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
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
