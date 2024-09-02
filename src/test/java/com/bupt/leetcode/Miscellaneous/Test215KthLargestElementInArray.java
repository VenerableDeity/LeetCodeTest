package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test215KthLargestElementInArray {
    /*
    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

    示例 1:
        输入: [3,2,1,5,6,4], k = 2
        输出: 5

    示例 2:
        输入: [3,2,3,1,2,4,5,5,6], k = 4
        输出: 4

    实例 3:
        输入: [-1, -1], k = 2
        输出: -1

    提示：
        1 <= k <= nums.length <= 10^5
        -10^4 <= nums[i] <= 10^4
     */
    @Test
    public void test() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4));

        int[] nums3 = {-1, -1};
        System.out.println(findKthLargest(nums3, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().sorted((o1, o2) -> o2 - o1).mapToInt(Integer::intValue).toArray();
        return nums[k - 1];
    }
}
