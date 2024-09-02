package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Test3LongestSubstringWithoutRepeatingCharacters {
    /*
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。

    示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。

    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

    提示：
        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成
     */

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println("-----------------------------------");
        System.out.println(lengthOfLongestSubstringByHash("abcabcbb"));
        System.out.println(lengthOfLongestSubstringByHash("bbbbb"));
        System.out.println(lengthOfLongestSubstringByHash("pwwkew"));
        System.out.println("-----------------------------------");
        System.out.println(lengthOfLongestSubstringByDeque("abcabcbb"));
        System.out.println(lengthOfLongestSubstringByDeque("bbbbb"));
        System.out.println(lengthOfLongestSubstringByDeque("pwwkew"));
    }

    /**
     * 思路：滑动窗口
     * 滑动窗口：[left, right] 之间的字符不重复
     * 哈希表：存储字符出现的次数
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int n = s.length();
        int[] res = new int[128];
        int left = 0, right = 0, max = 0;
        while (right < n){
            char c = s.charAt(right);
            res[c]++;
            while (res[c] > 1){
                char d = s.charAt(left);
                res[d]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

//        int res = 0, count = 0;
//        int left = 0;
//        int[] arr = new int[128];
//        for (int right = 0; right < s.length(); right++) {
//            char c = s.charAt(right); // 当前遍历字符
//            if (arr[c] != 0) {
//                // 循环将左指针右移，直到出现当前字符
//                while (arr[c] == 1) {
//                    char d = s.charAt(left++);
//                    arr[d]--; // 将退出滑动窗口的字符出现次数归0
//                    count--; // 当前子串长度-1
//                }
//            }
//            arr[c]++;  // 出现次数+1
//            count++;  // 当前子串长度+1
//            res = Math.max(res, count); // 更新res长度
//        }
//        return res;
    }


    public int lengthOfLongestSubstringByHash(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d); // 如果字符的计数为0，则从map中移除，以节省空间
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstringByDeque(String s) {
        int n = s.length();
        int max = 0;
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!queue.contains(s.charAt(i))) {
                queue.offer(s.charAt(i));
                max = Math.max(max, queue.size());
            } else {
                while(queue.contains(s.charAt(i))) {
                    queue.poll();
                }
                queue.offer(s.charAt(i));
            }
        }
        return max;
    }

}
