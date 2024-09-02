package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test201BitwiseANDOfNumbersRange {
    /*
    给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

    示例 1：
        输入：left = 5, right = 7
        输出：4
    示例 2：
        输入：left = 0, right = 0
        输出：0
    示例 3：
        输入：left = 1, right = 2147483647
        输出：0

    提示：
    0 <= left <= right <= 2^31 - 1
     */
    @Test
    public void test() {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 0));
        System.out.println(rangeBitwiseAnd(1, 2147483647));
    }

    /**
     * 思路：找到left和right的最长公共前缀，然后将后面的位数全部置为0
     * 原理：对于一个区间[left, right]，如果left和right的二进制表示的最高位不同，那么[left, right]之间的数的最高位必然为0
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    /**
     * 思路：将right的最低位置为0，直到left >= right
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd2(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }
}
