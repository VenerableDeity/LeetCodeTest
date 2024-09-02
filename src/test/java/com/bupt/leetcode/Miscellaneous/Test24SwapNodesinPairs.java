package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test24SwapNodesinPairs {
    /*
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

    示例 1：
        输入：head = [1,2,3,4]
        输出：[2,1,4,3]

    示例 2：
        输入：head = []
        输出：[]

    示例 3：
        输入：head = [1]
        输出：[1]

    提示：
        链表中节点的数目在范围 [0, 100] 内
        0 <= Node.val <= 100
     */
    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode newHead = swapPairs(head);
        printList(newHead);

        ListNode head2 = null;
        ListNode newHead2 = swapPairs(head2);
        printList(newHead2);

        ListNode head3 = new ListNode(1);
        ListNode newHead3 = swapPairs(head3);
        printList(newHead3);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0, head);
        ListNode cur = head.next, pre = head, prePair = sentinel;
        ListNode newHead = head.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            // 交换节点
            prePair.next = cur;
            pre.next = cur.next;
            cur.next = pre;
            // 更新指针
            prePair = pre;
            pre = tmp;
            if (pre != null) cur = pre.next;
            else break;
        }
        return newHead;
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
