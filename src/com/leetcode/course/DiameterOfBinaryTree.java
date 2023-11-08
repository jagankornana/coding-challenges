package com.leetcode.course;

public class DiameterOfBinaryTree {
    private int maxDiameter;

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
        node2.left = node3;
        node2.right = node4;

//        node1.left = node3;
//        node3.left = node4;

        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        System.out.println(obj.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode node) {
        this.maxDiameter = 0;
        findMaxDiameter(node);
        return maxDiameter;
    }

    public int findMaxDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = 0, rightDepth = 0;
        if (node.left != null) {
            leftDepth = findMaxDiameter(node.left);
        }
        if (node.right != null) {
            rightDepth = findMaxDiameter(node.right);
        }
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
