package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test202HappyNumber {
    /*
    编写一个算法来判断一个数 n 是不是快乐数。
    「快乐数」 定义为：
        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

    示例 1：
        输入：n = 19
        输出：true
        解释：
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

    示例 2：
        输入：n = 2
        输出：false

    提示：
        1 <= n <= 2^31 - 1
     */
    @Test
    public void test() {
        int n = 19;
        System.out.println(isHappy(n));

        int n2 = 2;
        System.out.println(isHappy(n2));
    }


    /**
     * 快慢指针
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }

    /**
     * 哈希表
     * @param n
     * @return
     */
//    public boolean isHappy(int n) {
//        HashSet<Integer> set = new HashSet<>();
//        int num = n;
//        while (true) {
//            if (set.contains(num)) {
//                return false;
//            } else {
//                set.add(num);
//                int result = 0;
//                while (num > 0) {
//                    int tmp = num % 10;
//                    result += tmp * tmp;
//                    num /= 10;
//                }
//                if (result == 1) {
//                    return true;
//                } else {
//                    num = result;
//                }
//            }
//        }
//    }
}
