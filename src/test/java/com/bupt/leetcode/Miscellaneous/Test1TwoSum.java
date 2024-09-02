package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test1TwoSum {
    /*
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
    你可以假设每种输入只会对应一个答案。但是数组中同一个元素在答案里不能重复出现。
    你可以按任意顺序返回答案。

    示例 1：
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

    示例 2：
        输入：nums = [3,2,4], target = 6
        输出：[1,2]

    示例 3：
        输入：nums = [3,3], target = 6
        输出：[0,1]

    提示：
        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        只会存在一个有效答案
     */

    @Test
    public void test(){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index = twoSumHash(nums, target);
        System.out.println("[" + index[0] + ", " + index[1] + "]");

        nums = new int[]{3, 2, 4};
        target = 6;
        index = twoSumHash(nums, target);
        System.out.println("[" + index[0] + ", " + index[1] + "]");

        nums = new int[]{3, 3};
        target = 6;
        index = twoSumHash(nums, target);
        System.out.println("[" + index[0] + ", " + index[1] + "]");
    }

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (target == nums[i] + nums[j]){
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }

    /**
     * 思路：使用哈希表存储已经遍历过的元素，遍历过程中判断 target - nums[i] 是否在哈希表中
     * 重要 api：HashMap.containsKey(key) 若 key 存在则返回 true 否则返回 false
     * 拓展：如果数组是有序的，可以使用双指针法，即一个指针指向数组头，一个指针指向数组尾，根据两个指针指向的元素之和与 target 的大小关系来移动指针
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // key: num, value: index
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


//    public int[] twoSumSort(int[] nums, int target) {
//        int[] index = new int[2];
//        int left = 0, right = nums.length - 1;
//        // 先排序
//        Arrays.sort(nums);
//        ArrayList<Integer> arr = new ArrayList<>();
//        for (int num : nums) {
//            arr.add(num);
//        }
//        arr.sort(Integer::compareTo);
//        while (left < right) {
//            if (arr.get(left) + arr.get(right) == target) {
//                index[0] = left;
//                index[1] = right;
//                break;
//            } else if (arr.get(left) + arr.get(right) < target) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return index;
//    }
}
