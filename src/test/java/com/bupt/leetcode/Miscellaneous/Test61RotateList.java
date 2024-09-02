package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test61RotateList {
    /*
    给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

    示例 1：
        输入：head = [1,2,3,4,5], k = 2
        输出：[4,5,1,2,3]

    示例 2：
        输入：head = [0,1,2], k = 4
        输出：[2,0,1]

    提示：
        链表中节点的数目在范围 [0, 500] 内
        -100 <= Node.val <= 100
        0 <= k <= 2 * 10^9
     */
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = createList(nums);
        ListNode result = rotateRight(head, 2);
        printList(result);

        int[] nums2 = {0, 1, 2};
        ListNode head2 = createList(nums2);
        ListNode result2 = rotateRight(head2, 4);
        printList(result2);
    }

    /**
     * 思路：先计算链表长度，然后计算出实际需要移动的位置，找到倒数第k+1个节点，将其next指向null，将尾节点指向头节点
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length == 0) return head;
        k = k % length;
        if (k == 0) return head;

        p = head; // p指向尾节点
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;  // pre指向倒数第k+1个节点
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        ListNode res = pre.next;
        pre.next = null;
        p.next = head;
        return res;
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
