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
            Node realRoot = root; //so we can return the real root
            Node frontOfCurrentLayer = new Node(0, null, null, root);
            Node curr = frontOfCurrentLayer;

            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;

                if (root == null) {
                    curr = frontOfCurrentLayer;
                    root = frontOfCurrentLayer.next;
                    frontOfCurrentLayer.next = null;

                }
            }
            return realRoot;
        }
}
