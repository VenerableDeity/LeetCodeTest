package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test16ThreeSumClosest {
    /*
    给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
    返回这三个数的和。
    假定每组输入只存在恰好一个解。

    示例 1：
        输入：nums = [-1,2,1,-4], target = 1
        输出：2
        解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

    示例 2：
        输入：nums = [0,0,0], target = 1
        输出：0

    提示：
        3 <= nums.length <= 1000
        -1000 <= nums[i] <= 1000
        -10^4 <= target <= 10^4
     */

    @Test
    public void test() {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));

        nums = new int[]{0, 0, 0};
        System.out.println(threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        /*
        标签：数组遍历
        首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
        如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
        如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
        当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
        当 sum == 0 时，nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R−−
        时间复杂度：O(n^2)，n 为数组长度
        */
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))  // 当前和与目标和的差值比之前的差值小
                    ans = sum;
                if (sum > target)  // 当前和大于目标和，右指针左移
                    end--;
                else if (sum < target)  // 当前和小于目标和，左指针右移
                    start++;
                else
                    return ans;  // 当前和等于目标和，直接返回
            }
        }
        return ans;
    }
}
