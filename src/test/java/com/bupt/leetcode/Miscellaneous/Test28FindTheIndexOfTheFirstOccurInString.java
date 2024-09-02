package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test28FindTheIndexOfTheFirstOccurInString {
    /*
    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    如果 needle 不是 haystack 的一部分，则返回  -1 。

    示例 1：
        输入：haystack = "sadbutsad", needle = "sad"
        输出：0
        解释："sad" 在下标 0 和 6 处匹配。
        第一个匹配项的下标是 0 ，所以返回 0 。

    示例 2：
        输入：haystack = "leetcode", needle = "leeto"
        输出：-1
        解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。

    提示：
        1 <= haystack.length, needle.length <= 10^4
        haystack 和 needle 仅由小写英文字符组成
     */
    @Test
    public void test() {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));

        haystack = "leetcode";
        needle = "leeto";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 思路：暴力匹配
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);  // 使用内置函数
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 思路二： KMP 算法
     * @param haystack
     * @param needle
     * @return
     */
    public int kmp(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
