package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test560SubarraySumEqualsK {
    /*
    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    子数组是数组中元素的连续非空序列。

    示例 1：
        输入：nums = [1,1,1], k = 2
        输出：2
    示例 2：
        输入：nums = [1,2,3], k = 3
        输出：2

    提示：
        1 <= nums.length <= 2 * 10^4
        -1000 <= nums[i] <= 1000
        -10^7 <= k <= 10^7
     */
    @Test
    public void test() {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2));

    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> psCounts = new HashMap<>();    // 统计前缀和出现次数，<前缀和，出现次数>
        psCounts.put(0, 1);                                   // 初始ps[0] = 0出现一次
        int res = 0;                                         // 满足条件的子数组个数
        int ps = 0;                                          // 当前前缀和ps[i]
        for(int num: nums){
            ps += num;                                              // 更新前缀和，[0, i+1)
            res += psCounts.getOrDefault(ps - k, 0);                // 累加以元素nums[i]为结尾，满足子数组条件个数
            psCounts.put(ps, psCounts.getOrDefault(ps, 0) + 1);     // 将当前前缀和加入哈希表
        }
        return res;
    }
}
