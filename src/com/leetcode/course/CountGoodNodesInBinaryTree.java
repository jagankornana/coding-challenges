package com.poc.practice;

public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node2.left = node1;
        node2.right = node4;
        node1.left = node3;
        node1.right = node5;

        CountGoodNodesInBinaryTree obj = new CountGoodNodesInBinaryTree();
        System.out.println(obj.goodNodes(node2));
    }

    public int goodNodes(TreeNode node) {
        return goodNodes(node, node.val);
    }

    public int goodNodes(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }
        return node.val >= maxVal ? 1 + goodNodes(node.left, node.val) + goodNodes(node.right, node.val) :
                goodNodes(node.left, maxVal) + goodNodes(node.right, maxVal);
    }
}
