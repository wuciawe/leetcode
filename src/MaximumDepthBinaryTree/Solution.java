package MaximumDepthBinaryTree;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null) return 1 + maxDepth(root.right);
        else if(root.right == null) return 1 + maxDepth(root.left);
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}