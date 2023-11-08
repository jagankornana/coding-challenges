package com.leetcode.course;

public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
        node1.left = node2;
        node2.left = node3;

        MinDepthOfBinaryTree obj = new MinDepthOfBinaryTree();
        System.out.println(obj.minDepth(root));
    }

    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int minDepth = 0;
        if (node.left != null && node.right != null) {
            minDepth = Math.min(minDepth(node.left), minDepth(node.right));
        } else if (node.left != null) {
            minDepth = minDepth(node.left);
        } else {
            minDepth = minDepth(node.right);
        }
        return minDepth + 1;
    }
}
