package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by haha on 2015/4/28.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> record = new Stack<TreeNode>();
        if(root != null)
            record.add(root);
        int level = 0;
        while(!record.isEmpty()){
            ++level;
            Stack<TreeNode> l = new Stack<TreeNode>();
            List<Integer> r = new ArrayList<Integer>();
            if(level % 2 == 0){
                while(!record.isEmpty()){
                    TreeNode node = record.pop();
                    r.add(node.val);
                    if(node.right != null)
                        l.add(node.right);
                    if(node.left != null)
                        l.add(node.left);
                }
            }else{
                while(!record.isEmpty()){
                    TreeNode node = record.pop();
                    r.add(node.val);
                    if(node.left != null)
                        l.add(node.left);
                    if(node.right != null)
                        l.add(node.right);
                }
            }
            record = l;
            result.add(r);
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