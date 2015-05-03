package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haha on 2015/4/27.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(root != null)
            nodes.add(root);
        while(!nodes.isEmpty()){
            result.add(nodes.get(0).val);
            List<TreeNode> l = new ArrayList<TreeNode>();
            for(TreeNode node: nodes){
                if(node.right != null) l.add(node.right);
                if(node.left != null) l.add(node.left);
            }
            nodes = l;
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