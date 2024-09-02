package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test66PlusOne {
    /*
    给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
    你可以假设除了整数 0 之外，这个整数不会以零开头。

    示例 1：
        输入：digits = [1,2,3]
        输出：[1,2,4]
        解释：输入数组表示数字 123。

    示例 2：
        输入：digits = [4,3,2,1]
        输出：[4,3,2,2]
        解释：输入数组表示数字 4321。

    示例 3：
        输入：digits = [0]
        输出：[1]

    提示：
        1 <= digits.length <= 100
        0 <= digits[i] <= 9
     */
    @Test
    public void test() {
        int[] digits = {1, 2, 3};
        int[] res = plusOne(digits);
        for (int re : res) {
            System.out.print(re + " ");
        }

        System.out.println();

        digits = new int[]{4, 3, 2, 1};
        res = plusOne(digits);
        for (int re : res) {
            System.out.print(re + " ");
        }

        System.out.println();

        digits = new int[]{0};
        res = plusOne(digits);
        for (int re : res) {
            System.out.print(re + " ");
        }

        System.out.println();

        digits = new int[]{9};
        res = plusOne(digits);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int carat = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carat;
            if (digits[i] >= 10) {
                digits[i] -= 10;
                carat = 1;
            } else {
                carat = 0;
                break;
            }
        }
        int[] newArr = new int[digits.length+1];
        if (carat == 1) {
            for (int i = 0; i < newArr.length; i++) {
                if (i == 0) {
                    newArr[i] = 1;
                } else {
                    newArr[i] = digits[i-1];
                }
            }
            digits = newArr;
        }
        return digits;
    }
}
