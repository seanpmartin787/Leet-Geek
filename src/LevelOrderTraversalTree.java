import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalTree {

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //I think we can do this with a breadth first search and queue
        List<List<Integer>> levelOrderT = new ArrayList();
        if (root == null) return levelOrderT;
        List<Integer> levelValues = new ArrayList();
        Queue<TreeNode> level = new LinkedList();
        level.offer(root);

        while (!level.isEmpty()) {

            int size = level.size();
            for (int i=0; i<size; i++) {
                TreeNode current = level.poll();
                levelValues.add(current.val);
                if (current.left != null) level.offer(current.left);
                if (current.right != null) level.offer(current.right);
            }
            levelOrderT.add(levelValues);
            levelValues = new ArrayList();
        }
        return levelOrderT;
    }
}
