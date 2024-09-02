package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test108ConvertSortedArrayToBinarySearchTree {
    /*
    给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。

    示例 1：
        输入：nums = [-10,-3,0,5,9]
        输出：[0,-3,9,-10,null,5]
        解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

    示例 2：
        输入：nums = [1,3]
        输出：[3,1]
        解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

    提示：
        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums 按 严格递增 顺序排列
     */
    @Test
    public void test() {
        InOrder(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        System.out.println();
        InOrder(sortedArrayToBST(new int[]{1, 3}));
    }

    /**
     * 思路：递归 + 二分法
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return node;
    }

    public void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val + " ");
        InOrder(root.right);
    }
}
