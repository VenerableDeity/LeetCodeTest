package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test117PopulatingNextRightPointersInEachNodeII {
    /*
    给定一个二叉树：
    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
    初始状态下，所有 next 指针都被设置为 NULL 。


    示例 1：
        输入：root = [1,2,3,4,5,null,7]
        输出：[1,#,2,3,#,4,5,7,#]
        解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。

    示例 2：
        输入：root = []
        输出：[]

    提示：
        树中的节点数在范围 [0, 6000] 内
        -100 <= Node.val <= 100

    进阶：
        你只能使用常量级额外空间。
        使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
     */
    @Test
    public void test() {
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
        Node res = connect(root);
        preOrder(res);

        System.out.println();

        Node root2 = null;
        Node res2 = connect(root2);
        preOrder(res2);

        System.out.println();

        Node root3 = new Node(1);
        preOrder(connect(root3));
    }

    /**
     * 思路：层序遍历
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) return root;
        Deque<Node> queue = new ArrayDeque<>();
        Node sentinel = new Node();
        queue.offer(root);
        queue.offer(sentinel);
        Node pre = root;
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p != sentinel) {
                if (p != root && pre != sentinel) pre.next = p;
                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            } else {
                pre.next = null;
                if (!queue.isEmpty()) queue.offer(sentinel);
            }
            pre = p;
        }
        return root;
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
