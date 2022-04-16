public class TreeRightPointer {
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

    class Solution {
        public Node connect(Node root) {

            getNext (null, root, root, 0);

            return root;
        }

        public void getNext (Node subRoot, Node parent, Node child, int depth) {
            if (child == null) return;
            else if (child == parent.left) {
                child.next = parent.right;
                getNext (child, child, child.left, 0);
                getNext (subRoot, child, child.right, depth + 1);
            } else {
                child.next = getMinAtDepth(subRoot, depth);
                getNext (child, child, child.left, 0);
                getNext (subRoot, child, child.right, depth + 1);
            }
        }

        public Node getMinAtDepth (Node subRoot, int depth) {
            if (subRoot == null) return null;
            else {
                subRoot = subRoot.right;
                for (int i = 0; i < depth; i++) {
                    subRoot = subRoot.left;
                }
                return  subRoot;
            }
        }
    }
}
