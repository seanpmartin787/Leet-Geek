import java.util.ArrayList;
import java.util.List;

public class TreeTraversalInOrder {

    private class TreeNode {
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

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        traverseTree(res, root);
        return res;
    }
    private static void traverseTree (List<Integer> res, TreeNode root) {
        if (root == null) return;

        traverseTree(res, root.left);
        res.add(root.val);
        traverseTree(res, root.right);
    }
}
