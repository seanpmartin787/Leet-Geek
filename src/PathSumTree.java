import java.util.ArrayList;
import java.util.List;



public class PathSumTree {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        //edge case
        List<List<Integer>> res = new ArrayList<>();
        solveTree(res, new ArrayList<Integer>(), targetSum, root);
        return res;
    }

    private static void solveTree (List<List<Integer>> res, List<Integer> path, int targetSum, TreeNode currentNode) {
        if (currentNode == null || targetSum < 0) return;
        if (targetSum == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        //otherwise we haven't found the end just yet
        //we will recurse on left and right node
        path.add(currentNode.val);
        solveTree(res, path, targetSum - currentNode.val, currentNode.right);
        solveTree(res, path, targetSum - currentNode.val, currentNode.left);
        path.remove(path.size()-1);
    }
}
