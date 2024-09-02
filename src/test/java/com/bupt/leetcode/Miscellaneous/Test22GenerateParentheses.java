package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class Test22GenerateParentheses {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    示例 1：
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]

    示例 2：
        输入：n = 1
        输出：["()"]

    提示：
        1 <= n <= 8
     */

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        dfs(n, sb, res, 0, 0);
        return res;
    }

    // left 左括号用的个数
    // right 右括号用的个数
    public void dfs(int n, StringBuilder sb, List<String> res, int left, int right) {
        if (left == n && right == n) {  // 左右括号都用了n个
            res.add(sb.toString());
        }

        if (left < n) {  // 左括号剩余
            sb.append("(");
            dfs(n, sb, res, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {  // 右括号数量小于左括号，如(()，这种情况下就可以添加右括号
            sb.append(")");
            dfs(n, sb, res, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
