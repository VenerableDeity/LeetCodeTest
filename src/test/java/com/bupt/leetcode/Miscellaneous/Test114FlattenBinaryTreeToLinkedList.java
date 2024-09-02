package com.bupt.leetcode.Miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test114FlattenBinaryTreeToLinkedList {
    /*
    给你二叉树的根结点 root ，请你将它展开为一个单链表：
    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。

    示例 1：
        输入：root = [1,2,5,3,4,null,6]
        输出：[1,null,2,null,3,null,4,null,5,null,6]

    示例 2：
        输入：root = []
        输出：[]

    示例 3：
        输入：root = [0]
        输出：[0]

    提示：
        树中结点数在范围 [0, 2000] 内
        -100 <= Node.val <= 100

    进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        preOrder(root);
    }

    /**
     * 思路：先序遍历，将节点存入list，然后遍历list，将节点的左子树置为null，右子树置为下一个节点
     * @param root
     */
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        List<TreeNode> list = new ArrayList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode p = root;
//        while (p != null || !stack.isEmpty()) {
//            if (p != null) {
//                stack.push(p);
//                list.add(p);
//                p = p.left;
//            } else {
//                p = stack.pop();
//                p = p.right;
//            }
//        }
//        TreeNode pre = root;
//        for (TreeNode q : list) {
//            q.left = null;
//            if (q != root) {
//                pre.right = q;
//            }
//            pre = q;
//        }
//    }

    /**
     * 思路：
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

}
