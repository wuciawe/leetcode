package BinaryTreeMaximumPathSum;

/**
 * Created by haha on 2015/5/1.
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        if(root == null)
            return 0;
        int r = solver(root, res);
        return r > res[0] ? r : res[0];
    }

    private int solver(TreeNode root, int[] res){
        if(root.left == null && root.right == null){
            if(root.val > res[0]) res[0] = root.val;
            return root.val;
        }else{
            int left = root.left == null ? 0 : solver(root.left, res);
            int right = root.right == null ? 0 : solver(root.right, res);
            int r = left > right ? left : right;
            r = r > 0 ? r + root.val : root.val;
            int r2 = root.val + left + right;
            if(r > r2) r2 = r;
            if(r2 > res[0]) res[0] = r2;
            return r;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}