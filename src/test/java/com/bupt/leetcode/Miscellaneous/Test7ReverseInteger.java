package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test7ReverseInteger {
    /*
    给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
    假设环境不允许存储 64 位整数（有符号或无符号）。

    示例 1：
        输入：x = 123
        输出：321

    示例 2：
        输入：x = -123
        输出：-321

    示例 3：
        输入：x = 120
        输出：21

    示例 4：
        输入：x = 0
        输出：0

    提示：
        -231 <= x <= 231 - 1
     */

    @Test
    public void test() {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(0));
        System.out.println(reverse(1534236469));
//        System.out.println(Integer.MAX_VALUE);
    }

    public int reverse(int x) {
        // 通过取余数和整除来实现反转
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }
}
