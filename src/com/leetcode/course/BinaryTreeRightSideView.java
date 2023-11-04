package com.poc.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node1;
//        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
//        node5.right = node6;

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        System.out.println(obj.rightSideView_BFS(root));
        System.out.println(obj.rightSideView_DFS(root));
    }

    public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        rightSideView_DFS(root, list, 0);
        return list;
    }

    private void rightSideView_DFS(TreeNode node, List<Integer> list, int level) {
        if (level == list.size()) {
            list.add(node.val);
        }
        if (node.right != null) {
            rightSideView_DFS(node.right, list, level + 1);
        }
        if (node.left != null) {
            rightSideView_DFS(node.left, list, level + 1);
        }
    }

    public List<Integer> rightSideView_BFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodesInLevel = queue.size();
            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode currNode = queue.remove();
                if (i == nodesInLevel - 1) {
                    list.add(currNode.val);
                }
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return list;
    }
}
