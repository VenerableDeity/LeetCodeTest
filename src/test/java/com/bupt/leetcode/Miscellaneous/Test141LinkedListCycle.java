package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test141LinkedListCycle {
    /*
    给你一个链表的头节点 head ，判断链表中是否有环。如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
    为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。
    仅仅是为了标识链表的实际情况。如果链表中存在环 ，则返回 true 。 否则，返回 false 。

    示例 1：
        输入：head = [3,2,0,-4], pos = 1
        输出：true
        解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
        输入：head = [1,2], pos = 0
        输出：true
        解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
        输入：head = [1], pos = -1
        输出：false
        解释：链表中没有环。


    提示：
        链表中节点的数目范围是 [0, 10^4]
        -10^5 <= Node.val <= 10^5
        pos 为 -1 或者链表中的一个 有效索引 。

    进阶：你能用 O(1)（即，常量）内存解决此问题吗？
     */
    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(0);
        ListNode head4 = new ListNode(-4);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;
        System.out.println(hasCycle(head));

        ListNode head5 = new ListNode(1);
        ListNode head6 = new ListNode(2);
        head5.next = head6;
        head6.next = head5;
        System.out.println(hasCycle(head5));

        ListNode head7 = new ListNode(1);
        System.out.println(hasCycle(head7));
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}


// Definition for singly-linked list.
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
