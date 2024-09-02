package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test23MergeKSortedLists {
    /*
    给你一个链表数组，每个链表都已经按升序排列。
    请你将所有链表合并到一个升序链表中，返回合并后的链表。

    示例 1：
        输入：lists = [[1,4,5],[1,3,4],[2,6]]
        输出：[1,1,2,3,4,4,5,6]
        解释：链表数组如下：
        [
          1->4->5,
          1->3->4,
          2->6
        ]
        将它们合并到一个有序链表中得到。
        1->1->2->3->4->4->5->6

    示例 2：
        输入：lists = []
        输出：[]

    示例 3：
        输入：lists = [[]]
        输出：[]

    提示：
        k == lists.length
        0 <= k <= 10^4
        0 <= lists[i].length <= 500
        -10^4 <= lists[i][j] <= 10^4
        lists[i] 按 升序 排列
        lists[i].length 的总和不超过 10^4
     */


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode createList(int[] nums){
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }

    private void printList(ListNode head){
        System.out.print("[");
        while (head != null){
            System.out.print(head.val);
            head = head.next;
            if (head != null){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void test() {
        ListNode[] lists = new ListNode[3];
        lists[0] = createList(new int[]{1, 4, 5});
        lists[1] = createList(new int[]{1, 3, 4});
        lists[2] = createList(new int[]{2, 6});
        ListNode res = mergeKLists(lists);
        printList(res);


    }


    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

}
