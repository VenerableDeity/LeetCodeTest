package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test190ReverseBits {
    /*
    颠倒给定的 32 位无符号整数的二进制位。
    提示：
        请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，
        并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
        在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。

    示例 1：
        输入：n = 00000010100101000001111010011100
        输出：964176192 (00111001011110000010100101000000)
        解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
             因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。

    示例 2：
        输入：n = 11111111111111111111111111111101
        输出：3221225471 (10111111111111111111111111111111)
        解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
             因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。

    提示：
        输入是一个长度为 32 的二进制字符串
     */

    @Test
    public void test() {
        // 测试用例 1
        assertEquals(964176192, reverseBits(0b00000010100101000001111010011100), "Test case 1 failed");
        // 测试用例 2
        assertEquals(-1073741825, reverseBits(0b11111111111111111111111111111101), "Test case 2 failed");
    }

    /**
     * 思路：result左移一位，n&1得n的最低位，然后result加上n的最低位，n右移一位
     * @param n
     * @return
     */
    public int reverseBits(int n) {  // you need treat n as an unsigned value
        String str = Integer.toBinaryString(n);
        str = String.format("%32s", str).replace(' ', '0');
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return (int)Long.parseLong(sb.toString(), 2);

//        int result = 0;
//        for (int i = 0; i < 32; i++) {
//            // result左移一位，n&1得n的最低位，然后result加上n的最低位
//            result = (result << 1) + (n & 1);
//            // n右移一位
//            n >>= 1;
//        }
//        return result;
    }
}
