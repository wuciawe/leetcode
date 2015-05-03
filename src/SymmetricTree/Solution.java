package SymmetricTree;

import java.util.Stack;

/**
 * Created by haha on 2015/4/11.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode rl = root.left;
        TreeNode rr = root.right;
        if(rl == null && rr == null) return true;
        if((rl == null || rr == null) || (rl.val != rr.val)) return false;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(rl);
        stack.push(rr);
        while(!stack.empty()){
            TreeNode ta = stack.pop();
            TreeNode tb = stack.pop();
            TreeNode tal = ta.left;
            TreeNode tbr = tb.right;
            TreeNode tar = ta.right;
            TreeNode tbl = tb.left;
            if(tal == null && tbr == null){

            }else if((tal == null || tbr == null) || (tal.val != tbr.val)){
                return false;
            }else {
                stack.push(tal);
                stack.push(tbr);
            }
            if(tar == null && tbl == null){

            }else if((tar == null || tbl == null) || (tar.val != tbl.val)){
                return false;
            }else{
                stack.push(tar);
                stack.push(tbl);
            }
        }
        return true;
    }
}

class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }