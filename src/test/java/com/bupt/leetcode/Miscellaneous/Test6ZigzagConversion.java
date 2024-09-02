package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test6ZigzagConversion {
    /*
    将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
    比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    P   A   H   N
    A P L S I I G
    Y   I   R
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);

    示例 1：
    输入：s = "PAYPALISHIRING", numRows = 3
    输出："PAHNAPLSIIGYIR"

    示例 2：
    输入：s = "PAYPALISHIRING", numRows = 4
    输出："PINALSIGYAHRPI"
    解释：
    P     I    N
    A   L S  I G
    Y A   H R
    P     I

    示例 3：
    输入：s = "A", numRows = 1
    输出："A"

    提示：
    1 <= s.length <= 1000
    s 由英文字母（小写和大写）、',' 和 '.' 组成
    1 <= numRows <= 1000
     */

    @Test
    public void test(){
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));

        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j + i < n; j += cycleLen){
                res.append(s.charAt(j + i));  // 添加非斜线上的字符
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){  // 非首行和末行 且 不越界
                    res.append(s.charAt(j + cycleLen - i));  // 添加对应的斜线上的字符
                }
            }
        }
        return res.toString();
    }
}
