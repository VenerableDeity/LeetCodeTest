package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test4MedianOfTwoSortedArrays {
    /*
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    算法的时间复杂度应该为 O(log (m+n)) 。

    示例 1：
        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2

    示例 2：
        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

    提示：
        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -10^6 <= nums1[i], nums2[i] <= 10^6
     */

    @Test
    public void test() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 思路：归并排序
     *
     * @param nums1
     * @param nums2
     * @return
     */
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums = new int[nums1.length + nums2.length];
//        int i = 0, j = 0, k = 0;  // i: nums1的指针，j: nums2的指针，k: nums的指针
//        while (i < nums1.length && j < nums2.length) {
//            if (nums1[i] < nums2[j]) {
//                nums[k++] = nums1[i++];
//            } else {
//                nums[k++] = nums2[j++];
//            }
//        }
//        while (i < nums1.length) {
//            nums[k++] = nums1[i++];
//        }
//        while (j < nums2.length) {
//            nums[k++] = nums2[j++];
//        }
//        if (nums.length % 2 == 0) {
//            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
//        } else {
//            return nums[nums.length / 2];
//        }
//    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = (totalLength + 1) / 2;
        int p1 = 0, p2 = 0;
        int res = 0, posRes = 0;
        for (int i = 1; i <= mid; i++) {
            if (p1 == nums1.length) {
                res = nums2[p2++];
            } else if (p2 == nums2.length) {
                res = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                res = nums1[p1++];
            } else {
                res = nums2[p2++];
            }
        }
        if (totalLength % 2 == 0) {
            if (p1 == nums1.length) {
                posRes = nums2[p2];
            } else if (p2 == nums2.length) {
                posRes = nums1[p1];
            } else {
                posRes = Math.min(nums1[p1], nums2[p2]);
            }
            return (res + posRes) / 2.0;
        } else {
            return res;
        }
    }
}
