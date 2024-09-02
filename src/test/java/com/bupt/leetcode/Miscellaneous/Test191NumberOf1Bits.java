package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test191NumberOf1Bits {
    /*
    编写一个函数，获取一个正整数的二进制形式并返回其二进制表达式中设置位的个数（也被称为汉明重量）。

    示例 1：
        输入：n = 11
        输出：3
        解释：输入的二进制串 1011 中，共有 3 个设置位。

    示例 2：
        输入：n = 128
        输出：1
        解释：输入的二进制串 10000000 中，共有 1 个设置位。

    示例 3：
        输入：n = 2147483645
        输出：30
        解释：输入的二进制串 11111111111111111111111111111101 中，共有 30 个设置位。

    提示：
        1 <= n <= 2^31 - 1

    进阶：
        如果多次调用这个函数，你将如何优化你的算法？
     */
    @Test
    public void test() {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight2(2147483645));
    }

    /**
     * 思路：将整数转换为二进制字符串，然后统计1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    // 进阶：如果多次调用这个函数，你将如何优化你的算法？
    // 思路：n & (n - 1)可以消除n的二进制表示中的最后一个1
    /**
     * 每次执行操作 n &= (n - 1)，都会将 n 的二进制表示中的最右边的1变为0。这是因为：
     *      当你从一个数中减去1时，该数的二进制表示中的最右边的1会变成0，如果这个1后面还有0，那么这些0都会变成1。例如：
     *      n = 12 的二进制为 1100
     *      n - 1 = 11 的二进制为 1011
     *      然后当你执行 n &= (n - 1) 时：
     *      1100 AND 1011 = 1000
     *      这个操作实际上将最低位的1（以及它后面的所有位）清零。
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
