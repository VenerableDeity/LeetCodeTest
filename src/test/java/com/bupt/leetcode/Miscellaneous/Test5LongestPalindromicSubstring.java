package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test5LongestPalindromicSubstring {
    /*
    给你一个字符串 s，找到 s 中最长的回文子串。如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

    示例 1：
        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。

    示例 2：
        输入：s = "cbbd"
        输出："bb"

    提示：
        1 <= s.length <= 1000
        s 仅由数字和英文字母组成
     */

    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {  // 字符串长度为 1，直接返回
            return s;
        }
        int maxLen = 1;  // 记录最长回文子串的长度
        int begin = 0;  // 记录最长回文子串的起始位置
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {  // L <= 3 时，只要头尾两个字符相同，就是回文
                        dp[i][j] = true;  // 不断缩小范围，直到 L <= 3
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];  // 当前字符串是不是回文取决于去掉头尾的字符串是不是回文
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {  // j - i + 1 表示当前子串的长度
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
