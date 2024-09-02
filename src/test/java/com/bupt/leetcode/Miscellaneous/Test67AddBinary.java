package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test67AddBinary {
    /*
    给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。

    示例 1：
        输入:a = "11", b = "1"
        输出："100"

    示例 2：
        输入：a = "1010", b = "1011"
        输出："10101"

    提示：
        1 <= a.length, b.length <= 10^4
        a 和 b 仅由字符 '0' 或 '1' 组成
        字符串如果不是 "0" ，就不含前导零
     */
    @Test
    public void test() {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));

        a = "1010";
        b = "1011";
        System.out.println(addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
