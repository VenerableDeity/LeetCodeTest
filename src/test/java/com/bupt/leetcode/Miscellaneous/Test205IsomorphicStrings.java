package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Test205IsomorphicStrings {
    /*
    给定两个字符串 s 和 t ，判断它们是否是同构的。如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
    每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

    示例 1:
        输入：s = "egg", t = "add"
        输出：true

    示例 2：
        输入：s = "foo", t = "bar"
        输出：false

    示例 3：
        输入：s = "paper", t = "title"
        输出：true

    示例 4：
        输入：s = "abac", t = "eded"
        输出：false

    提示：
        1 <= s.length <= 5 * 10^4
        t.length == s.length
        s 和 t 由任意有效的 ASCII 字符组成
     */
    @Test
    public void test() {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(isIsomorphic(s2, t2));

        String s3 = "paper";
        String t3 = "title";
        System.out.println(isIsomorphic(s3, t3));

        String s4 = "abac";
        String t4 = "eded";
        System.out.println(isIsomorphic(s4, t4));
    }

    /**
     * 思路：使用map存储映射关系，遍历s和t，如果s中的字符已经在map中，判断其映射关系是否正确，如果不在map中，判断t中的字符是否已经被映射
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(s.charAt(0), t.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }


}
