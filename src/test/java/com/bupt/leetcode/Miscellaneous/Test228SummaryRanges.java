package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test228SummaryRanges {
    /*
    给定一个  无重复元素 的 有序 整数数组 nums 。返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
    也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
    列表中的每个区间范围 [a,b] 应该按如下格式输出：
        "a->b" ，如果 a != b
        "a" ，如果 a == b

    示例 1：
        输入：nums = [0,1,2,4,5,7]
        输出：["0->2","4->5","7"]
        解释：区间范围是：
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"

    示例 2：
        输入：nums = [0,2,3,4,6,8,9]
        输出：["0","2->4","6","8->9"]
        解释：区间范围是：
        [0,0] --> "0"
        [2,4] --> "2->4"
        [6,6] --> "6"
        [8,9] --> "8->9"

    提示：
        0 <= nums.length <= 20
        -2^31 <= nums[i] <= 2^31 - 1
        nums 中的所有值都 互不相同
        nums 按升序排列
     */
    @Test
    public void test(){
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));

        int[] nums2 = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums2));
    }

    /**
     * 思路：双指针
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        int left = 0, right = 0;  // 左右边界
        List<String> list = new ArrayList<>();
        while (right < nums.length) {
            while (right < nums.length - 1 && nums[right] + 1 == nums[right + 1]) {
                right++;  // 找到连续区间的右边界
            }
            if (left == right)  // 如果区间长度为0，就单独输出
                list.add(Integer.toString(nums[left]));
            else list.add(nums[left] + "->" + nums[right]);
            right++;
            left = right;
        }
        return list;
    }
}
