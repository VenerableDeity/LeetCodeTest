package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Test129SumRootToLeafNumbers {
    /*
    给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
    每条从根节点到叶节点的路径都代表一个数字：例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
    计算从根节点到叶节点生成的 所有数字之和 。
    叶节点 是指没有子节点的节点。

    示例 1：
        输入：root = [1,2,3]
        输出：25
        解释：
        从根到叶子节点路径 1->2 代表数字 12
        从根到叶子节点路径 1->3 代表数字 13
        因此，数字总和 = 12 + 13 = 25

    示例 2：
        输入：root = [4,9,0,5,1]
        输出：1026
        解释：
        从根到叶子节点路径 4->9->5 代表数字 495
        从根到叶子节点路径 4->9->1 代表数字 491
        从根到叶子节点路径 4->0 代表数字 40
        因此，数字总和 = 495 + 491 + 40 = 1026

    提示：
        树中节点的数目在范围 [1, 1000] 内
        0 <= Node.val <= 9
        树的深度不超过 10
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(sumNumbers(root));

        TreeNode root2 = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0));
        System.out.println(sumNumbers(root2));
    }

    public int sumNumbers(TreeNode root) {
//        return dfs(root, 0);
        return bfs(root);
    }

    /**
     * 深度优先搜索: 递归
     * @param root
     * @param prevSum
     * @return
     */
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    /**
     * 广度优先搜索: 队列
     * @param root
     * @return
     */
    public int bfs(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {  // 叶子节点，计算路径和
                sum += num;
            } else {  // 非叶子节点，继续放入队列
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
