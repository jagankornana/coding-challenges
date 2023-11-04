package com.poc.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AllNodesDistanceK {

    HashMap<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6= new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node6;

        AllNodesDistanceK obj = new AllNodesDistanceK();
        System.out.println(obj.distanceK(node1, node3, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> resultList = new ArrayList<>();
        graph = new HashMap<>();
        dfs(root);
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        queue.add(target.val);
        seen.add(target.val);
        while (!queue.isEmpty() && k >= 0) {
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                Integer nodeVal = queue.remove();
                if (k == 0) {
                    resultList.add(nodeVal);
                }
                for (Integer neighbour : graph.getOrDefault(nodeVal, new ArrayList<>())) {
                    if (!seen.contains(neighbour)) {
                        queue.add(neighbour);
                        seen.add(neighbour);
                    }
                }
            }
            k--;
        }

        return resultList;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            graph.computeIfAbsent(node.val, value -> new ArrayList<>()).add(node.left.val);
            graph.computeIfAbsent(node.left.val, value -> new ArrayList<>()).add(node.val);
        }
        if (node.right != null) {
            graph.computeIfAbsent(node.val, value -> new ArrayList<>()).add(node.right.val);
            graph.computeIfAbsent(node.right.val, value -> new ArrayList<>()).add(node.val);
        }
        dfs(node.left);
        dfs(node.right);
    }
}
