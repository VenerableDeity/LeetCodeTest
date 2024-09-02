package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Test290WordPattern {
    /*
    给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
    这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。

    示例1:
        输入: pattern = "abba", s = "dog cat cat dog"
        输出: true

    示例 2:
        输入:pattern = "abba", s = "dog cat cat fish"
        输出: false

    示例 3:
        输入: pattern = "aaaa", s = "dog cat cat dog"
        输出: false

    提示:
        1 <= pattern.length <= 300
        pattern 只包含小写英文字母
        1 <= s.length <= 3000
        s 只包含小写英文字母和 ' '
        s 不包含 任何前导或尾随对空格
        s 中每个单词都被 单个空格 分隔
     */
    @Test
    public void test() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(wordPattern(pattern2, s2));

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println(wordPattern(pattern3, s3));
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strs[i])){
                    return false;
                }
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}
