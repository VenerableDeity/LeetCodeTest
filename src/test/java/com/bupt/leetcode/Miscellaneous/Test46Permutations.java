package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test46Permutations {
    /*
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

    示例 1：
        输入：nums = [1,2,3]
        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

    示例 2：
        输入：nums = [0,1]
        输出：[[0,1],[1,0]]

    示例 3：
        输入：nums = [1]
        输出：[[1]]

    提示：
        1 <= nums.length <= 6
        -10 <= nums[i] <= 10
        nums 中的所有整数 互不相同
     */
    @Test
    public void test() {
        System.out.println(permute(new int[]{1, 2, 3}));
        listTotal.clear();
        System.out.println(permute(new int[]{0, 1}));
        listTotal.clear();
        System.out.println(permute(new int[]{1}));
        listTotal.clear();
    }

    List<List<Integer>> listTotal = new ArrayList<>();  // 存放所有排列

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return listTotal;
    }

    public void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            listTotal.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;  // 排列，不能重复
            list.add(num);
            backtrack(nums, list);
            list.removeLast();
        }
    }
}
