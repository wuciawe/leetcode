package BinaryTreeLevelOrderTraversalII;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<TreeNode> nodes = new ArrayList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();

        if(root != null)
            nodes.add(root);
        while(!nodes.isEmpty()){
            List<Integer> l = new ArrayList<Integer>();
            List<TreeNode> nnodes = new ArrayList<TreeNode>();
            for(TreeNode node : nodes){
                l.add(node.val);
                if(node.left != null) nnodes.add(node.left);
                if(node.right != null) nnodes.add(node.right);
            }
            stack.add(l);
            nodes = nnodes;
        }

        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}