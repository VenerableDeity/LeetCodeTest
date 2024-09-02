package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test14LongestCommonPrefix {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。

    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"

    示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。

    提示：
    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] 仅由小写英文字母组成
     */

    @Test
    public void test(){
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        // 找出最短字符串的长度
        for (String str : strs) {
            if (str.length() < minLen) minLen = str.length();
        }

        char[] commonPrefix = new char[minLen];
        for (int j = 0; j < minLen; j++) {
            char c = strs[0].charAt(j);
            for (int k = 1; k < strs.length; k++) {
                if (c != strs[k].charAt(j)) {
                    // 当遇到不相同的字符时，返回当前找到的公共前缀
                    return new String(commonPrefix, 0, j);
                }
            }
            commonPrefix[j] = c; // 设置公共前缀的下一个字符
        }

        // 如果所有字符串的前缀都相同，返回整个公共前缀
        return new String(commonPrefix, 0, minLen);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {  // 从第二个字符串开始
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {  // 
                if (ans.charAt(j) != strs[i].charAt(j))  // 当前字符不相等时，跳出循环
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }


}
