package com.leetcode.course;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        LowestCommonAncestor obj = new LowestCommonAncestor();
        TreeNode result = obj.lowestCommonAncestor(root, node3, node2);
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node == p || node == q) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
