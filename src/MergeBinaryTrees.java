import com.sun.source.tree.Tree;

public class MergeBinaryTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

            if (root1 == null) return root2;
            else if (root2 == null) return root1;
            else {
                root1.val += root2.val;
                //recurse
                root1.left = mergeNodes(root1.left, root2.left);
                root1.right = mergeNodes(root1.right, root2.right);
            }
            return root1;
        }

        public static TreeNode mergeNodes(TreeNode one, TreeNode two) {

            if (one == null && two == null) return null;
            else if (two == null) return one;
            else if (one == null) return two;
            else {
                one.val += two.val;
                //recurse
                one.left = mergeNodes(one.left, two.left);
                one.right = mergeNodes(one.right, two.right);

                return one;
            }

        }
    }




