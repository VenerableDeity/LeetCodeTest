package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test56MergeIntervals {
    /*
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

    示例 1：
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

    示例 2：
        输入：intervals = [[1,4],[4,5]]
        输出：[[1,5]]
        解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

    提示：
        1 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^4
     */
    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints));
        }

        System.out.println();

        int[][] intervals2 = {{1, 4}, {4, 5}};
        result = merge(intervals2);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints));
        }
    }

    /**
     * 思路：先按照区间起始位置排序，然后遍历区间，如果当前区间的起始位置大于结果集中最后一个区间的终止位置，
     * 则说明当前区间和结果集中最后一个区间不重合，直接将当前区间加入结果集；否则，说明当前区间和结果集中最后一个区间重合，更新结果集中最后一个区间的终止位置为当前区间的终止位置和结果集中最后一个区间的终止位置的最大值。
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.addLast(new int[]{L, R});
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
