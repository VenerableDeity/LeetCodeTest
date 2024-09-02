package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test2AddTwoNumbers {

    /*
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例 1：
        输入：l1 = [2,4,3], l2 = [5,6,4]
        输出：[7,0,8]
        解释：342 + 465 = 807.

    示例 2：
        输入：l1 = [0], l2 = [0]
        输出：[0]

    示例 3：
        输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        输出：[8,9,9,9,0,0,0,1]

    提示：
        每个链表中的节点数在范围 [1, 100] 内 （不能直接进行相加运算，100位已经超出了所有的基本数据类型范围）
        0 <= Node.val <= 9
        题目数据保证列表表示的数字不含前导零
     */

    @Test
    public void test(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solution = new Solution();
        ListNode totalNode = solution.addTwoNumbers(l1, l2);
        while (totalNode != null){
            System.out.println(totalNode.val);
            totalNode = totalNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        /**
         * 思路：先计算两个链表的长度，然后用0结点补齐两个链表的长度，再进行相加操作
         * 扩展：如果链表是正序存储的，先将链表反转，再进行相加操作
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 计算两个链表的长度 以及 得到尾结点指针
            Integer len1 = 0, len2 = 0;
            ListNode p1 = l1, p2 = l2, l1Tail = l1, l2Tail = l2;
            while(p1 != null){
                len1++;
                l1Tail = p1;
                p1 = p1.next;
            }
            while(p2 != null){
                len2++;
                l2Tail = p2;
                p2 = p2.next;
            }

            // 补齐两个链表的长度，用0结点在短链表后方补齐，方便后续相加操作时对齐
            Integer difference = Math.abs(len1 - len2);  // 两个链表长度差值
            ListNode head = new ListNode(), pre = new ListNode();
            for (int i = 0; i < difference; i++){
                ListNode tmp = new ListNode();
                tmp.val = 0;
                tmp.next = null;
                if (i == 0){
                    head = tmp;
                    pre = tmp;
                    continue;
                }
                pre.next = tmp;
                pre = tmp;
            }

            if (len1 > len2){
                l2Tail.next = head;
            } else if (len2 > len1) {
                l1Tail.next = head;
            }

            // 两个链表长度相等，开始相加
            p1 = l1;
            p2 = l2;
            pre = l1;
            Integer carry = 0;  // 进位
            while (p1 != null && p2 != null){
                Integer res = p1.val + p2.val + carry;
                if (res >= 10){
                    carry = 1;
                    res -= 10;
                }else{
                    carry = 0;
                }
                p1.val = res;
                pre = p1;
                p1 = p1.next;
                p2 = p2.next;
            }
            if (carry != 0){  // 最高位有进位时，新建结点
                ListNode l = new ListNode();
                l.val = 1;
                l.next = null;
                pre.next = l;
            }
            return l1;
        }
    }
}
