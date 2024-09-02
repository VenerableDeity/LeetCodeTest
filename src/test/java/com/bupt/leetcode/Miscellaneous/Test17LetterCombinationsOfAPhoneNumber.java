package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test17LetterCombinationsOfAPhoneNumber {
    /*
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    示例 1：
        输入：digits = "23"
        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

    示例 2：
        输入：digits = ""
        输出：[]

    示例 3：
        输入：digits = "2"
        输出：["a","b","c"]

    提示：
        0 <= digits.length <= 4
        digits[i] 是范围 ['2', '9'] 的一个数字。
     */

    @Test
    public void test() {
//        System.out.println(letterCombinations("23"));
//        System.out.println(letterCombinations(""));
//        System.out.println(letterCombinations("2"));
        System.out.println(bfs("234"));
        System.out.println(letterCombinations("234"));
//        System.out.println(letterCombinations("947352"));
    }

    public List<String> letterCombinations(String digits) {
        /*
        首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
        该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面。
        然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
        回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
         */
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        HashMap<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(res, phoneMap, digits, 0, new StringBuffer());
        return res;
    }

    public void dfs(List<String> res, HashMap<Character, String> phoneMap, String digits, int digitsIndex, StringBuffer str) {
        // 深度优先搜索
        if (digitsIndex == digits.length()) {  // 如果已经遍历完了电话号码的所有数字，则已有的字母排列是完整的
            res.add(str.toString());
        } else {
            char digit = digits.charAt(digitsIndex);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {  // 遍历当前数字对应的所有可能的字母
                str.append(letters.charAt(i));  // 将其中的一个字母插入到已有的字母排列后面
                dfs(res, phoneMap, digits, digitsIndex + 1, str);  // 继续处理电话号码的后一位数字
                str.deleteCharAt(digitsIndex);  // 回退操作
            }
        }
    }

    public List<String> bfs(String digits) {
        // 广度优先搜索
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        HashMap<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        for (int i = 0; i < digits.length(); i++) {
            // 广度优先搜索
            char digit = digits.charAt(i);
            String letters = phoneMap.get(digit);
            if (res.isEmpty()) {
                for (int j = 0; j < letters.length(); j++) {
                    res.add(String.valueOf(letters.charAt(j)));
                }
            } else {
                List<String> tmp = new ArrayList<>();
                for (String r : res) {
                    for (int j = 0; j < letters.length(); j++) {
                        tmp.add(r + letters.charAt(j));
                    }
                }
                res = tmp;
            }
        }

        return res;
    }
}
