package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class Test125ValidPalindrome {
    /*
    如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    字母和数字都属于字母数字字符。
    给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

    示例 1：
        输入: s = "A man, a plan, a canal: Panama"
        输出：true
        解释："amanaplanacanalpanama" 是回文串。

    示例 2：
        输入：s = "race a car"
        输出：false
        解释："raceacar" 不是回文串。

    示例 3：
        输入：s = " "
        输出：true
        解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
        由于空字符串正着反着读都一样，所以是回文串。

    提示：
        1 <= s.length <= 2 * 10^5
        s 仅由可打印的 ASCII 字符组成
     */
    @Test
    public void test() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));
    }

    /**
     * 思路：调用api
     * @param s
     * @return
     */
//    public boolean isPalindrome(String s) {
//        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
//        StringBuilder sb = new StringBuilder(s1);
//        String s2 = sb.reverse().toString();
//        return s1.equalsIgnoreCase(s2);
//    }

    /**
     * 思路：手动实现，遍历
     * ASCII码数字和字母的范围：97-122，65-90，48-57
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                s1.append(s.charAt(i));
            } else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                s1.append((char) (s.charAt(i) + 32));
            } else if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                s1.append(s.charAt(i));
            }
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s1.length(); i++) {
            stack.push(s1.charAt(i));
        }

        boolean flag = true;
        for (int i = 0; i < stack.size(); i++) {
            Character c = stack.pop();
            if (c != s1.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
