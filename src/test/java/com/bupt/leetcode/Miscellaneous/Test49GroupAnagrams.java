package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Test49GroupAnagrams {
    /*
    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

    示例 1:
        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

    示例 2:
        输入: strs = [""]
        输出: [[""]]

    示例 3:
        输入: strs = ["a"]
        输出: [["a"]]

    提示：
        1 <= strs.length <= 10^4
        0 <= strs[i].length <= 100
        strs[i] 仅包含小写字母
     */
    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
    }

    /**
     * 思路：使用 map 存储排序后的字符串和原字符串的映射关系
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
