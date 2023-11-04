package com.poc.practice;

public class InsertIntoBinarySearchTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node3.left = node2;
        node2.left = node1;
        node3.right = node4;
        node4.right = node5;

        InsertIntoBinarySearchTree obj = new InsertIntoBinarySearchTree();
        TreeNode result = obj.insertIntoBST(node3, 10);
        obj.inOrder(result);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }
}
