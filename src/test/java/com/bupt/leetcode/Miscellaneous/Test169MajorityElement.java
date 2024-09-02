package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test169MajorityElement {
    /*
    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1：
        输入：nums = [3,2,3]
        输出：3

    示例 2：
        输入：nums = [2,2,1,1,1,2,2]
        输出：2

    提示：
        n == nums.length
        1 <= n <= 5 * 10^4
        -10^9 <= nums[i] <= 10^9

    进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
     */

    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
         // 方法一：
//         HashMap<Integer, Integer> frequencyMap = new HashMap<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (frequencyMap.containsKey(nums[i])) {
//                 frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
//             } else {
//                 // 否则，将该数字加入 HashMap，并设置其计数为 1
//                 frequencyMap.put(nums[i], 1);
//             }
//         }
//
//         int count = nums.length / 2;
//         Integer resultKey = null; // 存储符合条件的键
//         for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
//             if (entry.getValue() > count) {
//                 resultKey = entry.getKey();
//                 break; // 找到第一个满足条件的键后退出循环
//             }
//         }
//         return resultKey;

        // 方法二：
        Arrays.sort(nums);
        int count = nums.length / 2;
        int left = 0;
        int right = left + count;
        for (; right < nums.length; right++, left++) {
            if (nums[left] == nums[right]) {
                break;
            }
        }
        return nums[left];

        // 方法三：
    }
}
