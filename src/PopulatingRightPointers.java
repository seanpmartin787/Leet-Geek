public class PopulatingRightPointers {

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

        public Node connect(Node root) {
            setNext(root);
            return root;
        }

        public static void setNext (Node curr) {
            if (curr == null) return;

            if (curr.left != null && curr.right != null) {
                curr.left.next = curr.right;
                setNext(curr.left);
            } else if (curr.left != null && curr.right == null) {
                curr.left.next = getNext(curr.next);
                setNext(curr.left);
            }

            if (curr.right != null) {
                curr.right.next = getNext(curr.next);
                setNext(curr.right);
            }
        }

        public static Node getNext (Node curr) {
            Node next = null;
            while (curr != null && next == null) {

                if (curr.left != null) {
                    next = curr.left;
                } else if (curr.right != null) {
                    next = curr.right;
                } else {
                    curr = curr.next;
                }
            }
            return next;
        }

}
