package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test92ReverseLinkedListII {
    /*
    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

    示例 1：
        输入：head = [1,2,3,4,5], left = 2, right = 4
        输出：[1,4,3,2,5]

    示例 2：
        输入：head = [5], left = 1, right = 1
        输出：[5]

    提示：
        链表中节点数目为 n
        1 <= n <= 500
        -500 <= Node.val <= 500
        1 <= left <= right <= n

    进阶： 你可以使用一趟扫描完成反转吗？
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = createList(nums);
        ListNode result = reverseBetween(head, 2, 4);
        printList(result);

        int[] nums2 = {5};
        ListNode head2 = createList(nums2);
        ListNode result2 = reverseBetween(head2, 1, 1);
        printList(result2);
    }

    /**
     * 思路：找到left的前一个节点pre，然后反转left到right的节点，最后将pre.next指向反转后的头节点
     * 翻转链表的方法：头插法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        // 头插法：将cur.next插入到pre.next，然后cur.next指向cur.next.next
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummy.next;
    }

    public void printList(ListNode head) {
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
}
