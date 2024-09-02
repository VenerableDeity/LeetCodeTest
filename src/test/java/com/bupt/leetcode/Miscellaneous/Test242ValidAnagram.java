package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test242ValidAnagram {
    /*
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

    示例 1:
        输入: s = "anagram", t = "nagaram"
        输出: true

    示例 2:
        输入: s = "rat", t = "car"
        输出: false

    提示:
        1 <= s.length, t.length <= 5 * 10^4
        s 和 t 仅包含小写字母

    进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     */
    @Test
    public void test() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2));

    }

//    public boolean isAnagram(String s, String t) {
//        int[] sCount = new int[26];
//        int[] tCount = new int[26];
//        for (char c : s.toCharArray()) {
//            sCount[c - 'a']++;  // 'a'的ASCII码为97，'b'的ASCII码为98，所以c - 'a'即为c的索引
//        }
//        for (char c : t.toCharArray()) {
//            tCount[c - 'a']++;  // 'A'的ASCII码为65，'B'的ASCII码为66，所以c - 'A'即为c的索引  0的ASCII码为48
//        }
//        for (int i = 0; i < 26; i++) {
//            if (sCount[i] != tCount[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
