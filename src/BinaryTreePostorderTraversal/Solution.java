package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by haha on 2015/5/2.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root != null)
            stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(set.contains(cur)){
                res.add(cur.val);
            }else{
                set.add(cur);
                stack.push(cur);
                if(cur.right != null) stack.push(cur.right);
                if(cur.left != null) stack.push(cur.left);
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}