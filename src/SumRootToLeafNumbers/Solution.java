package SumRootToLeafNumbers;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        if(root != null)
            solver(root, res, 0);
        return res[0];
    }

    private void solver(TreeNode root, int[] res, int cur){
        cur = cur * 10 + root.val;
        if(root.left != null) solver(root.left, res, cur);
        if(root.right != null) solver(root.right, res, cur);
        if(root.left == null && root.right == null) res[0] += cur;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}