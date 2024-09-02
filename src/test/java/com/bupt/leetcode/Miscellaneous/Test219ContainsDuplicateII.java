package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Test219ContainsDuplicateII {
    /*
    给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
    如果存在，返回 true ；否则，返回 false 。

    示例 1：
    输入：nums = [1,2,3,1], k = 3
    输出：true

    示例 2：
    输入：nums = [1,0,1,1], k = 1
    输出：true

    示例 3：
    输入：nums = [1,2,3,1,2,3], k = 2
    输出：false

    提示：
        1 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9
        0 <= k <= 10^5
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2));

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3));
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for (int i = 0; i < nums.length; i++) {
//            int tmp = nums[i];
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if (tmp == nums[j] && Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 思路：滑动窗口 k + 1 的大小，如果窗口中有重复元素，返回true
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {  // add 返回值为false，说明set中已经存在该元素
                return true;
            }
        }
        return false;
    }
}
