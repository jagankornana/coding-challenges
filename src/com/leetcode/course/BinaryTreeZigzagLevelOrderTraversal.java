package com.leetcode.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {

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

        BinaryTreeZigzagLevelOrderTraversal obj = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(obj.zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigZagOrder = new ArrayList<>();
        if (root == null) {
            return zigZagOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean isLeft = true;
        while (!stack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> levelNodes = new ArrayList<>();
            int nodesInStack = stack.size();
            for (int i = 0; i < nodesInStack; i++) {
                levelNodes.add(stack.pop());
            }
            for(TreeNode currNode : levelNodes){
                list.add(currNode.val);
                if (isLeft) {
                    if (currNode.left != null) {
                        stack.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        stack.add(currNode.right);
                    }
                } else {
                    if (currNode.right != null) {
                        stack.add(currNode.right);
                    }
                    if (currNode.left != null) {
                        stack.add(currNode.left);
                    }
                }
            }
            isLeft = !isLeft;
            zigZagOrder.add(list);
        }
        return zigZagOrder;
    }
}
