package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test19RemoveNthNodeFromEndOfList {
    /*
    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

    示例 1：
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]

    示例 2：
        输入：head = [1], n = 1
        输出：[]

    示例 3：
        输入：head = [1,2], n = 1
        输出：[1]

    提示：
        链表中结点的数目为 sz
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz

    进阶：你能尝试使用一趟扫描实现吗？
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode createList(int[] nums) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }

    private void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = createList(nums);
        printList(removeNthFromEnd(head, 2));

        int[] nums2 = {1};
        ListNode head2 = createList(nums2);
        printList(removeNthFromEnd(head2, 1));

        int[] nums3 = {1, 2};
        ListNode head3 = createList(nums3);
        printList(removeNthFromEnd(head3, 1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (n == length) {
            return head.next;
        }

        ListNode pre = head;
        p = head;
        for (int i = 0; i < length - n; i++) {
            pre = p;
            p = p.next;
        }
        pre.next = p.next;

        return head;
    }

    public ListNode removeNthFromEndAdvanced(ListNode head, int n) {
        // 一趟扫描实现
        // 思想：双指针，第一个指针先走n步，然后第二个指针开始走，当第一个指针走到尾部时，第二个指针正好走到倒数第n个节点的前一个节点
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
