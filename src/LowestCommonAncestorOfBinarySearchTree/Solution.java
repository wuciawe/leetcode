package LowestCommonAncestorOfBinarySearchTree;

/**
 * Created by haha on 2015/7/23.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <= q.val) return lca(root, p, q);
        else return lca(root, q, p);
    }

    private TreeNode lca(TreeNode root, TreeNode left, TreeNode right){
        if(root == null || (root.val >= left.val && root.val <= right.val)) return root;
        else if(right.val < root.val) return lca(root.left, left, right);
        else return lca(root.right, left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}