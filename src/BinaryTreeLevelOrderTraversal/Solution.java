package BinaryTreeLevelOrderTraversal;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<TreeNode> nodes = new ArrayList<TreeNode>();
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

            nodes = nnodes;
            result.add(l);
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