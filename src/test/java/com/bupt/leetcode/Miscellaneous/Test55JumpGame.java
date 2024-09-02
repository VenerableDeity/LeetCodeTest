package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test55JumpGame {
    /*
    给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。

    示例 1：
        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

    示例 2：
        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

    提示：
        1 <= nums.length <= 10^4
        0 <= nums[i] <= 10^5
     */
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));

        nums = new int[]{2, 0, 0};
        System.out.println(canJump(nums));
    }

    /**
     * DFS 思路：
     * 1. 从第一个下标开始，将其加入栈，并标记为已访问
     * 2. 遍历栈中的所有节点，遍历过程中做出判断，如果符合条件则退出循环，返回结果
     * 3. 如果没有找到符合条件的节点，继续遍历下一层
     * 4. 注意：标记访问数组的时机：入栈即标记为已访问，可以防止重复入栈
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        // 从第一个下标开始
        stack.push(0);
        visited[0] = true; // 标记起始点为已访问

        while (!stack.isEmpty()) {
            int position = stack.pop();

            // 如果可以到达最后一个下标，返回 true
            if (position == n - 1) {
                return true;
            }

            // 检查从当前位置可以跳到的所有位置
            for (int i = 1; i <= nums[position]; i++) {
                int nextPosition = position + i;
                if (nextPosition < n && !visited[nextPosition]) {
                    stack.push(nextPosition);
                    visited[nextPosition] = true;
                }
            }
        }

        // 如果不能到达最后一个下标，返回 false
        return false;

//        if (nums.length == 0) return true;
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        boolean[] isVisited = new boolean[nums.length];
//        stack.push(0);
//        while (!stack.isEmpty()) {
//            int index = stack.pop();
//
//            int num = nums[index];
//            if (isVisited[index] == true) {
//                continue;
//            }
//            isVisited[index] = true;
//            for (int j = 1; j <= num; j++) {
//                int target = index + j;
//                if (target >= nums.length - 1) return true;
//                else {
//                    stack.push(target);
//                }
//            }
//        }
//        return false;
    }

}
