package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test82RemoveDuplicatesFromSortedListII {
    /*
    给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表。

    示例 1：
        输入：head = [1,2,3,3,4,4,5]
        输出：[1,2,5]

    示例 2：
        输入：head = [1,1,1,2,3]
        输出：[2,3]

    提示：
        链表中节点数目在范围 [0, 300] 内
        -100 <= Node.val <= 100
        题目数据保证链表已经按升序 排列
     */
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(3);
        ListNode head5 = new ListNode(4);
        ListNode head6 = new ListNode(4);
        ListNode head7 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }

        System.out.println();

        ListNode head8 = new ListNode(1);
        ListNode head9 = new ListNode(1);
        ListNode head10 = new ListNode(1);
        ListNode head11 = new ListNode(2);
        ListNode head12 = new ListNode(3);
        head8.next = head9;
        head9.next = head10;
        head10.next = head11;
        head11.next = head12;
        ListNode res2 = deleteDuplicates(head8);
        while (res2 != null) {
            System.out.print(res2.val);
            res2 = res2.next;
        }
    }

    /**
     * 思路：设置一个哨兵节点，pre指向虚拟节点，cur指向head，遍历链表，如果cur的下一个节点不为空且cur的值等于cur的下一个节点的值，
     * 则进入循环，直到cur的下一个节点为空或者cur的值不等于cur的下一个节点的值，pre的next指向cur的next，否则pre指向pre的next，
     * cur指向cur的next。最后返回哨兵节点的next。 时间复杂度为O(n)，空间复杂度为O(1)。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);  // 虚拟节点（哨兵节点）即在头节点之前的一个节点
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, p = head.next;
        while (p != null) {
            if (pre.val == p.val) {
                while (p != null && pre.val == p.val) {
                    p = p.next;
                }
                if (p == null) {
                    pre.next = null;
                    break;
                } else {
                    pre.next = p;
                    pre = p;
                    p = p.next;
                }
            } else {
                pre = p;
                p = p.next;
            }
        }
        return head;
    }
}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
