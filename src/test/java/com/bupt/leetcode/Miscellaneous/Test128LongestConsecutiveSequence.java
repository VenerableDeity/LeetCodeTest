package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test128LongestConsecutiveSequence {
    /*
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

    示例 1：
        输入：nums = [100,4,200,1,3,2]
        输出：4
        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

    示例 2：
        输入：nums = [0,3,7,2,5,8,4,6,0,1]
        输出：9

    提示：
        0 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
     */
    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2));
    }

    /**
     * 思路：先排序，然后遍历数组，找到连续的数字，记录最大长度
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                res = Math.max(res, count);
                count = 1;
            }
        }
        return Math.max(res, count);
    }
}
