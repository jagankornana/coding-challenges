package com.ctci.trees_graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

public class ListofDepths {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input array: ");
        Stream<String> stringStream = Arrays.stream(br.readLine().split(" "));
        int[] array = stringStream.mapToInt(Integer::parseInt).toArray();
        Tree tree = new Tree();
        tree.root = tree.buildCompleteTree(new Node(array[0]), 0, array);
//        tree.inOrder(tree.root);
        Map<Integer, LinkedList<Node>> listOfDepths = new HashMap<>();
        findDepthOfEachNode(tree.root, 0, listOfDepths);
        for (int i = 0; i < listOfDepths.size(); i++) {
            System.out.print("Depth " + i + " nodes: ");
            for (Node node : listOfDepths.get(i)) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    private static void findDepthOfEachNode(Node node, int depth, Map<Integer, LinkedList<Node>> listOfDepths) {
        if (node == null) {
            return;
        }
        if (listOfDepths.get(depth) == null) {
            listOfDepths.put(depth, new LinkedList<>());
            listOfDepths.get(depth).add(node);
        } else {
            listOfDepths.get(depth).add(node);
        }
        findDepthOfEachNode(node.left, depth + 1, listOfDepths);
        findDepthOfEachNode(node.right, depth + 1, listOfDepths);
    }

    static class Tree {
        Node root;

        private Node buildCompleteTree(Node parent, int parentIndex, int[] array) {
            if (parentIndex < array.length) {
                parent = new Node(array[parentIndex]);
                parent.left = buildCompleteTree(parent.left, parentIndex * 2 + 1, array);
                parent.right = buildCompleteTree(parent.right, parentIndex * 2 + 2, array);
            }
            return parent;
        }

        void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
