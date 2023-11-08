package com.leetcode.course;

public class SameTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        node4.left = node5;
//        node4.right = node6;

        SameTree obj = new SameTree();
        System.out.println(obj.isSameTree(node1, node4));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return p == q;
    }
}
