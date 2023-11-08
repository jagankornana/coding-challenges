package com.leetcode.course;

public class MaxDiffBetweenNodeAndAncestor {

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


        MaxDiffBetweenNodeAndAncestor obj = new MaxDiffBetweenNodeAndAncestor();
        System.out.println(obj.maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    public int maxAncestorDiff(TreeNode node, int min, int max) {
        if (node.left == null && node.right == null) {
            return max - min;
        }

        int left = 0, right = 0;
        if (node.left != null) {
            left = maxAncestorDiff(node.left, Math.min(min, node.left.val), Math.max(max, node.left.val));
        }
        if (node.right != null) {
            right = maxAncestorDiff(node.right, Math.min(min, node.right.val), Math.max(max, node.right.val));
        }
        return Math.max(left, right);
    }
}
