package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test530MinimumAbsoluteDifferenceInBST {
    /*
    给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
    差值是一个正数，其数值等于两值之差的绝对值。

    示例 1：
        输入：root = [4,2,6,1,3]
        输出：1

    示例 2：
        输入：root = [1,0,48,null,null,12,49]
        输出：1

    提示：
        树中节点的数目范围是 [2, 10^4]
        0 <= Node.val <= 10^5

    注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(getMinimumDifference(root));

        TreeNode root2 = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));
        System.out.println(getMinimumDifference(root2));
    }

    public int getMinimumDifference(TreeNode root) {
        //
        // if (root == null) return 0;
        // List<Integer> resList = new ArrayList<>();
        // Deque<TreeNode> queue = new ArrayDeque<>();
        // queue.offer(root);
        // while (!queue.isEmpty()) {
        //     TreeNode t = queue.poll();
        //     resList.add(t.val);
        //     if (t.left != null) queue.offer(t.left);
        //     if (t.right != null) queue.offer(t.right);
        // }
        // if (resList.size() == 1) return 0;
        // resList.sort((x, y) -> x - y);
        // int res = Integer.MAX_VALUE;
        // for (int i = 1; i < resList.size(); i++) {
        //     int tmp = resList.get(i) - resList.get(i - 1);
        //     if (tmp < res) res = tmp;
        // }
        // return res;

        int res = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root, pre = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (pre != null) {
                    int tmp = p.val - pre.val;
                    if (tmp < res) res = tmp;
                }
                pre = p;
                p = p.right;
            }
        }
        return res;
    }
}
