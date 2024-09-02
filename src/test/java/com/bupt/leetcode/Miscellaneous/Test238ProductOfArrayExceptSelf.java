package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test238ProductOfArrayExceptSelf {
    /*
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

    示例 1:
        输入: nums = [1,2,3,4]
        输出: [24,12,8,6]

    示例 2:
        输入: nums = [-1,1,0,-3,3]
        输出: [0,0,9,0,0]

    提示：
        2 <= nums.length <= 10^5
        -30 <= nums[i] <= 30
        保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内

    进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
     */

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i);
            System.out.print(',');
        }

        System.out.println();

        nums = new int[]{-1, 1, 0, -3, 3};
        result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i);
            System.out.print(',');
        }
    }

    /**
     * 思路：左右乘积列表 L 和 R
     * 初始化两个空数组 L 和 R。对于给定索引 i，L[i] 代表的是 i 左侧所有数字的乘积，R[i] 代表的是 i 右侧所有数字的乘积。
     * 我们需要用两个循环来填充 L 和 R 数组的值。对于数组 L，L[0] 应该是 1，因为第一个元素的左边没有元素。对于其他元素：L[i] = L[i-1] * nums[i-1]。
     * 同理，对于数组 R，R[length-1] 应为 1。length 指的是输入数组的大小。其他元素：R[i] = R[i+1] * nums[i+1]。
     * 当 R 和 L 数组填充完成，我们只需要在输入数组上迭代，且索引 i 处的值为：L[i] * R[i]。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
