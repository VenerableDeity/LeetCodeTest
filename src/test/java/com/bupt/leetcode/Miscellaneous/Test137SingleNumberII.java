package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test137SingleNumberII {
    /*
    给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。

    示例 1：
        输入：nums = [2,2,3,2]
        输出：3

    示例 2：
        输入：nums = [0,1,0,1,0,1,99]
        输出：99

    提示：
        1 <= nums.length <= 3 * 10^4
        -2^31 <= nums[i] <= 2^31 - 1
        nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
     */
    @Test
    public void test() {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(nums2));
    }

    /**
     * 思路：对于每一个数的每一位，统计所有数在这一位上的和，然后对3取余，剩下的就是只出现一次的数在这一位上的值
     * 统计每一位的和：对于数组中的每个元素，统计该位上的1的数量。由于数组的每个元素都是整数，我们可以通过位运算（例如：num & 1）来检查每个整数的每一位。
     * 对3取余：由于除了一个元素外，其他元素都出现三次，如果一位上的1的总数能被3整除，说明只出现一次的数在该位上为0；否则为1。这是因为每个出现三次的元素都会在各自的位上贡献三个1或三个0，这些都能够被3整除，从而被抵消。唯一不被抵消的就是那个只出现一次的元素。
     * 该方法适用于解决「除一个数字以外，其他数字都出现 k 次」的问题。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int n = 3;
        int[] counts = new int[32];  // 存储每一位上的和
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {  // 统计每个数在每一位上的和
                counts[i] += num & 1;
                num >>>= 1;  // >>>=是无符号右移，不管正负，高位补0
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;  // <<=是左移，相当于result *= 2
            result |= counts[i] % n;  // |=是按位或，相当于result += counts[i] % 3
        }
        return result;
    }

}
