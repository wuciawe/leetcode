package InvertBinaryTree;

/**
 * Created by haha on 2015/6/13.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}