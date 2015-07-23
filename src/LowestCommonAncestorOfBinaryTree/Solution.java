package LowestCommonAncestorOfBinaryTree;

/**
 * Created by haha on 2015/7/23.
 */
public class Solution {
    private int count = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            if(root == p) ++ count;
            if(root == q) ++ count;
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        if(count == 2) return l;
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if(l != null && r != null) return root;
        return l != null ? l : r;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}