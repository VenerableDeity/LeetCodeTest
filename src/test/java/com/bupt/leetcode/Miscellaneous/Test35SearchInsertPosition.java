package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test35SearchInsertPosition {
    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。

    示例 1:
        输入: nums = [1,3,5,6], target = 5
        输出: 2
    示例 2:
        输入: nums = [1,3,5,6], target = 2
        输出: 1
    示例 3:
        输入: nums = [1,3,5,6], target = 7
        输出: 4
    示例 4:
        输入: nums = [1,3,5,6], target = 0
        输出: 0

    提示:
        1 <= nums.length <= 10^4
        -10^4 <= nums[i] <= 10^4
        nums 为 无重复元素 的 升序 排列数组
        -10^4 <= target <= 10^4
     */
    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
        // O(n)
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] >= target) return i;
        // }
        // return n;

        // 二分查找 O(log n)
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        mid = (left + right) / 2;
        if (nums[mid] < target) return mid + 1;
        else return mid;
    }
}
