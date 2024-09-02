package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test136SingleNumber {
    /*
    给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

    示例 1 ：
        输入：nums = [2,2,1]
        输出：1

    示例 2 ：
        输入：nums = [4,1,2,1,2]
        输出：4

    示例 3 ：
        输入：nums = [1]
        输出：1

    提示：
        1 <= nums.length <= 3 * 10^4
        -3 * 10^4 <= nums[i] <= 3 * 10^4
        除了某个元素只出现一次以外，其余每个元素均出现两次。
     */
    @Test
    public void test() {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println(singleNumber(nums3));

    }

    /**
     * 思路：异或运算，相同的数异或结果为0，0和任何数异或结果为这个数本身
     * 所有出现两次的数异或结果为0，最后剩下的数就是只出现一次的数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
