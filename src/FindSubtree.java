//import javax.swing.tree.TreeNode;

public class FindSubtree {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }

      }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (compareTrees(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public boolean compareTrees (TreeNode nodeOne, TreeNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) return true;
        if (nodeOne == null || nodeTwo == null) return false;
        if (nodeOne.val != nodeTwo.val) return false;

        return compareTrees(nodeOne.left, nodeTwo.left) && compareTrees(nodeOne.right, nodeTwo.right);

    }
}
