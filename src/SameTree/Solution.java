package SameTree;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    private boolean flag = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(flag){
            if(p == null && q == null){
                return true;
            }else if(p == null || q == null || p.val != q.val){
                flag = false;
                return false;
            }else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }else{
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}