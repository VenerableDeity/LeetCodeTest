package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test57InsertInterval {
    /*
    给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
    并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
    在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
    返回插入之后的 intervals。
    注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。

    示例 1：
        输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
        输出：[[1,5],[6,9]]
    示例 2：
        输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        输出：[[1,2],[3,10],[12,16]]
        解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

    提示：
        0 <= intervals.length <= 10^4
        intervals[i].length == 2
        0 <= starti <= endi <= 10^5
        intervals 根据 starti 按 升序 排列
        newInterval.length == 2
        0 <= start <= end <= 10^5
     */
    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);
        for (int[] ints : result) {
            System.out.print("[" + ints[0] + "," + ints[1] + "]");
        }

        System.out.println();

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        result = insert(intervals2, newInterval2);
        for (int[] ints : result) {
            System.out.print("[" + ints[0] + "," + ints[1] + "]");
        }
    }

    /**
     * 思路：遍历区间，如果当前区间的结束位置小于新区间的开始位置，说明当前区间在新区间的左侧，直接加入结果集；
     * 如果当前区间的开始位置大于新区间的结束位置，说明当前区间在新区间的右侧，将新区间加入结果集，并将当前区间加入结果集；
     * @param intervals
     * @param newInterval
     * @return
     */
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int left = newInterval[0];
//        int right = newInterval[1];
//        boolean placed = false;
//        List<int[]> ansList = new ArrayList<int[]>();
//        for (int[] interval : intervals) {
//            if (interval[0] > right) {
//                // 在插入区间的右侧且无交集
//                if (!placed) {
//                    ansList.add(new int[]{left, right});
//                    placed = true;
//                }
//                ansList.add(interval);
//            } else if (interval[1] < left) {
//                // 在插入区间的左侧且无交集
//                ansList.add(interval);
//            } else {
//                // 与插入区间有交集，计算它们的并集
//                left = Math.min(left, interval[0]);
//                right = Math.max(right, interval[1]);
//            }
//        }
//        if (!placed) {
//            ansList.add(new int[]{left, right});
//        }
//        int[][] ans = new int[ansList.size()][2];
//        for (int i = 0; i < ansList.size(); ++i) {
//            ans[i] = ansList.get(i);
//        }
//        return ans;
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;
        return merge(newIntervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.isEmpty() || merged.getLast()[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], R);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
