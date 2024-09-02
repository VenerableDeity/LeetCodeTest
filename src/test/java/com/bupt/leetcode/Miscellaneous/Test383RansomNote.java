package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test383RansomNote {
    /*
    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
    如果可以，返回 true ；否则返回 false 。
    magazine 中的每个字符只能在 ransomNote 中使用一次。

    示例 1：
        输入：ransomNote = "a", magazine = "b"
        输出：false

    示例 2：
        输入：ransomNote = "aa", magazine = "ab"
        输出：false

    示例 3：
        输入：ransomNote = "aa", magazine = "aab"
        输出：true

    提示：
        1 <= ransomNote.length, magazine.length <= 10^5
        ransomNote 和 magazine 由小写英文字母组成
     */
    @Test
    public void test() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

        String ransomNote2 = "a";
        String magazine2 = "b";
        System.out.println(canConstruct(ransomNote2, magazine2));

        String ransomNote3 = "aa";
        String magazine3 = "ab";
        System.out.println(canConstruct(ransomNote3, magazine3));
    }

    /**
     * 思路：遍历ransomNote，对于ransomNote中的每个字符，判断其是否在magazine中，如果在，则删除magazine中的该字符
     * @param ransomNote
     * @param magazine
     * @return
     */
//    public boolean canConstruct(String ransomNote, String magazine) {
//        boolean flag = true;
//        StringBuilder m = new StringBuilder(magazine);
//        for (int i = 0; i < ransomNote.length(); i++) {
//            char c = ransomNote.charAt(i);
//            String cStr = String.valueOf(c);
//            int index = m.indexOf(cStr);
//            if (index == - 1) {
//                flag = false;
//                break;
//            } else {
//                m.deleteCharAt(index);
//            }
//        }
//        return flag;
//    }

    /**
     * 思路：遍历magazine，统计magazine中每个字符出现的次数，然后遍历ransomNote，
     * 对于ransomNote中的每个字符，判断其是否在magazine中，如果在，则将magazine中的该字符的次数减1
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
