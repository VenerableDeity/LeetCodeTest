package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Test112PathSum {
    /*
    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
    这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。叶子节点 是指没有子节点的节点。

    示例 1：
        输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        输出：true
        解释：等于目标和的根节点到叶节点路径如上图所示。

    示例 2：
        输入：root = [1,2,3], targetSum = 5
        输出：false
        解释：树中存在两条根节点到叶子节点的路径：
        (1 --> 2): 和为 3
        (1 --> 3): 和为 4
        不存在 sum = 5 的根节点到叶子节点的路径。

    示例 3：
        输入：root = [], targetSum = 0
        输出：false
        解释：由于树是空的，所以不存在根节点到叶子节点的路径。

    提示：
        树中节点的数目在范围 [0, 5000] 内
        -1000 <= Node.val <= 1000
        -1000 <= targetSum <= 1000
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(11);
        TreeNode root6 = new TreeNode(13);
        TreeNode root7 = new TreeNode(4);
        TreeNode root8 = new TreeNode(7);
        TreeNode root9 = new TreeNode(2);
        TreeNode root11 = new TreeNode(1);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root3.left = root6;
        root3.right = root7;
        root4.left = root8;
        root4.right = root9;
        root7.right = root11;
        System.out.println(hasPathSum(root, 22));

        TreeNode root12 = new TreeNode(1);
        TreeNode root13 = new TreeNode(2);
        TreeNode root14 = new TreeNode(3);
        root12.left = root13;
        root12.right = root14;
        System.out.println(hasPathSum(root12, 5));

        TreeNode root15 = null;
        System.out.println(hasPathSum(root15, 0));
    }

    /**
     * 思路：递归，如果当前节点是叶子节点，判断当前节点的值是否等于目标值；如果当前节点不是叶子节点，递归判断左右子树是否存在路径
     * @param root
     * @param targetSum
     * @return
     */
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) return false;
//        if (root.left == null && root.right == null) {
//            return root.val == targetSum;
//        } else {
//            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
//        }
//    }

    /**
     * 思路：层序遍历，遍历过程中记录从根节点到当前节点的路径和，如果当前节点是叶子节点，判断路径和是否等于目标值
     * 要点：需要两个队列，一个队列存储节点，一个队列存储路径和
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
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
