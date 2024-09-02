package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test86PartitionList {
    /*
    给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    你应当 保留 两个分区中每个节点的初始相对位置。

    示例 1：
        输入：head = [1,4,3,2,5,2], x = 3
        输出：[1,2,2,4,3,5]

    示例 2：
        输入：head = [2,1], x = 2
        输出：[1,2]

    实例 3：
        输入：head = [1,4,3,0,2,5,2], x = 3
        输出：[1,0,2,2,4,3,5]

    提示：
        链表中节点的数目在范围 [0, 200] 内
        -100 <= Node.val <= 100
        -200 <= x <= 200
     */
    @Test
    public void test() {
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = createList(nums);
        ListNode result = partition(head, 3);
        printList(result);

        int[] nums2 = {2, 1};
        ListNode head2 = createList(nums2);
        ListNode result2 = partition(head2, 2);
        printList(result2);

        int[] nums3 = {1, 4, 3, 0, 2, 5, 2};
        ListNode head3 = createList(nums3);
        ListNode result3 = partition(head3, 3);
        printList(result3);
    }

    public ListNode partition(ListNode head, int x) {
        // 思路：双指针先定位到第一个大于或等于x的节点及它之前的位置，然后遍历链表，将小于x的节点插入到这个节点之前
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                break;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        ListNode insertPos = pre;  // 因为要保持相对顺序，所以不能用头插法，只能用插入法，insertPos要不断更新
        while (p != null) {
            if (p.val < x) {
                pre.next = p.next;
                p.next = insertPos.next;
                insertPos.next = p;
                insertPos = p;
                p = pre.next;
            } else {
                pre = pre.next;
                p = p.next;
            }

        }
        return dummy.next;

        // 思路：分别创建两个链表，一个存放小于x的节点，一个存放大于或等于x的节点，最后将两个链表拼接
//        ListNode small = new ListNode(0);
//        ListNode smallHead = small;
//        ListNode large = new ListNode(0);
//        ListNode largeHead = large;
//        while (head != null) {
//            if (head.val < x) {
//                small.next = head;
//                small = small.next;
//            } else {
//                large.next = head;
//                large = large.next;
//            }
//            head = head.next;
//        }
//        large.next = null;
//        small.next = largeHead.next;
//        return smallHead.next;

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
