package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test189RotateArray {
    /*
    给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

    示例 1:
        输入: nums = [1,2,3,4,5,6,7], k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右轮转 1 步: [7,1,2,3,4,5,6]
        向右轮转 2 步: [6,7,1,2,3,4,5]
        向右轮转 3 步: [5,6,7,1,2,3,4]

    示例 2:
        输入：nums = [-1,-100,3,99], k = 2
        输出：[3,99,-1,-100]
        解释:
        向右轮转 1 步: [99,-1,-100,3]
        向右轮转 2 步: [3,99,-1,-100]

    提示：
        1 <= nums.length <= 10^5
        -2^31 <= nums[i] <= 2^31 - 1
        0 <= k <= 10^5

    进阶：
        尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
        你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 3);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(',');
        }

        System.out.println();

        nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(',');
        }
    }

    // 方法一：使用额外数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        int pNums = 0;
        k %= n;
        for (int i = k; i < n; i++) {
            arr[i] = nums[pNums++];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = nums[pNums++];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }

    // 方法二：分治
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}
