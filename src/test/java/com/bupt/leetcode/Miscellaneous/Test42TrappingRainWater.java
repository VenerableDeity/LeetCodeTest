package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test42TrappingRainWater {
    /*
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

    示例 1：
        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

    示例 2：
        输入：height = [4,2,0,3,2,5]
        输出：9

    提示：
        n == height.length
        1 <= n <= 2 * 10^4
        0 <= height[i] <= 10^5
     */
    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height2));
    }

    /**
     * 思路：对于每个柱子，找到其左右两边的最高柱子，取两者的较小值减去当前柱子的高度，即为当前柱子能接到的雨水
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // int n = height.length;
        // if (n == 0) return 0;
        // int res = 0;
        // for (int i = 1; i < n - 1; i++) {
        //     int lMax = 0, rMax = 0;
        //     // 找右边最高
        //     for (int j = i; j < n; j++) {
        //         rMax = Math.max(rMax, height[j]);
        //     }
        //     // 找左边最高
        //     for (int j = i; j >= 0; j--) {
        //         lMax = Math.max(lMax, height[j]);
        //     }
        //     res += Math.min(lMax, rMax) - height[i];
        // }
        // return res;

        int n = height.length;
        if (n == 0) return 0;
        int res = 0;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // 初始化 base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++)
            res += Math.min(l_max[i], r_max[i]) - height[i];

        return res;
    }
}
