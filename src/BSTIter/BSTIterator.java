package BSTIter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haha on 2015/4/28.
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            stack.add(cur);
            cur  = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        TreeNode rless = cur.right;
        while(rless != null){
            stack.add(rless);
            rless = rless.left;
        }
        return cur.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}