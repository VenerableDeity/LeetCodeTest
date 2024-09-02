package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test77Combinations {
    /*
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
    你可以按 任何顺序 返回答案。

    示例 1：
        输入：n = 4, k = 2
        输出：
        [
          [2,4],
          [3,4],
          [2,3],
          [1,2],
          [1,3],
          [1,4],
        ]

    示例 2：
        输入：n = 1, k = 1
        输出：[[1]]

    提示：
        1 <= n <= 20
        1 <= k <= n
     */
    @Test
    public void test() {
        System.out.println(combine(4, 2));
        listTotal.clear();
        System.out.println(combine(1, 1));
        listTotal.clear();
        System.out.println(combine(9, 3));
        listTotal.clear();
    }

    List<List<Integer>> listTotal = new ArrayList<>();  // 存放所有组合

    /**
     * 思路：回溯
     * @param n  [1, n]
     * @param k  k个数的组合
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<>(), 1);
        return listTotal;
    }

    /**
     * 回溯
     * @param n [1, n]
     * @param k k个数的组合
     * @param list 临时存放组合
     * @param index 从index开始
     */
    private void backtrack(int n, int k, List<Integer> list, int index) {
        if (list.size() == k) {
            listTotal.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            // 经典回溯模板
            list.add(i);
            // 以 i + 1进行递归
            backtrack(n , k, list, i + 1);
            list.removeLast();
        }
    }

}
