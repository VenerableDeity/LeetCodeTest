package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test21MergeTwoSortedLists {
    /*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    示例 1：
        输入：l1 = [1,2,4], l2 = [1,3,4]
        输出：[1,1,2,3,4,4]

    示例 2：
        输入：l1 = [], l2 = []
        输出：[]

    示例 3：
        输入：l1 = [], l2 = [0]
        输出：[0]

    提示：
        两个链表的节点数目范围是 [0, 50]
        -100 <= Node.val <= 100
        l1 和 l2 均按 非递减顺序 排列
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
    public void test(){
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode l1 = createList(nums1);
        ListNode l2 = createList(nums2);
        printList(mergeTwoLists(l1, l2));

        printList(mergeTwoLists(null, null));

        printList(mergeTwoLists(null, new ListNode(0, null)));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        else if (list2 == null) {
//            return list1;
//        }
//        else if (list1.val < list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        }
//        else {
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
//    }
}
