/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        Node node = root;
        while (node != null) {
            connectHelper(node);
            node = node.left;
        }

        return root;
    }

    public void connectHelper(Node node) {
        while (node != null) {
            if (node.left != null) {
                node.left.next = node.right;
            }
            if (node.next != null && node.right != null) {
                node.right.next = node.next.left;
            }

            node = node.next;
        }
    }
}
