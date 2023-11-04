package com.poc.practice;

public class ValidateBinarySearchTree {

    private boolean flag;
    private TreeNode prevNode;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node3.left = node2;
        node2.left = node6;
        node3.right = node4;
        node4.right = node5;

        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        System.out.println(obj.isValidBST(node3));
    }

    public boolean isValidBST(TreeNode node) {
        flag = true;
        inOrder(node);
        return flag;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prevNode != null) {
            flag &= (node.val > prevNode.val);
        }
        prevNode = node;
        inOrder(node.right);
    }

}
