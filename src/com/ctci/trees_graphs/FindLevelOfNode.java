package com.ctci.trees_graphs;

/*
   1. Only write your code in the methods that have the comment 'write your code here' or in the section 'write optional helper methods here'
   2. Do not modify anything else
   3. If your code cannot compile or fails the test cases in 'main()', you will not receive a response from us
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindLevelOfNode {

    public static void main(String... args) {

		/*
		   Consider the following tree:

		         1
		      /  |  \
		     2   4   6
		   / |  / \  |  \
		  3  9 5  7  11 12
		      / \      / | \
		     13 16    14 23 17
		       / \
		      24 32


		  Assuming the numbers are the ids of each node, the tree can be written down as follows:

		  1(2,4,6) 2(3,9) 4(5,7) 6(11,12) 5(13,16) 12(14,23,17) 16(24,32)

		  In the example above, for the group 1(2,4,6), node 2, 4 and 6 are the child nodes of
		  node 1. Note that extra whitespaces should be accepted. Assume ids are positive integers only.

		*/

        Tree first = new Tree("1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");

        assertTrue(first.getLevelOfNodeWithId(1) == 5);
        assertTrue(first.getLevelOfNodeWithId(4) == 4);
        assertTrue(first.getLevelOfNodeWithId(5) == 3);
        assertTrue(first.getLevelOfNodeWithId(12) == 3);
        assertTrue(first.getLevelOfNodeWithId(16) == 2);
        assertTrue(first.getLevelOfNodeWithId(23) == 2);
        assertTrue(first.getLevelOfNodeWithId(32) == 1);

		/*
		      2
		   / | | \
		  5  4 3  1
		  |     \
		  7      9
		 / \   /  \
		12 10 11  14
		    |
		    13
		   / | \
		 16  8  15

		*/

        Tree second = new Tree(" 2(5, 4, 3,1)  5(7)   3(9) 7(12, 10)   9(11, 14)  10(13) 13(16,8,15)");
        assertTrue(second.getLevelOfNodeWithId(2) == 6);
        assertTrue(second.getLevelOfNodeWithId(5) == 5);
        assertTrue(second.getLevelOfNodeWithId(3) == 5);
        assertTrue(second.getLevelOfNodeWithId(12) == 3);
        assertTrue(second.getLevelOfNodeWithId(11) == 3);
        assertTrue(second.getLevelOfNodeWithId(13) == 2);
        assertTrue(second.getLevelOfNodeWithId(8) == 1);
    }

    private static void assertTrue(boolean v) {
        if (!v) {
            Thread.dumpStack();
            System.exit(0);
        }
    }
}

class Tree {
    private Node root;

    // do not add new properties

    public Tree(String treeData) {
        // write your code here
        treeData = treeData.replace(" ", "");
        String[] strings = treeData.split("\\)");
        for (int i = 0; i < strings.length; i++) {
            String[] nodes = strings[i].split("\\(");
            String parent = nodes[0];
            String[] children = nodes[1].split(",");
            if (i == 0) {
                root = new Node(Integer.parseInt(parent));
                for (String child : children) {
                    root.appendChild(new Node(Integer.parseInt(child), root));
                }
            } else {
                Node node = findNodeInTree(Integer.parseInt(parent));
                if (node != null) {
                    for (String child : children) {
                        node.appendChild(new Node(Integer.parseInt(child), node));
                    }
                }
            }
        }
    }

    /**
     * Finds a node with a given id and return it's level.
     * The nodes at the bottom of the tree have a level of 1.
     *
     * @param id The id of node
     * @return The level of the the node of that id, or -1 if a node is not found
     */
    public int getLevelOfNodeWithId(int id) {
        // write your code here
        int depth = findTreeDepth(root);
        int level = findNodeLevelFromRoot(root, id, 0);
        if (level != -1) {
            return depth - level;
        }
        return -1;
    }

    // write optional helper methods here

    private Node findNodeInTree(int id) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            if (node.getId() == id) {
                return node;
            } else {
                queue.addAll(node.getChildren());
            }
        }
        return null;
    }

    private int findTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int maxDepth = 0;
        for (Node child : node.getChildren()) {
            maxDepth = Math.max(maxDepth, findTreeDepth(child));
        }
        return maxDepth + 1;
    }

    private int findNodeLevelFromRoot(Node node, int id, int level) {
        if (node == null) {
            return 0;
        }

        if (node.getId() == id) {
            return level;
        }

        for (Node child : node.getChildren()) {
            if (child.getId() == id) {
                return level + 1;
            }
            int downLevel = findNodeLevelFromRoot(child, id, level + 1);
            if (downLevel != 0 && downLevel != -1) {
                return downLevel;
            }
        }

        return -1;
    }

}

class Node {
    private Node parent;
    private List<Node> children;
    private int id;

    public Node(int id) {
        this.id = id;
        this.children = new ArrayList<Node>();
    }

    public Node(int id, Node parent) {
        this(id);
        this.parent = parent;
    }

    public void appendChild(Node child) {
        children.add(child);
    }

    public int getId() {
        return id;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
