package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test151ReverseWordsInAString {
    /*
    给你一个字符串 s ，请你反转字符串中 单词 的顺序。
    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

    示例 1：
    输入：s = "the sky is blue"
    输出："blue is sky the"

    示例 2：
    输入：s = "  hello world  "
    输出："world hello"
    解释：反转后的字符串中不能存在前导空格和尾随空格。

    示例 3：
    输入：s = "a good   example"
    输出："example good a"
    解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。

    提示：
        1 <= s.length <= 10^4
        s 包含英文大小写字母、数字和空格 ' '
        s 中 至少存在一个 单词
     */

    @Test
    public void test() {
        String s = "the sky is blue";
        System.out.println(reverseWords2(s));

        s = "  hello world  ";
        System.out.println(reverseWords2(s));

        s = "a good   example";
        System.out.println(reverseWords3(s));
    }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' ') {
                int j = i + 1;
                while (j < stringBuilder.length() && stringBuilder.charAt(j) == ' ') {
                    j++;
                }
                if (j > i + 1) {
                    stringBuilder.delete(i + 1, j);
                }
            }
        }
        int before = stringBuilder.length();
        StringBuilder resSB = new StringBuilder();
        for (int i = stringBuilder.length() - 1; i >= 0; i--) {
            if (stringBuilder.charAt(i) == ' ') {
                resSB.append(stringBuilder.substring(i + 1, before)).append(" ");
                before = i;
            } else if (i == 0) {
                resSB.append(stringBuilder.substring(i, before));
            }
        }
        return resSB.toString();
    }

    public String reverseWords2(String s) {
        String[] strings = s.trim().split(" ");  // 去除首尾空格并按空格分割
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {  // 去除多余空格
                stringBuilder.append(strings[i]).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        s = s.trim();
        StringBuilder resSB = new StringBuilder();
        int right = s.length();
        for (int left = s.length() - 1; left >= 0; left--) {
            if (s.charAt(left) == ' ') {
                resSB.append(s.substring(left + 1, right)).append(" ");
                while (left >= 0) {
                    if (s.charAt(left) != ' ') {
                        break;
                    }
                    left--;
                }
                right = left + 1;
                if (left == 0) {
                    resSB.append(s.substring(left, right));
                }
            } else if (left == 0) {
                resSB.append(s.substring(left, right));
            }
        }
        return resSB.toString();
    }
}
