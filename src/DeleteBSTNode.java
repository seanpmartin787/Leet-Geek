import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

class DeleteBSTNode {

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

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {return root;}
        else if (root.val == key && root.left == null && root.right == null ) {return null;}


        TreeNode prev = root, next = root;

        while (next != null && next.val != key) {
            prev = next;
            next = getNext(next, key);

        }

        if (next == null) {
            //Nothing to delete
        } else {
            if (next.val > prev.val) {
                //right node
                if (next.left == null && next.right ==null) {
                    //if bottom node
                    prev.right = null;
                } else if (next.left == null || next.right == null) {
                    //leaf node
                    if (next.left != null) {
                        prev.right = next.left;
                    } else {
                        prev.right = next.right;
                    }

                } else {
                    next.val = removeInternal(next);
                }//Internal node

            } else {
                //right node
                if (next.left == null && next.right ==null) {
                    //if bottom node
                    prev.left = null;
                } else if (next.left == null || next.right == null) {
                    //leaf node
                    if (next.left != null) {
                        prev.left = next.left;
                    } else {
                        prev.left = next.right;
                    }
                } else {
                    next.val = removeInternal(next);
                }//Internal node

            }//left node
        }//else we got a winner

        return root;

    }
    public TreeNode getNext(TreeNode prev, int Searchvalue) {

        if (prev.val > Searchvalue) prev = prev.left;
        else prev = prev.right;

        return  prev;
    }

    public TreeNode getMin(TreeNode node) {

        while (node.left != null) {
            node = node.left;
        }//find smallest node in right sub tree
        return node;

    }
}
