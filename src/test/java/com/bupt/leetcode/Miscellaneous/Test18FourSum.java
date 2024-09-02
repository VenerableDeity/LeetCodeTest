package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test18FourSum {
    /*
    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
    请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
    0 <= a, b, c, d < n，且 a、b、c 和 d 互不相同，nums[a] + nums[b] + nums[c] + nums[d] == target
    你可以按 任意顺序 返回答案 。

    示例 1：
        输入：nums = [1,0,-1,0,-2,2], target = 0
        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    示例 2：
        输入：nums = [2,2,2,2,2], target = 8
        输出：[[2,2,2,2]]

    提示：
         1 <= nums.length <= 200
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9`
     */
    @Test
    public void test() {
        int[] nums1 = {1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(fourSum(nums1, target1));

        int[] nums2 = {2,2,2,2,2};
        int target2 = 8;
        System.out.println(fourSum(nums2, target2));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) { // 枚举第一个数
            long x = nums[a]; // 使用 long 避免溢出
            if (a > 0 && x == nums[a - 1]) continue; // 跳过重复数字
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break; // 优化一
            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
            for (int b = a + 1; b < n - 2; b++) { // 枚举第二个数
                long y = nums[b];
                if (b > a + 1 && y == nums[b - 1]) continue; // 跳过重复数字
                if (x + y + nums[b + 1] + nums[b + 2] > target) break; // 优化一
                if (x + y + nums[n - 2] + nums[n - 1] < target) continue; // 优化二
                int c = b + 1, d = n - 1;
                while (c < d) { // 双指针枚举第三个数和第四个数
                    long s = x + y + nums[c] + nums[d]; // 四数之和
                    if (s > target) d--;
                    else if (s < target) c++;
                    else { // s == target
                        ans.add(List.of((int) x, (int) y, nums[c], nums[d]));
                        for (c++; c < d && nums[c] == nums[c - 1]; c++) ; // 跳过重复数字
                        for (d--; d > c && nums[d] == nums[d + 1]; d--) ; // 跳过重复数字
                    }
                }
            }
        }
        return ans;
    }
}
