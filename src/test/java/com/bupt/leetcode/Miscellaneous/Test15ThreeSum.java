package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test15ThreeSum {
    /*
    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    示例 1：
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。

    示例 2：
        输入：nums = [0,1,1]
        输出：[]
        解释：唯一可能的三元组和不为 0 。

    示例 3：
        输入：nums = [0,0,0]
        输出：[[0,0,0]]
        解释：唯一可能的三元组和为 0 。

    提示：
        3 <= nums.length <= 3000
        -10^5 <= nums[i] <= 10^5
     */

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        nums = new int[]{0, 1, 1};
        System.out.println(threeSum(nums));

        nums = new int[]{0, 0, 0};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        /*
        标签：数组遍历
        首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
        如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
        如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
        当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
        当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
        时间复杂度：O(n^2)，n 为数组长度
        */
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }


}
