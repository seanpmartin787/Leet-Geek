import java.util.ArrayList;
import java.util.List;



public class PathSumTree {
    public static class TreeNode {
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

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode testTree = new TreeNode(5);
        testTree.left = new TreeNode(4);
        testTree.right = new TreeNode(7);

        System.out.println(pathSum(testTree, 12));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        //edge case
        List<List<Integer>> res = new ArrayList<>();
        solveTree(res, new ArrayList<Integer>(), targetSum, root);
        return res;
    }

    private static void solveTree (List<List<Integer>> res, List<Integer> path, int targetSum, TreeNode currentNode) {
        if (currentNode == null) return;

        path.add(currentNode.val);
        if (currentNode.right == null && currentNode.left == null && targetSum == currentNode.val) {
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        //otherwise we haven't found the end just yet
        //we will recurse on left and right node
        solveTree(res, path, targetSum - currentNode.val, currentNode.right);
        solveTree(res, path, targetSum - currentNode.val, currentNode.left);

        path.remove(path.size() - 1);
    }
}
