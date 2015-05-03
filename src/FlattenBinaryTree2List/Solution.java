package FlattenBinaryTree2List;

import java.util.Stack;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null){
            if(root.right != null) stack.add(root.right);
            if(root.left != null) stack.add(root.left);
        }
        TreeNode p = root;
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            p.left = null;
            p.right = cur;
            p = cur;
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}