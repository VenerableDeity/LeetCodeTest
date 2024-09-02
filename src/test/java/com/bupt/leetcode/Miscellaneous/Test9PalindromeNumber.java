package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;


public class Test9PalindromeNumber {
    /*
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    回文数:是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

    示例 1：
    输入：x = 121
    输出：true

    示例 2：
    输入：x = -121
    输出：false
    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

    示例 3：
    输入：x = 10
    输出：false
    解释：从右向左读, 为 01 。因此它不是一个回文数。

    提示：
    -231 <= x <= 231 - 1
     */
    @Test
    public void test(){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        String xStr = String.valueOf(x);
        for (int i = 0, j = xStr.length()-1; i < j; i++, j--){
            if (xStr.charAt(i) != xStr.charAt(j)) return false;
        }
        return true;
    }
}
