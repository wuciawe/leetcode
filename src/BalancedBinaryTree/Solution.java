package BalancedBinaryTree;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean[] flag = new boolean[]{true};
        int h1 = height(root.left, flag);
        int h2 = height(root.right, flag);
        return flag[0] && Math.abs(h1 - h2) <= 1;
    }

    private int height(TreeNode root, boolean[] flag){
        if(root == null){
            return 0;
        }else{
            int h1, h2;
            if(flag[0]){
                h1 = height(root.left, flag);
            }else{
                return 0;
            }
            if(flag[0]){
                h2 = height(root.right, flag);
            }else{
                return 0;
            }
            if(Math.abs(h1 - h2) > 1){
                flag[0] = false;
                return 0;
            }
            return 1 + Math.max(h1, h2);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}