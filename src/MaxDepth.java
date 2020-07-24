import org.junit.Test;

import java.util.*;

public class MaxDepth {

    int maxDepth = 0;

    public int maxDepth(Node root) {

        if (root != null) {
            getDepth(root, maxDepth);
        }

        return maxDepth;
    }

    public void getDepth(Node node, int depth) {

        if (node != null) {
            depth++;

            if (node.children != null) {
                for (Node child : node.children) {
                    getDepth(child, depth);
                }
            }

        }
        maxDepth = Math.max(maxDepth, depth);
        return;
    }

    @Test
    public void test() {

        Node head = new Node(1);
        List<Node> oneChildren = new ArrayList<>();
        List<Node> threeChildren = new ArrayList<>();

        oneChildren.add(new Node(3));
        oneChildren.add(new Node(2));
        oneChildren.add(new Node(4));
        threeChildren.add(new Node(5));
        threeChildren.add(new Node(6));

        head.children = oneChildren;
        oneChildren.get(0).children = threeChildren;

        System.out.println(maxDepth(head));
    }

}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}