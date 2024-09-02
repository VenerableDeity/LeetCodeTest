package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test20ValidParentheses {
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。

    示例 1：
    输入：s = "()"
    输出：true

    示例 2：
    输入：s = "()[]{}"
    输出：true

    示例 3：
    输入：s = "(]"
    输出：false

    提示：
    1 <= s.length <= 104
    s 仅由括号 '()[]{}' 组成
     */

    @Test
    public void test(){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }


    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int j = 0;  // j指向栈顶元素的下一个位置
        stack[j++] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack[j] = s.charAt(i);
                j++;  // j指向栈顶元素的下一个位置
            }else if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if (j == 0) return false; // 栈为空，说明右括号多了
                j -= 1;
                char c = stack[j];
                if (s.charAt(i) == '}' && c != '{') {
                    return false;
                }else if (s.charAt(i) == ')' && c != '(') {
                    return false;
                }else if (s.charAt(i) == ']' && c != '[') {
                    return false;
                }
            }
        }
        return j == 0;
    }

}
