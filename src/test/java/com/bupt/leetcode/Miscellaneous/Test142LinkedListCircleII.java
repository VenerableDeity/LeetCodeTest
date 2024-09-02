package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

public class Test142LinkedListCircleII {
    /*
    给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
    评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
    注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。不允许修改 链表。

    示例 1：
        输入：head = [3,2,0,-4], pos = 1
        输出：返回索引为 1 的链表节点
        解释：链表中有一个环，其尾部连接到第二个节点。

    示例 2：
        输入：head = [1,2], pos = 0
        输出：返回索引为 0 的链表节点
        解释：链表中有一个环，其尾部连接到第一个节点。

    示例 3：
        输入：head = [1], pos = -1
        输出：返回 null
        解释：链表中没有环。

    提示：
        链表中节点的数目范围在范围 [0, 10^4] 内
        -10^5 <= Node.val <= 10^5
        pos 的值为 -1 或者链表中的一个有效索引
     */
    @Test
    public void test() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(detectCycle(head).val);

        ListNode head2 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        head2.next = node4;
        node4.next = head2;
        System.out.println(detectCycle(head2).val);

        ListNode head3 = new ListNode(1);
        System.out.println(detectCycle(head3));
    }

    /**
     * 快慢指针 + 数学推导（即slow与fast相遇时的节点为环的入口）
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
